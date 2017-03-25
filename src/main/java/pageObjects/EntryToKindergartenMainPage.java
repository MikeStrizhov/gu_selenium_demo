package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.logging.Logger;

/**
 * Created by Michael Strizhov on 22.03.2017.
 */

//https://www.mos.ru/pgu/ru/services/link/1742/
public class EntryToKindergartenMainPage extends Page {

    final String URL = "https://www.mos.ru/pgu/ru/services/link/1742/?utm_source=mos&utm_medium=ek&utm_referrer=mos.ru&utm_campaign=3532&utm_term=733533";

    WebDriver driver;
    public By buttonGetService = By.id("get_service");

    public EntryToKindergartenMainPage(WebDriver driver) {
        super(driver);
        //Init page
        this.driver = driver;
    }

    @Step("Проверка 'Услуга выбрана, открылась посадочная страница'")
    public void checkPageOpened() {
        log.info("Check page title for \"Получение информации о выбранных дошкольных образовательных учреждениях / Описание / Портал госуслуг Москвы\"");
        waitForPageTitle("Получение информации о выбранных дошкольных образовательных учреждениях / Описание / Портал госуслуг Москвы");
        waitForElement(buttonGetService);
        Assert.assertEquals(driver.getCurrentUrl(), URL);

    }

    @Step("Проверка 'Услуга выбрана, открылась посадочная страница'")
    public void pressGetService() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        waitForElement(buttonGetService);
        click(buttonGetService);
    }
}