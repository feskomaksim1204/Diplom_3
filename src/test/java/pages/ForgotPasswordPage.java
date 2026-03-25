package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    private By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By restoreButton = By.xpath(".//button[text()='Восстановить']");
    private By loginLink = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickRestoreButton() {
        driver.findElement(restoreButton).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void restorePassword(String email) {
        setEmail(email);
        clickRestoreButton();
    }
}
