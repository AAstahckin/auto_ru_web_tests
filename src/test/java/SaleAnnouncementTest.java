import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.PostCarPage;
import pages.components.MarketingPopupComponents;
import pages.components.SaleCarPopupComponent;

import static utils.RandomUtils.*;

@Story("Заполнение формы о продаже авто")
@DisplayName("Ручное заполнение формы")
@Owner("Aleksey_Astashkin")
public class SaleAnnouncementTest extends TestBase {

    PostCarPage postCarPage = new PostCarPage();
    MarketingPopupComponents marketingPopupComponents = new MarketingPopupComponents();
    SaleCarPopupComponent saleCarPopupComponent = new SaleCarPopupComponent();

    @DisplayName("Ручное заполнение формы")
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

        postCarPage.openSaleCars();
        marketingPopupComponents.shutdownMarketingPopup();
        saleCarPopupComponent.shutdownMarketingPopup();
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
                .setContacts(userName, email, phone);
    }

}