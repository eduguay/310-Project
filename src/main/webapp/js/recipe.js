$(document).ready(function() {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const name = url.searchParams.get("name");

  /* display content */
  displayRecipe(name);

  /* add eventlistener to list options */
  $(".add-list").on("click", () => {
    // window.history.pushState({}, "", "./list.html");
    if (
      $(
        $(".dropdown-content").text() === undefined || ".dropdown-content"
      ).text() === ""
    ) {
      alert("Please select a list first!");
    } else {
      location.href = `./list.html?type=${$(".dropdown-content")
        .text()
        .trim()}`;
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
    location.href = "/results.html";
  });

  $(".dropdown-item-single").click(function() {
    $(".dropdown-content").text($(this).text());
  });

  /* get recipe data */
  function displayRecipe(name) {
    const recipe = {
      prepTime: "20min",
      cookTime: "30min",
      ingredients: ["A", "B", "C", "D", "E", "F"],
      instructions: [
        "Get a poisonous cookie",
        "Throw the cookie to Halfond's face"
      ],
      image: "./images/1.jpg",
      name
    };

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
});
