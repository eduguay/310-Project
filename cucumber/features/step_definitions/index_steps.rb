# go to default page
Given(/^I am about to go to the website$/) do
    visit 'http://localhost:8080/Team4'
end

Then(/^I should see I'm Hungry$/) do
    expect(page).to have_title "I'm Hungry"
end

Then(/^I should see the number of results be 5$/) do 
    expect(find('#search-text').value).to eq '5'
end

Then(/^I should see the placeholder of food be Enter Food$/) do
    expect(find('#food-text')['placeholder']).to eq 'Enter Food'
end

# enter input fot search
Given(/^I am at Index page$/) do
    visit 'http://localhost:8080/Team4'
end

Then(/^I will enter "(.*)" as the input for food to search$/) do |foodToSearch|
    fill_in 'food-text', :with => foodToSearch
end

Then(/^I will enter "(.*)" as the input for number of searches$/) do |numOfSearch|
    fill_in 'search-text', :with => numOfSearch
end

When(/^press Feed Me!$/) do
    find('#search-button').native.send_key(:enter)
end

Then(/^I should see the Result Page$/) do
    expect(page).to have_title "Search Results - I'm Hungry"
    expect(page.current_url).to eq 'http://localhost:8080/Team4/results.html?food=coffee&numOfSearch=7'
end