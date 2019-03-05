public class Hits {
 Recipe RecipeObject;
 private boolean bookmarked;
 private boolean bought;


 // Getter Methods 

 public Recipe getRecipe() {
  return RecipeObject;
 }

 public boolean getBookmarked() {
  return bookmarked;
 }

 public boolean getBought() {
  return bought;
 }

 // Setter Methods 

 public void setRecipe(Recipe recipeObject) {
  this.RecipeObject = recipeObject;
 }

 public void setBookmarked(boolean bookmarked) {
  this.bookmarked = bookmarked;
 }

 public void setBought(boolean bought) {
  this.bought = bought;
 }
}
