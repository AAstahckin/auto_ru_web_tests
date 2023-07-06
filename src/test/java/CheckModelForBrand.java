import data.enums.BrandAndMarks;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;
import java.util.List;

@DisplayName("Тест поиска моделей автомобиля по бренду")
@Tag("smoke")
@Description("Тест поиска моделей автомобиля по бренду")
public class CheckModelForBrand extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @EnumSource(value = BrandAndMarks.class)
    @ParameterizedTest(name = "Для бренда {0} в списке присутствуют модели авто")
    void searchMarksAndBrand(BrandAndMarks brandAndMarks) {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage
                .clickBrandAuto(brandAndMarks.getTypeName())
                .checkTitleModel(brandAndMarks.getTypeName(), List.of(brandAndMarks.getTypeValue()));
    }

}
