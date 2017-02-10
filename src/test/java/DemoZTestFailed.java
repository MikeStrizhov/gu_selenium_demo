import org.testng.annotations.Test;
import pageObjects.AuthPage;
import pageObjects.MainPage;
import pageObjects.RequestsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import utils.Utils;

/**
 * Created by Administrator on 12/26/2016.
 */
@Features("Тестирование ЕВРАЗ")
public class DemoZTestFailed extends TestInit{
    Utils util;

    @Stories("Демонстрационные тесты")
    @Title("ДемоТест1")
    @Test
    void testBody() {
        AuthPage authPage = new AuthPage(driver);
        authPage.doLogin();

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenus(true);
        mainPage.clickToRequestsElem();

        RequestsPage requestsPage = new RequestsPage(driver);
        requestsPage.addRequest();

        mainPage.openNewReq();

        requestsPage.getToWork();

        mainPage.remove();
    }
}
