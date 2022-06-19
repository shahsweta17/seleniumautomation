package org.example;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager extends Utils {
    LoadProp loadProp = new LoadProp();
    public final String USERNAME = loadProp.getProperty("bsUsername");
    public final String ACCESS_KEY = loadProp.getProperty("bsAccessKey");
    public final String BrowseStackURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    DesiredCapabilities caps = new DesiredCapabilities();

    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));
    //boolean cloud =true; // if true this cloud will choose for browserstack
   // String browserName = System.getProperty("browser");
    String browserName = "Chrome";

    public void startOfBrowser() {
        //making decision cloud true or false
        // this will be run if cloud true(In cloud)
        if (cloud) {
            System.out.println("Running in cloud");
            //applying conditional loop for different browser options
            if (browserName.equalsIgnoreCase("Chrome")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
               caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "101.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");


            } else if (browserName.equalsIgnoreCase("safari")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "101.0");
               caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");

            } else if (browserName.equalsIgnoreCase("firefox")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");
            }
            else {
                System.out.println("your browser stack is wrong or connection issue");
            }
            try {
                driver = new RemoteWebDriver(new URL(BrowseStackURL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
           }
        }
        else {
            System.out.println("Running Locally.......................");

            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                //open chrome
                driver = new ChromeDriver();
            } else if
           (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
               //open firefox
                driver = new FirefoxDriver();
            } else if
            (browserName.equalsIgnoreCase("Edge")) {
               System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
               //open Edge
               driver = new EdgeDriver();
            } else {
            System.out.println("your browser name is wrong or not provided" + browserName);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com");
    }

    public void closeTheBrowser() {
        driver.quit();
    }
}
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.Capabilities;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//import static org.example.BasePage.driver;
//
//public class DriverManager extends Utils {
//    LoadProp loadProp = new LoadProp();
//
//
//    public final String AUTOMATE_USERNAME = loadProp.getProperty("bsUsername");
//    public final String AUTOMATE_ACCESS_KEY = loadProp.getProperty("bsAccessKey");
//    public final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub_cloud.browserstack.com/wd/hub";
//    DesiredCapabilities caps = new DesiredCapabilities();
//    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));
//
//     // String browserName = "chrome";
//    String browserName = System.getProperty("browser");
//
//    public void startOfBrowser() {
//        if (cloud) {
//            System.out.println("running cloud");
//
//            if (browserName.equalsIgnoreCase("chrome")) {
//                caps.setCapability("os", "windows");
//                caps.setCapability("os_version", "10");
//                caps.setCapability("browser", "chrome");
//                caps.setCapability("browser_version", "101.0");
//                caps.setCapability("browserstack.local", "false");
//                caps.setCapability("browserstack.selenium_version", "4.1.0");
//            } else {
//                System.out.println("your browser name is wrong");
//            }
//            try {
//                driver = new RemoteWebDriver(new URL(BrowserStackURL),caps);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//        }
//            else {
//            System.out.println("Running locally....................");
//
//                if (browserName.equalsIgnoreCase("chrome")) {
//                  System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
//                   driver = new ChromeDriver();
//
//               } else if (browserName.equalsIgnoreCase("Firefox")) {
//                   FirefoxOptions options = new FirefoxOptions();
//                   options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //location where Firefox is installed
//                    System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
//                   driver = new FirefoxDriver();
//
//                } else if (browserName.equalsIgnoreCase("edge")) {
//                    System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
//                    driver = new EdgeDriver();
//               } else {
//                    System.out.println("browser name is wrong:" + browserName);
//              }
//            }
//            //open Chrome browser
//          driver.manage().window().maximize();
//          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//          driver.get("https://demo.nopcommerce.com/");
//         //  driver.get(loadProp.getProperty("url"));
//       }
//        //close browser
//            public void closeTheBrowser(){
//                driver.quit();
//            }
//        }



