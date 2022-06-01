package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utils{

    public void userAddShoppingCart(){
        //check shoppingCart URL>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("cart"), "Your shopping cart url does not contain cart word");

        //check shoppingCart page>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String expectedMessage = "Shopping cart";
        String actualMessage = getTextFromElement(By.className("page-title"));
        Assert.assertEquals(actualMessage, expectedMessage);

        //check your own computer product available in cart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String ExpectedMessage = "Build your own computer";
        String ActualMessage = getTextFromElement(By.className("product-name"));
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    }

}
