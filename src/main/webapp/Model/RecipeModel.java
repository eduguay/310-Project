
public class RecipeModel {
	private String recipeName;
	private HashMap<String, Integer> ingredients;
	private LinkedList<String> instructions;
	private int prepTime;
	private int cookingTime;
	
	public Recipe (String name) {
		this.recipeName = name;
	}
	
	public String getRecipeName() {
		return recipeName;
	}
	
	public int getPrepTime() {
		return prepTime;
	}
	public int getCookingTime() {
		return cookingTime;
	}
}
