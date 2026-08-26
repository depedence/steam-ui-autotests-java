package steam;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import steam.config.AppConfig;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeEach
    void setUp() {
        Configuration.remote = AppConfig.selenoidUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = AppConfig.baseUrl();
        Configuration.timeout = 10_000;

        Map<String, Object> selenoidOptions = Map.of(
                "enableVNC", true,
                "enableVideo", true);

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities = options;
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
