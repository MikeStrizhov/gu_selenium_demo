package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Properties;

/**
 * Created by Michael Strizhov on 25.03.2017.
 */
public class KindergartenServiceStep4Page extends Page  {
    final String URL = "https://www.mos.ru/pgu/ru/application/dogm/77060101/#step_4";
    final String PAGE_TITLE ="Запись в детский сад / Департамент образования города Москвы";

    By parentBirthDate = By.id("A_Sh5_Block1_Date1"); //дата рождения родителя
    By parentPhonenumber = By.xpath("//input[@name='field[a.declarant.telephone1]']"); //номер телефона

    By parentType = By.xpath("//div[@id='A_Sh5_Block1_List1_chosen']/a"); //Вид представительства
    By parentTypeElem = By.xpath("//div[@id='A_Sh5_Block1_List1_chosen']/div/ul/li[3]"); //Вид представительства. Отец

    By checkBoxByEmail = By.xpath("//label[@for='A_Sh5_Block1_Flag2']"); //Уведомление по электронной почте
    By checkBoxBySMS = By.xpath("//label[@for='A_Sh5_Block1_Flag3']"); //Уведомление по смс

    By emailField = By.id("A_Sh5_Block1_Text4"); //email

    By parentPhonenumberForSms = By.id("A_Sh5_Block1_Text5"); //номер телефона

    public By nextButton = By.id("button_next");

    public KindergartenServiceStep4Page(WebDriver driver) {
        super(driver);
        //Init page
        //this.driver = driver;
    }

    @Step("В поле \"Дата рождения\" ввести корректные данные (10 цифр, возраст родителя выше возраста ребенка)")
    public void fillParentBirthdate() {
        sleep(1000);
        sendKeys(parentBirthDate,Properties.getProperty("Step70_BirthDate"));
    }

    @Step("В поле \"Контактный телефон\" ввести корректные данные (10 цифр по маске (XXX ) XXX-XX-XX, где «Х» - цифра)")
    public void fillParentPhone() {
        sleep(1000);
        sendKeys(parentPhonenumber,Properties.getProperty("Step71_Phonenumber"));
    }

    @Step("Из списка \"Вид представительства\" выбрать необходимый вариант.")
    public void fillParentType() {
        sleep(1000);
        click(parentType);
        click(parentTypeElem);
    }

    @Step("Включить чекбокс \"Уведомление по электронной почте\".")
    public void checkBoxByEmail() {
        sleep(1000);
        click(checkBoxByEmail);
    }

    @Step("В поле \"Электронная почта\" ввести корректные данные (По маске xxxxx@xxxx.xxx)")
    public void fillEmailAddr() {
        sleep(1000);
        sendKeys(emailField,Properties.getProperty("Step74_Email"));
    }

    @Step("Включить чекбокс \"Уведомление по SMS\".")
    public void checkBoxSMS() {
        sleep(1000);
        click(checkBoxBySMS);
    }

    @Step("В поле \"Телефон\" ввести корректные данные (10 цифр по маске (XXX ) XXX-XX-XX, где «Х» - цифра)")
    public void fillSMSNumber() {
        sleep(1000);
        sendKeys(parentPhonenumberForSms,Properties.getProperty("Step76_SMS"));
    }
    @Step("Нажать на кнопку \"Отправить\"")
    public void clickSendButton() {
        sleep(1000);
        click(nextButton);
    }
}
