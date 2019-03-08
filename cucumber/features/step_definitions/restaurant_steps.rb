def wait_for_ajax
    Timeout.timeout(10000) do
      active = page.evaluate_script('jQuery.active')
      until active == 0
        active = page.evaluate_script('jQuery.active')
      end
    end
  end

# check restaurant page
Given(/^User enters "coffee" and "7" and click Feed Me! and clicks the first result of Restaurant$/) do
    visit 'http://localhost:8080/Team4'
    fill_in 'food-text', :with => 'coffee'
    fill_in 'search-text', :with => '7'
    find('#search-button').native.send_key(:enter)
    wait_for_ajax
    name = find('.restaurant-0 .result-restaurant-item-name').text
    find('.restaurant-0').click
    expect(page.current_url).to eq 'http://localhost:8080/Team4/restaurant.html?name=' + name + '&numOfSearch=7'
end

Then(/^Page displays the name, address, phone number, and website link of the restaurant$/) do
    # name
    url = page.current_url
    uri = URI.parse(url)
    params = CGI.parse(uri.query)
    name = params['name'].first
    expect(find('.restaurant-title').text).to eq name
    # address
    expect(find('.restaurant-address').text).to match(/.+/)
    # website
    expect(find('.restaurant-website').text).to match(/.+/)
end

Then(/^There is a button to trigger a printable version of the restaurant$/) do
    expect(find('.print-version').text).to eq 'Printable Version'
    url = page.current_url
    uri = URI.parse(url)
    params = CGI.parse(uri.query)
    name = params['name'].first
    new_window = window_opened_by { find('.print-version').click }
    within_window new_window do
        expect(current_url).to eq 'http://localhost:8080/Team4/printableRestaurant.html?name=' + name
    end
end


# click on address
Then(/^Clicking on the address takes you to Google Maps directions page with the destination prefilled with the address of the restaurant and starting point as USC$/) do
    new_window = window_opened_by { find('.restaurant-address').click }
    within_window new_window do
        expect(current_url).to match(/google/)
    end
end

# click on website
Then(/^Clicking on the website link takes you to the restaurant’s home page$/) do
    new_window = window_opened_by { find('.restaurant-address').click }
    within_window new_window do
        expect(current_url).to match(/.+/)
    end
end

# list options
Then(/^Go to three lists to see if the restaurant is added$/) do 
    url = page.current_url
    uri = URI.parse(url)
    params = CGI.parse(uri.query)
    name = params['name'].first
    find('.return-to').click
    # fav list
    find('.select-list').click
    find('.item-1').click
    find('.manage-list').click
    expect(page).to have_css(name)
    # to explore list
    find('.select-list').click
    find('.item-2').click
    find('.manage-list').click
    expect(page).to have_css(name)
    # do not show list
    find('.select-list').click
    find('.item-3').click
    find('.manage-list').click
    expect(page).to have_css(name)
end