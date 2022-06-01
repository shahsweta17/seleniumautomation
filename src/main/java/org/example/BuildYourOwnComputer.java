package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOwnComputer extends Utils{

public void buildYourOwnComputerDetail(){
    //select the processor>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Select processor = new Select(driver.findElement(By.id("product_attribute_1")));
    processor.selectByIndex(1);

    //select Ram>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Select Ram = new Select(driver.findElement(By.id("product_attribute_2")));
    Ram.selectByIndex(1);

    //select hdd>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    driverWaitForClickable(10, By.id("product_attribute_3_6"));

    //select os>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(By.id("product_attribute_4_9"));

    //select software>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(By.id("product_attribute_5_11"));
    clickOnElement(By.id("product_attribute_5_12"));


}
public void clickOnAddToCartButton(){
    //click on add to cart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(By.id("add-to-cart-button-1"));
}


}

