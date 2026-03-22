package tests;

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
    public void testBunsTab() {
        userSteps.clickBunsTab();
        assertEquals("Активный раздел не 'Булки'", "Булки", userSteps.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void testSaucesTab() {
        userSteps.clickSaucesTab();
        assertEquals("Активный раздел не 'Соусы'", "Соусы", userSteps.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void testFillingsTab() {
        userSteps.clickFillingsTab();
        assertEquals("Активный раздел не 'Начинки'", "Начинки", userSteps.getActiveTabText());
    }
}
