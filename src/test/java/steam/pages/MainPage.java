package steam.pages;

import io.qameta.allure.Step;
import steam.utils.NavigationUtils;

public class MainPage {

    @Step("Open \"Steam\" main page")
    public void openMainPage() {
        NavigationUtils.openWithRetry("/");
    }
}
