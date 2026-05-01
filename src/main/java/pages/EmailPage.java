package pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Objects;

public class EmailPage {

    private SHAFT.GUI.WebDriver driver;
    private By letsStartButton;
    private By emailTextField;
    private By continueButton;

    public EmailPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        if (Objects.equals(SHAFT.Properties.platform.targetPlatform(), "ANDROID")) {
            initiateAndroidLocators();
        } else {
            initiateIOSLocators();
        }
    }

    public EmailPage enterEmailAndContinue(String email) {
        driver.element().click(letsStartButton);
        driver.element().click(emailTextField).clear(emailTextField).type(emailTextField, email);
        driver.element().click(continueButton);
        return this;
    }

    private void initiateAndroidLocators() {
        letsStartButton = AppiumBy.accessibilityId("arrow_forward_icon, Let's Start");
        emailTextField = By.xpath("//android.widget.EditText[@hint='email@example.com']");
        continueButton = AppiumBy.accessibilityId("Continue");
    }

    private void initiateIOSLocators() {}
}
