package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

/**
 * Created by Administrator on 12/26/2016.
 */
public class Page extends Utils {
    private WebDriver driver;

    public Page(final WebDriver drv) {
        super(drv);
        this.driver = drv;
    }

    public WebElement $ (By by) {
        return driver.findElement(by);
    }
}
