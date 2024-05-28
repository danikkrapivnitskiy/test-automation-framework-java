package listener;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j(topic = "|TestNG Listener|")
public class ListenerTestNG implements ITestListener {
    private static final String SCREENSHOT_FOLDER = "screenshots";
    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        takeScreenshot(driverThreadLocal.get(), result.getTestClass().getXmlTest().getName());
    }

    private void takeScreenshot(WebDriver driver, String testName) {
        try {
            if (driver instanceof TakesScreenshot) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                String fileName = testName + "_" + now.format(formatter) + ".png";
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String path = SCREENSHOT_FOLDER + File.separator + fileName;

                Files.createDirectories(Paths.get(SCREENSHOT_FOLDER));

                try (FileOutputStream outputStream = new FileOutputStream(path)) {
                    outputStream.write(Files.readAllBytes(screenshot.toPath()));
                } catch (IOException e) {
                    log.error("Failure during saving a screenshot: ", e.getMessage());
                }
                log.info("Screenshot saved to: " + path);
            }
        } catch (Exception e) {
            log.error("Error taking screenshot: ", e);
        }
    }
}
