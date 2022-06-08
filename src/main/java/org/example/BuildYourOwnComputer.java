package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOwnComputer extends Utils{
    private By _processor = By.id("product_attribute_1");
    private By _Ram =By.id("product_attribute_2");
    private By _hdd = By.id("product_attribute_3_6");
    private By _os = By.id("product_attribute_4_9");
    private By _software = By.id("product_attribute_5_11");
    private By _Software = By.id("product_attribute_5_12");
    private By _addtocart = By.id("add-to-cart-button-1");
public void buildYourOwnComputerDetail(){
    //select the processor>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Select processor = new Select(driver.findElement(_processor));
    processor.selectByIndex(1);

    //select Ram>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Select Ram = new Select(driver.findElement(_Ram));
    Ram.selectByIndex(1);

    //select hdd>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    driverWaitForClickable(10, (_hdd));

    //select os>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(_os);

    //select software>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    clickOnElement(_software);
    //select Software
    clickOnElement(_Software);


}
public void clickOnAddToCartButton(){
    //click on add to cart>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    clickOnElement(_addtocart);
}


}

