package actions.pageObjects;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.pageUI.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver=driver;
    }

    public void inputToUsernameTextbox(String userName) {
        waitForElementClickable(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputToCaptchaTextbox(String captcha) {
        waitForElementClickable(driver, LoginPageUI.CAPTCHA_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.CAPTCHA_TEXTBOX, captcha);
    }

    public DashboardPageObject clickSignInButton() {
        waitForElementClickable(driver, LoginPageUI.SIGN_IN_BUTTON);
        clickToElement(driver, LoginPageUI.SIGN_IN_BUTTON);
        return PageGeneratorManager.getDashboardPage(driver);
    }

}
