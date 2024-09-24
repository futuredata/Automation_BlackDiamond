package testcases.com.mp.common;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.DashboardPageObject;
import actions.pageObjects.LoginPageObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LoginSuccessfullyAsAdmin extends BaseTest {

    // Declare + Init
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;

    private String userName, password, captcha;

    @Parameters({"browser", "environment"})
    @BeforeTest
    public void beforeTest(String browserName, String environment) {

        //driver = getBrowserDriver(browserName);
        driver = getBrowserDriver(browserName, environment);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        userName = "admin";
        password = "123456";
        captcha = "";

        loginPage.inputToUsernameTextbox(userName);
        loginPage.inputToPasswordTextbox(password);
        sleepInSecond(15);

        dashboardPage = loginPage.clickSignInButton();
        dashboardPage.waitForGoToDashboardListButtonClickable();
    }
    @AfterTest(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver();
    }
}
