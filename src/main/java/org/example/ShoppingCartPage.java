package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utils{
    private By _userAddShoppingCart =By.className("page-title");
   private By _computerProduct =By.className("product-name");

    public void userAddShoppingCart(){
        //check shoppingCart URL>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("cart"), "Your shopping cart url does not contain cart word");

        //check shoppingCart page>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String expectedMessage = "Shopping cart";
        String actualMessage = getTextFromElement(_userAddShoppingCart);
        Assert.assertEquals(actualMessage, expectedMessage);

        //check your own computer product available in cart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String ExpectedMessage = "Build your own computer";
        String ActualMessage = getTextFromElement(_computerProduct);
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    }

}
