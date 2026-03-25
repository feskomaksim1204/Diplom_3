package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserGenerator;
import org.junit.Before;
import org.junit.Test;
import steps.UserSteps;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    private UserSteps userSteps;
    private User user;

    @Before
    public void setUpTest() {
        userSteps = new UserSteps(driver);
        user = UserGenerator.getRandomUser();

        driver.get("https://stellarburgers.education-services.ru");
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя")
    public void testSuccessfulRegistration() {
        userSteps.clickPersonalAccountButton();
        userSteps.clickRegisterLinkOnLogin();
        userSteps.register(user.getName(), user.getEmail(), user.getPassword());

        assertTrue("Страница входа не открылась",
                userSteps.isLoginPageDisplayed());
    }

    @Test
    @DisplayName("Ошибка при регистрации с паролем меньше 6 символов")
    @Description("Проверка появления ошибки при попытке зарегистрироваться с паролем менее 6 символов")
    public void testRegistrationWithInvalidPassword() {
        User invalidUser = UserGenerator.getUserWithInvalidPassword();

        userSteps.clickPersonalAccountButton();
        userSteps.clickRegisterLinkOnLogin();
        userSteps.register(invalidUser.getName(), invalidUser.getEmail(), invalidUser.getPassword());

        assertTrue("Ошибка для некорректного пароля не отображается",
                userSteps.isPasswordErrorDisplayed());
    }
}
