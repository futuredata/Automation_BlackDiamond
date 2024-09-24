package testcases.com.mp.search;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.DashboardPageObject;
import actions.pageObjects.SearchPageObject;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Search_04_Chart extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private SearchPageObject searchPage;

    private String searchQuery = "tenantname:D0034";
    private String searchTimeRange = "Last 15 minutes";

    @BeforeClass
    public void beforeClass() {
        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        searchPage = dashboardPage.gotoSearchPage(driver);

        searchPage.clickSearchTimeRangeDropdown();
        searchPage.selectATimeRangeByName(searchTimeRange);

        //searchPage.inputToSearchTextbox(searchQuery);
        searchPage.clickSearchIcon();
    }

    @Test
    public void Search_10_Generate_Chart_Successfully(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Generate chart for MappedSeverity field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click MappedSeverity field");
        if (searchPage.isTypeOfChartByNameUnDisplayed("Generate chart")) {
            searchPage.clickFieldByID("mappedseverity");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click Generate chart");
        searchPage.clickTypeOfChartByName("Generate chart");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the chart is displayed in the right side");
        verifyTrue(searchPage.isGraphByIDDisplayed("mappedseverity"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'X' icon to close the chart");
        searchPage.clickCloseGraphIcon();

    }

    @Test
    public void Search_11_Create_Quick_Value_Successfully(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Quick Values for MappedSeverity field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click MappedSeverity field");
        if ((searchPage.isTypeOfChartByNameUnDisplayed("Quick Values"))) {
            searchPage.clickFieldByID("mappedseverity");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click Quick Values");
        searchPage.clickTypeOfChartByName("Quick Values");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the Quick Values is displayed in the right side");
        verifyTrue(searchPage.isQuickValuesByIDDisplayed("mappedseverity"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'X' icon to close the Quick Values");
        searchPage.clickCloseQuickValuesIcon();

    }

    @Test
    public void Search_12_Create_Statistics_Successfully(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Statistics for MappedSeverity field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click MappedSeverity field");
        if ((searchPage.isTypeOfChartByNameUnDisplayed("Statistics"))) {
            searchPage.clickFieldByID("mappedseverity");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click Statistics");
        searchPage.clickTypeOfChartByName("Statistics");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the Statistics is displayed in the right side");
        verifyTrue(searchPage.isStatisticsByIDDisplayed("mappedseverity"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'X' icon to close the Statistics");
        searchPage.clickCloseStatisticsIcon();

    }

    @Test
    public void Search_13_Create_World_Map_Successfully(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: World Map for CourierIP (couip) field");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click CourierIP (couip) field");
        if (searchPage.isTypeOfChartByNameUnDisplayed("World Map")) {
            searchPage.clickFieldByID("colip");
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click World Map");
        searchPage.clickTypeOfChartByName("World Map");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify that the World Map is displayed in the right side");
        verifyTrue(searchPage.isWorldMapDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click 'X' icon to close the World Map");
        searchPage.clickCloseSWorldMapIcon();

    }
}
