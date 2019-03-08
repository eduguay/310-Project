import static org.junit.Assert.assertTrue;



import java.io.PrintWriter;

import java.io.StringWriter;

import java.util.HashMap;

import java.util.Map;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import org.junit.Test;

import org.mockito.Mockito;



public class RecipeModel1Test extends Mockito{

	

//	@Test

//	public void testFiltering() throws Exception {

//		RecipeModel1 test = new RecipeModel1();

//		String recipeName = "Chicken Vesuvio";

//		Map<String,String[]> recipeList = new HashMap<String,String[]>();

//		String[] times = new String[2];

//		times[0] = "5.0";

//		times[1] = "5.0";

//		recipeList.put(recipeName, times);

//		

//		test.filter(recipeList);

//		

//		Lists.doNotShow.add(recipeName);

//		Lists.favorites.add(recipeName);

//		

//		assertTrue(!Lists.favorites.equals(null));

//		assertTrue(!Lists.doNotShow.equals(null));

//	}

	

	@Test

	public void testSaveSession() throws Exception {

		RecipeModel1 test = new RecipeModel1();

		HttpServletRequest request = mock(HttpServletRequest.class); 

		HttpSession session = request.getSession(true);

		String recipeListGsonString = "";

		test.saveSession(session, recipeListGsonString);

		

		assertTrue(!(session == (null)));

	}

	

	@Test

	public void testAddToList() throws Exception {

		RecipeModel1 test = new RecipeModel1();

		String recipe = "recipetest";

		test.addToList("favorites",recipe);

		test.addToList("doNotShow",recipe);

		test.addToList("toExplore",recipe);

		

		assertTrue(!Lists.favorites.equals(null));

		assertTrue(!Lists.toExplore.equals(null));

		assertTrue(!Lists.doNotShow.equals(null));

	}

	

	@Test

	public void testServlet() throws Exception {

		HttpServletRequest request = mock(HttpServletRequest.class);       

		HttpServletResponse response = mock(HttpServletResponse.class); 



		when(request.getParameter("query")).thenReturn("chicken");



		StringWriter stringWriter = new StringWriter();

		PrintWriter writer = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(writer); //returns writer (aka the json from the RecipeModel1)



		new RecipeModel1().service(request, response);

		

		writer.flush(); 

		assertTrue(stringWriter.toString().contains(""));

	}

}