package steam.utils;

import lombok.NoArgsConstructor;
import org.openqa.selenium.TimeoutException;

@NoArgsConstructor
public class RetryUtils {

    private static final int MAX_ATTEMPTS = 3;

    public static void retry(Runnable action) {
        int attempt = 1;
        while (true) {
            try {
                action.run();
                return;
            } catch (TimeoutException e) {
                if (attempt >= MAX_ATTEMPTS) {
                    throw e;
                }
                System.out.println("Action timed out (attempt " + attempt + "/" + MAX_ATTEMPTS + "), retrying...");
                attempt++;
            }
        }
    }
}
