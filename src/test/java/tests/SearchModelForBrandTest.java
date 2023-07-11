package tests;

import data.enums.BrandAndMarks;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

@Story("Отображение моделей при поиске по бренду")
@DisplayName("Тест поиска моделей по бренду")
@Owner("Aleksey_Astashkin")
public class SearchModelForBrandTest extends TestBase {

    @EnumSource(value = BrandAndMarks.class)
    @DisplayName("Проверка отображения моделей для бренда")
    @ParameterizedTest(name = ": [{0}]")
    @Severity(SeverityLevel.TRIVIAL)
    void searchMarksAndBrand(BrandAndMarks brandAndMarks) {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage
                .clickBrandAuto(brandAndMarks.getTypeName())
                .checkTitleModel(brandAndMarks.getTypeName(), List.of(brandAndMarks.getTypeValue()));
    }

}
