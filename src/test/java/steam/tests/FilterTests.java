package steam.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import steam.BaseTest;
import steam.pages.FilterPage;

@Epic("Store filters")
@Feature("Add and remove tag filters on search page")
@Link(url = "https://store.steampowered.com/", name = "Steam")
public class FilterTests extends BaseTest {

    private final FilterPage filterPage = new FilterPage();

    @Test
    @DisplayName("Add filter tag")
    @Story("Add filter")
    @Tag("web")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("depedence")
    void addFilterTagTest() {
        filterPage.openFilterPage();
        filterPage.addFilterTag("Action");
        filterPage.checkFilterTagApplied("Action");
    }

    @Test
    @DisplayName("Remove filter tag")
    @Story("Remove filter")
    @Tag("web")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("depedence")
    void removeFilterTagTest() {
        filterPage.openFilterPage();
        filterPage.addFilterTag("Action");
        filterPage.checkFilterTagApplied("Action");

        filterPage.removeFilterTag("Action");
        filterPage.checkFilterTagNotApplied("Action");
    }

    @Test
    @DisplayName("Clear multiple filter tags")
    @Story("Clear filters")
    @Tag("web")
    @Severity(SeverityLevel.NORMAL)
    @Owner("depedence")
    void clearAllFilterTags() {
        filterPage.openFilterPage();
        filterPage.addFilterTag("Action");
        filterPage.addFilterTag("Singleplayer");
        filterPage.checkFilterTagApplied("Action");
        filterPage.checkFilterTagApplied("Singleplayer");

        filterPage.removeFilterTag("Action");
        filterPage.removeFilterTag("Singleplayer");
        filterPage.checkFiltersCleared("Action", "Singleplayer");
    }
}
