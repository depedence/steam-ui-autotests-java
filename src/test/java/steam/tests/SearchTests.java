package steam.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steam.BaseTest;
import steam.pages.MainPage;
import steam.pages.SearchPage;

@Epic("Search")
@Feature("Search game by title")
@Link(url = "https://store.steampowered.com/", name = "Steam")
public class SearchTests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Search game by title")
    @Story("Search field")
    @Tag("web")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("depedence")
    void searchGameByTitleTest() {
        mainPage.openMainPage();
        searchPage.clickOnSearchField();
        searchPage.findGameByTitle("Dota 2");
        searchPage.openFirstGameInSearchRow();
        searchPage.checkGameTitle("Dota 2");
        searchPage.checkGamePageUrl("/570/Dota_2/");
    }
}
