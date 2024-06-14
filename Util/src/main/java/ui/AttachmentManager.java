package ui;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static ui.WebDriverFactory.driverThreadLocal;
@Slf4j(topic = "|AttachmentManager|")
public class AttachmentManager {

    @Attachment(value = "screenshot", type = "image/png")
    public static void screenshot() {
        log.info("Taking screenshot...");
        if (driverThreadLocal.get() != null) {
            ((TakesScreenshot) driverThreadLocal.get()).getScreenshotAs(OutputType.BYTES);
        }
    }
}
