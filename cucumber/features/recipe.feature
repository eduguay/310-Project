Feature: Check Recipe Page

    Background:
        Given User enters "coffee" and "7" and click Feed Me! and clicks the first result of Recipe

    Scenario: Layout of recipe page
        Then Page displays the title of the recipe
        Then Page displays a picture of the dish
        Then Page displays prep and cook times of the recipe
        Then Page lists all ingredients
        Then Page lists step by step instructions
        Then There is a button to trigger a printable version of the recipe
        Then There is a button to take you back to previous Results Page

    Scenario: List options for recipe page
        Then There is a button labeled "Add to List"
        Then Click the add button by selecting nothing will have an alert
        Then There is a dropdown box to select one of the predefined lists
        Then Select Favorite List and click add to list
        Then Select To Explore List and click add to list
        Then Select Do Not Show List and click add to list
        Then Go to three lists to see if the recipe is added