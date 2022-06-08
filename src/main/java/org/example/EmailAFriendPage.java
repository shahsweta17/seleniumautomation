package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils{
    private By _emailFriendButton = By.xpath("//button[@class=\"button-2 email-a-friend-button\"]");
    private By _friendEmailID =By.xpath("//*[@id=\"FriendEmail\"]");
    private By _personalMessage = By.xpath("//*[@id=\"PersonalMessage\"]");
    private By _sendEmail = By.name("send-email");
    private By _sendMessage = By.className("result");
     public void userShouldEmailAFriend(){
        //click on email friend button
        driver.findElement(_emailFriendButton).click();

        //enter your friend email
        driver.findElement(_friendEmailID).sendKeys("abc@gmail.com");

        //enter your email address
       // driver.findElement(By.xpath("//*[@id=\"YourEmailAddress\"]")).sendKeys("shahsweta9@yahoo.com");

        // enter personal message
        driver.findElement(_personalMessage).sendKeys("This computer is a very nice and good price.");

        //click on send email Button
        driver.findElement(_sendEmail).click();

         //email sent message
        String expectedMessage = "Your message has been sent.";

        String actualMessage = driver.findElement(_sendMessage).getText();

        Assert.assertEquals( actualMessage,expectedMessage, " your message has not been sent");

    }

}
