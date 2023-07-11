package tests;

import data.enums.TransportType;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.AutoRuPage;
import pages.components.MarketingPopupComponents;
import java.util.List;

@Story("Виды транспорта на главной странице")
@DisplayName("Проверка отображения видов транспорта на главной странице")
@Owner("Aleksey_Astashkin")
public class SearchTypeTransportTest extends TestBase {

    @DisplayName("Отображение видов транспорта")
    @EnumSource(value = TransportType.class)
    @ParameterizedTest(name = ": {0}")
    @Severity(SeverityLevel.TRIVIAL)
    void searchMarksAndBrand(TransportType transportType) {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.checkTypeTransport(transportType.getTypeName(), List.of(transportType.getTypeValue()));
    }

}
