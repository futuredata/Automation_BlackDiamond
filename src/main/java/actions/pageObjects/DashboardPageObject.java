package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUI.DashboardPageUI;
import org.openqa.selenium.WebDriver;


public class DashboardPageObject extends BasePage {
    WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlayButton() {
        waitForElementClickable(driver, DashboardPageUI.PLAY_BUTTON);
        clickToElement(driver, DashboardPageUI.PLAY_BUTTON);

        waitForElementUndisplayed(driver, DashboardPageUI.CANCEL_SEARCH_REQUEST_BUTTON);
    }

    public boolean isWidgetDisplayed() {
        waitForElementVisible(driver, DashboardPageUI.WIDGET_LIST);
        return isElementDisplayed(driver, DashboardPageUI.WIDGET_LIST);
    }

    public void clickGoToDashboardListPage() {
        waitForElementUndisplayed(driver, DashboardPageUI.CANCEL_SEARCH_REQUEST_BUTTON);
        waitForElementClickable(driver, DashboardPageUI.GO_TO_DASHBOARD_LIST_BUTTON);
        clickToElement(driver, DashboardPageUI.GO_TO_DASHBOARD_LIST_BUTTON);
    }

    public void clickCreateDashboardButton() {
        waitForElementClickable(driver, DashboardPageUI.CREATE_DASHBOARD_BUTTON);
        clickToElement(driver, DashboardPageUI.CREATE_DASHBOARD_BUTTON);
    }

    public void inputToTitleTextbox(String dashboardTitle) {
        waitForElementVisible(driver, DashboardPageUI.TITLE_TEXTBOX);
        sendkeyToElement(driver, DashboardPageUI.TITLE_TEXTBOX, dashboardTitle);
    }

    public void inputToDescriptionTextbox(String dashboardDescription) {
        waitForElementVisible(driver, DashboardPageUI.DESCRIPTION_TEXTBOX);
        sendkeyToElement(driver, DashboardPageUI.DESCRIPTION_TEXTBOX, dashboardDescription);
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, DashboardPageUI.SAVE_BUTTON);
        clickToElement(driver, DashboardPageUI.SAVE_BUTTON);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, DashboardPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, DashboardPageUI.SUCCESS_MESSAGE);
    }

    public void waitForSuccessMessageUndisplayed() {
        //waitForElementInvisible(driver, DashboardPageUI.SUCCESS_MESSAGE);
        waitForElementUndisplayed(driver, DashboardPageUI.SUCCESS_MESSAGE);
    }

    public void clickEditDashboardButtonByDashboardName(String dashboardTitle) {
        waitForElementClickable(driver, DashboardPageUI.EDIT_DASHBOARD_BUTTON_BY_DASHBOARD_NAME, dashboardTitle);
        clickToElement(driver, DashboardPageUI.EDIT_DASHBOARD_BUTTON_BY_DASHBOARD_NAME, dashboardTitle);
    }

    public void acceptAlert() {
        waitForAlertPresence(driver);
        acceptAlert(driver);
    }

    public void clickMoreActionsButtonByDashboardName(String dashboardTitle) {
        waitForElementClickable(driver, DashboardPageUI.MORE_ACTIONS_BUTTON_BY_DASHBOARD_NAME, dashboardTitle);
        clickToElement(driver, DashboardPageUI.MORE_ACTIONS_BUTTON_BY_DASHBOARD_NAME, dashboardTitle);
    }

    public void clickDeleteThisDashboardOptionByDashboardName(String dashboardTitle) {
        waitForElementClickable(driver, DashboardPageUI.DELETE_THIS_DASHBOARD_OPTION_BY_DASHBOARD_NAME, dashboardTitle);
        clickToElement(driver, DashboardPageUI.DELETE_THIS_DASHBOARD_OPTION_BY_DASHBOARD_NAME, dashboardTitle);
    }

    public String getDefaultDashboardName() {
        waitForElementVisible(driver, DashboardPageUI.DEFAULT_DASHBOARD);
        return getElementText(driver, DashboardPageUI.DEFAULT_DASHBOARD);
    }

    public void clickSetAsStartPageOptionByDashboardName(String dashboardTitle) {
        waitForElementClickable(driver, DashboardPageUI.SET_AS_START_PAGE_OPTION_BY_DASHBOARD_NAME, dashboardTitle);
        clickToElement(driver, DashboardPageUI.SET_AS_START_PAGE_OPTION_BY_DASHBOARD_NAME, dashboardTitle);
    }

    public void waitForGoToDashboardListButtonClickable() {
        waitForElementClickable(driver,DashboardPageUI.GO_TO_DASHBOARD_LIST_BUTTON);
    }

    public void clickUnlockAndEditButton() {
        waitForElementClickable(driver, DashboardPageUI.UNLOCK_EDIT_BUTTON);
        clickToElement(driver, DashboardPageUI.UNLOCK_EDIT_BUTTON);
    }

    public void clickEditIconByWidgetTitle(String widgetTitle) {
        waitForElementClickable(driver, DashboardPageUI.EDIT_WIDGET_ICON_BY_NAME, widgetTitle);
        clickToElement(driver, DashboardPageUI.EDIT_WIDGET_ICON_BY_NAME, widgetTitle);
    }

    public void clickUpdateButton() {
        waitForElementClickable(driver, DashboardPageUI.UPDATE_BUTTON);
        clickToElement(driver, DashboardPageUI.UPDATE_BUTTON);
    }

    public void clickDeleteIconByWidgetTitle(String widgetTitleEdited) {
        waitForElementClickable(driver, DashboardPageUI.DELETE_WIDGET_ICON_BY_NAME, widgetTitleEdited);
        clickToElement(driver, DashboardPageUI.DELETE_WIDGET_ICON_BY_NAME, widgetTitleEdited);
    }


    public void inputToWidgetNameTextbox(String widgetTitleEdited) {
        waitForElementVisible(driver, DashboardPageUI.WIDGET_NAME_TEXTBOX, widgetTitleEdited);
        sendkeyToElement(driver, DashboardPageUI.WIDGET_NAME_TEXTBOX, widgetTitleEdited);
    }

    public boolean isWidgetDisappearedFromDashboard(String widgetTitleEdited) {
        waitForElementInvisible(driver, DashboardPageUI.WIDGET_ITEM_BY_NAME, widgetTitleEdited);
        return isElementUndisplayed(driver, DashboardPageUI.WIDGET_ITEM_BY_NAME, widgetTitleEdited);
    }
}
