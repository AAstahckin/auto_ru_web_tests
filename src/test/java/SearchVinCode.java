import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.PostCarPage;
import pages.components.MarketingPopupComponents;

import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

@DisplayName("Тест автоматического заполнения формы по VIN коду")
@Tag("regression")
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

        open("/");
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
