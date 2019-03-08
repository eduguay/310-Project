

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import restaurantJSON.DistanceDetails;
import restaurantJSON.NearbyResult;
import restaurantJSON.NearbyResults;
import restaurantJSON.PlaceDetails;
import restaurantJSON.Result;
import restaurantJSON.ReturnResult;
import restaurantJSON.SortByDistance;



// Places API Key: AIzaSyBKL46dI7C9lgxkPQXK63DNdZeK_8Tw06k 


/**
 * Servlet implementation class RestaurantModel
 */
public class RestaurantModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Building blocks of the API string
	private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
	private static final String MAPS_API_BASE = "https://maps.googleapis.com/maps/api/distancematrix";
	private static final String DETAILS_SEARCH = "/details";
	private static final String NEARBY_SEARCH = "/nearbysearch";
	private static final String OUT_JSON = "/json";
	private static final String FIELDS = "&fields=formatted_address,name,geometry,price_level,website,formatted_phone_number"; //  // 
		//Tommy Trojan LATs and LONGs
	private static final String LAT = "34.021217";
	private static final String LNG = "-118.287093";
	//private static final String TOMMY_ADDRESS = "801-899+Childs Way,+Los Angeles,+CA+90089";
	private static final String TOMMY_PLACE_ID = "ChIJIfdecuPHwoARKagsKQF16io";
		// Places API Key
	private static final String API_KEY = "&key=AIzaSyAwiU4-BZSxmoCRsMvHOsATa-TYvfcVrFU";
	
	private static ArrayList<ReturnResult> restaurantList = new ArrayList<ReturnResult>();
	
	// String keyword radius yards
	public static ArrayList<ReturnResult> search(String keyword, int radius){
		ArrayList<ReturnResult> results = null;
		HttpURLConnection conn = null;
		StringBuilder jsonResults = new StringBuilder();
		try {
			
			// Get nearby places
			StringBuilder sb = new StringBuilder(PLACES_API_BASE);
			sb.append(NEARBY_SEARCH);
			sb.append(OUT_JSON);
			sb.append("?location=" + String.valueOf(LAT) + "," + String.valueOf(LNG));
			sb.append("&rankby=distance");
			//sb.append("&radius=" + String.valueOf(radius));
			sb.append("&type=restaurant");
			sb.append("&keyword=" + URLEncoder.encode(keyword, "utf8").replace("+", "%20"));
			sb.append(API_KEY);
			
			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			
			int read;
			char[] buff = new char[1024];
			while ((read = in.read(buff)) != -1) {
				jsonResults.append(buff, 0, read);
			}
			
			
			// Get the list of placeID
			NearbyResults convertedObject = new Gson().fromJson(jsonResults.toString(), NearbyResults.class);
			List<NearbyResult> resultList = convertedObject.getResults();
			ArrayList<String> place_ids = new ArrayList<String>();
			for( int i = 0; i < resultList.size(); i++) {
				place_ids.add(resultList.get(i).getPlaceId());
			}
			
			// Get the placeID 
			
			results = new ArrayList<ReturnResult>();
			
			
			/*
			 *  Goes through the list of place IDs and gets more information about each one
			 */
			StringBuilder sb2 = new StringBuilder();
			StringBuilder jsonDistance = new StringBuilder();
			for( int i = 0; i < place_ids.size(); i++) {
				jsonResults = new StringBuilder();
				// Generate the call to the Places Details API
				sb = new StringBuilder(PLACES_API_BASE);
				sb.append(DETAILS_SEARCH);
				sb.append(OUT_JSON);
				sb.append("?placeid=" + place_ids.get(i));
				sb.append(FIELDS);
				sb.append(API_KEY);
				
				url = new URL(sb.toString());
				conn = (HttpURLConnection) url.openConnection();
				in = new InputStreamReader(conn.getInputStream());
				
				while ((read = in.read(buff)) != -1) {
					jsonResults.append(buff, 0, read);
				}

				PlaceDetails placeDetail = new Gson().fromJson(jsonResults.toString(), PlaceDetails.class);
				Result result = placeDetail.getResult();
				
				//Generate the call to the Distance Matrix API
				jsonDistance = new StringBuilder();
				sb2 = new StringBuilder(MAPS_API_BASE);
				sb2.append(OUT_JSON);
				sb2.append("?origins=place_id:" + TOMMY_PLACE_ID);
				sb2.append("&destinations=place_id:" + place_ids.get(i));
				sb2.append(API_KEY);
				
				url = new URL(sb2.toString());
				conn = (HttpURLConnection) url.openConnection();
				in = new InputStreamReader(conn.getInputStream());
				
				while ((read = in.read(buff)) != -1) {
					jsonDistance.append(buff, 0, read);
				}
				DistanceDetails distanceDetail = new Gson().fromJson(jsonDistance.toString(), DistanceDetails.class);
				String distanceTime = distanceDetail.getRows().get(0).getElements().get(0).getDuration().getText();
				int distanceValue = Integer.valueOf(distanceDetail.getRows().get(0).getElements().get(0).getDuration().getValue());
				
				
				ReturnResult returnResult = new ReturnResult();
				returnResult.copyResult(result);
				returnResult.setDistance(distanceTime);
				returnResult.setDistanceValue(distanceValue);
				
				results.add(returnResult);
			
			}
		} catch (MalformedURLException e) {
			System.out.println("Error processing Places API URL");
		} catch (IOException e) {
			System.out.println("Error connectiong to Places API");
		} finally {
			if(conn != null) {
				conn.disconnect();
			}	
		}
		return results;
	}
	
	
	public String formatJSON(ArrayList<ReturnResult> results, int returnLimit) {
		
		ArrayList<ReturnResult> limitedResults = new ArrayList<ReturnResult>();
		
		int iterations = 0;
		if( returnLimit > results.size()) {
			Gson restaurantListGson = new Gson(); 
			String restaurantListGsonString = restaurantListGson.toJson(results); 
			
			return restaurantListGsonString;
		} else {
			iterations = returnLimit;
		}
		
		for(int i = 0; i < iterations; i++) {
			limitedResults.add(results.get(i));
		}
		
		Gson restaurantListGson = new Gson(); 
		String restaurantListGsonString = restaurantListGson.toJson(limitedResults); 
		
		return restaurantListGsonString;
	}
	
