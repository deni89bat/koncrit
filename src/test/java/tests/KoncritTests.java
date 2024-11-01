package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.KoncritPage;

public class KoncritTests extends BaseTest {
    //KoncritPage koncritPage = new KoncritPage();

    @Test
    @DisplayName("Проверить текст блоков на лендинге Koncrit")
    void koncritTest() {
        korusMainPage.openKoncritPage();
        new KoncritPage()
                .checkPageTitle()
                .verifyAllBlocks();
    }

    @Test
    @DisplayName("Проверить что форму обратной связи, нельзя отправить без согласия на обработку персональных данных")
    @Tag("Negative")
    void callbackForm() {
        korusMainPage.openKoncritPage();
        new KoncritPage()
                .checkPageTitle()
                .clickDiscussProject()
                .callbackFormIsOpened()
                .fillCallbackForm()
                .uncheckConfidentialCheckbox()
                .discussProjectButtonIsDisabled()
                .clickDiscussProjectButton()
                .verifyFormIsStillOpen();
    }
}