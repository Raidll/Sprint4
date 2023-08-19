package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScooterOrderFirstPage {
    private WebDriver driver;
    // Поле ввода имени
    private final String inputName = ".//input[@placeholder='* Имя']";
    // Поле ввода Фамилии
    private final String inputSurname = ".//input[@placeholder='* Фамилия']";
    // Поле ввода адреса
    private final String inputAdress = ".//input[@placeholder='* Адрес: куда привезти заказ']";
    // Селектор выбора станции метро
    private final String selectMetroStation = ".//input[@class='select-search__input']";
    // Поле ввода номера телефона
    private final String inputTelephoneNumber = ".//input[@placeholder='* Телефон: на него позвонит курьер']";
    // Станция метро Черкизовская
    private final String cherkizovskayaStation = ".//div[text()='Черкизовская']";
    // Кнопка Далее
    private final String buttonNext = ".//button[text()='Далее']";


    public ScooterOrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public ScooterOrderFirstPage fillName(String name) {
        driver.findElement(By.xpath(inputName)).sendKeys(name);
        return this;
    }
    public ScooterOrderFirstPage fillSurname(String name) {
        driver.findElement(By.xpath(inputSurname)).sendKeys(name);
        return this;
    }
    public ScooterOrderFirstPage fillAdress(String name) {
        driver.findElement(By.xpath(inputAdress)).sendKeys(name);
        return this;
    }
    public ScooterOrderFirstPage fillTelephoneNumber(String name) {
        driver.findElement(By.xpath(inputTelephoneNumber)).sendKeys(name);
        return this;
    }
    public ScooterOrderFirstPage clickSelectMetroStation() {
        driver.findElement(By.xpath(selectMetroStation)).click();
        return this;
    }
    public ScooterOrderFirstPage clickCherkizovskayaStation() {
        driver.findElement(By.xpath(cherkizovskayaStation)).click();
        return this;
    }
    public ScooterOrderFirstPage clickButtonNext() {
        driver.findElement(By.xpath(buttonNext)).click();
        return this;
    }


}
