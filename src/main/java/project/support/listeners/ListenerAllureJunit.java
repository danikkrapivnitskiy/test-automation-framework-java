package project.support.listeners;

import browserSetUp.AttachmentManager;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import project.support.configuration.ConfigProperties;

public class ListenerAllureJunit implements AfterTestExecutionCallback, BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        ConfigProperties.initializePropertyFile();
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getExecutionException().isPresent()) AttachmentManager.screenshot();
    }
}
