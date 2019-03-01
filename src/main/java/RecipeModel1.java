import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecipeModel1
 */
public class RecipeModel1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeModel1() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "chicken";
		URL url = new URL("https://api.edamam.com/search?q="+query+"&app_id=4a9fd6fd&app_key=5c19fb5e5cd1a263402a46d716c31868");
		//HttpURLConnection con = (HttpURLConnection) url.openConnection();
		//con.setRequestMethod("GET");

		//print out the url and test if it is correct
		PrintWriter out = response.getWriter();
		out.println("<h1>" + url + "</h1>");

//		con.setRequestProperty("Content-Type", "application/json");

		URLConnection urlr = url.openConnection();
		urlr.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); 
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) urlr.getContent())); 
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
	    
	    
	    String q = rootobj.get("q").getAsString(); //just grab the zipcode
	    out.println("<h1>" + q + "</h1>");

		
		//		request.setAttribute("recipeListJson", recipeList);
		//		RequestDispatcher view1 = request.getRequestDispatcher("GuestMatches.jsp");
		//		view1.forward(request, response);
	}


}
