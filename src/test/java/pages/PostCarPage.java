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
import static java.time.Duration.ofSeconds;

public class PostCarPage {

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
            resetButton = $(".OfferAccordionContents__resetButton"),
            UserNameField = $(".OfferFormUserNameField__infoPopup .TextInput__inputWrap  .TextInput__control"),
            emailField = $(".OfferFormUserEmailField__infoPopup .TextInput__inputWrap  .TextInput__control"),
            phonesField = $(".OfferFormPhonesField__phoneAuth .TextInput__inputWrap  .TextInput__control"),
            withSubtitle = $(".OfferTechHeader__title_withSubtitle"),
            subtitle = $(".OfferTechHeader__subtitle"),
            inputVin = $(".OfferAccordionVin .TextInput__control"),
            buttonAccordionVin = $(".OfferAccordionVin .Button__content"),
            closeRedButton = $(".Link_color_red");

    ElementsCollection
            ptsTypeSelection = $$(".OfferFormPtsStatusField button");
    String dataId = "[data-id=%s]";

    @Step("Заполняем технический блок")
    public PostCarPage setCharacteristics(
            String brand,
            String model,
            String yearModel,
            String engineType,
            String gearType,
            String transmission,
            String horses,
            String color) {
        Allure.step("Вводим в поисковую строку " + brand);
        inputMarks.setValue(brand);
        Allure.step("Выбираем из списка " + brand);
        markFieldIconSection.$(byText(brand)).click();
        Allure.step("Выбираем из списка " + model);
        modelListSection.$(byText(model)).click();
        Allure.step("Выбираем из списка год " + yearModel);
        yearModelSection.$(byText(yearModel)).click();
        Allure.step("Выбираем двигатель " + engineType);
        engineTypeSection.$(byText(engineType)).click();
        Allure.step("Выбираем привод " + gearType);
        gearTypeSection.$(byText(gearType)).click();
        Allure.step("Выбираем каробку передач " + transmission);
        transmissionSection.$(byText(transmission)).click();
        Allure.step("Выбираем модификацию " + horses);
        techParamSection.$(byText(horses)).click();
        Allure.step("Выбираем цвет " + color);
        $(String.format(dataId, color)).click();
        checkedMenuSectionTech.shouldHave(visible);
        Allure.step("Нажимаем на кнопку продолжить");
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    @Step("Заполняем пробег")
    public PostCarPage setMileage(String value) {
        buttonTransparentBlue.shouldHave(editable);
        Allure.step("Вводим в поле пробег " + value);
        mileageInput.setValue(value);
        checkedMenuSectionMileage.shouldHave(visible);
        Allure.step("Нажимаем на кнопку продолжить");
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    @Step("Добавляем фото")
    public PostCarPage inputPhoto(String pathFile) {
        File file = new File(pathFile);
        fileInput.uploadFile(file);
        photoLoader.shouldNotBe(visible);
        checkedMenuSectionPhotos.shouldHave(visible);
        Allure.step("Нажимаем на кнопку продолжить");
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        Allure.step("Проверяем отображение текста о не распозновании номера");
        invalidGrzContent.shouldHave(text("Мы не распознали госномер на фото. Проверьте, что он виден хотя бы на одном снимке, иначе объявление может быть заблокировано."));
        return this;
    }

    @Step("Проверяем отображение блока ПТС")
    public PostCarPage checkPts() {
        seventhStep.should(visible, ofSeconds(3));
        buttonTransparentBlue.should(visible, ofSeconds(5));
        Allure.step("Проверяем отображение названия блока");
        seventhStep.should(text(PTS_HEADER.getField()), ofSeconds(3));
        Allure.step("Проверяем отображение текста 'Тип документа'");
        ptsStatusHeader.should(text(PTS_TYPE_DOCUMENT.getField()));
        Allure.step("Проверяем отображение полей год и месяц");
        ptsDateHeader.should(text(PTS_SALE_DATE.getField()));
        Allure.step("Проверяем отображение кнопок с видом ПТС");
        ptsTypeSelection.shouldHave(texts(ORIGINAL_PTS.getValue(), DUPLICATE_PTS.getValue(), NO_PTS.getValue()));
        return this;
    }

    @Step("Заполняем тип ПТС и количество владельцев")
    public PostCarPage setPtsDocumentType(String documentType, String owner) {
        Allure.step("Выбираем " + documentType);
        seventhStep.$(byText(documentType)).click();
        Allure.step("Выбираем " + owner);
        documentTypePtsComponents.choiceDocumentTypePts(documentType, owner);
        checkedMenuSectionPts.shouldHave(visible);
        return this;
    }

    @Step("Заполняем в блоке ПТС год и месяц приобретения автомобиля")
    public PostCarPage setPtsYearPurchaseCar(String yearSale, String mouth) {
        seventhStep.$(byText(PTS_YEAR.getField())).click();
        Allure.step("Заполняем год  " + yearSale);
        yearRadioSelection.$(byText(yearSale)).click();
        seventhStep.$(byText(PTS_MONTH.getField())).click();
        Allure.step("Заполняем месяц  " + mouth);
        yearRadioSelection.$(byText(mouth)).click();
        return this;
    }

    @Step("Проставляем чекбокс 'Не растаможен'")
    public PostCarPage setPtsNotCleared() {
        seventhStep.$(byText(PTS_NOT_CLEARED.getField())).click();
        return this;
    }

    @Step("Заполняем ПТС блок 'Гарантия'")
    public PostCarPage setPtsGuarantee(String year, String mouth) {
        seventhStep.$(byText(PTS_GUARANTEE.getField())).click();
        seventhStep.$(byText(PTS_GUARANTEE_YEAR_OF_ENDING.getField())).click();
        Allure.step("Заполняем год  " + year);
        yearRadioSelection.$(byText(year)).click();
        seventhStep.$(byText(PTS_GUARANTEE_END_MONTH.getField())).click();
        Allure.step("Заполняем год  " + mouth);
        yearRadioSelection.$(byText(mouth)).click();
        Allure.step("Нажимаем на кнопку продолжить");
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    @Step("Заполняем 'Описание'")
    public PostCarPage setDescription(String valeText, String valueDescriptionParams) {
        Allure.step("Проверяем отображение полей");
        descriptionHeader.shouldHave(text(DESCRIPTION_HEADER.getField()));
        descriptionFieldWarning.shouldHave(text(DESCRIPTION_WARNING.getField()));
        autoRuExclusiveField.shouldHave(text(DESCRIPTION_ONLY_ON_AUTO.getField()));
        conditionBeatenField.shouldHave(text(DESCRIPTION_BEATEN.getField()));
        buttonGray.should(editable, ofSeconds(5));
        inputDescription.click();
        Allure.step("Вводим текст в поле");
        inputDescription.setValue(valeText);
        Allure.step("Выбираем параметр " + valueDescriptionParams + " из списка ");
        eighthStep.$(byText(valueDescriptionParams)).hover().click();
        checkedMenuDescription.shouldHave(visible);
        Allure.step("Нажимаем на кнопку продолжить");
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    @Step("Заполняем 'Опции'")
    public PostCarPage setOptions(String option) {
        Allure.step("Проверяем отображение полей");
        sectionOptionsEquipment.shouldHave(text(OPTIONS_HEADER.getOptionsField()));
        equipmentField.shouldHave(text(OPTIONS_FOG_LIGHTS.getOptionsValue()));
        equipmentField.shouldHave(text(OPTIONS_BOARD_COMPUTER.getOptionsValue()));
        equipmentField.shouldHave(text(OPTIONS_CENTRAL_LOCKING.getOptionsValue()));
        equipmentField.shouldHave(text(OPTIONS_IMMOBILIZER.getOptionsValue()));
        allEquipment.should(visible, ofSeconds(5));
        blockButtons.should(visible, ofSeconds(5));
        Allure.step("Выбираем оцию " + option);
        sectionOptionsEquipment.$(byText(option)).click();
        buttonSkip.shouldNotBe(visible);
        checkedMenuEquipment.shouldHave(visible);
        Allure.step("Нажимаем на кнопку продолжить");
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    @Step("Заполняем 'Повреждения'")
    public PostCarPage setDamage(String damageType, String damageValue) {
        tenthStep.should(text("Повреждения"), ofSeconds(5));
        damageTypePtsComponents.clickDamageType(damageType, damageValue);
        Allure.step("Нажимаем на кнопку продолжить");
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    @Step("Заполняем 'Контакты'")
    public PostCarPage setContacts(String userName, String email, String phone) {
        eleventhStep.shouldHave(text("Контакты"));
        $(buttonWithLoader).shouldHave(visible);
        Allure.step("Заполняем " + userName);
        UserNameField.setValue(userName);
        Allure.step("Заполняем " + email);
        emailField.setValue(email);
        Allure.step("Заполняем " + phone);
        phonesField.setValue(phone);
        return this;
    }

    @Step("Нажимаем сбросить и переходим на главную страницу")
    public PostCarPage clickResetButton() {
        resetButton.click();
        confirm();
        closeRedButton.click();
        return this;
    }

    @Step("Нажимаем закрыть")
    public PostCarPage closeRedButton() {
        closeRedButton.click();
        return this;
    }

    @Step("Выполняем поиск по VIN")
    public PostCarPage searchVin(String vin, String brand) {
        Allure.step("Заполняем в поле поиска " + brand);
        inputMarks.setValue(brand);
        Allure.step("Выбираем " + brand);
        markFieldIconSection.$(byText(brand)).click();
        Allure.step("Вводим " + vin);
        inputVin.setValue(vin);
        Allure.step("Нажимаем заполнить");
        buttonAccordionVin.click();
        return this;
    }

    @Step("Проверяем автоматическое заполнение полей по VIN")
    public PostCarPage checkTexParam(
            String brand,
            String model,
            String yearAuto,
            String body,
            String engine,
            String drive,
            String transmission,
            String modification) {
        Allure.step("Проверяем что в шапке присутствует " + brand);
        withSubtitle.shouldHave(text(brand));
        Allure.step("Проверяем что в шапке присутствует " + yearAuto);
        subtitle.shouldHave(text(yearAuto));
        Allure.step("Проверяем что в шапке присутствует " + body);
        subtitle.shouldHave(text(body));
        Allure.step("Проверяем что в шапке присутствует " + modification);
        subtitle.shouldHave(text(modification));
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
