package steam.utils;

import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.open;

@NoArgsConstructor
public class NavigationUtils {

    public static void openWithRetry(String url) {
        RetryUtils.retry(() -> open(url));
    }
}
