import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javafx.util.Pair;

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

	//adds recipe to list
	public void addToList(String list, String recipe) {
		if (list.equals("favorites")) {
			Lists.favorites.add(recipe);
		}
		if (list.equals("doNotShow")) { 
			Lists.doNotShow.add(recipe);
		}
		if (list.equals("toExplore")) {
			Lists.toExplore.add(recipe);
		}
	}
	
	public void saveSession (HttpSession session, String recipeListGsonString) {
		if (session != null) {
			session.setAttribute("recipeList", recipeListGsonString);
		}
	}

	public Map<String,String[]> filter(Map<String,String[]> recipeList) {
		//filter recipe results from API with the doNotShow List constraints
		Iterator it = recipeList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			String recipeName = (String) pair.getKey();
			String[] times = (String[]) pair.getValue();

			if (Lists.doNotShow.contains(recipeName)) {
				System.out.println("donotshow ii" + recipeList.size());	
				recipeList.remove(recipeName);
			}
		}

		System.out.println("donotshow" + recipeList.size());

		//filter recipe results from API with the favorites List items to show at top
		Map<String,String[]> orderedRecipes = new LinkedHashMap<String,String[]>();
		Iterator it1 = recipeList.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry)it1.next();
			String recipeName = (String) pair.getKey();
			String[] times = (String[]) pair.getValue();
			if (Lists.favorites.contains(recipeName)) {
				System.out.println("fav ii" + recipeList.size());
				orderedRecipes.put(recipeName,times);
				recipeList.remove(recipeName);
			}
		}

		System.out.println("fav "  +recipeList.size());

		//add remaining items from recipeList to orderedRecipes
		if (!recipeList.isEmpty()) {
			Iterator it2 = recipeList.entrySet().iterator();
			while(it2.hasNext()) {
				Map.Entry pair = (Map.Entry)it2.next();
				String recipeName = (String) pair.getKey();
				String[] times = (String[]) pair.getValue();
				orderedRecipes.put(recipeName, times);
			}
		}

		return orderedRecipes;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//grabs query from search page
		//request.getParameter("query"); 
		String query = "chicken";

		//interface with the API to grab search results through API URL
		URL url = new URL("https://api.edamam.com/search?q="+query+"&app_id=4a9fd6fd&app_key=5c19fb5e5cd1a263402a46d716c31868");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		//print out the url and test if it is correct
		PrintWriter out = response.getWriter();

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

		//splits JSON string
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

		out.println("<h1>" + recipeList.size() + "</h1>");
		System.out.println(recipeList.size());

		//sort results by prepTime using TreeMap object
		//result stores the prepTime as key then pair as value
		//sort by key using TreeMap
		TreeMap<Double, Entry<String, String[]>> result = new TreeMap<Double, Entry<String, String[]>>();
		Iterator it = recipeList.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			String[] times = (String[]) pair.getValue();
			System.out.println("dfae " + Double.parseDouble(times[1]));
			result.put(Double.parseDouble(times[1]), pair);
		}
		
		LinkedHashMap<String, String[]> sortedRecipes = new LinkedHashMap<String, String[]>();
		Iterator it1 = result.entrySet().iterator();
		while(it1.hasNext()) {
			Map.Entry pair = (Map.Entry)it1.next();
			Map.Entry e = (Entry) pair.getValue();
			sortedRecipes.put((String)e.getKey(),(String[])e.getValue());
		}
		
		recipeList = filter(sortedRecipes);
		
		System.out.println("fav added"  +recipeList.size());

		//convert the JSON to a String to be passed to front-end
		Gson recipeListGson = new Gson(); 
		String recipeListGsonString = recipeListGson.toJson(recipeList);

		//creating session storage for JSON to be accessible to other servlets
		HttpSession session = request.getSession(true);
		saveSession(session,recipeListGsonString);

		//		request.setAttribute("recipeList", recipeListGsonString);
		//		RequestDispatcher view1 = request.getRequestDispatcher("results.html");
		//		view1.forward(request, response);

		//send recipeList to front end
		System.out.print(recipeListGsonString);
		out.print(recipeListGsonString);
		out.close();
	}
}
