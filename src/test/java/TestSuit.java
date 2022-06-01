import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.example.Utils.*;


public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();


    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        // click on register button>>>>>>>>>>>>>>>>>>>>>>>
        homePage.clickOnRegistrationButton();

        //enter registration detail
        registrationPage.registrationDetail();

        //click on registration button
        registrationPage.clickOnRegistrationButton();

        //verification register success
        registrationSuccessPage.verifyRegisterSuccessfully();
    }

    @Test
    public void userShouldBeAbelToAddInAddToCartProduct() {

        //click on build your own computer>>>>
        homePage.buildYourOwnComputerOnHomepage();

        //enter details
        buildYourOwnComputer.buildYourOwnComputerDetail();

        //click on add to cart
        buildYourOwnComputer.clickOnAddToCartButton();

        //click on shopping cart
        homePage.clickOnShoppingCart();

        //check shopping cart url
        shoppingCartPage.userAddShoppingCart();
    }

    @Test
    public void userShouldBeAbleToSendEmailAFriend() {
        //click on register
        homePage.clickOnRegistrationButton();

        //click on registration detail
        registrationPage.registrationDetail();
        //click on register again
        registrationPage.clickOnRegistrationButton();

        //click on computer
        homePage.clickOnDesktopOnHomepage();

        //click on desktop
        homePage.clickOnDesktopOnHomepage();

        //click on build your own computer
        homePage.clickOnBuildOwnComputer();

        // click on add to cart
        buildYourOwnComputer.clickOnAddToCartButton();
        //email a friend detail
        emailAFriendPage.userShouldEmailAFriend();
    }

    @Test
    public void userShouldBeAbleToChangeCurrency() {

        //Verify if build your own computer price is display in Dollar
        homePage.verifyDollarSignOnHomePage();

        //change the dollar in to euro
         homePage.changeTheDollarInToEuro();

       //Verify if build your own computer price is display in Euro
        homePage.verifyPriceDisplayInEuro();
    }

    @Test
    public void registerUserShouldBeAbleToVote() {
        //click on radio button good and vote
        homePage.verifyIfNonRegisteredUserIsAbleToVote();

         //click on registration button on homepage
        homePage.clickOnRegistrationButton();

       // add registration detail
        registrationPage.registrationDetail();

        //click on register button
        registrationPage.clickOnRegistrationButton();

        //click on continue button
        registrationSuccessPage.clickOnContinueButton();

        //verify registered user is able to vote
        homePage.verifyRegisteredUserIsAbleToVote();
    }
}

