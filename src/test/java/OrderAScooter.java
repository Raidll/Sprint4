import PageObject.HomePageScooter;
import PageObject.ScooterOrderFirstPage;
import PageObject.ScooterOrderSecondPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderAScooter {

    private final String[] testNames = {"Иван", "Пётр"};
    private final String[] testSurnames = {"Иванов", "Петров"};
    private final String[] testAdresses = {"Иванов", "Петрович"};
    private final String[] telephoneNumbers = {"79151111111", "79152222222"};
    private final String[] testDates = {"20.03.2024", "15.01.2025"};
    private final String[] testComments = {"Тестовый комментарий", "Второй тестовый комментарий"};

    WebDriver driver = new ChromeDriver();


    @Test
    public void orderAScooterTopButton()  {
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickTopOrderButton();

        ScooterOrderFirstPage scooterFirstOrderPage = new ScooterOrderFirstPage(driver);
        scooterFirstOrderPage.fillName(testNames[0])
                .fillSurname(testSurnames[0])
                .fillAdress(testAdresses[0])
                .clickSelectMetroStation()
                .clickCherkizovskayaStation()
                .fillTelephoneNumber(telephoneNumbers[0])
                .clickButtonNext();
        ScooterOrderSecondPage scooterOrderSecondPage = new ScooterOrderSecondPage(driver);
        scooterOrderSecondPage.fillDate(testDates[0])
                .hideCalendar()
                .clickDropdownRentalPeriod()
                .clickRentalPeriodIsOneDay()
                .clickCheckboxBlack()
                .fillComment(testComments[0])
                .clickOrderButton()
                .clickAcceptOrderButton()
                .waitingForVisibilityButtonCheckOrderStatus();
    }

    @Test
    public void orderAScooterButtomButton() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.scrollToBottomOrderButton()
                .clickBottomOrderButton();

        ScooterOrderFirstPage scooterFirstOrderPage = new ScooterOrderFirstPage(driver);
        scooterFirstOrderPage.fillName(testNames[1])
                .fillSurname(testSurnames[1])
                .fillAdress(testAdresses[1])
                .clickSelectMetroStation()
                .clickCherkizovskayaStation()
                .fillTelephoneNumber(telephoneNumbers[1])
                .clickButtonNext();
        ScooterOrderSecondPage scooterOrderSecondPage = new ScooterOrderSecondPage(driver);
        scooterOrderSecondPage.fillDate(testDates[1])
                .hideCalendar()
                .clickDropdownRentalPeriod()
                .clickRentalPeriodIsOneDay()
                .clickCheckboxBlack()
                .fillComment(testComments[1])
                .clickOrderButton()
                .clickAcceptOrderButton()
                .waitingForVisibilityButtonCheckOrderStatus();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
