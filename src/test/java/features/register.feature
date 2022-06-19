@test
  Feature:Registration
    Scenario: As a user,I should able to register successfully
      so that, I can use all the user features on demonopcommerce website

      Given I am on registration page
      When I enter required registration details
      And I click on register submit button
      Then I should able to registered successfully
      Then I should be logged in