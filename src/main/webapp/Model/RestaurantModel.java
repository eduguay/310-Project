

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Places API Key:  


/**
 * Servlet implementation class RestaurantModel
 */
public class RestaurantModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Building blocks of the API string
	private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
	private static final String TYPE_SEARCH = "/search";
	private static final String OUT_JSON = "/json";
		//Tommy Trojan LATs and Longs
	private static final String LAT = "34.021217";
	private static final String LNG = "-118.287093";
		// Places API Key
	private static final String API_KEY = "AIzaSyBKL46dI7C9lgxkPQXK63DNdZeK_8Tw06k";

	
	
	
	public static ArrayList<Place> search(String keyword, int radius){
		ArrayList<Place> resultList = null;
		
		HttpURLConnnection conn = null;
		StringBuilder jsonResults = new StringBuilder();
		try {
			StringBuilder sb = new StringBulider(PLACES_API_BASE);
			sb.append(TYPE_SEARCH);
			sb.append(OUT_JSON);
			sb.append("?sensor=false");
			sb.append("&key=" + API_KEY);
			sb.append("&keyword=" + URLEncoder.encode(keyword, "utf8"));
			sb.append("&location=" + String.valueOf(LAT) + "," + String.valueOf(LNG));
			sb.append("$radius=" + String.valueOf(radius));
			
			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in new InputStreamReader(conn.getInputStream());
			
			int read;
			char[] buff = new char[1024];
			while ((read = in.read(buff)) != -1) {
				jsonResults.append(buff, 0, read);
			}
		} catch (MalformedURLException e) {
			Log.e(LOG_TAG, "Error processing Places API URL", e);
			return resultList;
		} catch (IOException e) {
			Log.e(LOG_TAG, "Error connectiong to Places API", e);
			return resultList;
		} finally {
			if(conn != null) {
				conn.disconnect();
			}
		}
		
		try {
			//Create the JSON object
			JSONObject jsonObj = new JSONObject(jsonResults.toString());
			JSONArray predsJsonArray = jsonObj.getJSONArray("results");
			
			
			resultList = new ArrayList<Place>(predsJsonArray.length());
			for (int i = 0; i < predsJsonArray.length(); i++) {
				Place place = new Place();
				place.reference = predsJsonArray.getJSONObject(i).getString("reference");
				place.name = predsJsonArray.getJSONObject(i).getString("name");
				resultList.add(place);
			}
		} catch (JSONException e) {
			Log.e(LOG_TAG, "Error processing JSON results", e);
		}
		
		return resultList;
		
	}
	
	public static Place details(String reference) {
		HttpURLConnection conn = null;
		StringBuilder jsonResluts = new StringBuilder();
		try {
			StringBuilder sb = new StringBuilder(PLACES_API_BASE);
			sb.append(TYPE_DETAILS);
			sb.append(OUT_JSON);
			sb.append("?sensor=false");
			sb.append("&key=" + API_KEY);
			sb.append("&reference=" + URLEncoder.encode(referenc,  "utf8"));
			
			
			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream();
			
			int read;
			char[] buff = new char[1024];
			while((read = in.read(buff)) != -1) {
				jsonResults.append(buff, 0, read);
			}
		} catch (MalformedURLException e) {
			Log.e(LOG_TAG, "Error processing Places API URL", e);
			return null;
		} catch (IOException e) {
			Log.e(LOG_TAG, "Error connecting to Places API", e);
			return null;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		Place place = null;
		try {
			
			JSONObject jsonObj = new JSONObject(jsonResults.toString());
			
			place = new Place();
			place.icon = jsonobj.getString("icon");
			place.name = jsonObj.getSTring("name");
			place.formatted_address = jsonObj.getString("formatted_address");
			if(jsonObj.has("formatted_phone_number")) {
				place.formatted_phone_number = jsonObj.getString("formatted_phone_number");
			}
		} catch (JSONException e) {
			Log.e(LOG_TAG, "Error processing JSON results", e)))
		}
		
		return place;

	}
	
	
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantModel() {
        super();
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String query = "chicken";
    	
    	ArrayList<Place> restaurantList = search(query, 10);
    	
    	
    	Gson restaurantListGson = new Gson();
    	String restaurantListGsonString = restaurantListGeson.toJson(restaurantList);
    	
    	request.setAttribute("restaurantListGsonString", restaurantListGsonString);
    	RequestDispatcher view1 = request.getRequestDispatcher("results.html");
    	view1.forward(request, response);
    	
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
