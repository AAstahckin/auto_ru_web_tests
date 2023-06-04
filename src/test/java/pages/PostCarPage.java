package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.DocumentTypePtsComponents;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.enums.DescriptionFields.*;
import static data.enums.PtsFields.*;
import static data.enums.PtsTypeParams.*;
import static java.time.Duration.ofSeconds;

public class PostCarPage {

    DocumentTypePtsComponents documentTypePtsComponents = new DocumentTypePtsComponents();

    SelenideElement
            inputMarks = $(".TextInput__input .TextInput__box .TextInput__control"),
            markFieldIconSection = $(".MarkField__items"),
            modelListSection = $(".ModelField__list"),
            yearModelSection = $(".AccordionSectionBody__content .YearField"),
            engineTypeSection = $(".AccordionSectionBody__content .EngineTypeField"),
            gearTypeSection = $(".AccordionSectionBody__content .GearTypeField"),
            transmissionSection = $(".AccordionSectionBody__content .TransmissionField"),
            techParamSection = $(".AccordionSectionBody__content .TechParamField"),
            CheckedMenuSectionTech = $("[data-testid=menu-section-tech]").$(".OfferAccordionContents__listItemCheckedIcon"),
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
            autoruExclusiveField = $(".OfferWizardStep_current .OfferFormAutoruExclusiveField__legend"),
            conditionBeatenField = $(".OfferWizardStep_current .OfferFormConditionBeatenField__legend"),
            inputDescription = $(".TextArea__control"),
            eighthStep = $("#wizard-step-8"),
            sectionOptionsEquipment = $("#section-equipment"),
            allEquipment = $(".OfferFormEquipmentField__cut"),
            blockButtons = $(".OfferWizardControls__content"),
            tenthStep = $("#wizard-step-10"),
            damagesScheme = $(".VehicleBodyDamagesSchemeFrame__scheme div"),
            damagePopup = $(".DamagePopup"),
            eleventhStep = $("#wizard-step-11"),
            buttonWithLoader = $(".OfferFormPhonesField__submitButton .ButtonWithLoader__content"),
            resetButton = $(".OfferAccordionContents__resetButton"),
            UserNameField = $(".OfferFormUserNameField__infoPopup .TextInput__inputWrap  .TextInput__control"),
            emailField = $(".OfferFormUserEmailField__infoPopup .TextInput__inputWrap  .TextInput__control"),
            phonesField = $(".OfferFormPhonesField__phoneAuth .TextInput__inputWrap  .TextInput__control"),
            closeRedButton = $(".Link_color_red");

    ElementsCollection
            damagesSchemeSelections = $$(".OfferFormDamagesField__bodyDamagesWrapper .VehicleBodyDamagesSchemeFrame__scheme div"),
            ptsTypeSelection = $$(".OfferFormPtsStatusField button");
    String dataId = "[data-id=%s]";

