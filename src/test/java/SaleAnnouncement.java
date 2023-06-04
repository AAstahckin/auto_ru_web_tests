import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AutoRuPage;
import pages.PostCarPage;
import pages.components.MarketingPopupComponents;

import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class SaleAnnouncement extends TestBase {

    @BeforeEach
    void forTest() {
        Selenide.clearBrowserCookies();
    }

    AutoRuPage autoRuPage = new AutoRuPage();
    PostCarPage postCarPage = new PostCarPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();

    @CsvFileSource(resources = "/brandAndModelTestData.csv")
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
                              String mouthSale) {
        String
                mileage = getRandomNumber(7),
                userName = getRandomFirstName(),
                email = getRandomEmail(),
                phone = getRandomNumber(10);


        open("/");
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
                .setPtsGuarantee()
                .setDescription()
                .setOptions()
                .setDamage()
                .checkContacts(userName, email, phone)
                .clickResetButton()
                .closeRedButton();
    }


}
