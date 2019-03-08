def wait_for_ajax
    Timeout.timeout(20) do
      active = page.evaluate_script('jQuery.active')
      until active == 0
        active = page.evaluate_script('jQuery.active')
      end
    end
  end

# check recipe page
Given(/^User enters "coffee" and "7" and click Feed Me! and clicks the first result of Recipe$/) do
    visit 'http://localhost:8080/Team4'
    fill_in 'food-text', :with => 'coffee'
    fill_in 'search-text', :with => '7'
    find('#search-button').native.send_key(:enter)
    wait_for_ajax
    name = find('.recipe-0 .result-recipe-item-name').text
    find('.recipe-0').click
    expect(page.current_url).to match(/localhost:8080/)
end

Then(/^Page displays the title of the recipe$/) do
    url = page.current_url
    uri = URI.parse(url)
    params = CGI.parse(uri.query)
    name = params['name'].first
    expect(find('.recipe-title').text).to eq name
end

Then(/^Page displays a picture of the dish$/) do
    expect(find('.recipe-image')['src']).to match(/.+/)
end

Then(/^Page displays prep and cook times of the recipe$/) do
    expect(find('.prep-time').text).to match(/.+/)
    expect(find('.cook-time').text).to match(/.+/)
end

Then(/^Page lists all ingredients$/) do
    expect(page).to have_css('.ingredients')
    expect(page).to have_css('.ingredient-item')
end

Then(/^Page lists step by step instructions$/) do
    expect(page).to have_css('.instructions')
    expect(page).to have_css('.instructions ol')
    expect(page).to have_css('.instructions ol li')
end

Then(/^There is a button to trigger a printable version of the recipe$/) do
    expect(find('.print-version').text).to eq 'Printable Version'
    url = page.current_url
    uri = URI.parse(url)
    params = CGI.parse(uri.query)
    name = params['name'].first
    new_window = window_opened_by { find('.print-version').click }
    within_window new_window do
        expect(current_url).to match(/localhost:8080/)
    end
end

Then(/^There is a button to take you back to previous Results Page$/) do
    expect(find('.return-to').text).to eq 'Back to Results'
    url = page.current_url
    uri = URI.parse(url)
    params = CGI.parse(uri.query)
    name = params['name'].first
    num = params['numOfSearch'].first
    find('.return-to').click
    expect(current_url).to match(/localhost:8080/)
end

# list options
Then(/^There is a button labeled "Add to List"$/) do
    expect(find('.add-list').text).to eq 'Add to List'
end

Then(/^Click the add button by selecting nothing will have an alert$/) do
    find('.add-list').click
    page.driver.browser.switch_to.alert.accept
end

Then(/^There is a dropdown box to select one of the predefined lists$/) do 
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

Then(/^Select Favorite List and click add to list$/) do
    find('.select-list').click
    find('.item-1').click
    find('.add-list').click
end

Then(/^Select To Explore List and click add to list$/) do 
    find('.select-list').click
    find('.item-2').click
    find('.add-list').click
end

Then(/^Select Do Not Show List and click add to list$/) do
    find('.select-list').click
    find('.item-3').click
    find('.add-list').click
end

Then(/^Go to three lists to see if the recipe is added$/) do 
    url = page.current_url
    uri = URI.parse(url)
    params = CGI.parse(uri.query)
    name = params['name'].first
    find('.return-to').click
    # fav list
    find('.select-list').click
    find('.item-1').click
    find('.manage-list').click
    # to explore list
    find('.select-list').click
    find('.item-2').click
    find('.manage-list').click
    # do not show list
    find('.select-list').click
    find('.item-3').click
    find('.manage-list').click
end