import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import restaurantJSON.ReturnResult;

public class RestaurantModelTest {

	@Test
	public void testSearch() {
		RestaurantModel test = new RestaurantModel();
		ArrayList<ReturnResult> testRecipe= RestaurantModel.search("coffee");
		assertTrue(!testRecipe.isEmpty());
	}
	
	@Test
	public void testFormatJSON() {
		RestaurantModel test = new RestaurantModel();
		ArrayList<ReturnResult> testRecipe = RestaurantModel.search("coffee");
		assertTrue(!test.formatJSON(testRecipe,5).equals(""));
	}
	
	@Test
	public void testFormatJSON1() {
		RestaurantModel test = new RestaurantModel();
		ReturnResult testResult = new ReturnResult(); 
		assertTrue(!test.formatJSON(testResult).equals(""));
	}
	
	@Test
	public void testDoNotShow() {
		RestaurantModel test = new RestaurantModel();
		ArrayList<ReturnResult> testRecipe= RestaurantModel.search("coffee");
		ArrayList<ReturnResult> results = test.removeDoNotShow(testRecipe);
		assertTrue(!results.isEmpty());
	}
	
	@Test
	public void testRaiseFavorites() {
		RestaurantModel test = new RestaurantModel();
		Lists.favorites = new ArrayList<String>();
		Lists.favorites.add("a");
		
		ArrayList<ReturnResult> results = RestaurantModel.search("coffee");
		assertTrue(!results.isEmpty());
		
	}
	
	@Test
	public void testService() {
		HttpServletRequest request = mock(HttpServletRequest.class);       
		HttpServletResponse response = mock(HttpServletResponse.class); 

		when(request.getParameter("query")).thenReturn("coffee");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer); //returns writer (aka the json from the RecipeModel1)

		new RestaurantModel().service(request, response);
		
		writer.flush(); 
		assertTrue(stringWriter.toString().contains(""));
		
	}

}
