package steam;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import steam.config.AppConfig;
import steam.utils.Attach;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    static {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
    }

    @BeforeEach
    void setUp() {
        Configuration.remote = AppConfig.selenoidUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = AppConfig.baseUrl();
        Configuration.timeout = 10_000;

        Map<String, Object> selenoidOptions = Map.of("enableVNC", true, "enableVideo", true);

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities = options;
    }

    @AfterEach
    void tearDown() {
        String sessionId = null;
        if (WebDriverRunner.hasWebDriverStarted()) {
            sessionId = Objects
                    .requireNonNull(((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId())
                    .toString();
        }
        closeWebDriver();
        Attach.attachVideo(sessionId);
    }
}
