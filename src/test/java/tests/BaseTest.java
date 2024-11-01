
package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.KorusMainPage;
import utils.UIProps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class BaseTest {
    protected final KorusMainPage korusMainPage = new KorusMainPage();

    UIProps props = ConfigFactory.create(UIProps.class);

    @BeforeAll
    public static void setUp() {
        closeWebDriver();
        Configuration.remote = "http://193.239.160.56:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeEach
    @Step("Открыть страницу 'https://wms.korusconsulting.ru/'")
    void openMainPage() {
        open(props.baseURL());
    }


    @AfterEach
    @Step("Сделать скриншот и закрыть драйвер")
    public void tearDown() throws IOException {
        screenshot();
        closeWebDriver();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return screenshot == null ? null : Files.readAllBytes(screenshot.toPath());
    }
}

