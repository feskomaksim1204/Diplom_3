package tests;

import client.UserApiClient;
import constants.Endpoints;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.UserSteps;
import pages.HeaderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LoginParametrizedTest extends BaseTest {
    private UserSteps userSteps;
    private User user;
    private String accessToken;
    private HeaderPage headerPage;
    private UserApiClient userApiClient;

    private final String navigationMethod;
    private final String description;

    public LoginParametrizedTest(String navigationMethod, String description) {
        this.navigationMethod = navigationMethod;
        this.description = description;
    }

    @Parameterized.Parameters(name = "{1}")
    public static Object[][] data() {
        return new Object[][]{
                {"mainButton", "Вход через кнопку 'Войти в аккаунт' на главной"},
                {"personalAccount", "Вход через кнопку 'Личный кабинет'"},
                {"registerLink", "Вход через кнопку в форме регистрации"},
                {"forgotPasswordLink", "Вход через кнопку в форме восстановления пароля"}
        };
    }

    @Before
    public void setUpTest() {
        user = UserGenerator.getRandomUser();
        userApiClient = new UserApiClient();

        // Создаём пользователя через API
        accessToken = userApiClient.getAccessToken(
                userApiClient.createUser(user)
        );

        userSteps = new UserSteps(driver);
        headerPage = new HeaderPage(driver);
        driver.get(Endpoints.BASE_URL);
    }

    @Test
    @DisplayName("Вход пользователя")
    @Description("Проверка входа через разные кнопки навигации")
    public void testLogin() {
        switch (navigationMethod) {
            case "mainButton":
                userSteps.clickLoginButtonOnMain();
                break;
            case "personalAccount":
                userSteps.clickPersonalAccountButton();
                break;
            case "registerLink":
                userSteps.clickPersonalAccountButton();
                userSteps.clickRegisterLinkOnLogin();
                userSteps.clickLoginLinkOnRegister();
                break;
            case "forgotPasswordLink":
                userSteps.clickPersonalAccountButton();
                userSteps.clickForgotPasswordLinkOnLogin();
                userSteps.clickLoginLinkOnForgotPassword();
                break;
        }

        userSteps.login(user.getEmail(), user.getPassword());

        assertTrue("Кнопка 'Конструктор' не отображается — вход не выполнен",
                headerPage.isConstructorButtonDisplayed());
    }

    @After
    public void cleanUp() {
        if (accessToken != null) {
            userApiClient.deleteUser(accessToken);
        }
    }
}
