$(document).ready(() => {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const food = url.searchParams.get("food");
  const numOfSearch = url.searchParams.get("numOfSearch");

  /* display content */
  $(".result-text").text(`Results For ${food}`);
  displayImages(food);
  displayRestaurants(food, numOfSearch);
  displayRecipes(food, numOfSearch);

  /* add eventlistener to list options */
  $(".manage-list").on("click", () => {
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
  function displayImages(food) {
    const images = [
      "./images/1.jpg",
      "./images/2.jpg",
      "./images/3.jpg",
      "./images/4.jpg",
      "./images/5.jpg",
      "./images/6.jpg",
      "./images/7.jpg",
      "./images/8.jpg",
      "./images/9.jpg",
      "./images/10.jpg"
    ];

    images.forEach((image, index) => {
      const imageDOM = `<img class="result-image image-${index}" src="${image}" style='transform: rotate(${Math.floor(
        Math.random() * 90 - 45
      )}deg)'/>`;
      $(".result-images").append(imageDOM);
    });
  }

  /* get restaurant */
  function displayRestaurants(food, numOfSearch) {
    const restaurants = [
      {
        name: "EVK",
        min: "0.2min",
        address: "asdhjggggggggggggggg",
        price: "$"
      },
      {
        name: "EVKK",
        min: "0.2min",
        address: "asdhjggggggggggggggg",
        price: "$$"
      },
      {
        name: "EVKKK",
        min: "0.2min",
        address: "asdhjggggggggggggggg",
        price: "$$$"
      },
      {
        name: "EVKKKK",
        min: "0.2min",
        address: "asdhjggggggggggggggg",
        price: "$$$"
      }
    ];

    restaurants.forEach((restaurant, index) => {
      const restaurantDOM = `<div class="result-restaurant-item" ${
        index % 2 === 1 ? 'style="background: gray;"' : ""
      } onclick="location.href = './restaurant.html?name=${restaurant.name}'">
        <div class="result-restaurant-item-left">
          <p class="result-restaurant-item-name">${restaurant.name}</p>
          <p class="result-restaurant-item-min">${restaurant.min}</p>
          <p class="result-restaurant-item-address">${restaurant.address}</p>
        </div>
        <div class="result-restaurant-item-right">${restaurant.price}</div>
      </div>`;

      $(".result-restaurant").append(restaurantDOM);
    });
  }

  /* get recipe */
  function displayRecipes(food, numOfSearch) {
    const recipes = [
      {
        name: "EVK",
        cookTime: "10min",
        prepTime: "20min",
        price: "$"
      },
      {
        name: "EVK",
        cookTime: "10min",
        prepTime: "20min",
        price: "$$"
      },
      {
        name: "EVK",
        cookTime: "10min",
        prepTime: "20min",
        price: "$$$"
      },
      {
        name: "EVK",
        cookTime: "10min",
        prepTime: "20min",
        price: "$$$"
      }
    ];

    recipes.forEach((recipe, index) => {
      const recipeDOM = `<div class="result-recipe-item" ${
        index % 2 === 1 ? 'style="background: gray;"' : ""
      } onclick="location.href = './recipe.html?name=${recipe.name}'">
        <div class="result-recipe-item-left">
          <p class="result-recipe-item-name">${recipe.name}</p>
          <p class="result-recipe-item-prepTime">${recipe.prepTime}</p>
          <p class="result-recipe-item-cookTime">${recipe.cookTime}</p>
        </div>
        <div class="result-recipe-item-right">${recipe.price}</div>
      </div>`;

      $(".result-recipe").append(recipeDOM);
    });
  }

  console.log(food, numOfSearch);
});
