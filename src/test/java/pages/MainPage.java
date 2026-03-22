package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By bunsTab = By.xpath(".//span[text()='Булки']/parent::div");
    private By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");
    private By fillingsTab = By.xpath(".//span[text()='Начинки']/parent::div");
    private By activeTab = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public boolean isMainPageDisplayed() {
        return driver.findElement(bunsTab).isDisplayed();
    }

    public void clickBunsTab() {
        WebElement element = driver.findElement(bunsTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickSaucesTab() {
        WebElement element = driver.findElement(saucesTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickFillingsTab() {
        WebElement element = driver.findElement(fillingsTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String getActiveTabText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeTab));
        return driver.findElement(activeTab).getText();
    }

    public By getActiveTabLocator() {
        return activeTab;
    }
}
