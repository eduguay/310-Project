$(document).ready(function() {
  /* display results on hover */
  $("#search-text").on("mouseenter", () => {
    // alert("test!");
  });

  /* forward page */
  $(".search-form").on("submit", e => {
    e.preventDefault();
    location.href = `results.html?${$("form").serialize()}`;
  });
});
