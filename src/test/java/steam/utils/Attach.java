package steam.utils;

import io.qameta.allure.Allure;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@NoArgsConstructor
public class Attach {

    private static final Path VIDEO_DIR = Paths.get("selenoid", "video");
    private static final int MAX_WAIT_ATTEMPTS = 10;
    private static final long WAIT_INTERNAL_MS = 1000;

    public static void attachVideo(String sessionId) {
        if (sessionId == null)
            return;

        File videoFile = VIDEO_DIR.resolve(sessionId + ".mp4").toFile();

        int attempts = 0;
        while (!videoFile.exists() && attempts < MAX_WAIT_ATTEMPTS) {
            sleep(WAIT_INTERNAL_MS);
            attempts++;
        }

        if (!videoFile.exists()) {
            System.out.println("Video file not found for session " + sessionId + ", skipping attachment");
            return;
        }

        try (FileInputStream fis = new FileInputStream(videoFile)) {
            Allure.addAttachment("Session video", "video/mp4", fis, ".mp4");
        } catch (IOException e) {
            System.out.println("Failed attach video: " + e.getMessage());
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
