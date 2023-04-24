package config;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;

public class BaseTest {

    Attachments attachments = new Attachments();
    private static final WebDriverConfig webConfig = ConfigReader.Instance.read();

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.configure();
    }
    @AfterEach
    void addAttachments() {
        attachment("Source", webdriver().driver().source());
        attachments.takeScreenshot();
        attachments.pageSource();
        attachments.browserConsoleLogs();
        attachments.addVideo();
    }
}