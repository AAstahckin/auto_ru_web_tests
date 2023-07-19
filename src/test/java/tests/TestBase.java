package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.RemoteConfig;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.AddCarPage;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;
import pages.components.SaleCarPopupComponent;

import java.util.Map;

public class TestBase {

    AddCarPage addCarPage = new AddCarPage();
    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();
    SaleCarPopupComponent saleCarPopupComponent = new SaleCarPopupComponent();

    private static final WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static RemoteConfig remoteConfig = ConfigFactory.create(RemoteConfig.class, System.getProperties());


    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = webDriverConfig.baseUrl();
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();
        Configuration.timeout = 10000;

        if (remoteConfig.url() != null && remoteConfig.password() != null && remoteConfig.login() != null) {
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub", remoteConfig.login(), remoteConfig.password(), remoteConfig.url());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addBefore() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.clearBrowserCookies();
    }

    @AfterEach
    void addAfter() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (remoteConfig.url() != null && remoteConfig.password() != null && remoteConfig.login() != null) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }

}
