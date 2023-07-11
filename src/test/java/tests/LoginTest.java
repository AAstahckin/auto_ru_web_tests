package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@Story("Авторизация")
@DisplayName("Авторизация")
@Owner("Aleksey_Astashkin")
public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Проверка отображения страницы авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("sanity")
    public void checkLoginTest() {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        loginPage
                .clickButtonLogin()
                .checkWindowLogin();
    }

}
