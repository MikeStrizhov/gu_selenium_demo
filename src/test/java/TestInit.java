import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static utils.Driver.initDriver;

/**
 * Created by Administrator on 12/26/2016.
 */
@Listeners(Listener.class)
public class TestInit {
    WebDriver driver;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = initDriver();
    }

    @AfterMethod
    public void endOfMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
