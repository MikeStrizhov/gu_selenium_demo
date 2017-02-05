package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Utils;

/**
 * Created by Administrator on 12/26/2016.
 */
public class MainPage extends Page{
    WebDriver driver;

    //elements on page
    By mainMenu = By.id("menu-workplace-button-wrapperEl");
    By[] mainMenuElems = new By[]{
            By.xpath("//ul[@id='t-comp16-list']/li[position()=1]"),
            By.xpath("//ul[@id='t-comp16-list']/li[position()=2]"),
            By.xpath("//ul[@id='t-comp16-list']/li[position()=3]"),
            By.xpath("//ul[@id='t-comp16-list']/li[position()=4]")
    };
    By requestsLink = By.id("sidebar-item-text-2");

    By openNewButton = By.xpath("//div[@id='grid-CaseSectionDataGridGrid-wrap']/div[1]/div[@class='grid-row-actions']/span[@data-tag='edit']");
    By removeNewButton = By.xpath("//div[@id='grid-CaseSectionDataGridGrid-wrap']/div[1]/div[@class='grid-row-actions']/span[@data-tag='delete']");

    By yesButton = By.xpath("//span[@data-item-marker='Да']");
    By moreButton = By.xpath("//span[@data-item-marker='Посмотреть подробнее']");
    By deleteLink = By.xpath("//div[@class='constraints-item-tools-container']/span[1]/span[2]");
    By fullRemove = By.xpath("//ul[@data-item-marker='tools-button']/li[1]");

    public MainPage(WebDriver driver) {
        super(driver);
        //Init page
        this.driver = driver;
        waitForPageTitle("bpm'online");
        waitForElement(mainMenu);
    }

    @Step("Проходим по пунктам меню")
    public void selectMenus() {
        Utils.sleep(2000);
        selectMainMenuElemtByNum(2);
        Utils.sleep(2000);
        selectMainMenuElemtByNum(3);
        Utils.sleep(2000);
        selectMainMenuElemtByNum(4);
        Utils.sleep(2000);
    }

    @Step("Выбираем из главного меню элемент {0}")
    public void selectMainMenuElemtByNum(int num) {
        Utils.sleep(1000);
        click(mainMenu);
        Utils.sleep(1000);
        click(mainMenuElems[num-1]);
    }

    @Step("Выбираем пункт меню \"Обращения\"")
    public void clickToRequestsElem () {
        click(requestsLink);
        Utils.sleep(3000);
        Assert.fail("Принудительная ошибка теста");
    }

    @Step("Открываем свежесозданное обращение")
    public void openNewReq() {
        Utils.sleep(3000);
        click(openNewButton);
        Utils.sleep(1000);
    }

    @Step("Удаление обращения")
    public void remove() {
        Utils.sleep(2000);
        click(removeNewButton);
        Utils.sleep(1000);
        click(yesButton);
        Utils.sleep(1000);
        click(moreButton);
        Utils.sleep(1000);
        click(deleteLink);
        Utils.sleep(2000);
        click(fullRemove);
    }
}
