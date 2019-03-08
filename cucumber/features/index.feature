Feature: Check Index Page

	Background:
		Given I am at Index page

	Scenario: Go to default page
		Then I should see I'm Hungry

	Scenario: Look at default value for number of search result
		Then I should see the number of results be 5

	Scenario: Look at default value for placeholder under text box
		Then I should see the placeholder of food be Enter Food

	Scenario: Enter 'coffee' for food and '7' as number of search result
		Then I will enter "coffee" for food and "7" as number of search result
		Then I should see the Result Page
