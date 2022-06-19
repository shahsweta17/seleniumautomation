package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage {
    public static void clickOnElement(By by){driver.findElement(by).click(); }
    public static void typeText(By by, String text){driver.findElement(by).sendKeys(text);}
    public static String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyyhhmmss");
        return formatter.format(date);
    }
    public static void takeSnapShot(String a){
        TakesScreenshot scrShot =((TakesScreenshot) driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile, new File("ScreenShot\\"+a+randomDate()+".png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public static void driverWaitForClickable( int time, By by){
        WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.elementToBeClickable(by)).click();

    }
    public static void driverWaitUntilContainsUrl(By by,int time, String url){
        WebDriverWait wait2 =new WebDriverWait(driver,Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.urlContains(url));
    }
    public static void driverWaitUntilPresenceOfElement(By by, int time){
        WebDriverWait wait3 =new WebDriverWait(driver,Duration.ofSeconds(time));
        wait3.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static void driverWaitUntil(int time, WebElement element){
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void driverWaitSelectElement(By by, int time){
        WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait5.until(ExpectedConditions.elementToBeSelected(by));
    }
    public static void driverWaitAttribution(int time, String Attribute, String value, By by){
        WebDriverWait wait6 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait6.until(ExpectedConditions.attributeContains(by, Attribute, value));
    }
    public static void driverWaitUrlContains(int time, String UrlContains){
        WebDriverWait wait7 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait7.until(ExpectedConditions.urlContains(UrlContains));
    }
    public static void driverWaitUrlFractions(int time,String fraction){
        WebDriverWait wait8 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait8.until(ExpectedConditions.urlContains(fraction));
    }
    public static void driverWaitTextToBe(By by, String value,int time){
        WebDriverWait wait9 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait9.until(ExpectedConditions.textToBe(by,value));
    }
    public static void driverWaitPresenceOfElementLocated(By by, int time){
        WebDriverWait wait10 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait10.until(ExpectedConditions.presenceOfElementLocated(by));

    }
    public static void driverWaitAttributeToBeNotEmpty(int time, WebElement element,String text){
        WebDriverWait wait11 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait11.until(ExpectedConditions.attributeToBeNotEmpty(element, text));
    }
    public static void driverWaitAlertsPresent(int time){
        WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait12.until(ExpectedConditions.alertIsPresent());
    }
    public static void driverWaitTitleContains(int time, String name){
        WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait13.until(ExpectedConditions.titleContains(name));
    }
  public static void driverWaitUntilVisibilityOfAllElementsLocatedBy(int time, By by){
    WebDriverWait  wait14 = new WebDriverWait(driver,Duration.ofSeconds(time));
    wait14.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
  }
  public static void selectFromDropDownIndexValue(By by, int indexvalue){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(indexvalue);
  }
  public static void selectFromDropDownVisibleText(By by, String textvalue){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(textvalue);
    }
    public static void verifyCurrentUrl(String url){
       Assert.assertEquals(driver.getCurrentUrl(), url);
    }



}
