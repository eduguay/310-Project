import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import restaurantJSON.ReturnResult;

public class RestaurantModelTest {

	@Test
	public void testSearch() {
		RestaurantModel test = new RestaurantModel();
		ArrayList<ReturnResult>  testRecipe= test.search("coffee");
		
	}

}
