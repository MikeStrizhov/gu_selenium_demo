package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Administrator on 12/26/2016.
 */
public class Waiters {
    WebDriver driver;
    final int WAITTIMEOUT = 10;


    public Waiters(WebDriver drv) {
        this.driver = drv;
    }

    public void customWaiter(final Command condition) {
        customWaiter(condition, false);
    }

    private void customWaiter(final Command condition, final boolean canBeAllert) {
        (new WebDriverWait(driver, WAITTIMEOUT)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                if(canBeAllert) {
                    try {
                        d.switchTo().alert().accept();
                        return false;
                    }
                    catch (Exception e) {
                        return condition.execute();
                    }
                }
                else {
                    return condition.execute();
                }
            }
        });
    }

    public interface Command
    {
        public boolean execute();
    }

    @Step("Ожидаем страницу с заголовком {0}")
    public void waitForPageTitle(final String title) {
        try {
            customWaiter( new Command() {
                public boolean execute() {
                    return driver.getTitle().toLowerCase().equals(title.toLowerCase());
                }
            });
        } catch (Exception e) {
            Assert.fail("Страница с заголовком \""+title+"\" не загрузилась");
        }
    }

    @Step("Ожидаем элемент {0}")
    public void waitForElement(final WebElement element) {
        try {
            customWaiter( new Command() {public boolean execute() {return element.isDisplayed();}});
        } catch (Exception e) {
            Assert.fail("Элемент не найден");
        }
    }

    public void waitForElement(final By by) {
        WebElement elem = null;
        for(int i=0;i<10;i++) {
            try {
                elem = driver.findElement(by);
            } catch (Exception e) {
                Utils.sleep(3000);
            }
            if(elem!=null) {
                break;
            }
        }
        waitForElement(elem);
    }
}
