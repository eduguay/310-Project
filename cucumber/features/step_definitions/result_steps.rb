def wait_for_ajax
    Timeout.timeout(10000) do
      active = page.evaluate_script('jQuery.active')
      until active == 0
        active = page.evaluate_script('jQuery.active')
      end
    end
  end


# check result page
Given(/^User will enter "(.+)" and "(.+)" and click Feed Me!$/) do |foodToSearch, numOfSearch|
    visit 'http://localhost:8080/Team4'
    fill_in 'food-text', :with => foodToSearch
    fill_in 'search-text', :with => numOfSearch
    find('#search-button').native.send_key(:enter)
    wait_for_ajax
    expect(page.current_url).to eq 'http://localhost:8080/Team4/results.html?food=' + foodToSearch + '&numOfSearch=' + numOfSearch
end

# check images
Then(/^I should see a collage of images$/) do
    find('.image-0')[:class].include?('result-image')
    find('.image-1')[:class].include?('result-image')
    find('.image-2')[:class].include?('result-image')
    find('.image-3')[:class].include?('result-image')
    find('.image-4')[:class].include?('result-image')
    find('.image-5')[:class].include?('result-image')
    find('.image-6')[:class].include?('result-image')
    find('.image-7')[:class].include?('result-image')
    find('.image-8')[:class].include?('result-image')
    find('.image-9')[:class].include?('result-image')
end

When(/^Match the result of normal Google search "(.+)"$/) do |searchText|
    visit 'https://www.google.com/imghp?hl=en'
    fill_in 'q', :with => searchText
    find_field('q').native.send_key(:enter)
end

# check layout
Then(/^The page should display the title with "(.+)"$/) do |title|
    expect(find('.result-text').text).to eq 'Results for coffee'
end

Then(/^The content of dropdown menu should be nothing$/) do
    expect(find('span[class="dropdown-content"]').text).to eq ''
end

Then(/^The user will be able to select lists$/) do 
    find('.select-list').click
    find('.item-1').click
    expect(find('span[class="dropdown-content"]').text).to eq 'Favorites'
    find('.select-list').click
    find('.item-2').click
    expect(find('span[class="dropdown-content"]').text).to eq 'To Explore'
    find('.select-list').click
    find('.item-3').click
    expect(find('span[class="dropdown-content"]').text).to eq 'Do Not Show'
end

Then(/^There will be a button labeled "Manage List"$/) do
    expect(find('.manage-list').text).to eq 'Manage List'
end

Then(/^Click the button by selecting nothing will have an alert$/) do
    find('.manage-list').click
    page.driver.browser.switch_to.alert.accept
end

# select list
Then(/^Click the button by selecting "(.+)" will take you to "(.+)"$/) do |list, list2|
    # fav list
    find('.select-list').click
    find('.item-1').click
    expect(find('span[class="dropdown-content"]').text).to eq 'Favorites'
    find('.manage-list').click
    expect(page.current_url).to eq 'http://localhost:8080/Team4/list.html?type=Favorites&food=coffee&numOfSearch=7'
    page.driver.go_back
    # to explore list
    find('.select-list').click
    find('.item-2').click
    expect(find('span[class="dropdown-content"]').text).to eq 'To Explore'
    find('.manage-list').click 
    expect(page.current_url).to eq 'http://localhost:8080/Team4/list.html?type=To%20Explore&food=coffee&numOfSearch=7'
    page.driver.go_back
    # do not show list
    find('.select-list').click
    find('.item-3').click
    expect(find('span[class="dropdown-content"]').text).to eq 'Do Not Show'
    find('.manage-list').click 
    expect(page.current_url).to eq 'http://localhost:8080/Team4/list.html?type=Do%20Not%20Show&food=coffee&numOfSearch=7'
end

# Restaurants
Then(/^The title should be Restaurants$/) do
    expect(find('.result-restaurant-title').text).to eq 'Restaurants'
end

Then(/^The results will show the 7 closest restaurants to USC for coffee$/) do
    find('.restaurant-0')[:class].include?('result-restaurant-item')
    find('.restaurant-1')[:class].include?('result-restaurant-item')
    find('.restaurant-2')[:class].include?('result-restaurant-item')
    find('.restaurant-3')[:class].include?('result-restaurant-item')
    find('.restaurant-4')[:class].include?('result-restaurant-item')
    find('.restaurant-5')[:class].include?('result-restaurant-item')
    find('.restaurant-6')[:class].include?('result-restaurant-item')
end

