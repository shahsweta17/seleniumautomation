package org.example;

import com.sun.javafx.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.*;

public class RegistrationPage extends Utils {

    private By _genderButton = By.xpath("//input[@id=\"gender-male\"]");
    private By _firstName = By.xpath("//input[@name='FirstName']");
    private By _lastName = By.id("LastName");
   private By _birthDate = By.name("DateOfBirthDay");
   private By _birthMonth =By.name("DateOfBirthMonth");
   private By _birthYear = By.name("DateOfBirthYear");
   private By _email = By.id("Email");
   private By _password = By.id("Password");
   private  By _conformPassword = By.id("ConfirmPassword");
   private By _registerButton = By.id("register-button");


public void registrationDetail(){
    //select gender>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(_genderButton);

    // enter firstname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_firstName, "Automation");

    //enter lastname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_lastName, "Tester");
    // driver.findElement(By.id("LastName")).sendKeys("Tester");

    //select date of birth>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Select birthday = new Select(driver.findElement(_birthDate));
    birthday.selectByIndex(17);

    //select month>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Select birthMonth = new Select(driver.findElement(_birthMonth));
    birthMonth.selectByValue("6");

    //select year>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Select birthYear = new Select(driver.findElement(_birthYear));
    birthYear.selectByVisibleText("2000");

    //email>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_email, "shahsweta" + randomDate() + "9@yahoo.com");

    //password>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_password, "shwetashah");

    //confirm password>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_conformPassword, "shwetashah");
    // driver.findElement(By.id("ConfirmPassword")).sendKeys("shwetashah" );
}
public void clickOnRegistrationButton(){
    // click on register>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(_registerButton);
}
}
