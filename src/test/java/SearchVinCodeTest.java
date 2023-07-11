import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.PostCarPage;
import pages.components.MarketingPopupComponents;
import pages.components.SaleCarPopupComponent;

@Story("Заполнение объявления по VIN")
@DisplayName("Автоматическое заполнение формы")
@Owner("Aleksey_Astashkin")
public class SearchVinCodeTest extends TestBase {

    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();
    SaleCarPopupComponent saleCarPopupComponent = new SaleCarPopupComponent();
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

        postCarPage.openSaleCars();
        marketingPopupComponents.shutdownMarketingPopup();
        saleCarPopupComponent.shutdownMarketingPopup();
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
                        modification);
   }

}
