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

public class Search_02_Saved_Search extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private SearchPageObject searchPage;

    private String searchQuery = "tenantname:D0034";
    private String searchTimeRange = "Last 12 hours";
    private String saveSearchTitle = "Selenium" + randomNumber();
    private String saveSearchTitleUpdated = "Selenium Updated" + randomNumber();

    @BeforeClass
    public void beforeClass() {
        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        searchPage = dashboardPage.gotoSearchPage(driver);
    }

    @Test
    public void Search_04_Save_Search_Criteria(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Verify that save search function works correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click time range dropdown");
        searchPage.clickSearchTimeRangeDropdown();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select the 'Last 12 hours' time range from dropdown list");
        searchPage.selectATimeRangeByName(searchTimeRange);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Enter search query is 'tenantname:D0034' into search textbox");
        searchPage.inputToSearchTextbox(searchQuery);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click Search icon");
        searchPage.clickSearchIcon();

        try {
            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Click Saved Search dropdown list");
            searchPage.clickSavedSearchDropdown();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Select 'Save Search Criteria' option from the dropdown list");
            searchPage.selectSaveSearchCriteriaOption();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Enter the save search title into Title textbox");
            searchPage.inputToTitleTextbox(saveSearchTitle);

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Click Save button");
            searchPage.clickSaveButton();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 09: Verify the success message is displayed");
            verifyEquals(searchPage.getSuccessMessage(), "Search criteria saved as '" + saveSearchTitle + "'.");

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 10: Refresh the Search page to clear search criteria");
            searchPage.refreshCurrentPage(driver);

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 11: Click 'Saved Searches' arrow icon");
            searchPage.clickSavedSearchesArrowIcon();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 12: Enter the saved search title into Saved Searches textbox");
            searchPage.inputToSavedSearchesTextbox(saveSearchTitle);

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 13: Verify that the search time range is loaded correctly from the saved search");
            verifyEquals(searchPage.getCurrentSearchTimeRange(), searchTimeRange);

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 14: Verify that the search query is loaded correctly from the saved search");
            verifyEquals(searchPage.getCurrentSearchQuery("value"), searchQuery);

        } catch (Exception e) {
            ExtentTestManager.getTest().skip("Exception: There is no data to create the save search. Please check your search criteria.");
        }
    }

    @Test
    public void Search_05_Update_Saved_Search(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Verify that the saved search title is updated successfully");
        try {
            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click Saved Search dropdown list");
            searchPage.clickSavedSearchDropdown();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select 'Update saved search title' option from the dropdown list");
            searchPage.selectUpdateSavedSearchTitleOption();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Enter the new save search title into Title textbox");
            searchPage.inputToTitleTextbox(saveSearchTitleUpdated);

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click Save button");
            searchPage.clickSaveButton();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Verify the success message is displayed");
            verifyEquals(searchPage.getSuccessMessage(), "Saved search '" + saveSearchTitleUpdated + "' was updated.");



        } catch (Exception e) {
            ExtentTestManager.getTest().skip("Exception: There is no saved search to update. Please check the create save test case.");
        }
    }

    @Test
    public void Search_06_Delete_Saved_Search(Method method) {
        searchPage.waitForSuccessMessageIsNotVisible();

        ExtentTestManager.startTest(method.getName(), "Search: Verify that the saved search is deleted successfully");

        try {
            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click Saved Search dropdown list");
            searchPage.clickSavedSearchDropdown();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select 'Delete saved search' option from the dropdown list");
            searchPage.selectDeleteSavedSearchOption();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Accept alert");
            searchPage.acceptAlert();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify the success message is displayed");
            verifyEquals(searchPage.getSuccessMessage(), "Saved search \"" + saveSearchTitleUpdated + "\" was deleted successfully.");

            searchPage.refreshCurrentPage(driver);

        } catch (Exception e) {
            ExtentTestManager.getTest().skip("Exception: There is no saved search to delete. Please check the update saved test case.");
        }
    }

}
