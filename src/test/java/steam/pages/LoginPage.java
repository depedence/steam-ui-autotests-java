package steam.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step("Click login button")
    public void clickLoginButton() {
        $("[class='global_action_link']").click();
    }

    @Step("Check login page")
    public void checkLoginPage() {
        $("form:not([role='search']) button[type='submit']").shouldHave(Condition.text("Sign in"));
    }
}
