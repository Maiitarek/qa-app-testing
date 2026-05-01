package TestPackage.MNT1159_ProfessionalContactProfile;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.*;
import pages.*;

public class MNT1330_DeleteContact {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON loginData;
    private SHAFT.TestData.JSON envData;
    private ContactsPage contactsPage;
    private CommonMethodsPage commonMethodsPage;
    private ProfessionalPage professionalPage;

    @BeforeMethod
    public void beforeMethod() {
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
    }

    @Test(description = "Verify that the user can delete a contact")
    @Description("When a user deletes a contact, it should be removed from the contact list")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT1330: Delete Contact")
    public void deleteContact() {
        contactsPage.addNewContactWithFirstNameOnly("Amor");
        professionalPage.deleteContact();
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) driver.quit();
    }
}
