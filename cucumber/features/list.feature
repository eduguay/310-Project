Feature: Check List Page

    Background:
        Given User will enter "coffee" and "7" and click Feed Me! and adds several items to three lists

    Scenario: List Page Layout
        Then There is a button labeled Results Page
        Then Clicking the result button takes the user back to the Results Page
        Then There is a button labeled Return to Search Page
        Then Clicking the search button takes the user back to the Search Page

    Scenario: List options for list page
        Then There is a button labeled "Manage List" in list page
        Then The content of dropdown menu should be nothing
        Then Click the button by selecting nothing will have an alert
        Then The user will be able to select lists

    Scenario: Display all items in three lists
        Then All items that have been added to the list are to be displayed