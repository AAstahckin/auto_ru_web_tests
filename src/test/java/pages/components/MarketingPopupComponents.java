package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;

public class MarketingPopupComponents {

    SelenideElement confirmButton = $("#confirm-button");

    @Step("Убираем рекламное окно")
    public void shutdownMarketingPopup() {
        if(confirmButton.isDisplayed()) {
            Allure.step("Закрываем окно соглашения");
            confirmButton.click();
            Allure.step("Убираем рекламное окно");
            Cookie cookiePopupsShownCount = new Cookie("popups-popup-pdd-spring-shown-count", "1");
            WebDriverRunner.getWebDriver().manage().addCookie(cookiePopupsShownCount);
        } else {
            Allure.step("Убираем рекламное окно");
            Cookie cookiePopupsShownCount = new Cookie("popups-popup-pdd-spring-shown-count", "1");
            WebDriverRunner.getWebDriver().manage().addCookie(cookiePopupsShownCount);
        }
    }

}
