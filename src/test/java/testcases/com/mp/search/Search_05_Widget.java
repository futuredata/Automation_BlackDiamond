package testcases.com.mp.search;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.DashboardPageObject;
import actions.pageObjects.SearchPageObject;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Search_05_Widget extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private SearchPageObject searchPage;

    private String searchQuery = "tenantname:D0034";
    private String searchTimeRange = "Last 15 minutes";
    private String dashboardTitle = "Selenium_" + randomNumber();
    private String dashboardDescription = "Selenium_" + randomNumber();

    private String widgetTitle = "Selenium_" + randomNumber();
    private String widgetTitleEdited = "Selenium_Edited_" + randomNumber();
    private String graphWidgetTitle = "Selenium_Graph_" + randomNumber();
    private String quickValueWidgetTitle = "Selenium_Quick_Value_" + randomNumber();
    private String statisticsWidgetTitle = "Selenium_Statistics_" + randomNumber();
    private String worldMapWidgetTitle = "Selenium_World_Map_" + randomNumber();


    @BeforeClass
    public void beforeClass() {
        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        searchPage = dashboardPage.gotoSearchPage(driver);

        searchPage.clickSearchTimeRangeDropdown();
        searchPage.selectATimeRangeByName(searchTimeRange);

        //searchPage.inputToSearchTextbox(searchQuery);
        searchPage.clickSearchIcon();

        //Create a new dashboard
        searchPage.clickAddCountToDashboard();
        searchPage.clickCreateNewDashboard();
        searchPage.inputToDashboardTitleTextbox(dashboardTitle);
        searchPage.inputToDashboardDescriptionTextbox(dashboardDescription);
        searchPage.clickSaveDashboardButton();

        verifyEquals(searchPage.getSuccessMessage(), "Dashboard created successfully.");

        searchPage.waitForSuccessMessageUndisplayed(driver);

    }

    @Test
    public void Search_14_Create_A_Widget_From_Search_Results(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Create a widget from Search Results");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter the new widget title into Title textbox");
        searchPage.inputToWidgetTitleTextbox(widgetTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click Create button");
        searchPage.clickCreateWidgetButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the success message is displayed");
        verifyEquals(searchPage.getSuccessMessage(), "Widget created successfully.");

        searchPage.clickCancelButton();

    }

    @Test
    public void Search_15_Create_A_Widget_From_Chart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Create a widget from the generated chart of MappedSeverity field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click MappedSeverity field");
        if (searchPage.isTypeOfChartByNameUnDisplayed("Generate chart")) {
            searchPage.clickFieldByID("mappedseverity");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click Generate chart");
        searchPage.clickTypeOfChartByName("Generate chart");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the chart is displayed in the right side");
        verifyTrue(searchPage.isGraphByIDDisplayed("mappedseverity"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'Add to dashboard' button");
        searchPage.clickAddToDashboardButtonByChartType("graphs");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Select dashboard name is: " + dashboardTitle);
        searchPage.clickAddToDashboardNameByChartType("graphs", dashboardTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Enter the new widget title into Title textbox");
        searchPage.inputToWidgetTitleTextbox(graphWidgetTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click Create button");
        searchPage.clickCreateButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Click Cancel button");
        searchPage.clickCancelButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 09: Verify that the success message is displayed");
        verifyEquals(searchPage.getSuccessMessage(), "Widget created successfully.");
    }

    @Test
    public void Search_16_Create_A_Widget_From_Quick_Values(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Create a widget from the Quick Values of MappedSeverity field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click MappedSeverity field");
        if (searchPage.isTypeOfChartByNameUnDisplayed("Quick Values")) {
            searchPage.clickFieldByID("mappedseverity");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click Quick Values");
        searchPage.clickTypeOfChartByName("Quick Values");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the chart is displayed in the right side");
        verifyTrue(searchPage.isQuickValuesByIDDisplayed("mappedseverity"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'Add to dashboard' button");
        searchPage.clickAddToDashboardButtonByChartType("quick-values");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Select dashboard name is: " + dashboardTitle);
        searchPage.clickAddToDashboardNameByChartType("quick-values", dashboardTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Enter the new widget title into Title textbox");
        searchPage.inputToWidgetTitleTextbox(quickValueWidgetTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click Create button");
        searchPage.clickCreateButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Click Cancel button");
        searchPage.clickCancelButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 09: Verify that the success message is displayed");
        verifyEquals(searchPage.getSuccessMessage(), "Widget created successfully.");
    }

    @Test
    public void Search_17_Create_A_Widget_From_Statistics(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Create a widget from the Statistics of MappedSeverity field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click MappedSeverity field");
        if (searchPage.isTypeOfChartByNameUnDisplayed("Statistics")) {
            searchPage.clickFieldByID("mappedseverity");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click Statistics");
        searchPage.clickTypeOfChartByName("Statistics");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the chart is displayed in the right side");
        verifyTrue(searchPage.isStatisticsByIDDisplayed("mappedseverity"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'Add to dashboard' button");
        searchPage.clickAddToDashboardButtonByChartType("statistics");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Select dashboard name is: " + dashboardTitle);
        searchPage.clickAddToDashboardNameByChartType("statistics", dashboardTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Enter the new widget title into Title textbox");
        searchPage.inputToWidgetTitleTextbox(statisticsWidgetTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click Create button");
        searchPage.clickCreateButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Click Cancel button");
        searchPage.clickCancelButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 09: Verify that the success message is displayed");
        verifyEquals(searchPage.getSuccessMessage(), "Widget created successfully.");
    }

    @Test
    public void Search_18_Create_A_Widget_From_World_Map(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Create a widget from the World Map of CourierIP (couip) field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click CourierIP (couip) field");
        if (searchPage.isTypeOfChartByNameUnDisplayed("World Map")) {
            searchPage.clickFieldByID("couip");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click World Map");
        searchPage.clickTypeOfChartByName("World Map");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the map is displayed in the right side");
        verifyTrue(searchPage.isWorldMapDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'Add to dashboard' button");
        searchPage.clickAddToDashboardButtonByChartType("map");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Select dashboard name is: " + dashboardTitle);
        searchPage.clickAddToDashboardNameByChartType("map", dashboardTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Enter the new widget title into Title textbox");
        searchPage.inputToWidgetTitleTextbox(worldMapWidgetTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click Create and Go To Dashboard button");
        searchPage.clickCreateAndGoToDashboardButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Verify that the success message is displayed");
        verifyEquals(searchPage.getSuccessMessage(), "Widget created successfully.");
    }

    @Test
    public void Search_19_Edit_Widget(Method method) {
        ExtentTestManager.startTest(method.getName(), "Dashboard: Edit the graph widget");
        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 01: Click Play button");
        dashboardPage.clickPlayButton();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 02: Verify that the widget is displayed");
        verifyTrue(dashboardPage.isWidgetDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 03: Click Unlock/Edit button");
        dashboardPage.clickUnlockAndEditButton();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 04: Click Edit icon of the widget: " + graphWidgetTitle);
        dashboardPage.clickEditIconByWidgetTitle(graphWidgetTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 05: Enter the edited widget name into Name textbox");
        dashboardPage.inputToWidgetNameTextbox(widgetTitleEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 06: Click Update button");
        dashboardPage.clickUpdateButton();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 07: Verify that the success message is displayed");
        verifyEquals(dashboardPage.getSuccessMessage(), "Widget updated successfully.");

    }

    @Test
    public void Search_20_Delete_Widget(Method method) {
        ExtentTestManager.startTest(method.getName(), "Dashboard: Delete the widget");

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 01: Click Delete icon of the widget: " + widgetTitleEdited);
        dashboardPage.clickDeleteIconByWidgetTitle(widgetTitleEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 02: Accept the alert");
        dashboardPage.acceptAlert();

        ExtentTestManager.getTest().log(Status.INFO, "Dashboard - Step 03: Verify that the widget is disappeared from Dashboard");
        verifyTrue(dashboardPage.isWidgetDisappearedFromDashboard(widgetTitleEdited));

    }

    @AfterClass
    public void afterClass() {
        dashboardPage.clickGoToDashboardListPage();
        dashboardPage.clickMoreActionsButtonByDashboardName(dashboardTitle);
        dashboardPage.clickDeleteThisDashboardOptionByDashboardName(dashboardTitle);
        dashboardPage.acceptAlert();
        verifyEquals(dashboardPage.getSuccessMessage(), "Dashboard deleted successfully.");
        dashboardPage.waitForSuccessMessageUndisplayed();
    }

}
