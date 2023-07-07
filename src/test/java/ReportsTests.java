import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.ReportsPage;
import pages.components.MarketingPopupComponents;

@Story("Вкладка Отчеты")
@DisplayName("Проверка отчета")
@Owner("Aleksey_Astashkin")
public class ReportsTests extends TestBase {

    AutoRuPage autoRuPage = new AutoRuPage();
    ReportsPage reportsPage = new ReportsPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка отображения элементов")
    @Description("Проверка отображения элементов на странице")
    public void checkLoginTest() {
        autoRuPage.openAutoRu();
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.clickHeaderReports();
        reportsPage.checkWindowReports();

    }

    @CsvFileSource(resources = "/testDataVinCodeAndTexParam.csv")
    @DisplayName("Проверка отчета по vin")
    @Description("Проверка отчета")
    @ParameterizedTest(name = "по vin [{0}], бренд [{1}], модель [{2}]")
    @Severity(SeverityLevel.BLOCKER)
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
