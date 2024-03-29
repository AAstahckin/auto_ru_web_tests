package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.enums.PtsFields.PTS_OWNERS;
import static data.enums.PtsOwnersParams.*;
import static data.enums.PtsTypeParams.NO_PTS;
import static io.qameta.allure.Allure.step;

public class DocumentTypePtsComponents {

    SelenideElement
            seventhStep = $("#wizard-step-7"),
            ownersFieldHeader = $(".OfferFormOwnersNumberField");
    ElementsCollection ownersPtsNumberField = $$(".OfferFormOwnersNumberField .Tags_wrap_wrap span .Button__text");

    public DocumentTypePtsComponents choiceDocumentTypePts(String documentType, String owner) {
        if (!Objects.equals(documentType, NO_PTS.getTypeValue())) {
            ownersFieldHeader.shouldHave(text(PTS_OWNERS.getValue()));
            step("Проверяем отображение схемы автомобиля", () -> ownersPtsNumberField.shouldHave(texts(
                    FIRST_OWNER.getTypeValue(),
                    SECOND_OWNER.getTypeValue(),
                    THIRD_OWNER.getTypeValue(),
                    FOURTH_OR_MORE_OWNER.getTypeValue())));
            seventhStep.$(byText(owner)).click();
            return this;
        } else {
            ownersFieldHeader.shouldNotBe(visible);
        }
        return this;
    }
}
