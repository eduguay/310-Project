$(document).ready(function() {
  /* get info from parameter and send request to backend */
  const url_string = window.location.href;
  const url = new URL(url_string);
  const name = url.searchParams.get("name");

  /* display content */
  displayRestaurant(name);

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

  /* get Restaurant data */
  function displayRestaurant(name) {
    const restaurant = {
      address: "20min",
      phone: "2137564321",
      website: "https://www.leetcode.com",
      image: "./images/10.jpg",
      name
    };

    const restaurantDOM = `<h1 class="restaurant-title">${restaurant.name}</h1>
    <img src="${restaurant.image}" class="restaurant-image mt-3" />
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
});
