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
