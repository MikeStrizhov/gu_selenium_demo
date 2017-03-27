package pageObjects;

import org.apache.commons.lang.math.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Properties;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    public By fieldDocCreaterdPlace = By.xpath("//div[@id='A_Sh3_Block1_List2_chosen']/a");
    public By fieldDocCreatedPlaceFirstElem = By.xpath("//div[@id='A_Sh3_Block1_List2_chosen']/div/ul/li[2]");
    public By fieldDocCreatedPlaceSecondElem = By.xpath("//div[@id='A_Sh3_Block1_List2_chosen']/div/ul/li[3]");

    public By nextButton = By.id("button_next");
    public By cancelElkSaveButton = By.id("elk-save-cancel-button");

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
        sleep(WAIT_TIMEOUT_FOR_STEP);
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
        sleep(WAIT_TIMEOUT_FOR_STEP);
        scrollDown(fieldBirthCertificateSeries);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldBirthCertificateSeries);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sendKeys(fieldBirthCertificateSeries, Properties.getProperty("Step55_CertificateSeries"));
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldBirthCertificateNumber);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sendKeys(fieldBirthCertificateNumber, Properties.getProperty("Step55_CertificateNumber"));
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldBirthCertificateDate);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sendKeys(fieldBirthCertificateDate, Properties.getProperty("Step55_CertificateDate"));
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldBirthCertificateOrgan);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sendKeys(fieldBirthCertificateOrgan, Properties.getProperty("Step55_CertificateOrgan"));


        //ToDo write code - check for step55
    }

    public void fillChildBirthDateStep2() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sendKeys(fieldChildBirthDateStep2, Properties.getProperty("Step11_ChildBirthDate"));
    }

    @Step("")
    public void doTest() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        scrollDown("//*[@id=\"body\"]/div/h1");
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldChildMiddleName);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sendKeys(fieldChildMiddleName, Properties.getProperty("Step11_ChildBirthDate"));
        //ToDo write code - check for step??
    }

    @Step("В поле \"Место выдачи свидетельства о рождении\" выбрать \"Москва\" или \"Российская федерация\"")
    public void selectPlaceOfDocCreated() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(fieldDocCreaterdPlace);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(ThreadLocalRandom.current().nextInt(1, 3) == 1 ? fieldDocCreatedPlaceFirstElem : fieldDocCreatedPlaceSecondElem);
    }

    @Step("Нажать на кнопку \"Продолжить\".")
    public void clickNext() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(nextButton);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(cancelElkSaveButton);
        Assert.assertTrue(driver.getPageSource().contains("Шаг 3. Сведения о льготах"));
    }
}
