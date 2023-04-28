import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;

import static com.codeborne.selenide.Selenide.open;

public class SearchBrandAndModelSource extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @ValueSource(strings = {"Toyota Highlander", "Toyota Avensis", "Kia Magentis", "Mitsubishi Lancer"})
    @ParameterizedTest(name = "При поиске автомобиля по тексту : \"{0}\" в списке автомобилей отображается : \"{0}\"")
    @DisplayName("Проверка поиска автомобиля по бренду и модели")
    @Tags({@Tag("BLOCKER"), @Tag("SEARCH"), @Tag("WEB")})

    void searchMarksAndBrand(String searchQuery) {
        open("https://auto.ru/");
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.searchAuto(searchQuery);
    }

}
