package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Utils;

/**
 * Created by Administrator on 12/26/2016.
 */
public class RequestsPage extends Page{
    WebDriver driver;
    final String URL = "https://004930-crm-bundle.bpmonline.com/0/Nui/ViewModule.aspx#SectionModuleV2/CaseSection/";
    By addReqButton = By.id("CaseSectionSeparateModeAddRecordButtonButton-textEl");
    By saveReqButton = By.id("CasePageSaveButtonButton-textEl");
    By numbAtAddRequestWindow = By.id("MainHeaderSchemaPageHeaderCaptionLabel");
    By contragentField = By.id("CasePageCaseAccountLookupEdit-el");
    By contragentFindField = By.id("searchEdit-el");
    By contragentFindButton = By.xpath("//span[@data-tag='SearchButton']");
    By contragentFindElem = By.xpath("//div[@class='grid-cols-24 grid-primary-column']/span[position()=1]");
    By contragentSelectButton = By.xpath("//span[@data-tag='SelectButton']");
    By requestSelectService = By.id("CasePageServiceItemLookupEdit-right-icon-wrapper");
    By requestSelectServiceName1 = By.xpath("//div[@class='grid-cols-24 grid-primary-column']/span[position()=1]");
    By requestSelectServiceButton = By.xpath("//span[@data-tag='SelectButton']");
    By requestThemeField = By.id("CasePageSubjectTextEdit-el");
    By requestSaveButton = By.id("CasePageSaveButtonButton-textEl");

    By getToWorkButton = By.id("CaseSectionResolvedButtonButton-textEl");
    By finishButton = By.id("CaseSectionResolvedButtonButton-textEl");


    String CONTRAGENT = "Атрикс (пример)";


    public RequestsPage(WebDriver driver) {
        super(driver);
        //Init page
        this.driver = driver;
        waitForPageTitle("bpm'online");
        waitForElement(addReqButton);
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }

    @Step("Добавляем обращение")
    public String addRequest() {
        click(addReqButton);
        waitForElement(saveReqButton);
        String requestNumber = getText(numbAtAddRequestWindow);
        saveTextLog(requestNumber);
        driver.findElement(contragentField).sendKeys(Keys.ENTER);
        Utils.sleep(5000);
        sendKeys(contragentFindField,CONTRAGENT);
        Utils.sleep(1000);
        click(contragentFindButton);
        Utils.sleep(1000);
        click(contragentFindElem);
        Utils.sleep(1000);
        click(contragentSelectButton);
        Utils.sleep(1000);
        click(requestSelectService);
        Utils.sleep(1000);
        click(requestSelectServiceName1);
        Utils.sleep(1000);
        click(requestSelectServiceButton);
        Utils.sleep(1000);
        sendKeys(requestThemeField,"TestReqName");
        Utils.sleep(1000);
        click(requestSaveButton);
        return requestNumber;
    }

    @Step("Берём обращение в работу")
    public void getToWork() {
        click(getToWorkButton);
        Utils.sleep(5000);
        click(finishButton);
    }

}
