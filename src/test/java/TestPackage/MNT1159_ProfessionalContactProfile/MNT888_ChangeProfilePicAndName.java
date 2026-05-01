package TestPackage.MNT1159_ProfessionalContactProfile;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.*;
import pages.*;

public class MNT888_ChangeProfilePicAndName {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON loginData;
    private SHAFT.TestData.JSON envData;
    private ContactsPage contactsPage;
    private CommonMethodsPage commonMethodsPage;
    private ProfessionalPage professionalPage;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        loginData = new SHAFT.TestData.JSON("loginData.json");
        envData = new SHAFT.TestData.JSON("environmentData.json");
        commonMethodsPage = new CommonMethodsPage(driver);
        contactsPage = new ContactsPage(driver);
        professionalPage = new ProfessionalPage(driver);
        driver.getDriver().navigate().to(envData.getTestData("sit"));
        commonMethodsPage.loginUsingExistingAccount(
            loginData.getTestData("authorizedEmail"),
            loginData.getTestData("validPassword")
        );
        contactsPage.openContact("Ahmed Fadi");
    }

    @Test(description = "Verify that the user can change contact name")
    @Description("When a user changes the contact name, the profile should reflect the update")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT888: Change Contact Name")
    public void changeContactProfileName() {
        professionalPage.ChangeProfileName();
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) driver.quit();
    }
}
