package steam.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import steam.utils.RetryUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SearchPage {

    @Step("Click on search field")
    public void clickOnSearchField() {
        $("input[name='term']").click();
    }

    @Step("Find game by title: {gameTitle}")
    public void findGameByTitle(String gameTitle) {
        RetryUtils.retry(() -> {
            $("input[name='term']").setValue(gameTitle).pressEnter();
        });
    }

    @Step("Open first game from search results")
    public void openFirstGameInSearchRow() {
        $$(".search_result_row").first().click();
    }

    @Step("Check that game title in game page is: {expectedTitle}")
    public void checkGameTitle(String expectedTitle) {
        $("#appHubAppName").shouldHave(Condition.text(expectedTitle));
    }

    // expectedUrl example: "/570/Dota_2/"
    @Step("Check expected game URL is: {expectUrl}")
    public void checkGamePageUrl(String expectedUrl) {
        Selenide.webdriver().shouldHave(url("https://store.steampowered.com/app" + expectedUrl));
    }
}
