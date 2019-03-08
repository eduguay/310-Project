$(document).ready(function() {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const type = url.searchParams.get("type");
  const food = url.searchParams.get("food");
  const numOfSearch = url.searchParams.get("numOfSearch");

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
        .trim()}&food=${food}&numOfSearch=${numOfSearch}`;
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
    location.href = `/results.html?food=${food}&numOfSearch=${numOfSearch}`;
  });

  $(".dropdown-item-single").click(function() {
    $(".dropdown-content").text($(this).text());
  });

  /* get contents */
  function getContents(type) {
    switch (type) {
      case "Favorites":
        getFavList(displayContents);
        break;
      case "To Explore":
        getToEx(displayContents);
        break;
      case "Do Not Show":
        getNotShow(displayContents);
        break;

      default:
        return;
    }
  }

  // display contents
  function displayContents(contents) {
    contents.forEach((content, index) => {
      // if recipe
      if (content["cookTime"]) {
        const recipeDOM = `<div class="result-recipe-item ${content.name}" ${
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
        const restaurantDOM = `<div class="result-restaurant-item ${content.name}" ${
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

  // get favorites list
  function getFavList(callback) {
    $.ajax({
      type: "get",
      url: `temp?list=favorite`,
      async: true,
      success: function(data) {
        callback(data);
      },
      error: function(err) {
        console.log(err);
      }
    });
  }

  // get to explore list
  function getToEx(callback) {
    $.ajax({
      type: "get",
      url: `temp?list=toex`,
      async: true,
      success: function(data) {
        callback(data);
      },
      error: function(err) {
        console.log(err);
      }
    });
  }

  // get do not show list
  function getNotShow(callback) {
    $.ajax({
      type: "get",
      url: `temp?list=notshow`,
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
