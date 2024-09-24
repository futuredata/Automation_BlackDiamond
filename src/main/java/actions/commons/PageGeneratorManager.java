package actions.commons;

import actions.pageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboardPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }

    public static CorrelationPageObject getCorrelationPage(WebDriver driver){
        return new CorrelationPageObject(driver);
    }
    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }

    public static IdentityPageObject getIdentityPage(WebDriver driver){
        return new IdentityPageObject(driver);
    }
    public static TenantPageObject getTenantPage(WebDriver driver){
        return new TenantPageObject(driver);
    }
}

