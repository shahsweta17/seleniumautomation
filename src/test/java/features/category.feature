@category
Feature: category



  Scenario Outline: User should able to navigate to desired category page successfully from top header menu
    Given I am on homepage
    When I click on "<category_name>" link from top menu header
    Then I should able to successfully navigated to related "<category_url>" category page successfully

    Examples:
    |category_name    |category_url|
    |Computers        |https://demo.nopcommerce.com/computers|
    |Electronics      |https://demo.nopcommerce.com/electronics|
    |Apparel          |https://demo.nopcommerce.com/apparel    |
    |Digital downloads|https://demo.nopcommerce.com/digital-downloads|
    |Books            |https://demo.nopcommerce.com/books            |
    |Jewelry          |https://demo.nopcommerce.com/jewelry          |
    |Gift Cards       |https://demo.nopcommerce.com/gift-cards       |

