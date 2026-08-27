package steam.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@Epic("Demo")
@Feature("Demonstration of different test statuses in Allure report")
public class SmokeDemoTests {

    @Test
    @DisplayName("Demo: intentionally designed to fail")
    @Description("This test is intentionally designed to fail. " + "It demonstrates how a failed test looks in the Allure report and is not a real bug")
    @Story("Failed status demo")
    @Tag("demo")
    @Severity(SeverityLevel.TRIVIAL)
    void intentionallyFailingTest() {
        fail("This test intentionally fails to demonstrate the FAILED status in the Allure report");
    }

    @Test
    @Disabled("Intentionally skipped to demonstrate the SKIPPED status in the Allure report")
    @DisplayName("Demo: intentionally skipped test")
    @Story("Skipped status demo")
    @Tag("demo")
    @Severity(SeverityLevel.TRIVIAL)
    void intentionallySkippedTest() {
        // not run
    }
}
