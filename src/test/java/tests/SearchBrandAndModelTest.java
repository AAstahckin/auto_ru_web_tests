package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("smoke")
@Story("Поиск автомобиля")
@DisplayName("Поиск автомобиля по бренду и модели")
public class SearchBrandAndModelTest extends TestBase {

    @ValueSource(strings = {
            "Toyota Highlander", "Toyota Avensis", "Kia Magentis", "Mitsubishi Lancer",
            "BMW X5", "Mercedes-Benz GL-Класс", "LADA (ВАЗ) 2121 (4x4)"
    })
    @DisplayName("Поиск автомобиля")
    @ParameterizedTest(name = "[{0}]")
    void searchMarksAndBrand(String searchQuery) {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage
                .searchAuto(searchQuery)
                .checkResultSearch(searchQuery);
    }

}
