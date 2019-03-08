$(document).ready(function() {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const name = url.searchParams.get("name");
  const numOfSearch = url.searchParams.get("numOfSearch");
  const food = url.searchParams.get("food");

  /* display content */
  getRecipe(name, displayRecipe);

  /* add eventlistener to list options */
  $(".add-list").on("click", () => {
    // window.history.pushState({}, "", "./list.html");
    const type = $(".dropdown-content").text();
    if (type === undefined || type === "") {
      alert("Please select a list first!");
    } else {
      addToList(type);
    }
  });

  $(".select-list").on("click", () => {
    if ($(".dropdown-items").css("visibility") === "hidden") {
      $(".dropdown-items").css("visibility", "visible");
    } else {
      $(".dropdown-items").css("visibility", "hidden");
    }
  });

  $(".return-to").on("click", () => {
    location.href = `results.html?food=${food}&numOfSearch=${numOfSearch}`;
  });

  $(".dropdown-item-single").click(function() {
    $(".dropdown-content").text($(this).text());
  });

  $(".print-version").click(function() {
    window.open(`printableRecipe.html?name=${name}`);
  });

  /* display recipe data */
  function displayRecipe(recipe) {

    let ingredients = "";
    recipe.ingredients.forEach(ingredient => {
      ingredients += `<div class="ingredient-item">-${ingredient}</div>`;
    });

    let instructions = "";
    recipe.instructions.forEach(instruction => {
      instructions += `<li>${instruction}</li>`;
    });

    const recipeDOM = `<h1 class="recipe-title">${recipe.name}</h1>
    <img src="${recipe.image}" class="recipe-image mt-3" />
    <p class="prep-time mt-5">Prep Time: ${recipe.prepTime}</p>
    <p class="cook-time">Cook Time: ${recipe.cookTime}</p>
    <p class="ingredients-title mt-3 font-weight-bold">Ingredients</p>
    <div class="ingredients">
      ${ingredients}
    </div>
    <p class="instruction-title font-weight-bold">Instructions</p>
    <div class="instructions mt-3">
      <ol>
        ${instructions}
      </ol>
    </div>`;

    $(".recipe-detail").append(recipeDOM);
  }

  // get recipe data
  function getRecipe(name, callback) {
    $.ajax({
      type: "get",
      url: `RecipeModel1?query=${name}`,
      async: true,
      success: function(data) {
    	var recipe = JSON.parse(data);
    	console.log(recipe);
        callback(recipe);
      },
      error: function(err) {
        console.log(err);
      }
    });
  }

  // add to list
  function addToList(type) {
    $.ajax({
      type: "post",
      url: `add?type=${type}`,
      async: true,
      success: function(data) {
        callback(data);
      },
      error: function(err) {
        console.log(err);
      }
    });
  }
});
