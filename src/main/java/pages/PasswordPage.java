package pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Objects;

public class PasswordPage {

    private SHAFT.GUI.WebDriver driver;
    private By passwordTextField;
    private By loginButton;
    public By logo = AppiumBy.accessibilityId("logo");

    public PasswordPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        if (Objects.equals(SHAFT.Properties.platform.targetPlatform(), "ANDROID")) {
            initiateAndroidLocators();
        } else {
            initiateIOSLocators();
        }
    }

    public PasswordPage enterPasswordAndPressLogin(String password) {
        driver.element().waitUntil(ExpectedConditions.elementToBeClickable(passwordTextField));
        driver.element().click(passwordTextField).clear(passwordTextField).type(passwordTextField, password);
        driver.element().click(logo);
        driver.element().click(loginButton);
        return this;
    }

    private void initiateAndroidLocators() {
        passwordTextField = By.xpath("//android.widget.EditText[@hint='Enter your password']");
        loginButton = AppiumBy.accessibilityId("Login");
    }

    private void initiateIOSLocators() {}
}
