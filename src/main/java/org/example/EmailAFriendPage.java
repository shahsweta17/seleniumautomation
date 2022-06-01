package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils{
    public void userShouldEmailAFriend(){
        //click on email friend button
        driver.findElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]")).click();

        //enter your friend email
        driver.findElement(By.xpath("//*[@id=\"FriendEmail\"]")).sendKeys("abc@gmail.com");

        //enter your email address
       // driver.findElement(By.xpath("//*[@id=\"YourEmailAddress\"]")).sendKeys("shahsweta9@yahoo.com");

        // enter personal message
        driver.findElement(By.xpath("//*[@id=\"PersonalMessage\"]")).sendKeys("This computer is a very nice and good price.");

        //click on send email Button
        driver.findElement(By.name("send-email")).click();

         //email sent message
        String expectedMessage = "Your message has been sent.";

        String actualMessage = driver.findElement(By.className("result")).getText();

        Assert.assertEquals( actualMessage,expectedMessage, " your message has not been sent");

    }

}
