import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class RecipeModel1
 */
public class RecipeModel1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String test = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeModel1() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//grabs query from search page
		request.getParameter("query"); 
		String query = "chicken";

		//interface with the API to grab search results through API URL
		URL url = new URL("https://api.edamam.com/search?q="+query+"&app_id=4a9fd6fd&app_key=5c19fb5e5cd1a263402a46d716c31868");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		//print out the url and test if it is correct
		PrintWriter out = response.getWriter();
		out.println("<h1>" + url + "</h1>");

		con.setRequestProperty("Content-Type", "application/json");

		// Convert to a JSON object to print data
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line+"\n");
		}
		br.close();

		Gson gson = new Gson(); 
		RecipeModel recipe = gson.fromJson(sb.toString(),RecipeModel.class); 
		String recipe_string = recipe.hits.toString();
		ArrayList<String> recipeNameList = new ArrayList<String>();
		ArrayList<String> recipeTimesList = new ArrayList<String>();
		Map<String,String[]> recipeList = new HashMap<String, String[]>();

		//splits json string
		String[] parts = recipe_string.split(",");

		//add the names of recipes(called label in JSON) to the recipeTimesList ArrayList
		String recipe_name = ""; 
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].contains("label") && parts[i+1].contains("image")) {
				String[] label = parts[i].split("=");
				recipe_name = label[1];
				recipeNameList.add(recipe_name);
			}
		}

		//add the times to the recipeTimesList ArrayList  
		double cookTime = 0;
		double prepTime = 0;
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].contains("totalTime") && parts[i+1].contains("totalNutrients")) {
				String[] time = parts[i].split("=");
				cookTime = (Double.parseDouble(time[1])*0.6);
				prepTime = (Double.parseDouble(time[1])*0.4);
				recipeTimesList.add(Double.toString(cookTime));
				recipeTimesList.add(Double.toString(prepTime));
			}
		}

		//create a HashMap of <RecipeName, Recipe Times>
		for (int i = 0; i < recipeNameList.size();i++) {
			String[] times = new String[2];
			times[0] = recipeTimesList.get(i);  //cookTime
			times[1] = recipeTimesList.get(i+1);  //prepTime
			recipeList.put(recipeNameList.get(i), times);
		}

		//filter recipe results from API with the doNotShow List constraints
		Iterator it = recipeList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			String recipeName = (String) pair.getKey();
			String[] times = (String[]) pair.getValue();

			if (Lists.doNotShow.contains(recipeName)) {
				recipeList.remove(recipeName);
			}
			it.remove();
		}
		
		//filter recipe results from API with the favorites List items to show at top
		Map<String,String[]> orderedRecipes = new LinkedHashMap<String,String[]>();
		Iterator it1 = recipeList.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry)it1.next();
			String recipeName = (String) pair.getKey();
			String[] times = (String[]) pair.getValue();
			if (Lists.favorites.contains(recipeName)) {
				orderedRecipes.put(recipeName,times);
				recipeList.remove(recipeName);
			}
			it1.remove();
		}
		
		//add remaining items from recipeList to orderedRecipes
		if (!recipeList.isEmpty()) {
			Iterator it2 = recipeList.entrySet().iterator();
			while(it1.hasNext()) {
				Map.Entry pair = (Map.Entry)it2.next();
				String recipeName = (String) pair.getKey();
				String[] times = (String[]) pair.getValue();
				orderedRecipes.put(recipeName, times);
			}
		}
		
		//convert the JSON to a String to be passed to front-end
		Gson recipeListGson = new Gson(); 
		String recipeListGsonString = recipeListGson.toJson(orderedRecipes); 

		//creating session storage for JSON to be accessible to other servlets
		HttpSession session = request.getSession();
		session.setAttribute("recipeList", recipeListGsonString);

		//send recipeList to front end
		PrintWriter pw = response.getWriter();
		pw.print(recipeListGsonString);
	}
}