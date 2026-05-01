package pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import java.util.Objects;

public class HomePage {

    private SHAFT.GUI.WebDriver driver;
    private By homeIcon;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        if (Objects.equals(SHAFT.Properties.platform.targetPlatform(), "ANDROID")) {
            initiateAndroidLocators();
        } else {
            initiateIOSLocators();
        }
    }

    public HomePage assertLoginToHomePageSuccessfully() {
        return this;
    }

    private void initiateAndroidLocators() {
        homeIcon = AppiumBy.accessibilityId("home, home_selected");
    }

    private void initiateIOSLocators() {}
}
