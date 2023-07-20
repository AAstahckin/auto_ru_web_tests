package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.ReportsPage;

import static data.enums.ReportsFields.REPORT_TITTLE;
import static data.enums.ReportsFields.REPORT_VIN_TITTLE;

@Story("Вкладка Отчеты")
@DisplayName("Проверка отчета")
@Owner("Aleksey_Astashkin")
public class ReportsTests extends TestBase {

    ReportsPage reportsPage = new ReportsPage();

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка отображения элементов")
    @Description("Проверка отображения элементов на странице")
    public void checkLoginTest() {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.clickHeaderReports();
        reportsPage.checkWindowReports(REPORT_TITTLE.getValue(), REPORT_VIN_TITTLE.getValue());

    }

    @CsvFileSource(resources = "/testdata/testDataVinCodeAndTexParam.csv")
    @DisplayName("Проверка отчета по vin")
    @Description("Проверка отчета")
    @ParameterizedTest(name = "[{0}], бренд [{1}], модель [{2}]")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("sanity")
    public void checkLoginTest1(String vin, String brand, String model, String year) {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.clickHeaderReports();
        marketingPopupComponents.shutdownMarketingPopup();
        reportsPage
                .vinSetValue(vin)
                .checkReportVin(vin, brand, model, year);
    }

}
