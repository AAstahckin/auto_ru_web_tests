package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoRuPage {

    SelenideElement
            marksIndexSelector = $(".IndexSelector__marks"),
            titleHead = $(".ListingHead__title"),
            regionIndicators = $(".TopNavigationIndicators__item"),
            selectedBrand = $(".MMMFilter__itemColumn .Button__text"),
            selectedBrandAndModelValue = $(".MMMMultiFilter__row"),
            listModelsAuto = $("#popularMMM"),
            searchInput = $(".TextInput__control"),
            searchOutputTitle = $(".SearchLineSuggestItem__title"),
            mainHeader = $(".HeaderMainNav_theme_default");

    ElementsCollection
            listingCars = $$(".ListingCars_outputType_list div h3"),
            itemTransport = $$(".HeaderMainNav__subLinks li");

    public AutoRuPage clickBrandAuto(String brand) {
        marksIndexSelector.$(byText(brand)).click();
        return this;
    }

    public AutoRuPage checkTitleModel(String brand, String model) {
        selectedBrand.shouldHave(text(brand));
        titleHead.shouldHave(text("Купить " + brand));
        listModelsAuto.shouldHave(text(model));
        return this;
    }

    public AutoRuPage checkTypeTransport(String type, List<String> model) {
        regionIndicators.shouldHave(visible);
        mainHeader.shouldHave(visible);
        mainHeader.$(byText(type)).hover();
        itemTransport.shouldHave(texts(model));
        return this;
    }

    public AutoRuPage searchAuto(String value) {
        regionIndicators.shouldHave(visible);
        searchInput.setValue(value);
        searchOutputTitle.shouldHave(text(value)).click();
        titleHead.shouldHave(text("Купить " + value));
        selectedBrandAndModelValue.shouldHave(text(value));
        listingCars.findBy(text(value)).should(text(value));
        return this;
    }

}
