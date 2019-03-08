Feature: Check Index Page

	Background:
		Given I am at Index page

	Scenario: Go to default page
		Then I should see I'm Hungry

	Scenario: Look at default value for number of search result
		Then I should see the number of results be 5

	Scenario: Look at default value for placeholder under text box
		Then I should see the placeholder of food be Enter Food

	Scenario: Enter nothing for food and '5' for number of search result
		And press Feed Me!
		Then I should see I'm Hungry

	Scenario: Enter 'coffee' for food and '2.1' as number of search result
		Then I will enter "coffee" as the input for food to search
		Then I will enter "2.1" as the input for number of searches
		And press Feed Me!
		Then I should see I'm Hungry

	Scenario: Enter 'coffee' for food and 'test' as number of search result
		Then I will enter "coffee" as the input for food to search
		Then I will enter "test" as the input for number of searches
		And press Feed Me!
		Then I should see I'm Hungry

	Scenario: Enter 'coffee' for food and '-10' as number of search result
		Then I will enter "coffee" as the input for food to search
		Then I will enter "-10" as the input for number of searches
		And press Feed Me!
		Then I should see I'm Hungry

	Scenario: Enter 'coffee' for food and '7' as number of search result
		Then I will enter "coffee" as the input for food to search
		Then I will enter "7" as the input for number of searches
		And press Feed Me!
		Then I should see the Result Page