    public PostCarPage setCharacteristics(
            String brand,
            String model,
            String yearModel,
            String engineType,
            String gearType,
            String transmission,
            String horses,
            String color) {
        inputMarks.setValue(brand);
        markFieldIconSection.$(byText(brand)).click();
        modelListSection.$(byText(model)).click();
        yearModelSection.$(byText(yearModel)).click();
        engineTypeSection.$(byText(engineType)).click();
        gearTypeSection.$(byText(gearType)).click();
        transmissionSection.$(byText(transmission)).click();
        techParamSection.$(byText(horses)).click();
        $(String.format(dataId, color)).click();
        CheckedMenuSectionTech.shouldHave(visible);
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    public PostCarPage setMileage(String value) {
        buttonTransparentBlue.shouldHave(editable);
        mileageInput.setValue(value);
        checkedMenuSectionMileage.shouldHave(visible);
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    public PostCarPage inputPhoto(String pathFile) {
        File file = new File(pathFile);
        fileInput.uploadFile(file);
        photoLoader.shouldNotBe(visible);
        checkedMenuSectionPhotos.shouldHave(visible);
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        invalidGrzContent.shouldHave(text("Мы не распознали госномер на фото. Проверьте, что он виден хотя бы на одном снимке, иначе объявление может быть заблокировано."));
        return this;
    }

    public PostCarPage checkPts() {
        seventhStep.should(visible, ofSeconds(3));
        buttonTransparentBlue.should(visible, ofSeconds(5));
        seventhStep.should(text(PTS_HEADER.getField()), ofSeconds(3));
        ptsStatusHeader.should(text(PTS_TYPE_DOCUMENT.getField()));
        ptsDateHeader.should(text(PTS_SALE_DATE.getField()));
        ptsTypeSelection.shouldHave(texts(ORIGINAL_PTS.getValue(), DUPLICATE_PTS.getValue(), NO_PTS.getValue()));
        return this;
    }

    public PostCarPage setPtsDocumentType(String documentType, String owner) {
        seventhStep.$(byText(documentType)).click();
        documentTypePtsComponents.choiceDocumentTypePts(documentType, owner);
        checkedMenuSectionPts.shouldHave(visible);
        return this;
    }

    public PostCarPage setPtsYearPurchaseCar(String yearSale, String mouth) {
        seventhStep.$(byText(PTS_YEAR.getField())).click();
        yearRadioSelection.$(byText(yearSale)).click();
        seventhStep.$(byText(PTS_MONTH.getField())).click();
        yearRadioSelection.$(byText(mouth)).click();
        return this;
    }

    public PostCarPage setPtsNotCleared() {
        seventhStep.$(byText(PTS_NOT_CLEARED.getField())).click();
        return this;
    }

    public PostCarPage setPtsGuarantee() {
        seventhStep.$(byText(PTS_GUARANTEE.getField())).click();
        seventhStep.$(byText(PTS_GUARANTEE_YEAR_OF_ENDING.getField())).click();
        yearRadioSelection.$(byText("2028")).click();
        seventhStep.$(byText(PTS_GUARANTEE_END_MONTH.getField())).click();
        yearRadioSelection.$(byText("Январь")).click();
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }


    public PostCarPage setDescription() {
        descriptionHeader.shouldHave(text(DESCRIPTION_HEADER.getField()));
        descriptionFieldWarning.shouldHave(text(DESCRIPTION_WARNING.getField()));
        autoruExclusiveField.shouldHave(text(DESCRIPTION_ONLY_ON_AUTO.getField()));
        conditionBeatenField.shouldHave(text(DESCRIPTION_BEATEN.getField()));
        buttonGray.should(editable, ofSeconds(5));
        inputDescription.click();
        inputDescription.setValue("123");
        eighthStep.$(byText("Своевременное обслуживание")).hover().click();
        eighthStep.$(byText("Не участвовала в ДТП")).hover().click();
        checkedMenuDescription.shouldHave(visible);
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    public PostCarPage setOptions() {
        sectionOptionsEquipment.shouldHave(text("Опции"));
        allEquipment.should(visible, ofSeconds(5));
        blockButtons.should(visible, ofSeconds(5));
        sectionOptionsEquipment.$(byText("Центральный замок")).click();
        $(".OfferWizardControls__content .OfferWizardControls__buttonText").$(byText("Пропустить")).shouldNotBe(visible);
        checkedMenuEquipment.shouldHave(visible);
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    public PostCarPage setDamage() {
        tenthStep.should(text("Повреждения"), ofSeconds(5));
        damagesScheme.should(visible);
        damagesSchemeSelections.get(5).hover().click();
        damagePopup.$(byText("Окрашено")).hover().click();
        damagePopup.$(byText("Сохранить")).hover().click();
        buttonBlue.should(visible, ofSeconds(5)).hover().click();
        return this;
    }

    public PostCarPage checkContacts(String userName, String email, String phone) {
        eleventhStep.shouldHave(text("Контакты"));
        $(buttonWithLoader).shouldHave(visible);
        UserNameField.setValue(userName);
        emailField.setValue(email);
        phonesField.setValue(phone);
        return this;
    }

    public PostCarPage clickResetButton() {
        resetButton.click();
        confirm();
        closeRedButton.click();
        return this;
    }

    public PostCarPage closeRedButton() {
        closeRedButton.click();
        return this;
    }

}
