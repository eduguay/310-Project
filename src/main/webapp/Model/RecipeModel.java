import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
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


/**
 * Servlet implementation class Results
 */
@WebServlet("/Recipes")
public class RecipeModel extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Recipes() {
		super();
	}	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "chicken";
		//		https://api.edamam.com/search?q=chicken&app_id=4a9fd6fd&app_key=5c19fb5e5cd1a263402a46d716c31868
		URL url = new URL("https://api.edamam.com/search?q="+query+"&app_id=4a9fd6fd&app_key=5c19fb5e5cd1a263402a46d716c31868");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		PrintWriter out = response.getWriter();
		out.println("<h1>" + url + "</h1>");

		con.setRequestProperty("Content-Type", "application/json");
		
		//parse url json into JSONObject 
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
            System.out.println(line);
        }
        br.close();
        
//        System.out.println("sb.tostring()" + sb.toString());


		//		request.setAttribute("recipeListJson", recipeList);
		//		RequestDispatcher view1 = request.getRequestDispatcher("GuestMatches.jsp");
		//		view1.forward(request, response);
	}

}
