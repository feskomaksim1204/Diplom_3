package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import steps.UserSteps;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {
    private UserSteps userSteps;

    @Before
    public void setUpTest() {
        userSteps = new UserSteps(driver);
        driver.get("https://stellarburgers.education-services.ru");
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка, что после клика на 'Булки' активным становится раздел 'Булки'")
    public void testBunsTab() {
        // Сначала кликаем на другой раздел, чтобы убедиться, что переключение работает
        userSteps.clickSaucesTab();
        userSteps.clickBunsTab();
        assertEquals("Активный раздел не 'Булки'", "Булки", userSteps.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка, что после клика на 'Соусы' активным становится раздел 'Соусы'")
    public void testSaucesTab() {
        userSteps.clickSaucesTab();
        assertEquals("Активный раздел не 'Соусы'", "Соусы", userSteps.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка, что после клика на 'Начинки' активным становится раздел 'Начинки'")
    public void testFillingsTab() {
        userSteps.clickFillingsTab();
        assertEquals("Активный раздел не 'Начинки'", "Начинки", userSteps.getActiveTabText());
    }
}
