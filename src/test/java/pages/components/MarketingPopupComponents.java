package pages.components;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

public class MarketingPopupComponents {

    public void shutdownMarketingPopup() {
        Cookie cookiePopupsShownCount = new Cookie("popups-popup-pdd-spring-shown-count", "1");
        WebDriverRunner.getWebDriver().manage().addCookie(cookiePopupsShownCount);
    }

}
