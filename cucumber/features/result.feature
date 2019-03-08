Feature: Check Result Page

    Background:
        Given User will enter "coffee" and "7" and click Feed Me!

    Scenario: The page will display a collage of photos of 'coffee'
        Then I should see a collage of images
    # And Match the result of normal Google search "coffee"

    Scenario: The overall page layout should display the title and nav bar
        Then The page should display the title with "Results for coffee"
        Then There will be a button labeled "Manage List"
        Then The content of dropdown menu should be nothing
        Then Click the button by selecting nothing will have an alert
        Then The user will be able to select lists

    Scenario: Select List and click manage list, it will take you that list
        Then Click the button by selecting "Favorite List" will take you to "Favorite List"

    Scenario: There will be a column of results with the title Restaurants
        Then The title should be Restaurants
        Then The results will show the 7 closest restaurants to USC for coffee
        Then Each restaurant includes name, address, minutes and price
        Then Clicking on a restaurant will take the user to the Restaurant Page

    Scenario: There will be a column of results with the title Recipes
        Then The title should be Recipes
        Then The results will show the 7 recipes for coffee
        Then Each recipe includes name, prep time and cook time
        Then Clicking on a recipe will take the user to the Recipe Page

    Scenario: There should be a button labeled "Return to Search Page" that transitions the user back to the Search Page
        Then There is a button labeled "Return to Search Page"