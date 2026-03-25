package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;

public class UserSteps {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;
    private HeaderPage headerPage;

    public UserSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        headerPage = new HeaderPage(driver);
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной")
    public void clickLoginButtonOnMain() {
        mainPage.clickLoginButton();
    }

    @Step("Клик по кнопке 'Личный кабинет' в шапке")
    public void clickPersonalAccountButton() {
        headerPage.clickPersonalAccountButton();
    }

    @Step("Клик по кнопке 'Конструктор' в шапке")
    public void clickConstructorButton() {
        headerPage.clickConstructorButton();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogo() {
        headerPage.clickLogo();
    }

    @Step("Заполнение формы регистрации: имя = {name}, email = {email}, пароль = {password}")
    public void register(String name, String email, String password) {
        registerPage.register(name, email, password);
    }

    @Step("Клик по ссылке 'Войти' на странице регистрации")
    public void clickLoginLinkOnRegister() {
        registerPage.clickLoginLink();
    }

    @Step("Проверка отображения ошибки для некорректного пароля")
    public boolean isPasswordErrorDisplayed() {
        return registerPage.isPasswordErrorDisplayed();
    }

    @Step("Заполнение формы входа: email = {email}, пароль = {password}")
    public void login(String email, String password) {
        loginPage.login(email, password);
    }

    @Step("Клик по ссылке 'Зарегистрироваться' на странице входа")
    public void clickRegisterLinkOnLogin() {
        loginPage.clickRegisterLink();
    }

    @Step("Клик по ссылке 'Восстановить пароль' на странице входа")
    public void clickForgotPasswordLinkOnLogin() {
        loginPage.clickForgotPasswordLink();
    }

    @Step("Клик по ссылке 'Войти' на странице восстановления пароля")
    public void clickLoginLinkOnForgotPassword() {
        forgotPasswordPage.clickLoginLink();
    }

    @Step("Проверка, что открылась главная страница")
    public boolean isMainPageDisplayed() {
        return mainPage.isMainPageDisplayed();
    }

    @Step("Проверка, что открылась страница входа")
    public boolean isLoginPageDisplayed() {
        return loginPage.isLoginButtonDisplayed();
    }

    @Step("Получение текста активного раздела в конструкторе")
    public String getActiveTabText() {
        return mainPage.getActiveTabText();
    }

    @Step("Клик по разделу 'Булки'")
    public void clickBunsTab() {
        mainPage.clickBunsTab();
    }

    @Step("Клик по разделу 'Соусы'")
    public void clickSaucesTab() {
        mainPage.clickSaucesTab();
    }

    @Step("Клик по разделу 'Начинки'")
    public void clickFillingsTab() {
        mainPage.clickFillingsTab();
    }
    public By getActiveTabLocator() {
        return mainPage.getActiveTabLocator();
    }
}
