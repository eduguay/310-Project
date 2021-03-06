$(document).ready(() => {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const food = url.searchParams.get("food");
  const numOfSearch = url.searchParams.get("numOfSearch");

  /* display content */
  $(".result-text").text(`Results for ${food}`);
  getImages(food, displayImages);
  getRestaurants(food, numOfSearch, displayRestaurants);
  getRecipes(food, numOfSearch, displayRecipes);

  /* add eventlistener to list options */
  $(".manage-list").on("click", () => {
    // window.history.pushState({}, "", "./list.html");
    if (
      $(
        $(".dropdown-content").text() === undefined || ".dropdown-content"
      ).text() === " "
    ) {
      alert("Please select a list first!");
    } else {
      location.href = `./list.html?type=${$(".dropdown-content")
        .text()
        .trim()}&food=${food}&numOfSearch=${numOfSearch}`;
    }
  });

  $(".return-to").on("click", () => {
    location.href = "./index.html";
  });

  $(".select-list").on("click", () => {
    if ($(".dropdown-items").css("visibility") === "hidden") {
      $(".dropdown-items").css("visibility", "visible");
    } else {
      $(".dropdown-items").css("visibility", "hidden");
    }
  });

  $(".dropdown-item-single").click(function() {
    $(".dropdown-content").text($(this).text());
  });

  /* get images */
  function displayImages(images) {

    images.forEach((image, index) => {
      const imageDOM = `<img class="result-image image-${index}" src="${image}" style='transform: rotate(${Math.floor(
        Math.random() * 90 - 45
      )}deg)'/>`;
      $(".result-images").append(imageDOM);
    });
  }

  /* get restaurant */
  function displayRestaurants(restaurants) {

    const url_string_2 = window.location.href;
    const url_2 = new URL(url_string_2);
    const num = url_2.searchParams.get("numOfSearch");

    restaurants.forEach((restaurant, index) => {
      const restaurantDOM = `<div class="result-restaurant-item restaurant-${index}" ${
        index % 2 === 1 ? 'style="background: gray;"' : ""
      } onclick="location.href = './restaurant.html?name=${
        restaurant.name
      }&numOfSearch=${num}&food=${food}'">
        <div class="result-restaurant-item-left">
          <p class="result-restaurant-item-name">${restaurant.name}</p>
          <p class="result-restaurant-item-min">${restaurant.min}</p>
          <p class="result-restaurant-item-address">${restaurant.address}</p>
        </div>
        <div class="result-restaurant-item-right">${restaurant.price ? restaurant.price : 1}</div>
      </div>`;

      $(".result-restaurant").append(restaurantDOM);
    });
  }

  /* get recipe */
  function displayRecipes(recipes, numOfSearch) {

    const url_string_2 = window.location.href;
    const url_2 = new URL(url_string_2);
    const num = url_2.searchParams.get("numOfSearch");

    recipes.forEach((recipe, index) => {
      const recipeDOM = `<div class="result-recipe-item recipe-${index}" ${
        index % 2 === 1 ? 'style="background: gray;"' : ""
      } onclick="location.href = './recipe.html?name=${
        recipe.name
      }&numOfSearch=${num}&food=${food}'">
        <div class="result-recipe-item-left">
          <p class="result-recipe-item-name">${recipe.recipeName}</p>
          <p class="result-recipe-item-prepTime">${recipe.prepTime}</p>
          <p class="result-recipe-item-cookTime">${recipe.cookTime}</p>
        </div>
      </div>`;

      $(".result-recipe").append(recipeDOM);
    });
  }

  // get images from backend
  function getImages(food, callback) {
    $.ajax({
      type: "get",
      url: `SearchController?key=${food}`,
      async: true,
      success: function(data) {
    	  var images = JSON.parse(data);
        callback(images);
      },
      error: function(err) {
        console.log(err);
        callback();
      }
    });
  }

  // get restaurants from backend
  function getRestaurants(food, numOfSearch, callback) {
    $.ajax({
      type: "get",
      url: `RestaurantModel?key=${food}&num=${numOfSearch}`,
      async: true,
      success: function(data) {
    	
    	var restaurant = JSON.parse(data);
    	 console.log(restaurant);
        callback(restaurant);
      },
      error: function(err) {
    	  console.log('error');
        console.log(err);
        callback();
      }
    });
  }

  // get recipes from backend
  function getRecipes(food, numOfSearch, callback) {
    $.ajax({
      type: "get",
      url: `RecipeModel1?key=${food}&num=${numOfSearch}`,
      async: true,
      success: function(data) {
    	  var recipe = JSON.parse(data);
    	
    	  console.log(recipe[0]);
    	  
        callback(recipe[0]);
      },
      error: function(err) {
        console.log(err);
        callback();
      }
    });
  }

  console.log(food, numOfSearch);
});
