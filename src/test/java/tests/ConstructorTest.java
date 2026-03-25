package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.UserSteps;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {
    private UserSteps userSteps;
    private WebDriverWait wait;

    @Before
    public void setUpTest() {
        userSteps = new UserSteps(driver);
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        driver.get("https://stellarburgers.education-services.ru");
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка, что после клика на 'Булки' активным становится раздел 'Булки'")
    public void testBunsTab() {
        // Сначала кликаем на другой раздел, чтобы убедиться, что переключение работает
        userSteps.clickSaucesTab();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                userSteps.getActiveTabLocator(), "Соусы"));

        userSteps.clickBunsTab();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                userSteps.getActiveTabLocator(), "Булки"));

        assertEquals("Активный раздел не 'Булки'", "Булки", userSteps.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка, что после клика на 'Соусы' активным становится раздел 'Соусы'")
    public void testSaucesTab() {
        userSteps.clickSaucesTab();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                userSteps.getActiveTabLocator(), "Соусы"));

        assertEquals("Активный раздел не 'Соусы'", "Соусы", userSteps.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка, что после клика на 'Начинки' активным становится раздел 'Начинки'")
    public void testFillingsTab() {
        userSteps.clickFillingsTab();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                userSteps.getActiveTabLocator(), "Начинки"));

        assertEquals("Активный раздел не 'Начинки'", "Начинки", userSteps.getActiveTabText());
    }
}
