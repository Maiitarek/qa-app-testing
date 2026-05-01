package TestPackage.MNT1159_ProfessionalContactProfile;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.*;
import pages.*;

public class MNT887_AddEditAreasofexpertise_industries {

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
        contactsPage.openContact("Ahmed Fadi");
        professionalPage.openContactProffessionalTab();
    }

    @Test(description = "Verify that the user can add/edit areas of expertise")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT887: Add/Edit Areas of Expertise and Industries")
    public void verifyAreasOfExpertiseAddAndEdit() {
        professionalPage.verifyAddAreasOfExpertise();
    }

    @Test(description = "Verify that the user can add/edit industries")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT887: Add/Edit Areas of Expertise and Industries")
    public void verifyIndustriesEdit() {
        professionalPage.verifyAddIndustries();
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) driver.quit();
    }
}
