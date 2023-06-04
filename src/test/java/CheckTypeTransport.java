import data.enums.TransportType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;

public class CheckTypeTransport extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @EnumSource(value = TransportType.class, names = {"COMMERCIAL", "MOTO", "CARS"})
    @ParameterizedTest(name = "При наведенеии в Header на элемент : {0} отображаются виды транспорта")
    @DisplayName("Тест для поиска модели по марки автомобиля")
    void searchMarksAndBrand(TransportType transportType) {
        open("/");
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.checkTypeTransport(transportType.getTypeName(), List.of(transportType.getTypeValue()));
    }

}
