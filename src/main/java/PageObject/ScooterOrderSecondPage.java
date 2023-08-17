package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderSecondPage {
    private WebDriver driver;

    private final String scooterDeliveryDate = ".//input[@placeholder='* Когда привезти самокат']";
    private final String dropdownRentalPeriod = ".//div[text()='* Срок аренды']";
    private final String rentalPeriodIsOneDay = ".//div[@class='Dropdown-menu']/div[text()='сутки']";
    private final String checkboxBlack = ".//input[@id='black']";
    private final String inputComment = ".//input[@placeholder='Комментарий для курьера']";
    private final String orderButton = ".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']";
    // Xpath вне заполняемых полей. Нужен, чтобы скрыть календарь
    private final String outside = ".//div[text()='Про аренду']";
    private final String acceptOrderButton = ".//button[text()='Да']";
    private final String checkOrderStatus = ".//button[text()='Посмотреть статус']";

    public ScooterOrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }
    public ScooterOrderSecondPage fillDate(String date) {
        driver.findElement(By.xpath(scooterDeliveryDate)).sendKeys(date);
        return this;
    }

    public ScooterOrderSecondPage clickDropdownRentalPeriod() {
        driver.findElement(By.xpath(dropdownRentalPeriod)).click();
        return this;
    }
    public ScooterOrderSecondPage clickRentalPeriodIsOneDay() {
        driver.findElement(By.xpath(rentalPeriodIsOneDay)).click();
        return this;
    }
    public ScooterOrderSecondPage clickCheckboxBlack() {
        driver.findElement(By.xpath(checkboxBlack)).click();
        return this;
    }
    public ScooterOrderSecondPage fillComment(String comment) {
        driver.findElement(By.xpath(inputComment)).sendKeys(comment);
        return this;
    }
    public ScooterOrderSecondPage clickOrderButton() {
        driver.findElement(By.xpath(orderButton)).click();
        return this;
    }
    //Клик вне поля для того, чтобы скрыть календарь
    public ScooterOrderSecondPage hideCalendar() {
        driver.findElement(By.xpath(outside)).click();
        return this;
    }
    public ScooterOrderSecondPage clickAcceptOrderButton() {
        driver.findElement(By.xpath(acceptOrderButton)).click();
        return this;
    }
    public ScooterOrderSecondPage waitingForVisibilityButtonCheckOrderStatus() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkOrderStatus)));
        return this;
    }
}
