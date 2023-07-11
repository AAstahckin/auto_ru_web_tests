package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class AutoRuPage {

    SelenideElement
            marksIndexSelector = $(".IndexSelector__marks"),
            titleHead = $(".ListingHead__title"),
            regionIndicators = $(".TopNavigationIndicators__item"),
            selectedBrand = $(".MMMFilter__itemColumn .Button__text"),
            selectedBrandAndModelValue = $(".MMMMultiFilter__row"),
            searchInput = $(".TextInput__control"),
            searchOutputTitle = $(".SearchLineSuggestItem__title"),
            addButton = $(".HeaderUserMenu__addButton"),
            headerMainNav = $("[data-id=history]"),
            mainHeader = $(".HeaderMainNav_theme_default");

    ElementsCollection
            listingCars = $$(".ListingCars_outputType_list div h3"),
            itemTransport = $$(".HeaderMainNav__subLinks li"),
            imageMark = $$(".IndexSuperMark__image"),
            listModelsAuto = $$(".ListingPopularMMM__items div a");

    @Step("Открываем auto.ru")
    public AutoRuPage openAutoRu() {
        open("");
        return this;
    }

    @Step("Нажимаем на меню Отчеты")
    public AutoRuPage clickHeaderReports() {
        headerMainNav.shouldHave(visible, ofSeconds(5)).click();
        return this;
    }

    @Step("Нажимаем на бренд {brand}")
    public AutoRuPage clickBrandAuto(String brand) {
        imageMark.get(9).shouldHave(visible, ofSeconds(15));
        marksIndexSelector
                .$(byText(brand))
                .shouldHave(visible, ofSeconds(8))
                .click();
        return this;
    }

    @Step("Проверка списка автомобилей по бренду")
    public AutoRuPage checkTitleModel(String brand, List<String> model) {
        step("Проверяем что в строке поиска присутствет выбранный бренд "  + brand, () ->
                selectedBrand.shouldHave(text(brand), ofSeconds(5)));
        step("Проверяем что названии поиска присутствует: Купить - ", () ->
                titleHead.shouldHave(text("Купить " + brand)));
        step("Проверяем что в списке присутствуют автомобили", () ->
                listModelsAuto.shouldHave(texts(model)));
        return this;
    }

    @Step("Проверка типа транспорта на главной странице")
    public AutoRuPage checkTypeTransport(String type, List<String> model) {
        regionIndicators.shouldHave(visible);
        mainHeader.shouldHave(visible);
        step("Наводим мышку на " + type, () ->
                mainHeader.$(byText(type)).hover());
        step("Проверяем список транспорта", () ->
                itemTransport.shouldHave(texts(model)));
        return this;
    }

    @Step("Проверка поиска автомобиля в поисковой строке")
    public AutoRuPage searchAuto(String value) {
        regionIndicators.shouldHave(visible);
        step("Вводим в поле поиска " + value, () ->
                searchInput.setValue(value));
        step("В выпадающем окне нажимаем на бренд с моделью", () ->
                searchOutputTitle.shouldHave(text(value)).click());
        step("Проверяем что названии поиска присутствует: Купить - ", () ->
                titleHead.shouldHave(text("Купить " + value)));
        step("Проверяем что в фильтре выбран бренд и модель", () ->
                selectedBrandAndModelValue.shouldHave(text(value)));
        step("Проверяем что в результатах поиска присутствует бренд и модель", () ->
                listingCars.findBy(text(value)).should(text(value)));
        return this;
    }

}
