import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.PostCarPage;
import pages.components.MarketingPopupComponents;

import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;
@DisplayName("Тест заполнения формы вручную")
@Tag("regression")
@Description("Тест заполнения формы вручную")
public class SaleAnnouncement extends TestBase {

    @BeforeEach
    void forTest() {
        Selenide.clearBrowserCookies();
    }

    AutoRuPage autoRuPage = new AutoRuPage();
    PostCarPage postCarPage = new PostCarPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @CsvFileSource(resources = "/testDataAutomobile.csv")
    @ParameterizedTest(name = "Заполнение объявления для марки {0}, модель {1}")
    void searchMarksAndBrand2(String brand,
                              String model,
                              String yearModel,
                              String engineType,
                              String gearType,
                              String transmission,
                              String horses,
                              String color,
                              String ptsType,
                              String owners,
                              String yearSale,
                              String mouthSale,
                              String guaranteeYear,
                              String guaranteeMouth) {

        String mileage = getRandomNumber(7);
        String userName = getRandomFirstName();
        String email = getRandomEmail();
        String phone = getRandomNumber(10);
        String descriptionParam = getRandomDescriptionParams();
        String damageType = getRandomDamageTypeParams();
        String damageValue = getRandomDamageValues();
        String options = getRandomOptionsParams();
        String descriptionText = getRandomText(100);

        open("");
        marketingPopupComponents.shutdownMarketingPopup();
        autoRuPage.clickAddButton();
        postCarPage
                .setCharacteristics(brand, model, yearModel, engineType, gearType, transmission, horses, color)
                .setMileage(mileage)
                .inputPhoto("src/test/resources/transport.jpg")
                .checkPts()
                .setPtsDocumentType(ptsType, owners)
                .setPtsYearPurchaseCar(yearSale,mouthSale)
                .setPtsNotCleared()
                .setPtsGuarantee(guaranteeYear, guaranteeMouth)
                .setDescription(descriptionText,descriptionParam)
                .setOptions(options)
                .setDamage(damageType, damageValue)
                .setContacts(userName, email, phone)
                .clickResetButton()
                .closeRedButton();
    }

}
