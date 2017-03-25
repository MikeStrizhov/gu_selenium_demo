package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Properties;

import java.util.List;

/**
 * Created by Michael Strizhov on 22.03.2017.
 */
public class KindergartenServiceStep1Page extends Page {
    final String URL = "https://www.mos.ru/pgu/ru/application/dogm/77060101/#step_1";
    final String PAGE_TITLE ="Запись в детский сад / Департамент образования города Москвы";
    //WebDriver driver;

    public By linkApplicationInfo2 = By.xpath(".//a[@class=\"white_link\"]");
    //public By linkApplicationInfo = By.xpath(".//a[contains(text()[normalize-space()], 'Информация по оформлению заявления')]");
    //public By linkApplicationInfo = By.xpath(".//a[@class=\"white_link\"]/..");
    public By linkApplicationInfo = By.cssSelector("#form-info > div.form-info-show-detail");
    //public By linkApplicationInfo = By.xpath("//*[@id=\"form-info\"]/div[1]/div[1]");
    public By linkCloseApplicationInfo = By.xpath(".//a[@class=\"btn-close-pop close\"]");
    //public By linkPrintApplicationInfo = By.xpath(".//a[@title=\"Распечатать\"]");
    public By linkPrintApplicationInfo = By.cssSelector("div.messagebox-body a[title=\"Распечатать\"]");
    String linkFAQXpath = ".//a[contains(text()[normalize-space()], 'часто задаваемые вопросы')]";
    public By linkFAQ = By.xpath(linkFAQXpath);
    public By fieldChildBirthDate = By.id("A_Sh2_Block1_Date1");
    public By textChildBirthDateRestriction = By.xpath(".//div[contains(text()[normalize-space()], 'На 1 сентября желаемого года поступления возраст ребенка должен быть от 2 месяцев до 7 лет')]");
    public By selectWishingEnterDate = By.id("A_Sh2_Block1_List1_chosen");
    //public By checkboxShortTermGroup = By.id("A_Sh2_Block3_Flag_1");
    public By checkboxShortTermGroup = By.xpath("//input[@id=\"A_Sh2_Block3_Flag_1\"]/..");
    public By selectShortTermGroupTime = By.id("A_Sh2_Block1_List1_GKP_chosen");
    public By linkShortTermGroupStartTimeInfo = By.xpath("//div[@class=\"additional hint-button\"]");
    //public By linkStep18AnyplaceOnPage = By.xpath("<legend>Дополнительно прошу:</legend>");
    public By radioPlaceRegistrationOfChild = By.xpath("//label[contains(text()[normalize-space()], 'По месту жительства на территории города Москвы')]/..");
    ////*[@id="step_1"]//div[@class="form-infobox   orange"][contains(text()[normalize-space()], 'Для адресов вида ')]
    public By textZelenograd = By.xpath("//*[@id=\"step_1\"]//div[@class=\"form-infobox   orange\"][contains(text()[normalize-space()], 'Для адресов вида ')]");

    public By checkboxStreetNotInListDiv = By.xpath("//*[@id=\"A_Sh2_Block3_Flag1\"]/..");
    public By checkboxStreetNotInList = By.xpath("//*[@id=\"A_Sh2_Block3_Flag1\"]");
    public By checkboxStreetNotInListForClick = By.xpath("//label[contains(text()[normalize-space()], 'Улицы нет в спиcке')]");

    public By linkStreetInfoButton = By.xpath("//*[@id=\"A_addr1\"]//label[contains(text()[normalize-space()], 'Улица')]/following-sibling::*//div[@class=\"additional  hint-button\"]");
    public By fieldChildRegistrationStreet = By.id("A_addr1_street");
    public By selectChildRegistrationHouse = By.id("A_addr1_house_chosen");
    public By selectChildRegistrationFlat = By.xpath("//*[@id=\"A_addr1\"][@type=\"text\"]");

