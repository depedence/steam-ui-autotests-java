package steam.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steam.BaseTest;
import steam.pages.LoginPage;
import steam.pages.MainPage;

@Epic("Login page")
@Feature("Elements on login page")
@Link(url = "https://store.steampowered.com/", name = "Steam")
public class LoginTests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Open login page")
    @Story("Login button")
    @Tag("web")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("depedence")
    void openLoginPageTest() {
        mainPage.openMainPage();
        loginPage.clickLoginButton();
        loginPage.checkLoginPage();
    }
}
