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

public class Search_01 extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private SearchPageObject searchPage;
    private String searchQuery = "parsertype:MAGI";
    private int numberOfTriggeredEvt;

    @BeforeClass
    public void beforeClass() {

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        searchPage = dashboardPage.gotoSearchPage(driver);

    }

    @Test
    public void Search_01_With_Relative_TimeRange_Is_Last1Hour(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Verify search results when searching with relative time range");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click time range dropdown");
        searchPage.clickSearchTimeRangeDropdown();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select the 'Last 1 Hour' time range from dropdown list");
        searchPage.selectATimeRangeByName("Last 1 hour");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Click Search icon");
        searchPage.clickSearchIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify that the 'Messages' section appears if there is more than one message");
        if (searchPage.getMessageListSize() == 0)
            verifyTrue(searchPage.isNothingFoundMessageDisplayed());
        else
            searchPage.clickFirstMessageFromMessageList();
        verifyTrue(searchPage.isMessageDetailsDisplayed());
    }

    @Test
    public void Search_02_With_Relative_TimeRange_Is_Yesterday(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Verify search results when searching with relative time range");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click time range dropdown");
        searchPage.clickSearchTimeRangeDropdown();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select the 'Yesterday' time range from dropdown list");
        searchPage.selectATimeRangeByName("Yesterday");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Click Search icon");
        searchPage.clickSearchIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Verify that the 'Messages' section appears if there is more than one message");
        if (searchPage.getMessageListSize() == 0)
            verifyTrue(searchPage.isNothingFoundMessageDisplayed());
        else
            searchPage.clickFirstMessageFromMessageList();
        verifyTrue(searchPage.isMessageDetailsDisplayed());
    }

    @Test
    public void Search_03_View_Triggered_Event(Method method) {
        ExtentTestManager.startTest(method.getName(), "Search: Verify that the number of trigger events equal to the number of message found in triggered tab");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Click time range dropdown");
        searchPage.clickSearchTimeRangeDropdown();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Select the 'Last 3 days' time range from dropdown list");
        searchPage.selectATimeRangeByName("Last 3 days");

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Enter search query is " + searchQuery + " into search textbox");
        searchPage.inputToSearchTextbox(searchQuery);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click Search icon");
        searchPage.clickSearchIcon();

        try {
            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05: Click the first message from message list");
            searchPage.clickFirstMessageFromMessageList();

            verifyTrue(searchPage.isMessageDetailsDisplayed());

            numberOfTriggeredEvt = searchPage.getTheNumberOfTriggeredEvt();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 06: Click the first 'View Trigger' button from message list");
            searchPage.clickFirstViewTriggerButton();

            verifyEquals(searchPage.getSuccessMessage(), "A new tab was added!");

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 07: Click Triggered tab");
            searchPage.clickTriggeredTab();

            searchPage.getTheNumberOfMessageFound();

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 08: Verify that the number of trigger events equal to the number of message found in triggered tab");
            verifyEquals(searchPage.getTheNumberOfMessageFound(), numberOfTriggeredEvt);

            ExtentTestManager.getTest().log(Status.INFO, "Search - Step 09: Click close icon of the triggered tab");
            searchPage.clickFirstCloseTriggeredTabIcon();

        } catch (Exception e) {
            ExtentTestManager.getTest().skip("Exception: There is no triggered event. Please check your search criteria.");
        }
    }

}
