import com.sun.javafx.util.Utils;
import org.example.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static org.example.Utils.takeSnapShot;


public class BaseTest  extends Utils {
    DriverManager driverManager = new DriverManager();

    @BeforeMethod
    public void openBrowser() {
        driverManager.startOfBrowser();
    }

    @AfterMethod
    public void close(ITestResult result) {
        if (!result.isSuccess()) {
             takeSnapShot(result.getName());
              }
            driverManager.closeTheBrowser();
        }
    }


