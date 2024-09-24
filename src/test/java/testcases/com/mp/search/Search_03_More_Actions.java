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

public class Search_03_More_Actions extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private SearchPageObject searchPage;

    private String searchQuery = "tenantname:D0034";
    private String searchTimeRange = "Last 15 minutes";
    private String fileName = "Selenium_" + randomNumber();
    private String fullFileName = fileName + ".zip";

    @BeforeClass
    public void beforeClass() {
        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        searchPage = dashboardPage.gotoSearchPage(driver);

        searchPage.clickSearchTimeRangeDropdown();
        searchPage.selectATimeRangeByName(searchTimeRange);

        searchPage.inputToSearchTextbox(searchQuery);
        searchPage.clickSearchIcon();
    }

    @Test
    public void Search_07_Show_Solr_Query(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Open Solr Query popup");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click more actions dropdown");
        searchPage.clickMoreActionsDropdown();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select Show Query option");
        searchPage.selectShowQueryOption();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify the show query popup is displayed");
        verifyEquals(searchPage.getPopupTitle(), "Solr Query");

        searchPage.clickClosePopupIcon();

    }

    @Test
    public void Search_08_Export_Search_Results_As_CSV(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Verify that the export search results as CSV function works correctly ");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click more actions dropdown");
        searchPage.clickMoreActionsDropdown();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select Export As CSV option");
        searchPage.selectExportAsCSVOption();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Enter the csv file name into File Name textbox");
        searchPage.inputToFileNameTextbox(fileName);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click Export button");
        searchPage.clickExportButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify the success message is displayed");
        verifyEquals(searchPage.getSuccessMessage(), "Your export process is running. We will send a notification to your email when the process is finish");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Click Export List button");
        searchPage.clickExportListButton();

        while (searchPage.getExportStatusByFileName(fileName + ".zip").equalsIgnoreCase("EXPORTING")) {
            searchPage.clickClosePopupIcon();
            sleepInSecond(1);
            searchPage.clickExportListButton();
            sleepInSecond(1);
        }

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Verify that the exported file status is 'SUCCESS'");
        verifyEquals(searchPage.getExportStatusByFileName(fileName + ".zip"), "SUCCESS");

        searchPage.clickClosePopupIcon();

    }

    @Test
    public void Search_09_Delete_Exported_File(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Delete the exported file");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click Export List button");
        searchPage.clickExportListButton();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click delete icon of created file");

        searchPage.clickDeleteIconByFileName(fileName + ".zip");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Accept alert");
        searchPage.acceptAlert();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify the success message is displayed");
        verifyEquals(searchPage.getSuccessMessage(), "Exported file is deleted!");

        searchPage.waitForSuccessMessageIsNotVisible();
        searchPage.clickClosePopupIcon();
    }

}
