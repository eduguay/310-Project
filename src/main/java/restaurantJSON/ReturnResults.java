package restaurantJSON;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReturnResults {

	@SerializedName("returnResults") 
	@Expose
	private List<ReturnResult> returnResults = null;
	
	
	public List<ReturnResult> getResults() {
		return returnResults;
	}
	
	public void setResults(List<ReturnResult> results) {
		this.returnResults = results;
	}
}
