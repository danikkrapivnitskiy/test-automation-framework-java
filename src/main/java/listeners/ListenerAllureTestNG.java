package listeners;

import browser.AttachmentManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

@Slf4j(topic = "|TestNG Listener|")
public class ListenerAllureTestNG implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        if (testResult.getStatus() == ITestResult.FAILURE) {
            AttachmentManager.screenshot();
        }
    }
}
