package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUI.CorrelationPageUI;
import org.openqa.selenium.WebDriver;


public class CorrelationPageObject extends BasePage {
    WebDriver driver;

    public CorrelationPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public String getPageHeader() {
        waitForElementVisible(driver, CorrelationPageUI.CORRELATION_MENU);
        return getElementText(driver, CorrelationPageUI.CORRELATION_MENU);
    }

    public void clickAddNewCENodeButton() {
        waitForElementClickable(driver, CorrelationPageUI.ADD_NEW_CE_NODE);
        clickToElement(driver, CorrelationPageUI.ADD_NEW_CE_NODE);
    }

    public void inputToIPTextbox(String ip) {
        waitForElementVisible(driver, CorrelationPageUI.IP_TEXTBOX);
        sendkeyToElement(driver, CorrelationPageUI.IP_TEXTBOX, ip);
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, CorrelationPageUI.SAVE_BUTTON);
        clickToElement(driver, CorrelationPageUI.SAVE_BUTTON);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, CorrelationPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, CorrelationPageUI.SUCCESS_MESSAGE);
    }

    public void clickEditIconByIP(String ip) {
        waitForElementClickable(driver, CorrelationPageUI.EDIT_NODE_ICON, ip);
        clickToElement(driver, CorrelationPageUI.EDIT_NODE_ICON, ip);
    }

    public void clickDeleteIconByIP(String ipEdited) {
        waitForElementClickable(driver, CorrelationPageUI.DELETE_NODE_ICON, ipEdited);
        clickToElement(driver, CorrelationPageUI.DELETE_NODE_ICON, ipEdited);
    }

    public void acceptAlert() {
        waitForAlertPresence(driver);
        acceptAlert(driver);
    }

    public void waitForSuccessMessageIsNotVisible() {
        waitForElementUndisplayed(driver, CorrelationPageUI.SUCCESS_MESSAGE);
    }
}