    //  //*[@id="step_1"]//label[contains(text()[normalize-space()], 'Округ')]/following-sibling::*//a[@class="chosen-single chosen-default"]/span
    public By selectChildRegistrationDistrict = By.xpath("//*[@id=\"step_1\"]//label[contains(text()[normalize-space()], 'Округ')]/following-sibling::*//a[@class=\"chosen-single chosen-default\"]/span");

    // //*[@id="step_1"]//label[contains(text()[normalize-space()], 'Район')]/following-sibling::*//a[@class="chosen-single chosen-default"]/span
    public By selectChildRegistrationRayon = By.xpath("//*[@id=\"step_1\"]//label[contains(text()[normalize-space()], 'Район')]/following-sibling::*//a[@class=\"chosen-single chosen-default\"]/span");
    public By fieldChildRegistrationStreetStep28 = By.xpath("//*[@id=\"step_1\"]//input[@name=\"field[a.internal.addr_man1.street]\"]");
    public By fieldChildRegistrationHouseStep28 = By.xpath("//*[@id=\"step_1\"]//input[@name=\"field[a.internal.addr_man1.dom]\"]");
    public By fieldChildRegistrationCorpusStep28 = By.xpath("//*[@id=\"step_1\"]//input[@name=\"field[a.internal.addr_man1.korpus]\"]");
    public By fieldChildRegistrationFlatStep28 = By.xpath("//*[@id=\"step_1\"]//input[@name=\"field[a.internal.addr_man1.room]\"]");
    // //*[@id="Z_Sh2_Block4_List1_ou_dou2"]//a[contains(text()[normalize-space()], 'название')]/..
    public By buttonSearchSchoolByName = By.xpath("//*[@id=\"Z_Sh2_Block4_List1_ou_dou2\"]//a[contains(text()[normalize-space()], 'название')]/..");
    // //*[@id="Z_Sh2_Block4_List1_ou_dou2"]//a[contains(text()[normalize-space()], 'местонахождение')]/..
    public By buttonSearchSchoolByPlace = By.xpath("//*[@id=\"Z_Sh2_Block4_List1_ou_dou2\"]//a[contains(text()[normalize-space()], 'местонахождение')]/..");
    public By fieldSchoolNameForSearch = By.id("Z_Sh3_Block2_text1");
    public By buttonSearchBySchoolName = By.id("Z_button_search_dou");
    // //*[@id="Z_Sh2_Block4_List1"]//a[contains(text()[normalize-space()], 'метро')]
    public By radiobuttonSearchSchoolByMetro = By.xpath("//*[@id=\"Z_Sh2_Block4_List1\"]//a[contains(text()[normalize-space()], 'метро')]");
    // ///*[@id="Z_Sh2_Block4_List1"]//a[contains(text()[normalize-space()], 'район')]
    public By radiobuttonSearchSchoolByRayon = By.xpath("//*[@id=\"Z_Sh2_Block4_List1\"]//a[contains(text()[normalize-space()], 'район')]");
    public By selectSchoolDistrict = By.xpath("//*[@id=\"Z_okrug_rayon_div\"]//input");
    // //*[@id="Z_okrug_rayon_div"]//label[contains(text()[normalize-space()], 'Район')]/following-sibling::div//input
    public By selectSchoolRayon = By.xpath("//*[@id=\"Z_okrug_rayon_div\"]//label[contains(text()[normalize-space()], 'Район')]/following-sibling::div//input");

    public By checkboxKinderGarden = By.xpath("//label[@for=\"Z_Sh2_Block4_list2_2\"]");
    public By buttonFindKinderGarden = By.id("Z_button_search_dou");


