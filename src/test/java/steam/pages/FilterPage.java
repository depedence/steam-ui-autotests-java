package steam.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import steam.utils.NavigationUtils;

import static com.codeborne.selenide.Selenide.$;

public class FilterPage {

    @Step("Open filter page")
    public void openFilterPage() {
        NavigationUtils.openWithRetry("/search");
    }

    @Step("Add filter tag: {tagLabel}")
    public void addFilterTag(String tagLabel) {
        filterCheckbox(tagLabel).click();
    }

    @Step("Remove filter tag: {tagLabel}")
    public void removeFilterTag(String tagLabel) {
        filterCheckbox(tagLabel).click();
    }

    @Step("Check filter tag \"{tagLabel}\" is applied")
    public void checkFilterTagApplied(String tagLabel) {
        filterCheckbox(tagLabel).shouldHave(Condition.cssClass("checked"));
    }

    @Step("Check filter tag \"{tagLabel}\" is not applied")
    public void checkFilterTagNotApplied(String tagLabel) {
        filterCheckbox(tagLabel).shouldNotHave(Condition.cssClass("checked"));
    }

    @Step("Check that all filter tags are cleared: {tagLabels}")
    public void checkFiltersCleared(String... tagLabels) {
        for (String tag : tagLabels) {
            checkFilterTagNotApplied(tag);
        }
    }

    private SelenideElement filterCheckbox(String tagLabel) {
        return $("span.tab_filter_control[data-loc='" + tagLabel + "']");
    }
}
