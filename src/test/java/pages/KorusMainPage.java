package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class KorusMainPage {
    protected SelenideElement solutionsDdl = $x("//li/a[normalize-space()='Решения']");
    protected SelenideElement koncritButton = $x("//li/ul/li/a[normalize-space()='Логистическая платформа KONCRIT']");

    @Step("Навести курсор на выпадающий список 'Решения' и кликнуть 'Логистическая платформа KONCRIT'")
    public void openKoncritPage() {
        solutionsDdl.shouldBe(visible).hover();
        koncritButton.shouldBe(visible).click();
    }
}
