package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.HashMap;

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

        dc.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));


        HashMap<String, String> chromePreferences = new HashMap<String, String>();
        chromePreferences.put("profile.password_manager_enabled", "false");
        chromePreferences.put("credentials_enable_service", "false");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePreferences);

        dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        //http://automated-testing.info/t/set-allow-location-chrome-browser-by-default/8814/4
        //chromePreferences.put("profile.default_content_settings.geolocation", 2);

        //dc.setCapability("chrome.prefs", chromePreferences);

        return dc;
    }
}