Then(/^Each restaurant includes name, address, minutes and price$/) do
    expect(find('.restaurant-0 .result-restaurant-item-name').text).to != '' 
    expect(find('.restaurant-0 .result-restaurant-item-min').text).to != '' 
    expect(find('.restaurant-0 .result-restaurant-item-address').text).to != '' 
    expect(find('.restaurant-0 .result-restaurant-item-right').text).to != '' 
    expect(find('.restaurant-1 .result-restaurant-item-name').text).to != '' 
    expect(find('.restaurant-1 .result-restaurant-item-min').text).to != '' 
    expect(find('.restaurant-1 .result-restaurant-item-address').text).to != '' 
    expect(find('.restaurant-1 .result-restaurant-item-right').text).to != '' 
    expect(find('.restaurant-2 .result-restaurant-item-name').text).to != '' 
    expect(find('.restaurant-2 .result-restaurant-item-min').text).to != '' 
    expect(find('.restaurant-2 .result-restaurant-item-address').text).to != '' 
    expect(find('.restaurant-2 .result-restaurant-item-right').text).to != '' 
    expect(find('.restaurant-3 .result-restaurant-item-name').text).to != '' 
    expect(find('.restaurant-3 .result-restaurant-item-min').text).to != '' 
    expect(find('.restaurant-3 .result-restaurant-item-address').text).to != '' 
    expect(find('.restaurant-3 .result-restaurant-item-right').text).to != '' 
    expect(find('.restaurant-4 .result-restaurant-item-name').text).to != '' 
    expect(find('.restaurant-4 .result-restaurant-item-min').text).to != '' 
    expect(find('.restaurant-4 .result-restaurant-item-address').text).to != '' 
    expect(find('.restaurant-4 .result-restaurant-item-right').text).to != '' 
    expect(find('.restaurant-5 .result-restaurant-item-name').text).to != '' 
    expect(find('.restaurant-5 .result-restaurant-item-min').text).to != '' 
    expect(find('.restaurant-5 .result-restaurant-item-address').text).to != '' 
    expect(find('.restaurant-5 .result-restaurant-item-right').text).to != '' 
    expect(find('.restaurant-6 .result-restaurant-item-name').text).to != '' 
    expect(find('.restaurant-6 .result-restaurant-item-min').text).to != '' 
    expect(find('.restaurant-6 .result-restaurant-item-address').text).to != '' 
    expect(find('.restaurant-6 .result-restaurant-item-right').text).to != '' 
end

Then(/^Clicking on a restaurant will take the user to the Restaurant Page$/) do
    name = find('.restaurant-0 .result-restaurant-item-name').text
    find('.restaurant-0').click
    expect(page.current_url).to eq 'http://localhost:8080/Team4/restaurant.html?name=' + name + '&numOfSearch=7'
end

# Recipe
Then(/^The title should be Recipes$/) do
    expect(find('.result-recipe-title').text).to eq 'Recipes'
end

Then(/^The results will show the 7 recipes for coffee$/) do
    find('.recipe-0')[:class].include?('result-recipe-item')
    find('.recipe-1')[:class].include?('result-recipe-item')
    find('.recipe-2')[:class].include?('result-recipe-item')
    find('.recipe-3')[:class].include?('result-recipe-item')
    find('.recipe-4')[:class].include?('result-recipe-item')
    find('.recipe-5')[:class].include?('result-recipe-item')
    find('.recipe-6')[:class].include?('result-recipe-item')
end

Then(/^Each recipe includes name, prep time and cook time$/) do
    expect(find('.recipe-0 .result-recipe-item-name').text).to != '' 
    expect(find('.recipe-0 .result-recipe-item-prepTime').text).to != '' 
    expect(find('.recipe-0 .result-recipe-item-cookTime').text).to != '' 
    expect(find('.recipe-1 .result-recipe-item-name').text).to != '' 
    expect(find('.recipe-1 .result-recipe-item-prepTime').text).to != '' 
    expect(find('.recipe-1 .result-recipe-item-cookTime').text).to != '' 
    expect(find('.recipe-2 .result-recipe-item-name').text).to != '' 
    expect(find('.recipe-2 .result-recipe-item-prepTime').text).to != '' 
    expect(find('.recipe-2 .result-recipe-item-cookTime').text).to != '' 
    expect(find('.recipe-3 .result-recipe-item-name').text).to != '' 
    expect(find('.recipe-3 .result-recipe-item-prepTime').text).to != '' 
    expect(find('.recipe-3 .result-recipe-item-cookTime').text).to != '' 
    expect(find('.recipe-4 .result-recipe-item-name').text).to != '' 
    expect(find('.recipe-4 .result-recipe-item-prepTime').text).to != '' 
    expect(find('.recipe-4 .result-recipe-item-cookTime').text).to != '' 
    expect(find('.recipe-5 .result-recipe-item-name').text).to != '' 
    expect(find('.recipe-5 .result-recipe-item-prepTime').text).to != '' 
    expect(find('.recipe-5 .result-recipe-item-cookTime').text).to != '' 
    expect(find('.recipe-6 .result-recipe-item-name').text).to != '' 
    expect(find('.recipe-6 .result-recipe-item-prepTime').text).to != '' 
    expect(find('.recipe-6 .result-recipe-item-cookTime').text).to != '' 
end

Then(/^Clicking on a recipe will take the user to the Recipe Page$/) do
    name = find('.recipe-0 .result-recipe-item-name').text
    find('.recipe-0').click
    expect(page.current_url).to eq 'http://localhost:8080/Team4/recipe.html?name=' + name + '&numOfSearch=7'
end

# return button
Then(/^There is a button labeled "Return to Search Page"$/) do
    expect(find('.return-to').text).to eq 'Return to Search'
end

