package listeners;

import configuration.ConfigProperties;
import ui.AttachmentManager;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ListenerAllureJunit implements AfterTestExecutionCallback, BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        ConfigProperties.initializePropertyFile();
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        if (extensionContext.getExecutionException().isPresent()) AttachmentManager.screenshot();
    }
}
