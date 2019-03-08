package restaurantJSON;

import java.util.Comparator;

public class SortByDistance implements Comparator<ReturnResult>{
	public int compare(ReturnResult a, ReturnResult b) {
		return a.getDistanceValue() - b.getDistanceValue();
	}
}
