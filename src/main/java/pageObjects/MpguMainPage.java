package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Michael Strizhov on 21.03.2017.
 */
public class MpguMainPage extends Page{
    WebDriver driver;
    public String URL = "https://www.mos.ru/";
    public By loginButton = By.cssSelector(".mos-header__controls-login-button");
    public By educationLink = By.xpath(".//div[@class='category__title'][contains(text()[normalize-space()], 'Образование')]");

    public MpguMainPage(WebDriver driver) {
        super(driver);
        //Init page
        this.driver = driver;
        openPage();
    }

    @Step("Открытие заглавной страницы сайта")
    public void openPage() {
        driver.get(URL);
        waitForPageTitle("Официальный сайт Мэра Москвы");
    }

    @Step("Нажатие кнопки Войти")
    public void pressLogin() {
        waitForElement(loginButton);
        click(loginButton);
    }
    @Step("Нажатие ссылки \"Образование\" в списке \"Категории услуг\"")
    public void pressEducatiom() {
        waitForElement(educationLink);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(educationLink);
        //ToDo Проверить: Отобразился список услуг принадлежащих к данной категории
    }

}
