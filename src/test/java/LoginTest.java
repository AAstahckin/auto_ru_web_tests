import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AutoRuPage;
import pages.LoginPage;
import pages.components.MarketingPopupComponents;

@Story("Авторизация")
@DisplayName("Авторизация")
@Owner("Aleksey_Astashkin")
public class LoginTest extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    LoginPage loginPage = new LoginPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @Test
    @DisplayName("Авторизация")
    @Description("Проверка отображения страницы авторизации")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLoginTest() {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        loginPage
                .clickButtonLogin()
                .checkWindowLogin();
    }

}
