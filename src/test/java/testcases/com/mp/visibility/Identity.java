package testcases.com.mp.visibility;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.DashboardPageObject;
import actions.pageObjects.IdentityPageObject;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Identity extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private IdentityPageObject identityPage;

    private String nonExistIdentity = "Non-exist Identity" + randomNumber();

    private String identityName = "IdentityName" + randomNumber();
    private String fullName = "Full Name " + randomNumber();
    private String emailAddress = "selenium" + randomNumber() + "@gmail.com";
    private String password = "123456";
    private String repeatPassword = "123456";

    private String fullNameEdited = "Full Name Edited " + randomNumber();
    private String emailAddressEdited = "selenium_edited" + randomNumber() + "@gmail.com";

    @BeforeClass
    public void beforeClass() {
        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        identityPage = dashboardPage.goToIdentityPage(driver);
    }

    @Test
    public void Identity_01_No_Data_Available(Method method) {
        ExtentTestManager.startTest(method.getName(), "Identity: Verify that the 'No Data Available' message displays when searching with non-exist identity");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 01: Enter keywords into search textbox");
        identityPage.inputToIdentitySearchTextbox(nonExistIdentity);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 02: Click Filter button");
        identityPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 03: Verify that the message 'No Data Available' is displayed");
        verifyTrue(identityPage.isNoDataAvailableMessageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 04: Click Reset button");
        identityPage.clickResetButton();
    }

    @Test
    public void Identity_02_Create_A_New_Identity(Method method) {
        ExtentTestManager.startTest(method.getName(), "Identity: Verify that the new identity is created successfully ");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 01: Click 'Add New Identity' button");
        identityPage.clickAddNewIdentityButton();

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 02: Enter identity name is: " + identityName);
        identityPage.inputToTextboxByID("username", identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 03: Enter Full Name is: " + fullName);
        identityPage.inputToTextboxByID("fullname", fullName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 04: Enter email address is: " + emailAddress);
        identityPage.inputToTextboxByID("email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 05: Enter password is: " + password);
        identityPage.inputToTextboxByID( "password", password);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 06: Enter repeat password is: " + repeatPassword);
        identityPage.inputToTextboxByID( "password-repeat", repeatPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 07: Select tenant from dropdown list ");
        identityPage.selectTenantByName("N0003");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 08: Select Group from dropdown list ");
        identityPage.selectGroupByName("N0003");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 09: Select time zone from dropdown list ");
        identityPage.selectTimeZoneByName("Asia/Ho_Chi_Minh");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 10: Click 'Create Identity' button");
        identityPage.clickCreateIdentityButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 11: Verify the success message is displayed");
        verifyEquals(identityPage.getSuccessMessage(driver), "Identity " + identityName + " was created successfully!");

        identityPage.waitForSuccessMessageUndisplayed(driver);

    }

    @Test
    public void Identity_03_Enable_The_New_Identity(Method method) {
        ExtentTestManager.startTest(method.getName(), "Identity: Verify that the new identity is enabled successfully ");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 01: Enter keywords into search textbox");
        identityPage.inputToIdentitySearchTextbox(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 02: Click Filter button");
        identityPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 03: Click Disable/Enable button");
        identityPage.clickIdentityStatusButtonByIdentityName(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 04: Select Enable option");
        identityPage.selectEnableOptionByIdentityName(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Accept alert");
        identityPage.acceptAlert(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Verify the success message is displayed");
        verifyEquals(identityPage.getSuccessMessage(driver), "Identity \"" + identityName + "\" is enabled.");

        identityPage.waitForSuccessMessageUndisplayed(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 07: Reset filter textbox by clicking Reset button");
        identityPage.clickResetButton();
    }

    @Test
    public void Identity_04_Personate_Identity(Method method) {
        ExtentTestManager.startTest(method.getName(), "Identity: Verify that the identity is edited successfully ");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 01: Enter keywords into search textbox");
        identityPage.inputToIdentitySearchTextbox(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 02: Click Filter button");
        identityPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 03: Click Personate button");
        identityPage.clickPersonateButtonByIdentityName(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Accept alert");
        identityPage.acceptAlert(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify the name of current user");
        verifyEquals(identityPage.getFullNameOfCurrentUser(), fullName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 06: Click close Personate icon");
        identityPage.clickClosePersonateIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Accept alert");
        identityPage.acceptAlert(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Verify the name of current user");
        verifyEquals(identityPage.getFullNameOfCurrentUser(), "Administrator");

    }

    @Test
    public void Identity_05_Edit_The_Identity(Method method) {
        ExtentTestManager.startTest(method.getName(), "Identity: Verify that the identity is edited successfully ");
        identityPage = dashboardPage.goToIdentityPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 01: Enter keywords into search textbox");
        identityPage.inputToIdentitySearchTextbox(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 02: Click Filter button");
        identityPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 03: Click Edit button");
        identityPage.clickEditButtonByIdentityName(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 04: Enter new Full Name is: " + fullNameEdited);
        identityPage.inputToTextboxByID("fullname", fullNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 05: Enter new email address is: " + emailAddressEdited);
        identityPage.inputToTextboxByID("email", emailAddressEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 06: Select tenant from dropdown list ");
        identityPage.selectTenantByName("D0034");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 07: Select Group from dropdown list ");
        identityPage.selectGroupByName("D0034_ADMIN");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 08: Select time zone from dropdown list ");
        identityPage.selectTimeZoneByName("Asia/Hong_Kong");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 09: Click 'Update Identity' button");
        identityPage.clickUpdateIdentityButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 10: Verify the success message is displayed");
        verifyEquals(identityPage.getSuccessMessage(driver), "Identity " + identityName + " was updated successfully!");

        identityPage.waitForSuccessMessageUndisplayed(driver);

    }

    @Test
    public void Identity_06_Delete_The_Identity(Method method) {
        ExtentTestManager.startTest(method.getName(), "Identity: Verify that the identity is deleted successfully ");

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 01: Enter keywords into search textbox");
        identityPage.inputToIdentitySearchTextbox(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 02: Click Filter button");
        identityPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Identity - Step 03: Click Delete button");
        identityPage.clickDeleteButtonByIdentityName(identityName);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Accept alert");
        identityPage.acceptAlert(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify the success message is displayed");
        verifyEquals(identityPage.getSuccessMessage(driver), "Identity " + identityName + " was deleted successfully!");

        identityPage.waitForSuccessMessageUndisplayed(driver);
    }
}
