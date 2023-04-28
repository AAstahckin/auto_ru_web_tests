import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;
import static com.codeborne.selenide.Selenide.open;

public class SearchModelCsvFileTest extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @CsvFileSource(resources = "/brandAndModelTestData.csv")
    @ParameterizedTest(name = "Для бренда \"{0}\" найдена \"{1}\" в списке моделей")
    @DisplayName("Тест для поиска модели по марки автомобиля")
    @Tags({@Tag("CRITICAL"), @Tag("SEARCH"), @Tag("WEB")})
    void searchMarksAndBrand(String brand, String model) {
        open("https://auto.ru/");
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage
                .clickBrandAuto(brand)
                .checkTitleModel(brand, model);
    }
}
