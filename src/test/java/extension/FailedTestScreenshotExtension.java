package extension;

import browser.DriverInitialize;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
@Slf4j(topic = "|Failed screenshot extension|")
public class FailedTestScreenshotExtension implements AfterTestExecutionCallback {

    private static final String SCREENSHOT_FOLDER = "screenshots";

    @SneakyThrows
    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            Optional<DriverInitialize> driverInitializeOptional = context.getRequiredTestInstances().findInstance(DriverInitialize.class);
            if (driverInitializeOptional.isPresent()) {
                DriverInitialize driverInitialize = driverInitializeOptional.get();
                WebDriver driver = driverInitialize.driver;

                if (driver instanceof TakesScreenshot) {
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                    String fileName = context.getTestMethod().get().getName() + "_" + now.format(formatter) + ".png";
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
            }
        }
    }
}