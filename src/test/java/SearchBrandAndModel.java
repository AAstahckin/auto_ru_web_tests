import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;

import static com.codeborne.selenide.Selenide.open;

@Tags({@Tag("regression"), @Tag("smoke")})
@DisplayName("Проверка поиска автомобиля по бренду и модели")
public class SearchBrandAndModel extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @ValueSource(strings = {
            "Toyota Highlander", "Toyota Avensis", "Kia Magentis", "Mitsubishi Lancer",
            "BMW X5", "Mercedes-Benz GL-Класс", "LADA (ВАЗ) 2121 (4x4)"
    })
    @ParameterizedTest(name = "Проверка поиска автомобиля {0} в поиске")
    void searchMarksAndBrand(String searchQuery) {
        open("https://auto.ru/");
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.searchAuto(searchQuery);
    }

}
