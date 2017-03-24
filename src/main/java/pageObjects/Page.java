package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.logging.Logger;

/**
 * Created by Administrator on 12/26/2016.
 */
public class Page extends Utils {
    Logger log = Logger.getLogger(this.getClass().getName());
    protected WebDriver driver;

    public Page(final WebDriver drv) {
        super(drv);
        this.driver = drv;
    }

    public WebElement $ (By by) {
        return driver.findElement(by);
    }

    public void scrollDown(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,element);

    }

    public void scrollDown(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,element);
    }

}
