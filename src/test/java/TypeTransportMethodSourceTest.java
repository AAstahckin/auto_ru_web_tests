import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static data.TransportType.*;
import static data.TransportType.CARS;

public class TypeTransportMethodSourceTest extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    static Stream<Arguments> testTypeTransport() {
        return Stream.of(
                Arguments.of(
                        COMMERCIAL.getTypeName(), List.of(COMMERCIAL.getTypeValue())
                ),
                Arguments.of(
                        MOTO.getTypeName(), List.of(MOTO.getTypeValue())
                ),
                Arguments.of(
                        CARS.getTypeName(), List.of(CARS.getTypeValue())
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "При наведенеии в Header на элемент : \"{0}\" отображаются виды транспорта: {1}")
    @DisplayName("Тест отображения типа и вида транспорта")
    @Tags({@Tag("CRITICAL"), @Tag("DISPLAY"), @Tag("WEB")})
    void testTypeTransport(String brand, List<String> model) {
        open("https://auto.ru/");
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.checkTypeTransport(brand, model);
    }

}
