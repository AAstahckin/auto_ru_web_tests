package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import pages.components.DamageTypePtsComponents;
import pages.components.DocumentTypePtsComponents;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.enums.DescriptionFields.*;
import static data.enums.OptionsFields.OPTIONS_HEADER;
import static data.enums.OptionsParams.*;
import static data.enums.PtsFields.*;
import static data.enums.PtsTypeParams.*;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class AddCarPage {

    DocumentTypePtsComponents documentTypePtsComponents = new DocumentTypePtsComponents();
    DamageTypePtsComponents damageTypePtsComponents = new DamageTypePtsComponents();

    SelenideElement
            inputMarks = $(".TextInput__input .TextInput__box .TextInput__control"),
            markInputText = $(".OfferAccordionSectionTech__mark .TextInput__inputWrap input"),
            modelInputText = $(".OfferAccordionSectionTech__model .TextInput__inputWrap input"),
            markInputYear = $(".TechAccordionSectionHeader_section_year"),
            markInputBody = $(".TechAccordionSectionHeader_section_body_type "),
            markInputEngine = $(".TechAccordionSectionHeader_section_engine_type"),
            markInputGear = $(".TechAccordionSectionHeader_section_gear_type"),
            markInputTransmission = $(".TechAccordionSectionHeader_section_transmission"),
            markInputTechParam = $(".TechAccordionSectionHeader_section_tech_param"),
            markFieldIconSection = $(".MarkField__items"),
            modelListSection = $(".ModelField__list"),
            yearModelSection = $(".AccordionSectionBody__content .YearField"),
            engineTypeSection = $(".AccordionSectionBody__content .EngineTypeField"),
            gearTypeSection = $(".AccordionSectionBody__content .GearTypeField"),
            transmissionSection = $(".AccordionSectionBody__content .TransmissionField"),
            techParamSection = $(".AccordionSectionBody__content .TechParamField"),
            checkedMenuSectionTech = $("[data-testid=menu-section-tech]").$(".OfferAccordionContents__listItemCheckedIcon"),
            buttonBlue = $(".OfferWizardControls .Button_color_blue"),
            buttonGray = $(".OfferWizardControls .Button_color_gray"),
            buttonTransparentBlue = $(".OfferWizardControls .Button_color_transparentBlue"),
            mileageInput = $("#wizard-step-2").$(".TextInput__control"),
            checkedMenuSectionMileage = $("[data-testid=menu-section-mileage]").$(".OfferAccordionContents__listItemCheckedIcon"),
            checkedMenuSectionPhotos = $("[data-testid=menu-section-photos]").$(".OfferAccordionContents__listItemCheckedIcon"),
            checkedMenuSectionPts = $("[data-testid=menu-section-pts]").$(".OfferAccordionContents__listItemCheckedIcon"),
            checkedMenuDescription = $("[data-testid=menu-section-description]").$(".OfferAccordionContents__listItemCheckedIcon"),
            checkedMenuEquipment = $("[data-testid=menu-section-equipment]").$(".OfferAccordionContents__listItemCheckedIcon"),
            fileInput = $(".PhotosAdd__fileInput"),
            photoLoader = $(".MdsPhoto__loader"),
            invalidGrzContent = $(".InvalidGrz__content"),
            seventhStep = $("#wizard-step-7"),
            ptsStatusHeader = $(".OfferAccordionSectionBody .OfferFormPtsStatusField__header"),
            ptsDateHeader = $(".OfferAccordionSectionBody .OfferFormPurchaseDateField__header"),
            yearRadioSelection = $(".Menu_mode_radio"),
            descriptionHeader = $(".OfferWizardStep_current .OfferAccordionSectionHeader__title"),
            descriptionFieldWarning = $(".OfferWizardStep_current .OfferFormDescriptionField__warning"),
            autoRuExclusiveField = $(".OfferWizardStep_current .OfferFormAutoruExclusiveField__legend"),
            conditionBeatenField = $(".OfferWizardStep_current .OfferFormConditionBeatenField__legend"),
            inputDescription = $(".TextArea__control"),
            eighthStep = $("#wizard-step-8"),
            sectionOptionsEquipment = $("#section-equipment"),
            equipmentField = $(".OfferFormEquipmentField .Tags_properGaps"),
            allEquipment = $(".OfferFormEquipmentField__cut"),
            blockButtons = $(".OfferWizardControls__content"),
            tenthStep = $("#wizard-step-10"),
            eleventhStep = $("#wizard-step-11"),
            buttonSkip = $(".OfferWizardControls__content .OfferWizardControls__buttonText").$(byText("Пропустить")),
            buttonWithLoader = $(".OfferFormPhonesField__submitButton .ButtonWithLoader__content"),
            UserNameField = $(".OfferFormUserNameField__infoPopup .TextInput__inputWrap  .TextInput__control"),
            emailField = $(".OfferFormUserEmailField__infoPopup .TextInput__inputWrap  .TextInput__control"),
            phonesField = $(".OfferFormPhonesField__phoneAuth .TextInput__inputWrap  .TextInput__control"),
            withSubtitle = $(".OfferTechHeader__title_withSubtitle"),
            subtitle = $(".OfferTechHeader__subtitle"),
            inputVin = $(".OfferAccordionVin .TextInput__control"),
            buttonAccordionVin = $(".OfferAccordionVin .Button__content");

    ElementsCollection
            ptsTypeSelection = $$(".OfferFormPtsStatusField button");

    String dataId = "[data-id=%s]";

    @Step("Открываем страницу создания объявления")
    public AddCarPage openSaleCars() {
        open("cars/used/add/");
        return this;
    }

    @Step("Заполняем технический блок")
    public AddCarPage setCharacteristics(
            String brand,
            String model,
            String yearModel,
            String engineType,
            String gearType,
            String transmission,
            String horses,
            String color) {
        step("Вводим в поисковую строку " + brand, () ->
                inputMarks.setValue(brand));
        step("Выбираем из списка " + brand, () ->
                markFieldIconSection.shouldHave(visible, ofSeconds(5)).$(byText(brand)).hover().click());
        step("Выбираем из списка " + model, () ->
                modelListSection.shouldHave(visible, ofSeconds(5)).$(byText(model)).hover().click());
        step("Выбираем из списка год " + yearModel, () ->
                yearModelSection.$(byText(yearModel)).click());
        step("Выбираем двигатель " + engineType, () ->
                engineTypeSection.$(byText(engineType)).click());
        step("Выбираем привод " + gearType, () ->
                gearTypeSection.$(byText(gearType)).click());
        step("Выбираем каробку передач " + transmission, () ->
                transmissionSection.$(byText(transmission)).click());
        step("Выбираем модификацию " + horses, () ->
                techParamSection.$(byText(horses)).click());
        step("Выбираем цвет", () ->
                $(String.format(dataId, color)).click());
        checkedMenuSectionTech.shouldHave(visible);
        step("Нажимаем на кнопку продолжить", () ->
                buttonBlue.should(visible, ofSeconds(5)).hover().click());
        return this;
    }

    @Step("Заполняем пробег")
    public AddCarPage setMileage(String value) {
        buttonTransparentBlue.shouldHave(editable);
        step("Вводим в поле пробег " + value, () ->
                mileageInput.setValue(value));
        checkedMenuSectionMileage.shouldHave(visible);
        step("Нажимаем на кнопку продолжить", () ->
                buttonBlue.should(visible, ofSeconds(5)).hover().click());
        return this;
    }

    @Step("Добавляем фото")
    public AddCarPage inputPhoto(String pathFile) {
        File file = new File(pathFile);
        step("Загружаем файл " + file.getName(), () ->
                fileInput.uploadFile(file));
        photoLoader.shouldNotBe(visible);
        checkedMenuSectionPhotos.shouldHave(visible);
        step("Нажимаем на кнопку продолжить", () ->
                buttonBlue.should(visible, ofSeconds(5)).hover().click());
        return this;
    }

    @Step("Проверяем информационное сообщение в блоке файлы")
    public AddCarPage checkWarningTextPhoto() {
        step("Проверяем отображение текста о не распозновании номера", () ->
                invalidGrzContent.shouldHave(text("Мы не распознали госномер на фото. Проверьте, что он виден хотя бы на одном снимке, иначе объявление может быть заблокировано.")));
        return this;
    }

    @Step("Проверяем отображение блока ПТС")
    public AddCarPage checkPts() {
        seventhStep.should(visible, ofSeconds(3));
        buttonTransparentBlue.should(visible, ofSeconds(5));
        step("Проверяем отображение названия блока", () ->
                seventhStep.should(text(PTS_HEADER.getValue()), ofSeconds(3)));
        step("Проверяем отображение текста 'Тип документа'", () ->
                ptsStatusHeader.should(text(PTS_TYPE_DOCUMENT.getValue())));
        step("Проверяем отображение полей год и месяц", () ->
                ptsDateHeader.should(text(PTS_SALE_DATE.getValue())));
        step("Проверяем отображение кнопок с видом ПТС", () ->
                ptsTypeSelection.shouldHave(texts(ORIGINAL_PTS.getTypeValue(), DUPLICATE_PTS.getTypeValue(), NO_PTS.getTypeValue())));
        return this;
    }

    @Step("Заполняем тип ПТС и количество владельцев")
    public AddCarPage setPtsDocumentType(String documentType, String owner) {
        step("Выбираем " + documentType, () ->
                seventhStep.$(byText(documentType)).click());
        step("Выбираем " + owner, () ->
                documentTypePtsComponents.choiceDocumentTypePts(documentType, owner));
        checkedMenuSectionPts.shouldHave(visible);
        return this;
    }

    @Step("Заполняем в блоке ПТС год и месяц приобретения автомобиля")
    public AddCarPage setPtsYearPurchaseCar(String yearSale, String mouth) {
        step("Нажимаем на " + PTS_YEAR.getValue(), () ->
                seventhStep.$(byText(PTS_YEAR.getValue())).click());
        step("Заполняем год  " + yearSale, () ->
                yearRadioSelection.$(byText(yearSale)).click());
        step("Нажимаем на " + PTS_MONTH.getValue(), () ->
                seventhStep.$(byText(PTS_MONTH.getValue())).click());
        step("Заполняем месяц  " + mouth, () ->
                yearRadioSelection.$(byText(mouth)).click());
        return this;
    }

    @Step("Проставляем чекбокс 'Не растаможен'")
    public AddCarPage setPtsNotCleared() {
        step("Нажимаем на " + PTS_NOT_CLEARED.getValue(), () ->
                seventhStep.$(byText(PTS_NOT_CLEARED.getValue())).click());
        return this;
    }

    @Step("Заполняем ПТС блок 'Гарантия'")
    public AddCarPage setPtsGuarantee(String year, String mouth) {
        step("Нажимаем на " + PTS_GUARANTEE.getValue(), () ->
                seventhStep.$(byText(PTS_GUARANTEE.getValue())).click());
        step("Нажимаем на " + PTS_GUARANTEE_YEAR_OF_ENDING.getValue(), () ->
                seventhStep.$(byText(PTS_GUARANTEE_YEAR_OF_ENDING.getValue())).click());
        step("Заполняем год  " + year, () ->
                yearRadioSelection.$(byText(year)).click());
        step("Нажимаем на " + PTS_GUARANTEE_END_MONTH.getValue(), () ->
                seventhStep.$(byText(PTS_GUARANTEE_END_MONTH.getValue())).click());
        step("Заполняем год  " + mouth, () ->
                yearRadioSelection.$(byText(mouth)).click());
        step("Нажимаем на кнопку продолжить", () ->
                buttonBlue.should(visible, ofSeconds(5)).hover().click());
        return this;
    }

    @Step("Заполняем 'Описание'")
    public AddCarPage setDescription(String valeText, String valueDescriptionParams) {
        Allure.step("Проверяем отображение полей");
        descriptionHeader.shouldHave(text(DESCRIPTION_HEADER.getTypeValue()));
        descriptionFieldWarning.shouldHave(text(DESCRIPTION_WARNING.getTypeValue()));
        autoRuExclusiveField.shouldHave(text(DESCRIPTION_ONLY_ON_AUTO.getTypeValue()));
        conditionBeatenField.shouldHave(text(DESCRIPTION_BEATEN.getTypeValue()));
        buttonGray.should(editable, ofSeconds(5));
        inputDescription.click();
        step("Вводим текст в поле " + valeText, () ->
                inputDescription.setValue(valeText));
        step("Выбираем параметр " + valueDescriptionParams + " из списка ", () ->
                eighthStep.$(byText(valueDescriptionParams)).hover().click());
        checkedMenuDescription.shouldHave(visible);
        step("Нажимаем на кнопку продолжить", () -> buttonBlue.should(visible, ofSeconds(5)).hover().click());
        return this;
    }

    @Step("Заполняем 'Опции'")
    public AddCarPage setOptions(String option) {
        Allure.step("Проверяем отображение полей");
        sectionOptionsEquipment.shouldHave(text(OPTIONS_HEADER.getTypeValue()));
        equipmentField.shouldHave(text(OPTIONS_FOG_LIGHTS.getTypeValue()));
        equipmentField.shouldHave(text(OPTIONS_BOARD_COMPUTER.getTypeValue()));
        equipmentField.shouldHave(text(OPTIONS_CENTRAL_LOCKING.getTypeValue()));
        equipmentField.shouldHave(text(OPTIONS_IMMOBILIZER.getTypeValue()));
        allEquipment.should(visible, ofSeconds(5));
        blockButtons.should(visible, ofSeconds(5));
        step("Выбираем оцию " + option, () ->
                sectionOptionsEquipment.$(byText(option)).click());
        buttonSkip.shouldNotBe(visible);
        checkedMenuEquipment.shouldHave(visible);
        step("Нажимаем на кнопку продолжить", () ->
                buttonBlue.should(visible, ofSeconds(5)).hover().click());
        return this;
    }

    @Step("Заполняем 'Повреждения'")
    public AddCarPage setDamage(String damageType, String damageValue) {
        tenthStep.should(text("Повреждения"), ofSeconds(5));
        damageTypePtsComponents.clickDamageType(damageType, damageValue);
        step("Нажимаем на кнопку продолжить", () ->
                buttonBlue.should(visible, ofSeconds(5)).hover().click());
        return this;
    }

    @Step("Заполняем 'Контакты'")
    public AddCarPage setContacts(String userName, String email, String phone) {
        eleventhStep.shouldHave(text("Контакты"));
        $(buttonWithLoader).shouldHave(visible);
        step("Заполняем " + userName, () ->
                UserNameField.setValue(userName));
        step("Заполняем " + email, () ->
                emailField.setValue(email));
        step("Заполняем " + phone, () ->
                phonesField.setValue(phone));
        return this;
    }

    @Step("Выполняем поиск по VIN")
    public AddCarPage searchVin(String vin, String brand) {
        step("Заполняем в поле поиска " + brand, () ->
                inputMarks.should(visible, ofSeconds(8)).setValue(brand));
        step("Выбираем " + brand, () ->
                markFieldIconSection.$(byText(brand)).click());
        step("Вводим " + vin, () ->
                inputVin.setValue(vin));
        step("Нажимаем заполнить", () ->
                buttonAccordionVin.click());
        return this;
    }

    @Step("Проверяем автоматическое заполнение полей по VIN")
    public AddCarPage checkTexParam(
            String brand,
            String model,
            String yearAuto,
            String body,
            String engine,
            String drive,
            String transmission,
            String modification) {
        step("Проверяем что в шапке присутствует " + brand, () ->
                withSubtitle.shouldHave(text(brand)));
        step("Проверяем что в шапке присутствует " + yearAuto, () ->
                subtitle.shouldHave(text(yearAuto)));
        step("Проверяем что в шапке присутствует " + body, () ->
                subtitle.shouldHave(text(body)));
        step("Проверяем что в шапке присутствует " + modification, () ->
                subtitle.shouldHave(text(modification)));
        Allure.step("Проверяем блок Характеристики");
        markInputText.shouldHave(attribute("value", brand));
        modelInputText.shouldHave(attribute("value", model));
        markInputYear.shouldHave(text(yearAuto));
        markInputBody.shouldHave(text(body));
        markInputEngine.shouldHave(text(engine));
        markInputGear.shouldHave(text(drive));
        markInputTransmission.shouldHave(text(transmission));
        markInputTechParam.shouldHave(text(modification));
        return this;
    }

}
