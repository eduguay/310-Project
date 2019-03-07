$(document).ready(function() {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const name = url.searchParams.get("name");
  const numOfSearch = url.searchParams.get("numOfSearch");

  /* display content */
  getRestaurant(name, displayRestaurant);

  /* add eventlistener to list options */
  $(".add-list").on("click", () => {
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
    location.href = `/results.html?food=${name}&numOfSearch=${numOfSearch}`;
  });

  $(".dropdown-item-single").click(function() {
    $(".dropdown-content").text($(this).text());
  });

  $(".print-version").click(function() {
    window.open(`printableRestaurant.html?name=${name}`);
  });

  /* display Restaurant data */
  function displayRestaurant(restaurant) {
    restaurant = {
      address: "20min",
      phone: "2137564321",
      website: "https://www.leetcode.com",
      image: "./images/10.jpg",
      name
    };

    const restaurantDOM = `<h1 class="restaurant-title">${restaurant.name}</h1>
    <p class="restaurant-address mt-5">Address: ${restaurant.address}</p>
    <p class="restaurant-phone">Contact: ${restaurant.phone}</p>
    <a
      class="restaurant-website"
      href="${restaurant.website}"
      target="_blank"
      >${restaurant.website}</a
    >`;

    $(".restaurant-detail").append(restaurantDOM);
  }

  // get restaurant data
  function getRestaurant(name, callback) {
    $.ajax({
      type: "get",
      url: `restaurant?name=${name}`,
      async: true,
      success: function(data) {
        callback(data);
      },
      error: function(err) {
        console.log(err);
        callback();
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
