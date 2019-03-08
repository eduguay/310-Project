

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import images.ImageReturn;
import images.Value;

/*
 *  Google Custom Search API Key: 
 */



/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Replace the subscriptionKey string value with your valid subscription key.
    static String subscriptionKey = "09afbe8610b749f3a1b20b31e14ebd97";

    static String host = "https://api.cognitive.microsoft.com";
    static String path = "/bing/v7.0/images/search";

//    static String searchTerm = "cake";
       
	
	public static SearchResults SearchImages (String searchQuery) throws Exception {
		
        // construct URL of search request (endpoint + query string)
        URL url = new URL(host + path + "?q=" +  URLEncoder.encode(searchQuery, "UTF-8") + "&maxHeight=200&count=10&imageType=Photo&mkt=en-us");
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);

        // receive JSON body
        InputStream stream = connection.getInputStream();
        String response = new Scanner(stream).useDelimiter("\\A").next();

        // construct result object for return
        SearchResults results = new SearchResults(new HashMap<String, String>(), response);

        // extract Bing-related HTTP headers
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (String header : headers.keySet()) {
            if (header == null) continue;      // may have null key
            if (header.startsWith("BingAPIs-") || header.startsWith("X-MSEdge-")) {
                results.relevantHeaders.put(header, headers.get(header).get(0));
            }
            
        }

        stream.close();
        return results;
    }

    // pretty-printer for JSON; uses GSON parser to parse and re-serialize
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (subscriptionKey.length() != 32) {
            System.out.println("Invalid Bing Search API subscription key!");
            System.out.println("Please paste yours into the source code.");
            System.exit(1);
        }

        try {
        	String searchTerm = request.getParameter("key");
        	//String searchTerm = "cake";
            System.out.println("Searching the Web for: " + searchTerm);

            SearchResults result = SearchImages(searchTerm);

            ImageReturn imageReturn = new Gson().fromJson(result.jsonResponse, ImageReturn.class);
            List<Value> values = imageReturn.getValue();
            
            ArrayList<String> images = new ArrayList<String>();
            for(int i = 0; i < values.size(); i++) {
            	images.add(values.get(i).getContentUrl());
            }
            
            //System.out.println("\nJSON Response:\n");
            //System.out.println(prettify(result.jsonResponse));
            Gson imagesList = new Gson();
            String jsonReturn = imagesList.toJson(images);
            System.out.println(jsonReturn);	    	
	    	PrintWriter pw = response.getWriter();
	    	pw.print(jsonReturn);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
            System.exit(1);
        }
        
        
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


//Container class for search results encapsulates relevant headers and JSON data
class SearchResults{
HashMap<String, String> relevantHeaders;
String jsonResponse;
SearchResults(HashMap<String, String> headers, String json) {
   relevantHeaders = headers;
   jsonResponse = json;
}
}