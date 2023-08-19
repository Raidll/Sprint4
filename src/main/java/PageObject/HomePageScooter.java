package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageScooter {
    private WebDriver driver;
    // Верхняя кнопка Заказать
    private final String topOrderButton = ".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']";
    // Нижняя кнопка заказать
    private final String bottomOrderButton = ".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']";



    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }
    // Клик по элементу, xpath которого передан
    public HomePageScooter clickOnElementByXpath(String elementXpath) {
        driver.findElement(By.xpath(elementXpath)).click();
        return this;
    }
    // Скролл к элементу, xpath которого передан
    public HomePageScooter scrollToElementByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    // Ожидание видимости элемента, xpath которого передан
    public HomePageScooter waitingForVisibilityByXpath(String xpath) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this;
    }

    public HomePageScooter clickTopOrderButton() {
        driver.findElement(By.xpath(topOrderButton)).click();
        return this;
    }

    public HomePageScooter clickBottomOrderButton() {
        driver.findElement(By.xpath(bottomOrderButton)).click();
        return this;
    }
    public HomePageScooter scrollToBottomOrderButton() {
        WebElement element = driver.findElement(By.xpath(bottomOrderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

}
