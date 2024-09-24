package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUI.BasePageUI;
import interfaces.pageUI.SearchPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends BasePage {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchTimeRangeDropdown() {
        waitForElementClickable(driver, SearchPageUI.RELATIVE_TIMERANGE_DROPDOWN);
        clickToElement(driver, SearchPageUI.RELATIVE_TIMERANGE_DROPDOWN);
    }

    public void selectATimeRangeByName(String timeRangeName) {
        waitForElementClickable(driver, SearchPageUI.DYNAMIC_RELATIVE_TIMERANGE, timeRangeName);
        clickToElement(driver, SearchPageUI.DYNAMIC_RELATIVE_TIMERANGE, timeRangeName);
    }

    public void clickSearchIcon() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_ICON);
        clickToElement(driver, SearchPageUI.SEARCH_ICON);

        waitForElementUndisplayed(driver, SearchPageUI.CANCEL_SEARCH_REQUEST_BUTTON);
    }

    public int getMessageListSize() {
        waitForElementVisible(driver, SearchPageUI.MESSAGE_LIST);
        return getElementSize(driver, SearchPageUI.MESSAGE_LIST);
    }

    public boolean isNothingFoundMessageDisplayed() {
        waitForElementVisible(driver, SearchPageUI.NOTHING_FOUND_MESSAGE);
        return isElementDisplayed(driver, SearchPageUI.NOTHING_FOUND_MESSAGE);
    }

    public void clickFirstMessageFromMessageList() {
        clickToFirstElement(driver, SearchPageUI.MESSAGE_LIST);
    }

    public boolean isMessageDetailsDisplayed() {
        waitForElementVisible(driver, SearchPageUI.MESSAGE_DETAILS);
        return isElementDisplayed(driver, SearchPageUI.MESSAGE_DETAILS);
    }

    public void inputToSearchTextbox(String searchQuery) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        deleteTextInElement(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchQuery);
    }

    public void clickSavedSearchDropdown() {
        waitForElementUndisplayed(driver, SearchPageUI.CANCEL_SEARCH_REQUEST_BUTTON);
        waitForElementClickable(driver, SearchPageUI.SAVED_SEARCH_DROPDOWN);
        clickToElement(driver, SearchPageUI.SAVED_SEARCH_DROPDOWN);
    }

    public void selectSaveSearchCriteriaOption() {
        waitForElementClickable(driver, SearchPageUI.SAVE_SEARCH_CRITERIA_OPTION);
        clickToElement(driver, SearchPageUI.SAVE_SEARCH_CRITERIA_OPTION);
    }

    public void selectUpdateSavedSearchTitleOption() {
        waitForElementClickable(driver, SearchPageUI.UPDATE_SEARCH_CRITERIA_OPTION);
        clickToElement(driver, SearchPageUI.UPDATE_SEARCH_CRITERIA_OPTION);
    }

    public void selectDeleteSavedSearchOption() {
        waitForElementClickable(driver, SearchPageUI.DELETE_SAVED_SEARCH_OPTION);
        clickToElement(driver, SearchPageUI.DELETE_SAVED_SEARCH_OPTION);
    }

    public void inputToTitleTextbox(String saveSearchTitle) {
        waitForElementVisible(driver, SearchPageUI.SAVE_SEARCH_TITLE);
        sendkeyToElement(driver, SearchPageUI.SAVE_SEARCH_TITLE, saveSearchTitle);
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, SearchPageUI.SAVE_BUTTON);
        clickToElement(driver, SearchPageUI.SAVE_BUTTON);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE);
        return getElementText(driver, BasePageUI.SUCCESS_MESSAGE);
    }

    public void clickSavedSearchesArrowIcon() {
        waitForElementUndisplayed(driver, SearchPageUI.CANCEL_SEARCH_REQUEST_BUTTON);
        waitForElementClickable(driver, SearchPageUI.SAVED_SEARCHES_ARROW_ICON);
        clickToElement(driver, SearchPageUI.SAVED_SEARCHES_ARROW_ICON);
    }

    public void inputToSavedSearchesTextbox(String saveSearchTitle) {
        waitForElementVisible(driver, SearchPageUI.SAVED_SEARCHES_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.SAVED_SEARCHES_TEXTBOX, saveSearchTitle);

        pressKeyToElement(driver, SearchPageUI.SAVED_SEARCHES_TEXTBOX, Keys.ENTER);
    }

    public String getCurrentSearchTimeRange() {
        waitForElementVisible(driver, SearchPageUI.RELATIVE_TIMERANGE_DROPDOWN);
        return getElementText(driver, SearchPageUI.RELATIVE_TIMERANGE_DROPDOWN);
    }

    public String getCurrentSearchQuery(String value) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        return getElementAttribute(driver, SearchPageUI.SEARCH_TEXTBOX, value);
    }

    public void acceptAlert() {
        waitForAlertPresence(driver);
        acceptAlert(driver);
    }

    public void clickMoreActionsDropdown() {
        waitForElementClickable(driver, SearchPageUI.MORE_ACTIONS_DROPDOWN);
        clickToElement(driver, SearchPageUI.MORE_ACTIONS_DROPDOWN);
    }

    public void selectExportAsCSVOption() {
        waitForElementClickable(driver, SearchPageUI.EXPORT_AS_CSV_OPTION);
        clickToElement(driver, SearchPageUI.EXPORT_AS_CSV_OPTION);
    }

    public void inputToFileNameTextbox(String fileName) {
        waitForElementVisible(driver, SearchPageUI.FILE_NAME_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.FILE_NAME_TEXTBOX, fileName);
    }

    public void clickExportButton() {
        waitForElementClickable(driver, SearchPageUI.EXPORT_BUTTON);
        clickToElement(driver, SearchPageUI.EXPORT_BUTTON);
    }

    public void clickExportListButton() {
        waitForElementClickable(driver, SearchPageUI.EXPORT_LIST_BUTTON);
        clickToElement(driver, SearchPageUI.EXPORT_LIST_BUTTON);
        sleepInSecond(1);
    }

    public void clickClosePopupIcon() {
        waitForElementClickable(driver, SearchPageUI.CLOSE_POPUP_ICON);
        clickToElement(driver, SearchPageUI.CLOSE_POPUP_ICON);
    }

    public String getExportStatusByFileName(String fileName) {
        waitForElementVisible(driver, SearchPageUI.DYNACMIC_EXPORT_FILE_STATUS_BY_FILE_NAME, fileName);
        return getElementText(driver, SearchPageUI.DYNACMIC_EXPORT_FILE_STATUS_BY_FILE_NAME, fileName);
    }

    public void clickDeleteIconByFileName(String fileName) {
        waitForElementClickable(driver, SearchPageUI.DYNACMIC_DELETE_ICON_BY_FILE_NAME, fileName);
        clickToElement(driver, SearchPageUI.DYNACMIC_DELETE_ICON_BY_FILE_NAME, fileName);
    }

    public String getPopupTitle() {
        waitForElementVisible(driver, SearchPageUI.POPUP_TITLE);
        return getElementText(driver, SearchPageUI.POPUP_TITLE);
    }

    public void selectShowQueryOption() {
        waitForElementClickable(driver, SearchPageUI.SHOW_QUERY_OPTION);
        clickToElement(driver, SearchPageUI.SHOW_QUERY_OPTION);
    }

    public int getTheNumberOfTriggeredEvt() {
        waitForAllElementsVisible(driver, SearchPageUI.TRIGGERED_EVT_LIST);
        return getElementSize(driver, SearchPageUI.TRIGGERED_EVT_LIST);
    }

    public void clickTriggeredTab() {
        clickToFirstElement(driver, SearchPageUI.TRIGGERED_TAB_LIST);
        waitForElementUndisplayed(driver, SearchPageUI.CANCEL_SEARCH_REQUEST_BUTTON);
    }

    public int getTheNumberOfMessageFound() {
        waitForElementVisible(driver, SearchPageUI.NUMBER_OF_MESSAGE_FOUND);
        int numberOfMessageFound = Integer.parseInt(getElementText(driver, SearchPageUI.NUMBER_OF_MESSAGE_FOUND).split(" ")[0]);
        return numberOfMessageFound;
    }

    public void clickFirstCloseTriggeredTabIcon() {
        clickToFirstElement(driver, SearchPageUI.CLOSE_TRIGGERED_TAB_ICON_LIST);
    }

    public void clickFirstViewTriggerButton() {
        clickToFirstElement(driver, SearchPageUI.VIEW_TRIGGER_BUTTON_LIST);
    }

    public void waitForSuccessMessageIsNotVisible() {
        waitForElementUndisplayed(driver, BasePageUI.SUCCESS_MESSAGE);
    }

    public void clickFieldByID(String fieldID) {
        waitForElementClickable(driver, SearchPageUI.DYNAMIC_FIELD_BY_ID, fieldID);
        clickToElement(driver, SearchPageUI.DYNAMIC_FIELD_BY_ID, fieldID);
    }

    public void clickTypeOfChartByName(String chartName) {
        waitForElementClickable(driver, SearchPageUI.DYNAMIC_TYPE_OF_CHART_BY_NAME, chartName);
        clickToElement(driver, SearchPageUI.DYNAMIC_TYPE_OF_CHART_BY_NAME, chartName);
        waitForElementUndisplayed(driver, SearchPageUI.CANCEL_SEARCH_REQUEST_BUTTON);
    }

    public boolean isGraphByIDDisplayed(String fieldID) {
        waitForElementVisible(driver, SearchPageUI.DYNAMIC_GENERATE_CHART_RESULTS_BY_ID, fieldID);
        return isElementDisplayed(driver, SearchPageUI.DYNAMIC_GENERATE_CHART_RESULTS_BY_ID, fieldID);
    }

    public boolean isTypeOfChartByNameUnDisplayed(String chartName) {
        return isElementUndisplayed(driver, SearchPageUI.DYNAMIC_TYPE_OF_CHART_BY_NAME, chartName);
    }

    public boolean isQuickValuesByIDDisplayed(String fieldID) {
        waitForElementVisible(driver, SearchPageUI.DYNAMIC_QUICK_VALUES_RESULTS_BY_ID, fieldID);
        return isElementDisplayed(driver, SearchPageUI.DYNAMIC_QUICK_VALUES_RESULTS_BY_ID, fieldID);
    }

    public boolean isStatisticsByIDDisplayed(String fieldID) {
        waitForElementVisible(driver, SearchPageUI.DYNAMIC_STATISTICS_RESULTS_BY_ID, fieldID);
        return isElementDisplayed(driver, SearchPageUI.DYNAMIC_STATISTICS_RESULTS_BY_ID, fieldID);
    }

    public boolean isWorldMapDisplayed() {
        waitForElementVisible(driver, SearchPageUI.WORLD_MAP_RESULTS);
        return isElementDisplayed(driver, SearchPageUI.WORLD_MAP_RESULTS);
    }

    public void clickCloseGraphIcon() {
        waitForElementVisible(driver, SearchPageUI.CLOSE_GENERATE_CHART_RESULTS_ICON);
        waitForElementClickable(driver, SearchPageUI.CLOSE_GENERATE_CHART_RESULTS_ICON);
        clickToElement(driver, SearchPageUI.CLOSE_GENERATE_CHART_RESULTS_ICON);
    }

    public void clickCloseQuickValuesIcon() {
        waitForElementVisible(driver, SearchPageUI.CLOSE_QUICK_VALUES_RESULTS_ICON);
        waitForElementClickable(driver, SearchPageUI.CLOSE_QUICK_VALUES_RESULTS_ICON);
        clickToElement(driver, SearchPageUI.CLOSE_QUICK_VALUES_RESULTS_ICON);
    }

    public void clickCloseStatisticsIcon() {
        waitForElementVisible(driver, SearchPageUI.CLOSE_STATISTICS_RESULTS_ICON);
        waitForElementClickable(driver, SearchPageUI.CLOSE_STATISTICS_RESULTS_ICON);
        clickToElement(driver, SearchPageUI.CLOSE_STATISTICS_RESULTS_ICON);
    }

    public void clickCloseSWorldMapIcon() {
        waitForElementVisible(driver, SearchPageUI.CLOSE_WORLD_MAP_RESULTS_ICON);
        waitForElementClickable(driver, SearchPageUI.CLOSE_WORLD_MAP_RESULTS_ICON);
        clickToElement(driver, SearchPageUI.CLOSE_WORLD_MAP_RESULTS_ICON);
    }

    public void clickAddCountToDashboard() {
        waitForElementClickable(driver, SearchPageUI.ADD_COUNT_TO_DASHBOARD_BUTTON);
        clickToElement(driver, SearchPageUI.ADD_COUNT_TO_DASHBOARD_BUTTON);
    }

    public void clickCreateNewDashboard() {
        waitForElementClickable(driver, SearchPageUI.CREATE_NEW_DASHBOARD_BUTTON);
        clickToElement(driver, SearchPageUI.CREATE_NEW_DASHBOARD_BUTTON);
    }

    public void inputToDashboardTitleTextbox(String dashboardTitle) {
        waitForElementVisible(driver, SearchPageUI.DASHBOARD_TITLE_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.DASHBOARD_TITLE_TEXTBOX, dashboardTitle);
    }

    public void inputToDashboardDescriptionTextbox(String dashboardDescription) {
        waitForElementVisible(driver, SearchPageUI.DASHBOARD_DESCRIPTION_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.DASHBOARD_DESCRIPTION_TEXTBOX, dashboardDescription);
    }

    public void clickSaveDashboardButton() {
        waitForElementClickable(driver, SearchPageUI.SAVE_BUTTON);
        clickToElement(driver, SearchPageUI.SAVE_BUTTON);
    }

    public void inputToWidgetTitleTextbox(String widgetTitle) {
        waitForElementVisible(driver, SearchPageUI.WIDGET_TITLE_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.WIDGET_TITLE_TEXTBOX, widgetTitle);
    }

    public void clickCreateWidgetButton() {
        waitForElementClickable(driver, SearchPageUI.CREATE_BUTTON);
        clickToElement(driver, SearchPageUI.CREATE_BUTTON);
    }

    public void clickCancelButton() {
        waitForElementClickable(driver, SearchPageUI.CANCEL_BUTTON);
        clickToElement(driver, SearchPageUI.CANCEL_BUTTON);
    }

    public void clickAddToDashboardButtonByChartType(String chartType) {
        waitForElementClickable(driver, SearchPageUI.DYNAMIC_ADD_TO_DASHBOARD_BUTTON_BY_CHART_TYPE, chartType);
        clickToElement(driver, SearchPageUI.DYNAMIC_ADD_TO_DASHBOARD_BUTTON_BY_CHART_TYPE, chartType);
    }

    public void clickAddToDashboardNameByChartType(String chartType, String dashboardTitle) {
        waitForElementClickable(driver, SearchPageUI.DYNAMIC_DASHBOARD_NAME_BY_CHART_TYPE, chartType, dashboardTitle);
        clickToElement(driver, SearchPageUI.DYNAMIC_DASHBOARD_NAME_BY_CHART_TYPE, chartType, dashboardTitle);
    }

    public void clickCreateAndGoToDashboardButton() {
        waitForElementClickable(driver, SearchPageUI.CREATE_AND_GO_TO_DASHBOARD_BUTTON);
        clickToElement(driver, SearchPageUI.CREATE_AND_GO_TO_DASHBOARD_BUTTON);
    }

    public void clickCreateButton() {
        waitForElementClickable(driver, SearchPageUI.CREATE_BUTTON);
        clickToElement(driver, SearchPageUI.CREATE_BUTTON);
    }
}
