$(document).ready(function() {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const type = url.searchParams.get("type");

  /* display content */
  $(".list-title").text(`${type} List`);
  getContents(type);

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

  $(".select-list").on("click", () => {
    if ($(".dropdown-items").css("visibility") === "hidden") {
      $(".dropdown-items").css("visibility", "visible");
    } else {
      $(".dropdown-items").css("visibility", "hidden");
    }
  });

  $(".return-to-search").on("click", () => {
    location.href = "/index.html";
  });

  $(".return-to-result").on("click", () => {
    location.href = "/results.html";
  });

  $(".dropdown-item-single").click(function() {
    $(".dropdown-content").text($(this).text());
  });

  /* get contents */
  function getContents(type) {
    let contents = [];
    if (type === "Favorites") {
      contents = [
        {
          name: "FAV",
          min: "0.2min",
          address: "asdhjggggggggggggggg",
          price: "$"
        },
        {
          name: "FAVK",
          min: "0.2min",
          address: "asdhjggggggggggggggg",
          price: "$$"
        },
        {
          name: "FAV",
          cookTime: "10min",
          prepTime: "20min",
          price: "$"
        },
        {
          name: "FAV",
          cookTime: "10min",
          prepTime: "20min",
          price: "$$"
        }
      ];
    } else if (type === "To Explore") {
      contents = [
        {
          name: "EXP",
          min: "0.2min",
          address: "asdhjggggggggggggggg",
          price: "$"
        },
        {
          name: "EXPK",
          min: "0.2min",
          address: "asdhjggggggggggggggg",
          price: "$$"
        },
        {
          name: "EXP",
          cookTime: "10min",
          prepTime: "20min",
          price: "$"
        },
        {
          name: "EXP",
          cookTime: "10min",
          prepTime: "20min",
          price: "$$"
        }
      ];
    } else if (type === "Do Not Show") {
      contents = [
        {
          name: "NO",
          min: "0.2min",
          address: "asdhjggggggggggggggg",
          price: "$"
        },
        {
          name: "NOK",
          min: "0.2min",
          address: "asdhjggggggggggggggg",
          price: "$$"
        },
        {
          name: "NO",
          cookTime: "10min",
          prepTime: "20min",
          price: "$"
        },
        {
          name: "NO",
          cookTime: "10min",
          prepTime: "20min",
          price: "$$"
        }
      ];
    }

    contents.forEach((content, index) => {
      // if recipe
      if (content["cookTime"]) {
        const recipeDOM = `<div class="result-recipe-item" ${
          index % 2 === 1 ? 'style="background: gray;"' : ""
        } onclick="location.href = './recipe.html?name=${content.name}'">
                <div class="result-recipe-item-left">
                  <p class="result-recipe-item-name">${content.name}</p>
                  <p class="result-recipe-item-prepTime">${content.prepTime}</p>
                  <p class="result-recipe-item-cookTime">${content.cookTime}</p>
                </div>
                <div class="result-recipe-item-right">${content.price}</div>
              </div>`;

        $(".list-content").append(recipeDOM);
      } else {
        // if restaurant
        const restaurantDOM = `<div class="result-restaurant-item" ${
          index % 2 === 1 ? 'style="background: gray;"' : ""
        } onclick="location.href = './restaurant.html?name=${content.name}'">
            <div class="result-restaurant-item-left">
              <p class="result-restaurant-item-name">${content.name}</p>
              <p class="result-restaurant-item-min">${content.min}</p>
              <p class="result-restaurant-item-address">${content.address}</p>
            </div>
            <div class="result-restaurant-item-right">${content.price}</div>
          </div>`;

        $(".list-content").append(restaurantDOM);
      }
    });
  }
});
