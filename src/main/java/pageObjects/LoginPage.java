package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Properties;

/**
 * Created by Michael Strizhov on 21.03.2017.
 */
public class LoginPage extends Page{
    WebDriver driver;
    public By loginField = By.id("alias");
    public By passwordField = By.id("aliaspswd");
    public By enterButton = By.id("outerlogin_button");
    public By logoutDropDownMenu = By.cssSelector("#mos-header .mos-header__controls-button > .mos-layout-icon.mos-layout-icon-dropdown_up");

    //public By logoutDropDownMenuExit = By.xpath("//*[@id=\"mos-header\"]/div[1]/div/div[1]/div[1]/ul/li[3]/div[2]");
    public By logoutDropDownMenuExit = By.xpath(".//*[@id='mos-header']//a[contains(text()[normalize-space()], 'Выход')]");


    public LoginPage(WebDriver driver) {
        super(driver);
        //Init page
        this.driver = driver;
        waitersForLoginPage();
    }

    @Step("Производим вход в систему")
    private void waitersForLoginPage() {
        waitForPageTitle("ВХОД В СИСТЕМУ");
        waitForElement(loginField);
        waitForElement(passwordField);
    }

    @Step("Ввод логина и пароля")
    public void enterLoginPassword() {
        sendKeys(loginField, Properties.getProperty("Step1_login"));
        sendKeys(passwordField, Properties.getProperty("Step1_password"));
    }
    @Step("Нажатие кнопки Войти")
    public void pressEnter() {
        click(enterButton);
    }

    @Step("Логаут")
    public void pressLogout() {
        waitForElement(logoutDropDownMenu);
        click(logoutDropDownMenu);
        sleep(1000);
        waitForElement(logoutDropDownMenuExit);
        click(logoutDropDownMenuExit);
    }


}
