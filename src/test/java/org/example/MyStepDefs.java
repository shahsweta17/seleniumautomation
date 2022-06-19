package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    @Given("I am on registration page")
    public void i_am_on_registration_page() {
       homePage.clickOnRegistrationButton();
       // registrationPage.userClickOnRegistrationButton();
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        registrationPage.registrationDetail();
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @When("I click on register submit button")
    public void i_click_on_register_submit_button() {
        registrationPage.userClickOnRegistrationButton();
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Then("I should able to registered successfully")
    public void i_should_able_to_registered_successfully() {
        registrationSuccessPage.verifyRegisterSuccessfully();
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Given("I am on homepage")
    public void i_am_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("I click on {string} link from top menu header")
    public void i_click_on_link_from_top_menu_header(String category_name) {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnCategoryLink(category_name);
    }
    @Then("I should able to successfully navigated to related {string} category page successfully")
    public void i_should_able_to_successfully_navigated_to_related_category_page_successfully(String category_url) {
        // Write code here that turns the phrase above into concrete actions
     Utils.verifyCurrentUrl(category_url);
    }



}
