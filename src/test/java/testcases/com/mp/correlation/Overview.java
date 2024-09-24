package testcases.com.mp.correlation;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.CorrelationPageObject;
import actions.pageObjects.DashboardPageObject;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Overview extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private CorrelationPageObject correlationPage;

    private String ip = "AUTO" + randomNumber();
    private String ipEdited = "EDITEDIP" + randomNumber();

    @BeforeClass
    public void beforeClass() {

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);

        correlationPage = dashboardPage.goToCorrelationPage(driver);

    }

    @Test
    public void Overview_01_Verify_Page_Header(Method method) {
        ExtentTestManager.startTest(method.getName(), "Correlation - Overview: Verify page header");

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 01: Navigate to 'Correlation' page");
        correlationPage = dashboardPage.goToCorrelationPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 02: Verify page header is Correlation Engine");
        //Assert.assertEquals(correlationPage.getPageHeader(), "Correlation Engine1");
        verifyEquals(correlationPage.getPageHeader(), "Correlation Engine");
    }

    @Test
    public void Overview_02_Add_New_CE_Node(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify that the new CE node is created successfully");

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 01: Click 'Add New CE Node' button");
        correlationPage.clickAddNewCENodeButton();

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 02: Enter IP into IP textbox");
        correlationPage.inputToIPTextbox(ip);

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 03: Click Save button");
        correlationPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 04: Verify that the success message is displayed");
        verifyEquals(correlationPage.getSuccessMessage(), "Creating successfully.");

        correlationPage.waitForSuccessMessageIsNotVisible();
    }

    @Test
    public void Overview_03_Edit_CE_Node(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify that the new CE node is created successfully");

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 01: Click 'Edit' icon of " + ip + " node");
        correlationPage.clickEditIconByIP(ip);

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 02: Enter edited IP into IP textbox");
        correlationPage.inputToIPTextbox(ipEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 03: Click Save button");
        correlationPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 04: Verify that the success message is displayed");
        verifyEquals(correlationPage.getSuccessMessage(), "updating successfully.");

        correlationPage.waitForSuccessMessageIsNotVisible();
    }
    @Test
    public void Overview_04_Delete_CE_Node(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify that the new CE node is deleted successfully");

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 01: Click 'Delete' icon of " + ipEdited + " node");
        correlationPage.clickDeleteIconByIP(ipEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 02: Accept the browser alert");
        correlationPage.acceptAlert();

        ExtentTestManager.getTest().log(Status.INFO, "Overview - Step 03: Verify that the success message is displayed");
        verifyEquals(correlationPage.getSuccessMessage(), "Deleting successfully.");

        correlationPage.waitForSuccessMessageIsNotVisible();
    }
}
