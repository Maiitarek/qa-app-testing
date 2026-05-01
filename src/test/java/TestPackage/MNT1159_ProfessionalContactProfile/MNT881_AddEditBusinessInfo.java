package TestPackage.MNT1159_ProfessionalContactProfile;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.*;
import pages.*;

public class MNT881_AddEditBusinessInfo {

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
        professionalPage.openContactProffessionalTab();
    }

    @Test(description = "Verify that the user can add/edit business info")
    @Description("When a user adds or edits business info, business info should be updated")
    @Severity(SeverityLevel.NORMAL)
    @Story("MNT881: Add/Edit business info")
    public void verifyBusinessInfoAdd() throws InterruptedException {
        professionalPage.verifyAddBusinessInfo();
    }

    @Test(description = "Verify that the user can edit business info")
    @Description("Edit business info — related fields should be updated")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT881: Add/Edit business info")
    public void verifyBusinessInfoEdit() throws InterruptedException {
        professionalPage.verifyEditBusinessInfo();
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) driver.quit();
    }
}
