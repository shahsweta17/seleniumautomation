package org.example;

import com.sun.javafx.util.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

import static org.example.BasePage.driver;
import static org.example.Utils.*;

public class HomePage extends Utils {

    private By _registerButton = By.className("ico-register");
    private By _buildYourOwnComputer = By.linkText("Build your own computer");
    private By _shoppingCart = By.className("cart-label");
    private By _computer = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']");
    private By _desktop = By.xpath("//img[@alt=\"Picture for category Desktops\"]");
    private By _addToCart = By.xpath("//div[@data-productid=\"1\"]/div/div[3]/div[2]//button[@class=\"button-2 product-box-add-to-cart-button\"]");
    private By _priceDisplayInDollar = By.className("actual-price");
    private By _changDollarInEuro = By.xpath("//*[@id=\"customerCurrency\"]/option[2]");
    private By _computerPriceDisplayInEuro = By.xpath("//*[@id=\"customerCurrency\"]");
    private By _goodRadioButton = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _clickOnVote = By.xpath("//button[@class=\"button-2 vote-poll-button\"]\n");
    private By _userNotAbleToVoteWithoutRegistered = By.xpath("//div[@id=\"block-poll-vote-error-1\"]");
    private By _radioButtonGood = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _voteButton = By.xpath("//button[@class=\"button-2 vote-poll-button\"]\n");
    private By _registerUserShouldVote = By.xpath("//span[@class=\"poll-total-votes\"]");
    private By _productTitles = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _clickOnFacebookButton =By.className("facebook");
    private  By _enterWordInSearchTextBox =By.id("small-searchterms");
    private  By _clickOnSearch =By.className("search-box-button");
    private  By _clickAllProduct =By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private  By _clickOnDetailsButton =By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[5]/div[2]/div[2]/div[3]/a");

    public void clickOnRegistrationButton() {
        // click on register button>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(_registerButton);
    }

    public void buildYourOwnComputerOnHomepage() {
        //click on build your own computer>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(_buildYourOwnComputer);
    }

    public void clickOnShoppingCart() {
        //click on shopping cart>>>>>
        clickOnElement(_shoppingCart);
    }

    public void clickOnDesktopOnHomepage() {
        //click on computer
        driver.findElement(_computer).click();
        //click on desk top
        driver.findElement(_desktop).click();
    }

    public void clickOnBuildOwnComputer() {
        //build your own compute added to the cart
        clickOnElement(_addToCart);
    }

    public void verifyDollarSignOnHomePage() {

        //Verify if build your own computer price is display in Dollar
        String actual_Message = driver.findElement(_priceDisplayInDollar).getText();
        Assert.assertTrue(actual_Message.startsWith("$"), "US Dollar is not the currency selected");
    }

    public void changeTheDollarInToEuro() {
        //change the dollar in to euro
        clickOnElement(_changDollarInEuro);
    }

    public void verifyPriceDisplayInEuro() {
        //Verify if build your own computer price is display in Euro
        String actualMessage = driver.findElement(_computerPriceDisplayInEuro).getText();
        Assert.assertTrue(actualMessage.contains("Euro"), "Euro is not the currency selected");
    }

    public void verifyIfNonRegisteredUserIsAbleToVote() {
        //click on radio button good
        clickOnElement(_goodRadioButton);

        //click on vote
        clickOnElement(_clickOnVote);

        //verify user is not able to vote without being registered
        driverWaitUntilVisibilityOfAllElementsLocatedBy(3, By.xpath("//div[@id=\"block-poll-vote-error-1\"]"));
        String actualMessage = driver.findElement(_userNotAbleToVoteWithoutRegistered).getText();
        Assert.assertTrue(actualMessage.contains("Only registered users can vote."), "Non registered user is able to vote");
    }

    public void verifyRegisteredUserIsAbleToVote() {
        //click on radio button good
        clickOnElement(_radioButtonGood);

        //click on vote
        clickOnElement(_voteButton);
        //verify registered user should be able to vote
        String actualMessage = driver.findElement(_registerUserShouldVote).getText();
        Assert.assertTrue(actualMessage.contains("vote(s)..."), "Registered user is not able to vote");
    }

    public void getProductTitles() {
        List<WebElement> productTitles = driver.findElements(_productTitles);
        System.out.println(productTitles.size());
        for (WebElement e : productTitles) {

            System.out.println(e.getText());
            System.out.println(".........................");
        }
    }

    public void voteButton() {
        //click on vote
        clickOnElement(_voteButton);
        //switching to error
        Alert alert = driver.switchTo().alert();
    }
    public void voteAlertMessage() {
        //get text for Alert//
        String alertMessage = driver.switchTo().alert().getText();
        String actualMessageForVote = "Please select an answer";
        Assert.assertEquals(actualMessageForVote, alertMessage);
        //Accept alert//
        driver.switchTo().alert().accept();
    }

    public void clickOnFacebookButton() {
        String MainWindow = driver.getWindowHandle();
        //click on facebook button//
        clickOnElement(_clickOnFacebookButton);

        //To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                //Switching to child window
                driver.switchTo().window(ChildWindow);
                // verify user is on correct Facebook page
                String expectedFacebookUrl = "https://www.facebook.com/nopCommerce";
                String actualFacebookUrl = driver.getCurrentUrl();
                Assert.assertEquals(actualFacebookUrl,expectedFacebookUrl);
                driver.close();;
            }
            //Switching to Parent window
            driver.switchTo().window(MainWindow);
            // verify user is on correct homepage
            String expectedHomeUrl = "https://demo.nopcommerce.com/";
            String actualHomeUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualHomeUrl,expectedHomeUrl);
            }
        }


        public void enterWordInSearchTextBox (String product){
            // enter text in searchTextBox//nike
            typeText(_enterWordInSearchTextBox, product);
            //click on search
            clickOnElement(_clickOnSearch);

            //verify url//
            String expectedSearchUrl = "https://demo.nopcommerce.com/search?q=" + product;
            String actualSearchUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualSearchUrl, expectedSearchUrl);

            //check all products
            List<WebElement> productTitles = driver.findElements(_clickAllProduct);
            for (WebElement e : productTitles) {
                System.out.println(e.getText());
            }   }

      public void clickOnDetailsButton () {
            //On Home Page click under News and nopCommerce new release!, click on Details Button
            clickOnElement(_clickOnDetailsButton);

        }
        public void clickOnCategoryLink(String categoryName){
        clickOnElement(By.linkText(categoryName));

        }
    }



