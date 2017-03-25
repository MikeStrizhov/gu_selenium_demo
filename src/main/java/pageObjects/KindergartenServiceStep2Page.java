package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Properties;

/**
 * Created by Michael Strizhov on 25.03.2017.
 */
public class KindergartenServiceStep2Page extends Page  {
    final String URL = "https://www.mos.ru/pgu/ru/application/dogm/77060101/#step_2";
    final String PAGE_TITLE ="Запись в детский сад / Департамент образования города Москвы";

    public By fieldChildLastName = By.xpath("//*[@id=\"filefields.1.contact-lastname\"]");
    public By fieldChildFirstName = By.xpath("//*[@id=\"filefields.1.contact-firstname\"]");
    public By fieldChildMiddleName = By.xpath("//*[@id=\"filefields.1.contact-middlename\"]");
    //*[@id="step_2"]//label[@for="filefields.1.contact.middlename_checkbox"]
    public By labelNotHaveMiddleName = By.xpath("//*[@id=\"step_2\"]//label[@for=\"filefields.1.contact.middlename_checkbox\"]");
    public By checkboxChildGender = By.xpath("//*[@id=\"step_2\"]//label[@for=\"filefields.1.contact-gender-1\"]");
    public By fieldChildBirthDateStep2 = By.xpath("//*[@id=\"step_2\"]//*[@id=\"A_Sh2_Block1_Date1\"]");

    public By fieldBirthCertificateSeries = By.xpath("//*[@id=\"file.1Series\"]");
    public By fieldBirthCertificateNumber = By.xpath("//*[@id=\"file.1Number\"]");
    public By fieldBirthCertificateDate = By.xpath("//*[@id=\"file.1Date\"]");
    public By fieldBirthCertificateOrgan = By.xpath("//input[@name=\"field[file.1.new_passport_place]\"]");


    public By field1 = By.xpath("");

    public KindergartenServiceStep2Page(WebDriver driver) {
        super(driver);
        //Init page
        //this.driver = driver;
    }

    @Step("Нажать ссылку \"Информация по оформлению заявления\"")
    public void fillChildData() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldChildLastName);
        sendKeys(fieldChildLastName, Properties.getProperty("Step51_ChildLastName"));
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldChildFirstName);
        sendKeys(fieldChildFirstName, Properties.getProperty("Step51_ChildFirstName"));
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldChildMiddleName);
        sendKeys(fieldChildMiddleName, Properties.getProperty("Step51_ChildMiddleName"));
        //ToDo write code - check for step51
    }
    @Step("Отметить чек-бокс \"Нет отчества\".")
    public void clickNotHaveMiddleName() {
        click(labelNotHaveMiddleName);
        //ToDo write code - check for step52
    }
    @Step("В поле \"Пол\" активировать необходимую радиокнопку.")
    public void clickChildGender() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(checkboxChildGender);
        //ToDo write code - check for step53
    }

    @Step("Заполнить следующие поля:\n" +
            "            - Серия (латинские и русские буквы и знак «-», до 10-ти символов)\n" +
            "            - Номер (50 символов)\n" +
            "            - Когда выдан (не ранее даты, указанной в поле \"Дата рождения\")\n" +
            "            - Кем выдан (100 символов)")
    public void fillBirthCertificateData() {
        scrollDown(fieldBirthCertificateSeries);
        click(fieldBirthCertificateSeries);
        sendKeys(fieldBirthCertificateSeries, Properties.getProperty("Step55_CertificateSeries"));
        click(fieldBirthCertificateNumber);
        sendKeys(fieldBirthCertificateNumber, Properties.getProperty("Step55_CertificateNumber"));
        click(fieldBirthCertificateDate);
        sendKeys(fieldBirthCertificateDate, Properties.getProperty("Step55_CertificateDate"));
        click(fieldBirthCertificateOrgan);
        sendKeys(fieldBirthCertificateOrgan, Properties.getProperty("Step55_CertificateOrgan"));


        //ToDo write code - check for step55
    }

    public void fillChildBirthDateStep2() {
        sendKeys(fieldChildBirthDateStep2, Properties.getProperty("Step11_ChildBirthDate"));
    }

    @Step("")
    public void doTest() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        scrollDown("//*[@id=\"body\"]/div/h1");
        click(fieldChildMiddleName);
        sendKeys(fieldChildMiddleName, Properties.getProperty("Step11_ChildBirthDate"));
        //ToDo write code - check for step??
    }


}
