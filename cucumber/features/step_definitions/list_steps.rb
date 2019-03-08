def wait_for_ajax
    Timeout.timeout(10000) do
      active = page.evaluate_script('jQuery.active')
      until active == 0
        active = page.evaluate_script('jQuery.active')
      end
    end
  end

# list page
Given(/^User will enter "coffee" and "7" and click Feed Me! and adds several items to three lists$/) do
    visit 'http://localhost:8080/Team4'
    fill_in 'food-text', :with => 'coffee'
    fill_in 'search-text', :with => '7'
    find('#search-button').native.send_key(:enter)
    wait_for_ajax
    # add restaurant 0 to Favorite List and To Explore List
    restaurant_name0 = find('.restaurant-0 .result-restaurant-item-name').text
    find('.restaurant-0').click
    find('.select-list').click
    find('.item-1').click
    find('.add-list').click
    find('.select-list').click
    find('.item-2').click
    find('.add-list').click
    find('.return-to').click
    wait_for_ajax
    # add restaurant 1 to Favorite List and To Explore List
    restaurant_name1 = find('.restaurant-1 .result-restaurant-item-name').text
    find('.restaurant-1').click
    find('.select-list').click
    find('.item-1').click
    find('.add-list').click
    find('.select-list').click
    find('.item-2').click
    find('.add-list').click
    find('.return-to').click
    wait_for_ajax
    # add restaurant 2 to Do Not Show List
    restaurant_name2 = find('.restaurant-2 .result-restaurant-item-name').text
    find('.restaurant-2').click
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
    # add recipe 1 to Favorite List and To Explore List
    recipe_name1 = find('.recipe-1 .result-recipe-item-name').text
    find('.recipe-1').click
    find('.select-list').click
    find('.item-1').click
    find('.add-list').click
    find('.select-list').click
    find('.item-2').click
    find('.add-list').click
    find('.return-to').click
    wait_for_ajax
    # add recipe 2 to Do Not Show List
    recipe_name2 = find('.recipe-2 .result-recipe-item-name').text
    find('.recipe-2').click
    find('.select-list').click
    find('.item-3').click
    find('.add-list').click
    find('.return-to').click
    wait_for_ajax

end