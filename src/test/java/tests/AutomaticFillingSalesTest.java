package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Story("Заполнение объявления по VIN")
@DisplayName("Автоматическое заполнение формы")
@Owner("Aleksey_Astashkin")
public class AutomaticFillingSalesTest extends TestBase {

    @Tag("sanity")
    @DisplayName("Автоматическое заполнение формы")
    @Severity(SeverityLevel.BLOCKER)
    @CsvFileSource(resources = "/testdata/testDataVinCodeAndTexParam.csv")
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

        addCarPage.openSaleCars();
        marketingPopupComponents.shutdownMarketingPopup();
        saleCarPopupComponent.shutdownMarketingPopup();
        addCarPage
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
