package testcases.com.mp.login;

import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.DashboardPageObject;
import actions.pageObjects.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Login_01 extends BaseTest {
    // Declare
    private WebDriver driver;

    // Declare + Init
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;

    private String userName, password, captcha;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        userName = "admin";
        password ="123456";
        captcha = "";

        driver = getBrowserDriver(browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.openPageUrl(driver, GlobalConstants.MP_HK_DEV_PAGE_URL);

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);

    }

//    @AfterClass (alwaysRun = true)
//    public void afterClass() {
//        closeBrowserAndDriver();
//    }
//
    @BeforeClass
    public void Login_01_With_Valid_Account() {
        loginPage.inputToUsernameTextbox(userName);
        loginPage.inputToPasswordTextbox(password);
        sleepInSecond(15);

        loginPage.inputToCaptchaTextbox(captcha);

        dashboardPage = loginPage.clickSignInButton();
    }

}
