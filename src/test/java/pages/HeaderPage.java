package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    private By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By logo = By.xpath(".//div[contains(@class, 'AppHeader_header__logo')]/a");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public boolean isConstructorButtonDisplayed() {
        try {
            return driver.findElement(constructorButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
