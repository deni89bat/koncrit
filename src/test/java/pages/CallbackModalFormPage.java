package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementClickInterceptedException;

import static com.codeborne.selenide.Selenide.$;

public class CallbackModalFormPage {
    protected SelenideElement callbackModal = $("#discussProject");
    private final SelenideElement fioInputField = callbackModal.find("input[name='NAME']");
    private final SelenideElement telInputField = callbackModal.find("input[name='PHONE']");
    private final SelenideElement emailInputField = callbackModal.find("input[name='EMAIL']");
    private final SelenideElement confidentialCheckbox = callbackModal.find("#confidChk-discussProject");
    private final SelenideElement confidentialLabel = callbackModal.find(".confid label");
    private final SelenideElement discussProjectButton = callbackModal.find(".form-btn");

    @Step("Пользователь видит форму обратной связи")
    public CallbackModalFormPage callbackFormIsOpened() {
        callbackModal.shouldBe(Condition.visible);
        return this;
    }

    @Step("Пользователь заполняет форму обратной связи")
    public CallbackModalFormPage fillCallbackForm() {
        fioInputField.shouldBe(Condition.visible).sendKeys("Иванов Иван Иваныч");
        telInputField.shouldBe(Condition.visible).click();
        telInputField.sendKeys("6666666666");
        emailInputField.shouldBe(Condition.visible).sendKeys("ivan@ivan.ru");
        return this;
    }

    @Step("Пользователь не даёт согласия на обработку данных")
    public CallbackModalFormPage uncheckConfidentialCheckbox() {
        confidentialCheckbox.shouldBe(Condition.checked);
        confidentialLabel.click();
        confidentialCheckbox.shouldNotBe(Condition.checked);  // Проверка, что чекбокс теперь не отмечен
        return this;
    }

    @Step("Пользователь видит, что кнопка 'Обусдить проект' некликабельна")
    public CallbackModalFormPage discussProjectButtonIsDisabled() {
        discussProjectButton.shouldHave(Condition.cssClass("disabled"));
        return this;
    }

    @Step("Пользователь нажимает кнопку 'Обусдить проект'")
    public CallbackModalFormPage clickDiscussProjectButton() {
        if (discussProjectButton.isDisplayed() && !discussProjectButton.has(Condition.cssClass("disabled"))) {
            try {
                discussProjectButton.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("Кнопка не нажимается: " + e.getMessage());
            }
        } else {
            System.out.println("Кнопка 'Обсудить проект' неактивна или не отображается.");
        }
        return this;
    }

    @Step("Пользователь видит, что форма всё ещё открыта")
    public CallbackModalFormPage verifyFormIsStillOpen() {
        callbackModal.shouldBe(Condition.visible);
        return this;
    }
}


