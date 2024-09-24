package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUI.IdentityPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class IdentityPageObject extends BasePage {
    WebDriver driver;

    public IdentityPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNoDataAvailableMessageDisplayed() {
        waitForElementVisible(driver, IdentityPageUI.NO_DATA_AVAILABLE_MESSAGE);
        return isElementDisplayed(driver, IdentityPageUI.NO_DATA_AVAILABLE_MESSAGE);
    }

    public void clickFilterButton() {
        waitForElementClickable(driver, IdentityPageUI.FILTER_BUTTON);
        clickToElement(driver, IdentityPageUI.FILTER_BUTTON);
        //waitForElementVisible(driver, IdentityPageUI.TABLE_HEADER);
        sleepInSecond(2);
    }

    public void inputToIdentitySearchTextbox(String nonExistIdentity) {
        waitForElementVisible(driver, IdentityPageUI.FILTER_IDENTITY_TEXTBOX);
        sendkeyToElement(driver, IdentityPageUI.FILTER_IDENTITY_TEXTBOX, nonExistIdentity);
    }

    public void clickResetButton() {
        waitForElementClickable(driver, IdentityPageUI.RESET_BUTTON);
        clickToElement(driver, IdentityPageUI.RESET_BUTTON);
    }

    public void inputToTextboxByID(String textboxID, String value) {
        waitForElementVisible(driver, IdentityPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
        sendkeyToElement(driver, IdentityPageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
    }

    public void clickAddNewIdentityButton() {
        waitForElementClickable(driver, IdentityPageUI.ADD_NEW_IDENTITY_BUTTON);
        clickToElement(driver, IdentityPageUI.ADD_NEW_IDENTITY_BUTTON);
    }

    public void selectTenantByName(String tenantName) {
        waitForElementVisible(driver, IdentityPageUI.TENANT_DROPDOWN_LIST);
        selectItemInDefaultDropdown(driver, IdentityPageUI.TENANT_DROPDOWN_LIST, tenantName);
    }

    public void selectGroupByName(String groupName) {
        waitForElementVisible(driver, IdentityPageUI.GROUP_DROPDOWN_LIST);
        selectItemInDefaultDropdown(driver, IdentityPageUI.GROUP_DROPDOWN_LIST, groupName);
    }

    public void selectTimeZoneByName(String timeZone) {
        waitForElementClickable(driver, IdentityPageUI.CLEAR_TIME_ZONE_ICON);
        clickToElement(driver, IdentityPageUI.CLEAR_TIME_ZONE_ICON);

        waitForElementVisible(driver, IdentityPageUI.TIME_ZONE_TEXTBOX);
        sendkeyToElement(driver, IdentityPageUI.TIME_ZONE_TEXTBOX, timeZone);

        pressKeyToElement(driver, IdentityPageUI.TIME_ZONE_TEXTBOX, Keys.ENTER);
    }

    public void clickCreateIdentityButton() {
        waitForElementClickable(driver, IdentityPageUI.CREATE_IDENTITY_BUTTON);
        clickToElement(driver, IdentityPageUI.CREATE_IDENTITY_BUTTON);
    }

    public void clickIdentityStatusButtonByIdentityName(String identityName) {
        waitForElementClickable(driver, IdentityPageUI.DYNAMIC_USER_STATUS_BUTTON_BY_IDENTITY_NAME, identityName);
        clickToElement(driver, IdentityPageUI.DYNAMIC_USER_STATUS_BUTTON_BY_IDENTITY_NAME, identityName);
    }

    public void selectEnableOptionByIdentityName(String identityName) {
        waitForElementClickable(driver, IdentityPageUI.DYNAMIC_ENABLE_OPTION_BY_IDENTITY_NAME, identityName);
        clickToElement(driver, IdentityPageUI.DYNAMIC_ENABLE_OPTION_BY_IDENTITY_NAME, identityName);
    }

    public void clickDeleteButtonByIdentityName(String identityName) {
        waitForElementClickable(driver, IdentityPageUI.DYNAMIC_DELETE_BUTTON_BY_IDENTITY_NAME, identityName);
        clickToElement(driver, IdentityPageUI.DYNAMIC_DELETE_BUTTON_BY_IDENTITY_NAME, identityName);
    }

    public void clickUpdateIdentityButton() {
        waitForElementClickable(driver, IdentityPageUI.UPDATE_IDENTITY_BUTTON);
        clickToElement(driver, IdentityPageUI.UPDATE_IDENTITY_BUTTON);
    }

    public void clickEditButtonByIdentityName(String identityName) {
        waitForElementClickable(driver, IdentityPageUI.DYNAMIC_EDIT_BUTTON_BY_IDENTITY_NAME, identityName);
        clickToElement(driver, IdentityPageUI.DYNAMIC_EDIT_BUTTON_BY_IDENTITY_NAME, identityName);
    }

    public void clickPersonateButtonByIdentityName(String identityName) {
        waitForElementClickable(driver, IdentityPageUI.DYNAMIC_PERSONATE_BUTTON_BY_IDENTITY_NAME, identityName);
        clickToElement(driver, IdentityPageUI.DYNAMIC_PERSONATE_BUTTON_BY_IDENTITY_NAME, identityName);
    }

    public String getFullNameOfCurrentUser() {
        sleepInSecond(1);
        waitForElementVisible(driver, IdentityPageUI.FULL_NAME_OF_USER);
        return getElementText(driver, IdentityPageUI.FULL_NAME_OF_USER);
    }

    public void clickClosePersonateIcon() {
        waitForElementClickable(driver, IdentityPageUI.CLOSE_PERSONATE_ICON);
        clickToElement(driver, IdentityPageUI.CLOSE_PERSONATE_ICON);
    }
}
