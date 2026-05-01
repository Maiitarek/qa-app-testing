package pages;

import com.shaft.driver.SHAFT;
import pages.EmailPage;
import pages.PasswordPage;
import pages.HomePage;

public class CommonMethodsPage {

    private SHAFT.GUI.WebDriver driver;

    public CommonMethodsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void loginUsingExistingAccount(String email, String password) {
        EmailPage emailPage = new EmailPage(driver);
        PasswordPage passwordPage = new PasswordPage(driver);
        HomePage homePage = new HomePage(driver);
        emailPage.enterEmailAndContinue(email);
        passwordPage.enterPasswordAndPressLogin(password);
        homePage.assertLoginToHomePageSuccessfully();
    }
}
