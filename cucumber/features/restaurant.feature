Feature: Check Restaurant Page

    Background:
        Given User enters "coffee" and "7" and click Feed Me! and clicks the first result of Restaurant

    Scenario: Layout of restaurant page
        Then Page displays the name, address, phone number, and website link of the restaurant
        Then There is a button to trigger a printable version of the restaurant
        Then There is a button to take you back to previous Results Page

    Scenario: Click on address of restaurant
        Then: Clicking on the address takes you to Google Maps directions page with the destination prefilled with the address of the restaurant and starting point as USC

    Scenario: Click on website link of the restaurant
        Then: Clicking on the website link takes you to the restaurant’s home page

    Scenario: List options for restaurant page
        Then There is a button labeled "Add to List"
        Then Click the add button by selecting nothing will have an alert
        Then There is a dropdown box to select one of the predefined lists
        Then Select Favorite List and click add to list
        Then Select To Explore List and click add to list
        Then Select Do Not Show List and click add to list
        Then Go to three lists to see if the restaurant is added