    //*[@id="A_all_search_fields"]//span[contains(text()[normalize-space()], 'cкрыть карту')]
    public By clickHideMap = By.xpath("//*[@id=\"A_all_search_fields\"]//span[contains(text()[normalize-space()], 'cкрыть карту')]");
    //*[@id="A_all_search_fields"]//span[contains(text()[normalize-space()], 'показать карту')]
    public By clickShowMap = By.xpath("//*[@id=\"A_all_search_fields\"]//span[contains(text()[normalize-space()], 'показать карту')]");
    //*[@id="Z_metro_div"]//input
    public By selectSearchSchoolByMetro = By.xpath("//*[@id=\"Z_metro_div\"]//input");

    public By checkboxSchoolWithKinderGarden = By.xpath("//label[@for=\"Z_Sh2_Block4_list2_1\"]");

    public By buttonSchoolWithKinderGarden1 = By.xpath("//*[@id=\"id_010141\"]//a[contains(text()[normalize-space()], 'Приоритетная')]");
    public By buttonSchoolWithKinderGarden2 = By.xpath("//*[@id=\"id_012721\"]//a[contains(text()[normalize-space()], 'Дополнительная 1')]");
    public By buttonSchoolWithKinderGarden3 = By.xpath("//*[@id=\"id_13068\"]//a[contains(text()[normalize-space()], 'Дополнительная 2')]");

    public By buttonContinue = By.id("button_next");

    public KindergartenServiceStep1Page(WebDriver driver) {
        super(driver);
        //Init page
        //this.driver = driver;
    }
    @Step("Отобразилась страница услуги \"Запись в детский сад\", активен шаг 1 \"Выбор образовательной организации\".")
    public void checkPageOpened() {
        //ToDo write code step5
    }
    @Step("Нажать ссылку \"Информация по оформлению заявления\"")
    public void pressApplicationInfo() {
//        sleep(500);
//        scrollDown(".//a[@class=\"white_link\"]");
        sleep(2000);
        scrollDown("//*[@id=\"body\"]/div/h1");
        sleep(500);

        click(linkApplicationInfo);
        //ToDo write code - check for step6
    }

    public void pressApplicationInfo2() {
        click(linkApplicationInfo2);
        //ToDo write code - check for step6
    }

/*    public void scrollDown(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,element);

    }*/

