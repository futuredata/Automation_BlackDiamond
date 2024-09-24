package testcases.com.mp.dashboard;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.DashboardPageObject;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Dashboard extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;

    private String ip = "AUTO" + randomNumber();
    private String ipEdited = "EDITEDIP" + randomNumber();

    private String dashboardTitle = "Selenium " + randomNumber();
    private String dashboardDescription = "Selenium " + randomNumber();

    private String dashboardTitleEdited = "Selenium Edited " + randomNumber();
    private String dashboardDescriptionEdited = "Selenium Edited " + randomNumber();

    //@Parameters({"browser"})
    @BeforeClass
    public void beforeClass() {

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);

    }

    @Test
    public void Dashboard_01_Click_Play_Button(Method method) {
        ExtentTestManager.startTest(method.getName(), "Dashboard: Verify that the widget is displayed when clicking Play button");

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 01: Click Play button");
        dashboardPage.clickPlayButton();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 02: Verify that the widget is displayed");
        verifyTrue(dashboardPage.isWidgetDisplayed());

    }

    @Test
    public void Dashboard_02_Create_New_Dashboard(Method method) {
        ExtentTestManager.startTest(method.getName(), "Dashboard: Verify that the dashboard is created successfully");

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 01: Click 'Go To Dashboard List' button");
        dashboardPage.clickGoToDashboardListPage();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 02: Click 'Create Dashboard' button");
        dashboardPage.clickCreateDashboardButton();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 03: Enter to Title textbox");
        dashboardPage.inputToTitleTextbox(dashboardTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 04: Enter to Description textbox");
        dashboardPage.inputToDescriptionTextbox(dashboardDescription);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 05: Click 'Save' button");
        dashboardPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 06: Verify that the success message is displayed");
        verifyEquals(dashboardPage.getSuccessMessage(), "Dashboard created successfully.");

        dashboardPage.waitForSuccessMessageUndisplayed();
    }

    @Test
    public void Dashboard_03_Edit_Dashboard(Method method) {
        ExtentTestManager.startTest(method.getName(), "Dashboard: Verify that the dashboard is edited successfully");

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 01: Click 'Edit Dashboard' button");
        dashboardPage.clickEditDashboardButtonByDashboardName(dashboardTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 02: Enter to Title textbox");
        dashboardPage.inputToTitleTextbox(dashboardTitleEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 03: Enter to Description textbox");
        dashboardPage.inputToDescriptionTextbox(dashboardDescriptionEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 04: Click 'Save' button");
        dashboardPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 05: Verify that the success message is displayed");
        verifyEquals(dashboardPage.getSuccessMessage(), "Dashboard updated successfully");

        dashboardPage.waitForSuccessMessageUndisplayed();
    }


    @Test
    public void Dashboard_04_Set_As_Start_Page_Dashboard(Method method) {
        ExtentTestManager.startTest(method.getName(), "Dashboard: Verify that the dashboard is set as startpage successfully");

        String originalDefaultDashboardName = dashboardPage.getDefaultDashboardName();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 01: Click 'More actions' button");
        dashboardPage.clickMoreActionsButtonByDashboardName(dashboardTitleEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 02: Click 'Set as startpage' button");
        dashboardPage.clickSetAsStartPageOptionByDashboardName(dashboardTitleEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 03: Verify that the success message is displayed");
        verifyEquals(dashboardPage.getSuccessMessage(), "Your start page was changed successfully");

        dashboardPage.waitForSuccessMessageUndisplayed();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 04: Verify that the dashboard is set as default successfully");
        String newDefaultDashboardName = dashboardPage.getDefaultDashboardName();
        verifyEquals(newDefaultDashboardName, dashboardTitleEdited);

        //Reset data for default dashboard
        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 05: Click 'More actions' button of original default dashboard");
        dashboardPage.clickMoreActionsButtonByDashboardName(originalDefaultDashboardName);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 06: Click 'Set as startpage' button of original default dashboard");
        dashboardPage.clickSetAsStartPageOptionByDashboardName(originalDefaultDashboardName);

        dashboardPage.waitForSuccessMessageUndisplayed();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 07: Verify that the default dashboard is reset successfully");
        String finalDefaultDashboardName = dashboardPage.getDefaultDashboardName();
        verifyEquals(finalDefaultDashboardName, originalDefaultDashboardName);

    }

    @Test
    public void Dashboard_05_Delete_Dashboard(Method method) {
        ExtentTestManager.startTest(method.getName(), "Dashboard: Verify that the dashboard is deleted successfully");

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 01: Click 'More actions' button");
        dashboardPage.clickMoreActionsButtonByDashboardName(dashboardTitleEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 02: Click 'Delete this dashboard' button");
        dashboardPage.clickDeleteThisDashboardOptionByDashboardName(dashboardTitleEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 03: Accept alert");
        dashboardPage.acceptAlert();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 04: Verify that the success message is displayed");
        verifyEquals(dashboardPage.getSuccessMessage(), "Dashboard deleted successfully.");

        dashboardPage.waitForSuccessMessageUndisplayed();
    }

}
