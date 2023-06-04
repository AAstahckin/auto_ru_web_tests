package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
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
            searchInput = $(".TextInput__control"),
            searchOutputTitle = $(".SearchLineSuggestItem__title"),
            addButton = $(".HeaderUserMenu__addButton"),
            allListModel = $(".ListingPopularMMM__expandLink"),
            inputMarks = $(".TextInput__input .TextInput__box .TextInput__control"),
            mainHeader = $(".HeaderMainNav_theme_default");

    ElementsCollection
            listingCars = $$(".ListingCars_outputType_list div h3"),
            itemTransport = $$(".HeaderMainNav__subLinks li"),
            listModelsAuto = $$(".ListingPopularMMM__items div a");

    public AutoRuPage clickAddButton() {
        addButton.click();
//        webdriver().shouldHave(url("https://auto.ru/cars/used/add/"));
//        inputMarks.setValue("BMW");
//        $(".MarkField__items").$(byText("BMW")).click();
//        $(".ModelField__list").$(byText("1 серии")).click();
//        $(".AccordionSectionBody__content .YearField").$(byText("2023")).click();
//        $(".AccordionSectionBody__content .EngineTypeField").$(byText("Бензин")).click();
//        $(".AccordionSectionBody__content .GearTypeField").$(byText("Передний")).click();
//        $(".AccordionSectionBody__content .TransmissionField").$(byText("Механика")).click();
//        $(".AccordionSectionBody__content .TechParamField").$(byText("136 л.с.")).click();
//        $("[data-id=CACECB]").click();
//        $("[data-testid=menu-section-tech]").$(".OfferAccordionContents__listItemCheckedIcon").shouldHave(visible);
//        $(".OfferWizardControls .Button_color_blue").click();
//
//
//
//        $(".OfferWizardControls .Button_color_transparentBlue ").shouldHave(editable);
//        $("#wizard-step-2").$(".TextInput__control").setValue("123123123");
//        $("[data-testid=menu-section-mileage]").$(".OfferAccordionContents__listItemCheckedIcon").shouldHave(visible);
//        $(".OfferWizardControls .Button_color_blue").should(visible, ofSeconds(5)).click();
//
//
//        File file = new File("src/test/resources/transport.jpg");
//        $(".PhotosAdd__fileInput").uploadFile(file);
//        $(".MdsPhoto__loader").shouldNotBe(visible);
//        $("[data-testid=menu-section-photos]").$(".OfferAccordionContents__listItemCheckedIcon").shouldHave(visible);
//        $(".OfferWizardControls .Button_color_blue").click();
//        $(".InvalidGrz__content").shouldHave(text("Мы не распознали госномер на фото. Проверьте, что он виден хотя бы на одном снимке, иначе объявление может быть заблокировано."));
//
//
//        $("#wizard-step-7").should(visible, ofSeconds(3));
//        $(".OfferWizardControls .Button_color_transparentBlue").should(visible, ofSeconds(5));
//        $("#wizard-step-7").should(text("ПТС"), ofSeconds(3));
//        $("#wizard-step-7").$(byText("Оригинал / Электронный ПТС")).click();
//        $("#wizard-step-7").$(byText("Первый")).click();
//        $("#wizard-step-7").$(byText("Год")).click();
//        $(".Menu_mode_radio").$(byText("2023")).click();
//        $("#wizard-step-7").$(byText("Месяц")).click();
//        $(".Menu_mode_radio").$(byText("Январь")).click();
//        $("#wizard-step-7").$(byText("Не растаможен")).click();
//        $("#wizard-step-7").$(byText("На гарантии")).click();
//        $("#wizard-step-7").$(byText("Год окончания")).click();
//        $(".Menu_mode_radio").$(byText("2028")).click();
//        $("#wizard-step-7").$(byText("Месяц")).click();
//        $(".Menu_mode_radio").$(byText("Январь")).click();
//        $("[data-testid=menu-section-pts]").$(".OfferAccordionContents__listItemCheckedIcon").shouldHave(visible);
//        $(".OfferWizardControls .Button_color_blue").click();
//
//        $(".OfferWizardControls .Button_color_gray ").should(editable, ofSeconds(5));
//        $(".TextArea__control").click();
//        $(".TextArea__control").setValue("123");
//        $("#wizard-step-8").$(byText("Своевременное обслуживание")).hover().click();
//        $("#wizard-step-8").$(byText("Не участвовала в ДТП")).hover().click();
//        $("[data-testid=menu-section-description]").$(".OfferAccordionContents__listItemCheckedIcon").shouldHave(visible);
//        $(".OfferWizardControls .Button_color_blue").should(visible, ofSeconds(5)).hover().click();
//
//        $("#section-equipment").shouldHave(text("Опции"));
//        $(".OfferFormEquipmentField__cut").should(visible, ofSeconds(5));
//        $("#section-equipment").$(byText("Центральный замок")).click();
//        $("#section-equipment").$(byText("Бортовой компьютер")).click();
//        $("[data-testid=menu-section-equipment]").$(".OfferAccordionContents__listItemCheckedIcon").shouldHave(visible);
//        $(".OfferWizardControls .Button_color_blue").hover().click();
//
//        $("#wizard-step-10").should(text("Повреждения"), ofSeconds(5));
//        $(".VehicleBodyDamagesSchemeFrame__scheme div").should(visible);
//        $$(".OfferFormDamagesField__bodyDamagesWrapper .VehicleBodyDamagesSchemeFrame__scheme div").get(5).hover().click();
//        $(".DamagePopup").$(byText("Окрашено")).hover().click();
//        $(".DamagePopup").$(byText("Сохранить")).hover().click();
//        $(".OfferWizardControls .Button_color_blue").hover().click();
//
//        $("#wizard-step-11").shouldHave(text("Контакты"));
//        $(".OfferFormPhonesField__submitButton .ButtonWithLoader__content").shouldHave(visible);
//

        return this;
    }

    public AutoRuPage clickBrandAuto(String brand) {
        marksIndexSelector.$(byText(brand)).click();
        return this;
    }

    public AutoRuPage checkTitleModel(String brand, List<String> model) {
        selectedBrand.shouldHave(text(brand));
        titleHead.shouldHave(text("Купить " + brand));
        allListModel.click();
        listModelsAuto.shouldHave(texts(model));
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