    @Step("Нажать на символ \"Х\" или на кнопку \"Закрыть\"")
    public void pressCloseApplicationInfo() {
        waitForElement(linkCloseApplicationInfo);
        click(linkCloseApplicationInfo);
        //ToDo write code - check for step7
    }
    @Step("Нажать на ссылку \"Распечатать\"")
    public void pressPrintApplicationInfo() {
        click(linkPrintApplicationInfo);
        //ToDo подумать над печатью

        //ToDo write code - check for step8
    }
    @Step("Нажать на ссылку \"часто задаваемые вопросы\".")
    public void pressFAQLink() {
        //scrollDown(linkFAQXpath);
        sleep(1000);
        click(linkFAQ);
        //ToDo write code - check for step10
    }
    public void openPage() {
        driver.get(URL);
        waitForPageTitle(PAGE_TITLE);
    }
    @Step("В поле \"Дата рождения ребенка\" ввести корректную дату (возраст ребенка должен быть менее 7 лет)")
    public void enterChildBirthDate() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sendKeys(fieldChildBirthDate, Properties.getProperty("Step11_ChildBirthDate"));
        //ToDo write code - check for step11
    }
    @Step("Проверить наличие инфоблока \"На 1 сентября желаемого года поступления ребенку должно быть менее 7 лет\"")
    public void checkTextChildBirthDateRestriction() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        waitForElement(textChildBirthDateRestriction);
        //ToDo write code - check for step12
    }

    @Step("Из выпадающего списка \"Желаемый год поступления на 1 сентября\" выбрать \"1 сентября 201X года\", где Х - цифра")
    public void enterSelectWishingEnterDate(String date) {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        waitForElement(selectWishingEnterDate);
        click(selectWishingEnterDate);
        //String date = Properties.getProperty("Step13_WishingEnterDate");
        //String xPathForDate = "//*[@id=\"A_Sh2_Block1_List1_chosen\"]//li[contains(text()[normalize-space()], '" + date +"')]";
        //  //li[contains(text()[normalize-space()], '1 сентября 2018 года')]
        String xPathForDate = "//li[contains(text()[normalize-space()], '" + date +"')]";
        By byDate = By.xpath(xPathForDate);
        //logWebElement(byDate);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(byDate);

        //ToDo write code - check for step13
    }
    @Step("Включить чекбокс \"Направить ребенка для зачисления в группу кратковременного пребывания\".")
    public void turnCheckboxShortTermGroup() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(checkboxShortTermGroup);
        //ToDo write code - check for step15
    }
    @Step("В поле \"С 1 сентября\" выбрать одно из значений.")
    public void choiceShortTermGroupStartTime() {
        sleep(WAIT_TIMEOUT_FOR_STEP);
    //    logWebElement(selectShortTermGroupTime);
        click(selectShortTermGroupTime);
        String date = Properties.getProperty("Step16_WishingShortTermGroupStartTime");
        //  //li[contains(text()[normalize-space()], '2017 года')]
        String xPathForDate = "//li[contains(text()[normalize-space()], '" + date +"')]";
        By byDate = By.xpath(xPathForDate);
    //    logWebElement(byDate);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(byDate);
        //ToDo write code - check for step16
    }
    @Step("Кликнуть на значок \"?\" справа от чекбокса \"Направить ребенка для зачисления в группу кратковременного пребывания\"")
    public void clickShortTermGroupStartTimeInfo() {
        click(linkShortTermGroupStartTimeInfo);
        //ToDo write code - check for step17
    }
    @Step("'Закрыть подсказку, нажав на \"х\" или нажав на любую область страницы")
    public void clickStep18AnyplaceOnPage() {
        //click(linkStep18AnyplaceOnPage);
        click(fieldChildBirthDate);
        //ToDo write code - check for step18
    }

    @Step("В поле \"Тип регистрации ребенка\" радиокнопку \"По месту пребывания на территории города Москвы\".")
    public void clickPlaceRegistrationOfChild() {
        click(radioPlaceRegistrationOfChild);
        //ToDo write code - check for step19
    }

    @Step("В поле \"Тип регистрации ребенка\" радиокнопку \"По месту пребывания на территории города Москвы\".")
    public void checkTextZelenograd() {
        waitForElement(textZelenograd);
        String stringZelenograd =  getText(textZelenograd);
        log.info("Шаг 20 найденн текстовый блок\n" + stringZelenograd);
        String forCompare = "Для адресов вида Зеленоград, корпус NNN, следует вводить улицу \"город Зеленоград\".\n" +
                "В случае отсутствия номера квартиры (для частных домов и др.) необходимо указать значение \"1\".";
        Assert.assertTrue("Шаг 20, ошибка сравнения текстового блока", stringZelenograd.contains(forCompare));
    }

    @Step("Убедиться, что чекбокс \"Улицы нет в спиcке\" выключен.")
    public void checkIsCheckboxStreetNotInList(){
        scrollDown("//*[@id=\"A_Sh2_Block3_Flag1\"]");
        sleep(WAIT_TIMEOUT_FOR_STEP);
//        logWebElement(checkboxStreetNotInList);
//        logWebElement(checkboxStreetNotInListDiv);
        //WebElement checkbox = driver.findElement(checkboxStreetNotInList);
        boolean isSelected =  stateOfCheckboxStreetNotInList();
        Assert.assertFalse("Шаг 21, чекбокс \"Улицы нет в спиcке\" включен.", isSelected);

/*        //click(checkboxStreetNotInListDiv);
        By b1 = By.xpath("//label[contains(text()[normalize-space()], 'Улицы нет в спиcке')]");
        logWebElement(b1);
        // /*//*[@id="region_dummy_form_chosen"]
        scrollDown("/*//*[@id=\"region_dummy_form_chosen\"]");
        logWebElement(b1);
        click(b1);

        ////label[contains(text()[normalize-space()], 'Улицы нет в спиcке')]
        click(checkboxStreetNotInList);
//        logWebElement(checkboxStreetNotInList);
//        logWebElement(checkboxStreetNotInListDiv);
        checkbox = driver.findElement(checkboxStreetNotInList);
        isSelected =  checkbox.isSelected();
        Assert.assertTrue("Шаг 21, чекбокс \"Улицы нет в спиcке\" включен.", isSelected);*/
    }

    public void clickOnCheckboxStreetNotInList(){
        //ToDo убедиться в необходимости скролла
        scrollDown("//*[@id=\"region_dummy_form_chosen\"]");
        click(checkboxStreetNotInListForClick);
    }

    public boolean stateOfCheckboxStreetNotInList(){
        WebElement checkbox = driver.findElement(checkboxStreetNotInList);
        boolean isSelected =  checkbox.isSelected();
        return isSelected;
    }

    @Step("Кликнуть на значек \"?\" справа от поля \"Улица\".")
    public void clickOnStreetInfoButton(){
        click(linkStreetInfoButton);

        //ToDo write code - check for step22
    }

    @Step("В поле \"Улица\" ввести первые несколько букв названия необходимой улицы.")
    public void enterFirstLettersChildRegistrationStreet(){
        sendKeys(fieldChildRegistrationStreet, Properties.getProperty("Step23_FirstLettersChildRegistrationStreet"));
        //ToDo write code - check for step23
    }

    @Step("'Из списка выбрать необходимый вариант.")
    public void enterChildRegistrationStreet(){
        String choice = Properties.getProperty("Step24_ChildRegistrationStreet");
        //enterChildRegistrationStreet(choice);
        sendKeys(fieldChildRegistrationStreet, choice);
        String xPath = "/html/body/ul/li/*//*[contains(text()[normalize-space()], '" + choice +"')]";

        By byForChoice = By.xpath(xPath);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(byForChoice);
        //ToDo write code - check for step24
    }

    @Step("В поле \"Дом\" выбрать из списка необходимый вариант.")
    public void enterChildRegistrationHouse(){
        String choice = Properties.getProperty("Step25_ChildRegistrationHouse");
        String xPath = "//*[@id=\"A_addr1_house_chosen\"]/div/ul/li[contains(text()[normalize-space()], '" + choice + "')]";
        scrollDown(selectChildRegistrationHouse);
        click(selectChildRegistrationHouse);
        By byForChoice = By.xpath(xPath);
        click(byForChoice);

        //ToDo write code - check for step25
    }

    @Step("В поле \"Квартира\" ввести корректные данные.")
    public void enterChildRegistrationFlat(){
        String choice = Properties.getProperty("Step26_ChildRegistrationFlat");
        String xPath = "/html/body/ul/li/a[contains(text()[normalize-space()], '" + choice + "')]";

        scrollDown(selectChildRegistrationFlat);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(selectChildRegistrationFlat);
        By byForChoice = By.xpath(xPath);
        click(byForChoice);

        //ToDo write code - check for step26
    }

    @Step("Включить чекбокс \"Улицы нет в списке\".")
    public void clickCheckboxStreetNotInList(){
        clickOnCheckboxStreetNotInList();
        boolean isSelected =  stateOfCheckboxStreetNotInList();
        Assert.assertTrue("Шаг 27, чекбокс \"Улицы нет в спиcке\" выключен.", isSelected);

        sleep(WAIT_TIMEOUT_FOR_STEP);
        //ToDo write code - check for step27
    }

    @Step("Заполнить следующие поля корректными данными:\n" +
            "- Округ (выбор из справочника)\n" +
            "- Район (выбор из справочника)\n" +
            "- Улица\n" +
            "- Дом\n" +
            "- Корпус\n" +
            "- Строение\n" +
            "- Квартира\n")
    public void enterChildRegistration(){
        enterChildRegistrationDistrict(Properties.getProperty("Step28_ChildRegistrationDistrict"));
        enterChildRegistrationRayon(Properties.getProperty("Step28_ChildRegistrationRayon"));
        enterChildRegistrationStreet(Properties.getProperty("Step28_ChildRegistrationStreet"));
        enterChildRegistrationHouse(Properties.getProperty("Step28_ChildRegistrationHouse"));
        enterChildRegistrationCorpus(Properties.getProperty("Step28_ChildRegistrationCorpus"));
        enterChildRegistrationFlat(Properties.getProperty("Step28_ChildRegistrationFlat"));

    }

    public void enterChildRegistrationDistrict(String districtName){
        click(selectChildRegistrationDistrict);
        // //*[@id="step_1"]//li[contains(text()[normalize-space()], 'Северный административный округ')]
        String xPath = "//*[@id=\"step_1\"]//li[contains(text()[normalize-space()], '" + districtName + "')]";
        By byForChoice = By.xpath(xPath);
        click(byForChoice);
    }
    public void enterChildRegistrationRayon(String name) {
        click(selectChildRegistrationRayon);
        String xPath = "//*[@id=\"step_1\"]//li[contains(text()[normalize-space()], '" + name + "')]";
        By byForChoice = By.xpath(xPath);
        click(byForChoice);
    }

    public void enterChildRegistrationStreet(String name){
        click(fieldChildRegistrationStreetStep28);
        sendKeys(fieldChildRegistrationStreetStep28, name);
    }

    public void enterChildRegistrationHouse(String name){
        click(fieldChildRegistrationHouseStep28);
        sendKeys(fieldChildRegistrationHouseStep28, name);
    }

    public void enterChildRegistrationCorpus(String name){
        click(fieldChildRegistrationCorpusStep28);
        sendKeys(fieldChildRegistrationCorpusStep28, name);
    }

    public void enterChildRegistrationFlat(String name){
        click(fieldChildRegistrationFlatStep28);
        sendKeys(fieldChildRegistrationFlatStep28, name);
    }

    @Step("В блоке \"За данным адресом закреплены следующие образовательные организации:\" включить радиокнопку \"Поиск по названию\"")
    public void pressButtonSearchSchoolByName() {
        scrollDown(buttonSearchSchoolByName);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(buttonSearchSchoolByName);

        //ToDo write code - check for step29
    }

    @Step("'Включить радиокнопку \"Поиск по местоположению\"")
    public void pressButtonSearchSchoolByPlace() {
        scrollDown(buttonSearchSchoolByPlace);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(buttonSearchSchoolByPlace);

        //ToDo write code - check for step34
    }

    @Step("В поле \"Поиск\" ввести название учебного заведения, например, \"Детский сад №20\".")
    public void enterSchoolNameForSearch(){
        sendKeys(fieldSchoolNameForSearch,Properties.getProperty("Step32_SchoolName"));
        //ToDo write code - check for step32
    }

    @Step("Нажать на кнопку \"Найти\".")
    public void pressSearchBySchoolName(){
        click(buttonSearchBySchoolName);
        //ToDo write code - check for step33
    }

    @Step("В поле \"Место нахождения\" включить \"метро\"")
    public void clickRadiobuttonSearchSchoolByMetro(){
        scrollDown(radiobuttonSearchSchoolByMetro);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(radiobuttonSearchSchoolByMetro);
        //ToDo write code - check for step45
    }
    @Step("В поле \"Место нахождения\" включить \"округ\"")
    public void clickRadiobuttonSearchSchoolByRayon(){
        scrollDown(radiobuttonSearchSchoolByRayon);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        click(radiobuttonSearchSchoolByRayon);
        //ToDo write code - check for step35
    }

    @Step("В поле \"Округ\" выбрать из списка любое значение.")
    public void enterSchoolDistrict(){
        click(selectSchoolDistrict);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        By by1 = By.xpath("//*[@id=\"Z_okrug_rayon_div\"]//li[contains(text()[normalize-space()], '"+ Properties.getProperty("Step36_SchoolDistrict") +"')]");
        click(by1);

        //ToDo write code - check for step36
    }

    @Step("В поле \"Район\" выбрать из списка произвольное значение.")
    public void enterSchoolRayon(){
        click(selectSchoolRayon);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        By by1 = By.xpath("//*[@id=\"Z_okrug_rayon_div\"]//li[contains(text()[normalize-space()], '"+ Properties.getProperty("Step37_SchoolRayon") +"')]");
        click(by1);

        //ToDo write code - check for step37
    }

    @Step("В поле \"Тип образовательной организации\" включить чекбокс \"Детский сад\".")
    public void clickCheckboxKinderGarden(){
        click(checkboxKinderGarden);
        //ToDo write code - check for step38
    }

    @Step("Нажать на кнопку \"Найти\"")
    public void clickFindKinderGarden(){
        scrollDown(buttonFindKinderGarden);
        click(buttonFindKinderGarden);
        //ToDo write code - check for step39
    }

    @Step("Нажать на кнопку \"Найти\"")
    public void clickHideMap(){
        click(clickHideMap);
        //ToDo write code - check for step41
    }

    @Step("Нажать на кнопку \"Найти\"")
    public void clickShowMap(){
        click(clickShowMap);
        //ToDo write code - check for step42
    }

    @Step("В поле \"Метро\" выбрать из списка необходимое метро")
    public void selectSearchSchoolByMetro(){
        click(selectSearchSchoolByMetro);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        By by1 = By.xpath("//*[@id=\"Z_metro_div\"]//li[contains(text()[normalize-space()], '"+ Properties.getProperty("Step46_SchoolByMetro") +"')]");
        click(by1);

        //ToDo write code - check for step46
    }

    @Step("Включить оба чекбокса \"Школа с дошкольным отделением\", \"Детский сад\" и нажать на кнопку \"Найти\".")
    public void searchSchoolByMetro(){
        //Этот чекбукс включен по умолчанию
        //click(checkboxKinderGarden);
        click(checkboxSchoolWithKinderGarden);
        click(buttonSearchBySchoolName);
        //ToDo write code - check for step47
    }

    @Step("Для первых трех найденных организаций нажать на кнопки \"Приоритетная\", \"Дополнительная 1\" и \"Дополнительная 2\" соответственно\". Убедиться, что кнопки находятся в нажатом положении.")
    public void pressButtonsForFoundSchools(){
        sleep(WAIT_TIMEOUT_FOR_STEP);
        sleep(WAIT_TIMEOUT_FOR_STEP);
        scrollDown(buttonSchoolWithKinderGarden1);
        click(buttonSchoolWithKinderGarden1);
        scrollDown(buttonSchoolWithKinderGarden2);
        click(buttonSchoolWithKinderGarden2);
        scrollDown(buttonSchoolWithKinderGarden3);
        click(buttonSchoolWithKinderGarden3);
        //ToDo write code - check for step48
    }



    @Step("Нажать на кнопку \"Продолжить\"")
    public void pressContinue(){
        scrollDown(buttonContinue);
        click(buttonContinue);
        //ToDo write code - check for step50
    }


    //=============================================================
    //=============================================================
    //=============================================================
    void logWebElement(By by){
        String res = "Log info for web element \n isDispled=" + driver.findElement(by).isDisplayed() +
                "\n isEnabled=" + driver.findElement(by).isEnabled() +
                "\n isSelected=" + driver.findElement(by).isSelected() +
                "\n text=" + driver.findElement(by).getText();

/*        System.out.println("============");
        System.out.println(res);*/
        log.info(res);
    }


}
