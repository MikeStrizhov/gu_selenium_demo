package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Michael Strizhov on 27.03.2017.
 */
public class MpguFaqPage extends Page {
    final String URL = "https://www.mos.ru/pgu/ru/faq/?subject=zapis_v_detskiy_sad";
    final String PAGE_TITLE ="Портал госуслуг Москвы";

    final String CURRENT_FAQ_SUBJECT = "Запись в детский сад";

    //*[@id="subject_chosen"]/a/span
    public By selectFaqSubject = By.xpath("//*[@id=\"subject_chosen\"]/a/span");

    public MpguFaqPage(WebDriver driver) {
        super(driver);
    }

    public void checkFAQLinkForStep10(){
        //проверка для шага 10
        //Отобразилась страница "Вопросы и ответы", задан фильтр по данной услуге.
        log.info("Check page title for \"Портал госуслуг Москвы\"");
        waitForPageTitle(PAGE_TITLE);

        WebElement selectContent = driver.findElement(selectFaqSubject);
        String currentFaq = selectContent.getText();
        log.info("Checking FAQ subject, current is '"+ currentFaq +"', expected is '" +CURRENT_FAQ_SUBJECT + "'");
        Assert.assertEquals(currentFaq, CURRENT_FAQ_SUBJECT, "Failed check for FAQ subject");
        //Assert.assertTrue(currentFaq.equals(CURRENT_FAQ_SUBJECT), "Failed check for FAQ subject");
        log.info("Checking current URL");
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }
}
