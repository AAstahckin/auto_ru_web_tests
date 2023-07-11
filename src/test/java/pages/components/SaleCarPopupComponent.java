package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;

public class SaleCarPopupComponent {

    SelenideElement offerInitialScreenCar = $(".OfferInitialScreenCarInfo__handMadeButton-DP9Gg");

    @Step("Убираем всплывающее окно о продаже авто")
    public void shutdownMarketingPopup() {
        if (offerInitialScreenCar.isDisplayed()) {
            offerInitialScreenCar.hover().click();
        }
    }
}
