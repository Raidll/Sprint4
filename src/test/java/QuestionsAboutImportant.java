import PageObject.HomePageScooter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionsAboutImportant {
    // Xpath вопроса
    private final String questionXpath;
    // Xpath ответа
    private final String answerXpath;
    // Текст вопроса
    private final String questionText;
    // Текст ответа
    private final String answerText;
    private final WebDriver driver = new ChromeDriver();


    public QuestionsAboutImportant(String questionXpath, String answerXpath, String questionText, String answerText) {
        this.questionXpath = questionXpath;
        this.answerXpath = answerXpath;
        this.questionText = questionText;
        this.answerText = answerText;

    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]  {
                {".//div[@id='accordion__heading-0']", ".//div[@id='accordion__panel-0']", "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {".//div[@id='accordion__heading-1']", ".//div[@id='accordion__panel-1']", "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {".//div[@id='accordion__heading-2']", ".//div[@id='accordion__panel-2']", "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {".//div[@id='accordion__heading-3']", ".//div[@id='accordion__panel-3']", "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {".//div[@id='accordion__heading-4']", ".//div[@id='accordion__panel-4']", "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {".//div[@id='accordion__heading-5']", ".//div[@id='accordion__panel-5']", "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {".//div[@id='accordion__heading-6']", ".//div[@id='accordion__panel-6']", "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {".//div[@id='accordion__heading-7']", ".//div[@id='accordion__panel-7']", "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkTextHowMuchDoesItCost()  {
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.scrollToElementByXpath(questionXpath)
                .waitingForVisibilityByXpath(questionXpath);
        assertEquals(driver.findElement(By.xpath(questionXpath)).getText(), questionText);
        homePageScooter.clickOnElementByXpath(questionXpath)
                .waitingForVisibilityByXpath(answerXpath);
        assertEquals(driver.findElement(By.xpath(answerXpath)).getText(), answerText);
    }



    @After
    public void teardown() {
        driver.quit();
    }

}
