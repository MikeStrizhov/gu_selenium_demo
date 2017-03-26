package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Properties;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Michael Strizhov on 25.03.2017.
 */
public class KindergartenServiceStep3Page extends Page  {
    final String URL = "https://www.mos.ru/pgu/ru/application/dogm/77060101/#step_3";
    final String PAGE_TITLE ="Запись в детский сад / Департамент образования города Москвы";

    public By cancelElkSaveButton = By.id("elk-save-cancel-button");

    public By selectExemptionField = By.xpath("//div[@id='A_Sh4_Block1_List1_chosen']/a");
    public By selectExemptionVariant = By.xpath("//div[@id='A_Sh4_Block1_List1_chosen']/div/ul/li[2]"); //выбор льготы через последнее число в xpath. Для демо только "Дети-сироты"

    public By selectExemptionSubject = By.xpath("//div[@id='A_Sh4_Block1_List2_chosen']/a"); //является льготником
    public By selectExemptionSubjectParent = By.xpath("//div[@id='A_Sh4_Block1_List2_chosen']/div/ul/li[3]"); //родитель

    By fillNameSurnameFromPersonalPage = By.xpath("//label[@for='A_Sh4_Block1_Block2_Flag1_0']"); //Заполнить из личного кабинета

    //Сведения о льготнике
    By parentSurname = By.id("filefields.2.contact-lastname"); //Фамилия
    By parentName = By.id("filefields.2.contact-firstname"); //Имя
    By parentMiddleName = By.id("filefields.2.contact-middlename"); //Отчество
    By parentBirthDate = By.id("filefields.2.contact-birthdate"); //Дата рождения
    By parentSNILS = By.id("filefields.2.contact-snils"); //СНИЛС
    By nonMiddleNameCheckBox = By.xpath("//label[@for='filefields.2.contact.middlename_checkbox']"); //нет отчества

    By selectParentDocument = By.xpath("//*[@id=\"A_Sh4_Block1_Block2\"]/div[8]/div[1]/div[1]/div/a"); //выбор документа
    By selectParentDocumentPasp = By.xpath("//*[@id=\"A_Sh4_Block1_Block2\"]/div[8]/div[1]/div[1]/div/div/ul/li[1]"); //выбор документа. Паспорт

    By documentSeries = By.id("file.2Series");
    By documentNumber = By.id("file.2Number");

    public By nextButton = By.id("button_next");

    public KindergartenServiceStep3Page(WebDriver driver) {
        super(driver);
        //Init page
        //this.driver = driver;
    }

    @Step("В поле \"Выберите льготу\" выбрать любой вариант, кроме \"Нет льготы\".")
    public void selectExemption() {
        sleep(1000);
        click(selectExemptionField);
        click(selectExemptionVariant);
    }

    @Step("В поле \"Является льготником\" выбрать \"Родитель\".")
     public void selectExemptionSubject() {
        sleep(1000);
        click(selectExemptionSubject);
        click(selectExemptionSubjectParent);
    }

    @Step("Включить чекбокс \"Заполнить из личного кабинета\".")
    public void fillFromPersonalPage() {
        sleep(1000);
        click(fillNameSurnameFromPersonalPage);
    }

    @Step("Выключить чекбокс \"Заполнить из личного кабинета\".")
    public void disableFillFromPersonalPage() {
        sleep(1000);
        click(fillNameSurnameFromPersonalPage);
    }

    @Step("Выключить чекбокс \"Заполнить из личного кабинета\".")
    public void fillParentInfo() {
        sleep(1000);
        sendKeys(parentSurname,Properties.getProperty("Step64_ParentSurname"));
        sendKeys(parentName,Properties.getProperty("Step64_ParentName"));
        sendKeys(parentMiddleName,Properties.getProperty("Step64_ParentMiddleName"));
        sendKeys(parentBirthDate,Properties.getProperty("Step64_BirthDate"));
        sendKeys(parentSNILS,Properties.getProperty("Step64_SNILS"));
    }

    @Step("Включить чекбокс \"Нет отчества\".")
    public void nonMiddleNameCheckBoxSelect() {
        sleep(1000);
        click(nonMiddleNameCheckBox);
    }

    @Step("В поле \"Тип документа\" выбрать \"Паспорт гражданина РФ\".")
    public void selectPasportAsParentDoc() {
        sleep(1000);
        click(selectParentDocument);
        click(selectParentDocumentPasp);
    }

    @Step("Заполнить поля\n" +
            " - Серия документа (4 цифры)\n" +
            " - Номер документа (6 цифр)")
    public void fillParentDocumber() {
        sleep(1000);
        sendKeys(documentSeries,Properties.getProperty("Step68_Series"));
        sendKeys(documentNumber,Properties.getProperty("Step68_Number"));
    }

    @Step("Нажать на кнопку \"Продолжить\".")
    public void clickNext() {
        sleep(1000);
        click(nextButton);
//        click(cancelElkSaveButton);
        Assert.assertTrue(driver.getPageSource().contains("Шаг 3. Сведения о льготах"));
    }
}
