package TestPackage.MNT1159_ProfessionalContactProfile;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.*;
import pages.*;

@Epic("MNT1159: Professional Contact Profile")
@Feature("MNT-886: Add/Edit Topics of Interest")
public class MNT886_TopicsOfinterestAddEdit {

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

    @Test(description = "Verify topics of interest add and edit")
    @Description("When a user adds or edits topics of interest, the contact profile should be updated")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT-886: Add/Edit Topics of Interest")
    public void verifyTopicsOfInterestAddAndEdit() throws InterruptedException {
        professionalPage.verifyTopicsOfIntrestAdd();
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) driver.quit();
    }
}
