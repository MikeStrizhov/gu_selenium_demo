package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Administrator on 12/26/2016.
 */
public class AuthPage extends Page{
    WebDriver driver;
    public String URL = "https://004930-crm-bundle.bpmonline.com";

    //elements on page
    public By loginField = By.id("loginEdit-el");
    public By passwField = By.id("passwordEdit-el");
    public By loginButton = By.id("t-comp12-textEl");
    final String LOGIN = "Ramil Muhametdinov";
    final String PASS = "mIaczVi1lB";

    public AuthPage(WebDriver driver) {
        super(driver);
        //Init page
        this.driver = driver;
        openPage(driver);
    }

    @Step("Открытие страницы логина")
    private void openPage(WebDriver driver) {
        driver.get(URL);
        waitForPageTitle("bpm'online");
        sleep(500);
    }

    @Step("Ввод аутентификационных данных")
    public void doLogin() {
        sendKeys(loginField,LOGIN);
        sendKeys(passwField,PASS);
        click(loginButton);
    }
}
