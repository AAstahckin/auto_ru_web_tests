package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement
            loginButton = $(".HeaderUserMenu__loginButton"),
            loginLogo = $(".AuthForm__logo-image"),
            loginTitle = $(".AuthForm__title"),
            loginYandexId = $(".AuthFormSocialLogin__yandexid"),
            otherLoginTitle = $(".AuthFormSocialLogin__title"),
            gosuslugi = $(".AuthFormSocialLogin__provider_gosuslugi"),
            continueButton = $(".Button_type_button");

    @Step("Нажимаем на кнопку Войти")
    public LoginPage clickButtonLogin() {
        loginButton.click();
        return this;
    }

    @Step("Проверяем окно авторизации")
    public LoginPage checkWindowLogin() {
        loginLogo.shouldHave(visible);
        loginTitle.shouldHave(text("Вход на сайт"));
        continueButton.shouldHave(visible);
        loginYandexId.shouldHave(visible);
        otherLoginTitle.shouldHave(text("Другие способы входа"));
        gosuslugi.shouldHave(visible);
        return this;
    }

}
