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
   private  By _confirmPassword = By.id("ConfirmPassword");
   private By _registerButton01 = By.id("register-button");

   LoadProp loadProp=new LoadProp();

public void registrationDetail(){
    //select gender>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(_genderButton);

    // enter firstname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_firstName, loadProp.getProperty("firstName"));

    //enter lastname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_lastName, loadProp.getProperty("lastName"));

    //properties
    //select date of birth>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    selectFromDropDownIndexValue(_birthDate,Integer.parseInt(loadProp.getProperty("birthDate")));

    //select month>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    selectFromDropDownIndexValue(_birthMonth,Integer.parseInt(loadProp.getProperty("birthMonth")));

    //select year>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    selectFromDropDownVisibleText(_birthYear,loadProp.getProperty("birthYear"));

    //email>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_email,loadProp.getProperty("emailFirstPart")  + randomDate() +loadProp.getProperty("emailSecondPart"));

    //password>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_password, loadProp.getProperty("password"));

    //confirm password>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    typeText(_confirmPassword, loadProp.getProperty("confirmPassword"));
}
public void userClickOnRegistrationButton(){
    // click on register>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(_registerButton01);

}
}
