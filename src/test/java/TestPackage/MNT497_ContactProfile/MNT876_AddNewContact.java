package TestPackage.MNT497_ContactProfile;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.*;
import pages.*;

@Epic("MNT-497: Contact Profile")
@Feature("MNT-876: Add New Contact")
public class MNT876_AddNewContact {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON loginData;
    private SHAFT.TestData.JSON envData;
    private ContactsPage contactsPage;
    private CommonMethodsPage commonMethodsPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        loginData = new SHAFT.TestData.JSON("loginData.json");
        envData = new SHAFT.TestData.JSON("environmentData.json");
        commonMethodsPage = new CommonMethodsPage(driver);
        contactsPage = new ContactsPage(driver);
        driver.getDriver().navigate().to(envData.getTestData("sit"));
        commonMethodsPage.loginUsingExistingAccount(
            loginData.getTestData("authorizedEmail"),
            loginData.getTestData("validPassword")
        );
    }

    @Test(description = "Validate adding contact with only mandatory field successfully")
    @Description("When I enter first name and click add contact, Then I should see the contact added successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT-876: Add New Contact")
    public void addNewContactWithMandatoryFieldsOnly() {
        contactsPage.addNewContactWithFirstNameOnly("Amira");
    }

    @Test(description = "Validate adding contact with all fields successfully")
    @Description("When I enter all data and click add contact, Then I should see the contact added successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("MNT-876: Add New Contact")
    public void addNewContactWithAllFields() {
        contactsPage.addNewContactWithAllFields();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
