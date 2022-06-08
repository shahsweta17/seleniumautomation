package org.example;

import com.sun.javafx.util.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static org.example.BasePage.driver;

public class DriverManager extends Utils {

    String browserName = "chrome";

    public void startOfBrowser() {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //location where Firefox is installed
            System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("provide a browser name:" + browserName);
        }

        //open Chrome browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    //close browser
    public void closeTheBrowser() {
        driver.quit();
    }
}