public String formatJSON(ReturnResult result) {
		
		Gson restaurantListGson = new Gson(); 
		String restaurantListGsonString = restaurantListGson.toJson(result); 
		
		return restaurantListGsonString;
	}
	
	
	public ArrayList<ReturnResult> removeDoNotShow(ArrayList<ReturnResult> results){
		
		if(Lists.doNotShow != null) {
			for(int i = results.size()-1; i >= 0; i-- ) {
				if(Lists.doNotShow.contains(results.get(i).getName())){
					results.remove(i);
				}
			}
		}
		
		return results;
	}
	
	public ArrayList<ReturnResult> raiseFavorites(ArrayList<ReturnResult> results){
		
		
		if(Lists.favorites != null) {
			int indexOfFav = 0;
		
			for(int i = 0; i < results.size(); i++ ) {
				if(Lists.favorites.contains(results.get(i).getName())){
					Collections.swap(results, i, indexOfFav++);
				}
			}
		}
		
		return results;
	}
	
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantModel() {
        super();
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getParameter("name") != null) {
    		for(int i = 0; i < restaurantList.size(); i++) {
    			if(restaurantList.get(i).getName().equals(request.getParameter("name"))) {
    				ArrayList<ReturnResult> holder = new ArrayList<ReturnResult>();
    				holder.add(restaurantList.get(i));
    				String jsonReturn = formatJSON(holder, 1);
    				System.out.println(jsonReturn);
    				System.out.println("Single call");
    				PrintWriter pw = response.getWriter();
    		    	pw.print(jsonReturn);
    		    	break;
    			}
    		}
    	} else if(request.getParameter("type") != null){
    		for(int i = 0; i < restaurantList.size(); i++) {
    			if(restaurantList.get(i).getName().equals(request.getParameter("name"))) {
    				
    		    	break;
    			}
    		}
    	} else {

	    	String query = request.getParameter("key");
	    	System.out.println(query);
	    	
	    	restaurantList = search(query, 2000);
	    	Collections.sort(restaurantList, new SortByDistance());
	    	restaurantList = removeDoNotShow(restaurantList);
	    	restaurantList = raiseFavorites(restaurantList);
	    	
	    	System.out.println(request.getParameter("num"));
	    	int number = Integer.valueOf(request.getParameter("num"));
	    	String jsonReturn = formatJSON(restaurantList, number);
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("restaurantList", jsonReturn);
	    	
	    	System.out.println(jsonReturn);	    	
	    	PrintWriter pw = response.getWriter();
	    	pw.print(jsonReturn);
    	}
    	
    }
}
