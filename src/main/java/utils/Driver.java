package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Administrator on 12/27/2016.
 */
public class Driver {
    public static WebDriver initDriver() {
        WebDriver driver = new ChromeDriver(getCapabilities());
        driver.manage().window().maximize();
        return driver;
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setJavascriptEnabled(true);
        return dc;
    }
}
