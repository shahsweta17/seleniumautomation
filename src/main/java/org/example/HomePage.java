package org.example;

import com.sun.javafx.util.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.clickOnElement;
import static org.example.Utils.driverWaitUntilVisibilityOfAllElementsLocatedBy;

public class HomePage extends Utils {

    private By _registerButton = By.className("ico-register");

    public void clickOnRegistrationButton() {
        // click on register button>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(_registerButton);
    }

    public void buildYourOwnComputerOnHomepage() {
        //click on build your own computer>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        clickOnElement(By.linkText("Build your own computer"));
    }

    public void clickOnShoppingCart() {
        //click on shopping cart>>>>>
        clickOnElement(By.className("cart-label"));
    }

    public void clickOnDesktopOnHomepage() {
        //click on computer
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();

        //click on desk top
        driver.findElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]")).click();
    }

    public void clickOnBuildOwnComputer() {
        //build your own compute added to the cart
        clickOnElement(By.xpath("//div[@data-productid=\"1\"]/div/div[3]/div[2]//button[@class=\"button-2 product-box-add-to-cart-button\"]"));
    }
    public void verifyDollarSignOnHomePage(){

        //Verify if build your own computer price is display in Dollar
        String actual_Message = driver.findElement(By.className("actual-price")).getText();
        Assert.assertTrue(actual_Message.startsWith("$"), "US Dollar is not the currency selected");
    }
    public void changeTheDollarInToEuro(){
        //change the dollar in to euro
        clickOnElement(By.xpath("//*[@id=\"customerCurrency\"]/option[2]"));
    }
      public void verifyPriceDisplayInEuro(){
        //Verify if build your own computer price is display in Euro
          String actualMessage = driver.findElement(By.xpath("//*[@id=\"customerCurrency\"]")).getText();
          Assert.assertTrue(actualMessage.contains("Euro"), "Euro is not the currency selected");
      }



    public void verifyIfNonRegisteredUserIsAbleToVote(){
        //click on radio button good
        clickOnElement(By.xpath("//input[@id=\"pollanswers-2\"]"));

        //click on vote
        clickOnElement(By.xpath("//button[@class=\"button-2 vote-poll-button\"]\n"));
        //verify user is not able to vote without being registered
       driverWaitUntilVisibilityOfAllElementsLocatedBy(3,By.xpath("//div[@id=\"block-poll-vote-error-1\"]"));
       String actualMessage =driver.findElement(By.xpath("//div[@id=\"block-poll-vote-error-1\"]")).getText();
        Assert.assertTrue(actualMessage.contains("Only registered users can vote."),"Non registered user is able to vote");
    }
    public void verifyRegisteredUserIsAbleToVote(){
        //click on radio button good
        clickOnElement(By.xpath("//input[@id=\"pollanswers-2\"]"));

        //click on vote
        clickOnElement(By.xpath("//button[@class=\"button-2 vote-poll-button\"]\n"));
        //verify registered user should be able to vote
        String actualMessage = driver.findElement(By.xpath("//span[@class=\"poll-total-votes\"]")).getText();
        Assert.assertTrue(actualMessage.contains("vote(s)..."),"Registered user is not able to vote");
    }
    }



