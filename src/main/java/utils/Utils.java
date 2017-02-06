package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by Administrator on 12/26/2016.
 */
public class Utils extends Waiters{
    WebDriver driver;

    public Utils(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Клик мышью на элементе {0}")
    public boolean click(By by) {
        try {
            waitForElement(driver.findElement(by));
            driver.findElement(by).click();
            return true;
        } catch (Exception e) {
            Assert.fail("Элемент "+by.toString()+" не существует");
            return false;
        }
    }

    @Step("Ввод текста {1} в поле {0}")
    public boolean sendKeys(By by,String text) {
        try {
            sleep(100);
            waitForElement(driver.findElement(by));
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
            sleep(100);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Получение текста из поля {0}")
    public String getText(By by) {
        String ret = "";
        try {
            waitForElement(driver.findElement(by));
            ret = driver.findElement(by).getText();
            if(ret.equals("")) {
                ret = driver.findElement(by).getAttribute("value");
            }
            return ret;
        } catch (Exception e) {
            return "";
        }
    }

    public static void robotSendKey(int keyCode) {
        try {
            sleep(500);
            Robot robot = new Robot();
            sleep(500);
            robot.keyPress(keyCode);
            sleep(20);
            robot.keyRelease(keyCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Image robotTakeShoot() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_PRINTSCREEN);
            sleep(100);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
            return getImageFromClipboard();
        } catch (AWTException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Image getImageFromClipboard()
    {
        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
        {
            try
            {
                return (Image) transferable.getTransferData(DataFlavor.imageFlavor);
            }
            catch (UnsupportedFlavorException e)
            {
                // handle this as desired
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // handle this as desired
                e.printStackTrace();
            }
        }
        else
        {
            System.err.println("getImageFromClipboard: That wasn't an image!");
        }
        return null;
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String name, WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{1}", type = "text/plain")
    public String saveTextLog(String message,String caption) {
        return message;
    }
    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }
}
