package org.example;

import com.sun.javafx.util.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.clickOnElement;

public class RegistrationSuccessPage extends Utils {

    public void verifyRegisterSuccessfully(){
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        System.out.println("Actual message:" + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "registration is not working");

    }
    public void clickOnContinueButton(){
        //click on continue
         clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
    }

}
