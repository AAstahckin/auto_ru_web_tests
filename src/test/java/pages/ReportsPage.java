package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class ReportsPage {

    SelenideElement
            vinTitle = $(".VinCheckSnippetDesktop__title"),
            vinText = $(".VinCheckSnippetDesktop__text"),
            vinInput = $(".VinCheckSnippetDesktop__input input"),
            vinReport = $(".VinReportPreviewDesktop__mmm"),
            historyByVin = $(".HistoryByVinPromoBlock__title"),
            vinMini = $(".ProAutoLandingDesktop__vinCheckMini"),
            continueButton = $(".VinCheckSnippetDesktop__input .Button__content");

    ElementsCollection
            listOutputParams = $$(".VinReportPreviewDesktop__top .VinReportPreviewDesktop__info div"),
            itemImagePromoBlock = $$(".HistoryByVinPromoBlock__itemImage");

    @Step("Проверяем страницу Отчеты")
    public ReportsPage checkWindowReports(String title, String titleVin) {
        step("Проверяем титульник страницы", () ->
                vinTitle.shouldHave(text(title)));
        step("Проверяем информационное сообщение", () ->
                vinText.shouldHave(text(titleVin)));
                vinInput.shouldHave(visible, ofSeconds(5));
                historyByVin.shouldHave(visible);
                vinMini.shouldHave(visible);
                continueButton.shouldHave(visible);
        return this;
    }

    @Step("Вводим в поле VIN {vinValue}")
    public ReportsPage vinSetValue(String vinValue) {
        itemImagePromoBlock.get(9).shouldHave(visible, ofSeconds(15));
        vinInput.hover().click();
        step("Вводим вин в поле", () ->
                vinInput.should(visible, ofSeconds(5)).setValue(vinValue));
        step("Нажимем продолэить", () ->
                continueButton.click());
        return this;
    }

    @Step("Проверяем отчет по {brand}")
    public ReportsPage checkReportVin(String vin, String brand, String model, String year) {
        step("", () ->
                vinReport.shouldHave(text(brand + " " + model + ", " + year)));
        step("", () ->
                listOutputParams.get(2).shouldHave(text(vin.substring(0, 3) + "**************")));
        return this;
    }

}
