package steam.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppConfig {
    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public static String baseUrl() {
        return get("BASE_URL", "https://store.steampowered.com");
    }

    public static String selenoidUrl() {
        return get("SELENOID_URL", "http://localhost:4444/wd/hub");
    }

    private static String get(String key, String defaultValue) {
        String value = dotenv.get(key);
        if (value == null) {
            value = System.getenv(key);
        }
        return value != null ? value : defaultValue;
    }
}
