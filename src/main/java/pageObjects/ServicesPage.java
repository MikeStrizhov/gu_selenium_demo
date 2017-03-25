package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Michael Strizhov on 22.03.2017.
 */

//для раздела сайта
//https://www.mos.ru/services/catalog/cat/3532/popular/
public class ServicesPage extends Page{
    WebDriver driver;
    public By linkKindergarten = By.xpath(".//span[@class='info-link__title'][contains(text()[normalize-space()], 'Детские сады')]");
    public By linkEntryToKindergarten = By.xpath(".//span[@class='info-link__title'][contains(text()[normalize-space()], 'Запись в детский сад')]");

    public ServicesPage(WebDriver driver) {
        super(driver);
        //Init page
        this.driver = driver;
    }

    @Step("Нажать на иконку услуги \"Детские сады\", выбрать услугу \"Запись в детский сад\".")
    public void pressEntryToKindergarten(){
        sleep(WAIT_TIMEOUT_FOR_STEP);
        waitForElement(linkKindergarten);
        click(linkKindergarten);
        waitForElement(linkEntryToKindergarten);
        click(linkEntryToKindergarten);
    }
}
