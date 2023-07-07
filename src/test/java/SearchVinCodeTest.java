import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.PostCarPage;
import pages.components.MarketingPopupComponents;

@Story("Заполнение объявления по VIN")
@DisplayName("Автоматическое заполнение формы")
@Owner("Aleksey_Astashkin")
public class SearchVinCodeTest extends TestBase {

    @BeforeEach
    void forTest() {
        Selenide.clearBrowserCookies();
    }

    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();
    AutoRuPage autoRuPage = new AutoRuPage();
    PostCarPage postCarPage = new PostCarPage();

    @DisplayName("Автоматическое заполнение формы")
    @Severity(SeverityLevel.BLOCKER)
    @CsvFileSource(resources = "/testDataVinCodeAndTexParam.csv")
    @ParameterizedTest(name = "Заполнение объявления по VIN {0}, модель {1}")
    void searchMarksAndBrand2(
            String vin,
            String brand,
            String model,
            String yearAuto,
            String body,
            String engine,
            String drive,
            String transmission,
            String modification) {

        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.clickAddButton();
        postCarPage
                .searchVin(vin, brand)
                .checkTexParam(
                        brand,
                        model,
                        yearAuto,
                        body,
                        engine,
                        drive,
                        transmission,
                        modification)
                .clickResetButton();
   }

}
