package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.KoncritBlockTitles;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class KoncritPage {
    protected final ElementsCollection blockTitles = $$x("//div/h2");
    protected final SelenideElement discussProjectBtn = $x("//a[@data-page='Обсудить проект в шапке решения']");

    @Step("Пользователь видит, что заголовок страницы 'Логистическая платформа KONCRIT | КОРУС Консалтинг' ")
    public KoncritPage checkPageTitle() {
        String actualPageTitle = title();
        Assertions.assertEquals("Логистическая платформа KONCRIT | КОРУС Консалтинг", actualPageTitle);
        return this;
    }

    @Step("Пользователь видит все блоки лендинга с корректными заголовками: {expectedTitles}")
    private KoncritPage checkAllBlocksTitles(List<String> expectedTitles) {
        // Проверка количества заголовков
        Assertions.assertEquals(expectedTitles.size(), blockTitles.size(), "Количество заголовков не соответствует ожидаемому");

        // Сбор фактических заголовков
        List<String> actualTitles = blockTitles
                .stream()
                .map(element -> normalizeText(element.getText()))
                .collect(Collectors.toList());

        // Сравнение фактических и ожидаемых заголовков
        Assertions.assertIterableEquals(expectedTitles, actualTitles, "Заголовки блоков не соответствуют ожидаемым");
        return this;
    }

    public KoncritPage verifyAllBlocks() {
        List<String> expectedTitles = Stream.of(KoncritBlockTitles.values())
                .map(KoncritBlockTitles::getTitleText)
                .collect(Collectors.toList());

        return checkAllBlocksTitles(expectedTitles);
    }

    private String normalizeText(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    @Step("Нажать кнопку 'Обсудить проект'")
    public CallbackModalFormPage clickDiscussProject() {
        discussProjectBtn.shouldBe(Condition.clickable)
                .click();
        return new CallbackModalFormPage();
    }

}
