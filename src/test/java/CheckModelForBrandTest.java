import data.enums.BrandAndMarks;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;
import java.util.List;


@Tag("smoke")
@Story("Отображение моделей при поиске по бренду")
@DisplayName("Тест поиска моделей автомобилей по бренду")
public class CheckModelForBrandTest extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @EnumSource(value = BrandAndMarks.class)
    @DisplayName("Проверка отображения моделей")
    @ParameterizedTest(name = "{0}")
    @Severity(SeverityLevel.TRIVIAL)
    void searchMarksAndBrand(BrandAndMarks brandAndMarks) {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage
                .clickBrandAuto(brandAndMarks.getTypeName())
                .checkTitleModel(brandAndMarks.getTypeName(), List.of(brandAndMarks.getTypeValue()));
    }

}
