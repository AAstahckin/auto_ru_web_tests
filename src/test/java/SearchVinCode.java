import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.PostCarPage;
import pages.components.MarketingPopupComponents;

@DisplayName("Тест автоматического заполнения формы по VIN коду")
@Description("Тест автоматического заполнения формы по VIN коду")
public class SearchVinCode extends TestBase {

    @BeforeEach
    void forTest() {
        Selenide.clearBrowserCookies();
    }

    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();
    AutoRuPage autoRuPage = new AutoRuPage();
    PostCarPage postCarPage = new PostCarPage();

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
