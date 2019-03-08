def wait_for_ajax
    Timeout.timeout(20) do
      active = page.evaluate_script('jQuery.active')
      until active == 0
        active = page.evaluate_script('jQuery.active')
      end
    end
  end

restaurant_name0 = ''
restaurant_name1 = ''
recipe_name0 = ''
recipe_name1 = ''

# list page
Given(/^User will enter "coffee" and "7" and click Feed Me! and adds several items to three lists$/) do
    visit 'http://localhost:8080/Team4'
    fill_in 'food-text', :with => 'coffee'
    fill_in 'search-text', :with => '7'
    find('#search-button').native.send_key(:enter)
    wait_for_ajax
    # add restaurant 0 to Favorite List and To Explore List
    # restaurant_name0 = find('.restaurant-0 .result-restaurant-item-name').text
    find('.restaurant-0').click
    find('.select-list').click
    find('.item-1').click
    find('.add-list').click
    find('.select-list').click
    find('.item-2').click
    find('.add-list').click
    find('.return-to').click
    wait_for_ajax
    # add restaurant 1 to Do Not Show List
    restaurant_name2 = find('.restaurant-1 .result-restaurant-item-name').text
    find('.restaurant-1').click
    find('.select-list').click
    find('.item-3').click
    find('.add-list').click
    find('.return-to').click
    wait_for_ajax
    # add recipe 0 to Favorite List and To Explore List
    recipe_name0 = find('.recipe-0 .result-recipe-item-name').text
    find('.recipe-0').click
    find('.select-list').click
    find('.item-1').click
    find('.add-list').click
    find('.select-list').click
    find('.item-2').click
    find('.add-list').click
    find('.return-to').click
    wait_for_ajax
    # add recipe 1 to Do Not Show List
    recipe_name2 = find('.recipe-1 .result-recipe-item-name').text
    find('.recipe-1').click
    find('.select-list').click
    find('.item-3').click
    find('.add-list').click
    find('.return-to').click
end

# list page layout
Then(/^There is a button labeled Results Page*/) do
    find('.select-list').click
    find('.item-1').click
    find('.manage-list').click
    expect(find('.return-to-result').text).to eq 'Results Page'
end

Then(/^Clicking the result button takes the user back to the Results Page$/) do
    find('.return-to-result').click
    expect(page.current_url).to match(/http:\/\/localhost:8080\/Team4\/results.html/)
end

Then(/^There is a button labeled Return to Search Page$/) do
    find('.select-list').click
    find('.item-1').click
    find('.manage-list').click
    expect(find('.return-to-search').text).to eq 'Return to Search Page'
end

Then(/^Clicking the search button takes the user back to the Search Page$/) do 
    find('.return-to-search').click
    expect(page.current_url).to eq 'http://localhost:8080/Team4/index.html'
end

# list page list options
Then(/^There is a button labeled "Manage List" in list page$/) do
    find('.select-list').click
    find('.item-1').click
    find('.manage-list').click
    expect(find('.manage-list').text).to eq 'Manage List'
end

# display all three lists
Then(/^All items that have been added to the list are to be displayed$/) do

    # favorite list
    find('.select-list').click
    find('.item-1').click
    find('.manage-list').click
    expect(page).to have_css(restaurant_name0)
    expect(page).to have_css(recipe_name0)

    # to explore list
    find('.select-list').click
    find('.item-2').click
    find('.manage-list').click
    expect(page).to have_css(restaurant_name0)
    expect(page).to have_css(recipe_name0)

    # do not show list
    find('.select-list').click
    find('.item-3').click
    find('.manage-list').click
    expect(page).to have_css(restaurant_name1)
    expect(page).to have_css(recipe_name1)

end