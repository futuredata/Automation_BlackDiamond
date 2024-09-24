package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUI.TenantPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TenantPageObject extends BasePage {
    WebDriver driver;

    public TenantPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickAscendingIconOfTenantCompanyName() {
        waitForElementClickable(driver, TenantPageUI.TENANT_COMPANY_NAME_ASCENDING_SORT_ICON);
        clickToElement(driver, TenantPageUI.TENANT_COMPANY_NAME_ASCENDING_SORT_ICON);
        sleepInSecond(3);
    }

    public void clickDescendingIconOfTenantCompanyName() {
        waitForElementClickable(driver, TenantPageUI.TENANT_COMPANY_NAME_DESCENDING_SORT_ICON);
        clickToElement(driver, TenantPageUI.TENANT_COMPANY_NAME_DESCENDING_SORT_ICON);
        sleepInSecond(3);
    }

    public boolean isTenantCompanyNameSortedDescending() {
        ArrayList<String> tenantCompanyNameUIList = new ArrayList<String>();

        //Get all tenants
        List<WebElement> tenantCompanyNameText = getListWebElement(driver, TenantPageUI.LIST_OF_TENANT_COMPANY_NAME);

        for (WebElement tenantName : tenantCompanyNameText) {
            tenantCompanyNameUIList.add(tenantName.getText());
            System.out.println("UI: " + tenantName.getText());
        }

        //Create a new array list
        ArrayList<String> tenantSortList = new ArrayList<String>();
        for (String tenant : tenantCompanyNameUIList) {
            tenantSortList.add(tenant);
        }
        // Sort tenantSortList
        Collections.sort(tenantSortList, String.CASE_INSENSITIVE_ORDER);

        for (String tenantName : tenantSortList) {
            System.out.println("Tenant Name after sort ASC:" + tenantName);
        }

        // Reverse tenantSortList
        Collections.reverse(tenantSortList);

        for (String tenantName : tenantSortList) {
            System.out.println("Tenant Name after sort DESC: " + tenantName);
        }

        //Compare 2 sorted list
        return tenantSortList.equals(tenantCompanyNameUIList);

    }


    public boolean isTenantCompanyNameSortedAscending() {
        ArrayList<String> tenantCompanyNameUIList = new ArrayList<String>();

        //Get all tenants
        List<WebElement> tenantCompanyNameText = getListWebElement(driver, TenantPageUI.LIST_OF_TENANT_COMPANY_NAME);

        for (WebElement tenantName : tenantCompanyNameText) {
            tenantCompanyNameUIList.add(tenantName.getText());
            System.out.println("UI: " + tenantName.getText());
        }

        //Create a new array list
        ArrayList<String> tenantSortList = new ArrayList<String>();
        for (String tenant : tenantCompanyNameUIList) {
            tenantSortList.add(tenant);
        }
        // Sort tenantSortList
        Collections.sort(tenantSortList, String.CASE_INSENSITIVE_ORDER);

        for (String tenantName : tenantSortList) {
            System.out.println("Tenant Name after sort ASC:" + tenantName);
        }

        //Compare 2 sorted list
        return tenantSortList.equals(tenantCompanyNameUIList);
    }

    public void clickDescendingIconOfTenantAlias() {
        waitForElementClickable(driver, TenantPageUI.TENANT_ALIAS_DESCENDING_SORT_ICON);
        clickToElement(driver, TenantPageUI.TENANT_ALIAS_DESCENDING_SORT_ICON);
        sleepInSecond(3);
    }

    public boolean isTenantAliasSortedDescending() {
        ArrayList<String> tenantAliasUIList = new ArrayList<String>();

        //Get all tenants
        List<WebElement> tenantAliasText = getListWebElement(driver, TenantPageUI.LIST_OF_TENANT_ALIAS);

        for (WebElement tenantAlias : tenantAliasText) {
            tenantAliasUIList.add(tenantAlias.getText());
            System.out.println("UI: " + tenantAlias.getText());
        }

        //Create a new array list
        ArrayList<String> tenantSortList = new ArrayList<String>();
        for (String tenant : tenantAliasUIList) {
            tenantSortList.add(tenant);
        }
        // Sort tenantSortList
        Collections.sort(tenantSortList, String.CASE_INSENSITIVE_ORDER);

        for (String tenantName : tenantSortList) {
            System.out.println("Tenant alias after sort ASC: " + tenantName);
        }

        // Reverse tenantSortList
        Collections.reverse(tenantSortList);

        for (String tenantName : tenantSortList) {
            System.out.println("Tenant alias after sort DESC: " + tenantName);
        }

        //Compare 2 sorted list
        return tenantSortList.equals(tenantAliasUIList);
    }

    public void clickAscendingIconOfTenantAlias() {
        waitForElementClickable(driver, TenantPageUI.TENANT_ALIAS_ASCENDING_SORT_ICON);
        clickToElement(driver, TenantPageUI.TENANT_ALIAS_ASCENDING_SORT_ICON);
        sleepInSecond(3);
    }

    public boolean isTenantAliasSortedAscending() {
        ArrayList<String> tenantAliasUIList = new ArrayList<String>();

        //Get all tenants
        List<WebElement> tenantAliasText = getListWebElement(driver, TenantPageUI.LIST_OF_TENANT_ALIAS);

        for (WebElement tenantAlias : tenantAliasText) {
            tenantAliasUIList.add(tenantAlias.getText());
            System.out.println("UI: " + tenantAlias.getText());
        }

        //Create a new array list
        ArrayList<String> tenantSortList = new ArrayList<String>();
        for (String tenant : tenantAliasUIList) {
            tenantSortList.add(tenant);
        }
        // Sort tenantSortList
        Collections.sort(tenantSortList, String.CASE_INSENSITIVE_ORDER);

        for (String tenantName : tenantSortList) {
            System.out.println("Tenant alias after sort ASC: " + tenantName);
        }

        //Compare 2 sorted list
        return tenantSortList.equals(tenantAliasUIList);
    }

    public boolean isNoDataAvailableMessageDisplayed() {
        waitForElementVisible(driver, TenantPageUI.NO_DATA_AVAILABLE_MESSAGE);
        return isElementDisplayed(driver, TenantPageUI.NO_DATA_AVAILABLE_MESSAGE);
    }

    public void clickFilterButton() {
        waitForElementClickable(driver, TenantPageUI.FILTER_BUTTON);
        clickToElement(driver, TenantPageUI.FILTER_BUTTON);
        waitForElementVisible(driver, TenantPageUI.TABLE_BODY);
        sleepInSecond(1);
    }

    public void inputToTenantSearchTextbox(String tenantAlias) {
        waitForElementVisible(driver, TenantPageUI.FILTER_TENANTS_TEXTBOX);
        deleteTextInElement(driver, TenantPageUI.FILTER_TENANTS_TEXTBOX);
        sendkeyToElement(driver, TenantPageUI.FILTER_TENANTS_TEXTBOX, tenantAlias);
    }

    public void clickResetButton() {
        waitForElementClickable(driver, TenantPageUI.RESET_BUTTON);
        clickToElement(driver, TenantPageUI.RESET_BUTTON);
        waitForElementVisible(driver, TenantPageUI.TABLE_BODY);
        sleepInSecond(1);
    }

    public String getTenantStatusByTenantAlias(String tenantAlias) {
        waitForElementVisible(driver, TenantPageUI.DYNAMIC_TENANT_STATUS_BUTTON_BY_TENANT_ALIAS, tenantAlias);
        return getElementText(driver, TenantPageUI.DYNAMIC_TENANT_STATUS_BUTTON_BY_TENANT_ALIAS, tenantAlias);
    }

    public int getTheNumberOfTenantsFoundByTenantAlias(String tenantAlias) {
        waitForElementVisible(driver, TenantPageUI.DYNAMIC_TENANT_STATUS_BUTTON_BY_TENANT_ALIAS, tenantAlias);
        return getElementSize(driver, TenantPageUI.DYNAMIC_TENANT_STATUS_BUTTON_BY_TENANT_ALIAS, tenantAlias);
    }

    public void clickTenantStatusButtonByTenantAlias(String tenantAlias) {
        waitForElementClickable(driver, TenantPageUI.DYNAMIC_TENANT_STATUS_BUTTON_BY_TENANT_ALIAS, tenantAlias);
        clickToElement(driver, TenantPageUI.DYNAMIC_TENANT_STATUS_BUTTON_BY_TENANT_ALIAS, tenantAlias);
    }

    public void selectEnableOptionByTenantAlias(String tenantAlias) {
        waitForElementClickable(driver, TenantPageUI.DYNAMIC_ENABLE_OPTION_BY_TENANT_ALIAS, tenantAlias);
        clickToElement(driver, TenantPageUI.DYNAMIC_ENABLE_OPTION_BY_TENANT_ALIAS, tenantAlias);
    }

    public void selectDisableOptionByTenantAlias(String tenantAlias) {
        waitForElementClickable(driver, TenantPageUI.DYNAMIC_DISABLE_OPTION_BY_TENANT_ALIAS, tenantAlias);
        clickToElement(driver, TenantPageUI.DYNAMIC_DISABLE_OPTION_BY_TENANT_ALIAS, tenantAlias);
    }

    public void clickHealthCheckButtonByTenantAlias(String tenantAlias) {
        waitForElementClickable(driver, TenantPageUI.DYNAMIC_HEALTH_CHECK_BUTTON_BY_TENANT_ALIAS, tenantAlias);
        clickToElement(driver, TenantPageUI.DYNAMIC_HEALTH_CHECK_BUTTON_BY_TENANT_ALIAS, tenantAlias);
    }

    public String getPopupHeader() {
        waitForElementVisible(driver, TenantPageUI.POPUP_HEADER);
        return getElementText(driver, TenantPageUI.POPUP_HEADER);
    }

    public void clickClosePopupIcon() {
        waitForElementClickable(driver, TenantPageUI.CLOSE_POPUP_ICON);
        clickToElement(driver, TenantPageUI.CLOSE_POPUP_ICON);
    }

    public void clickTreeButtonByTenantAlias(String tenantAlias) {
        waitForElementClickable(driver, TenantPageUI.DYNAMIC_TREE_BUTTON_BY_TENANT_ALIAS, tenantAlias);
        clickToElement(driver, TenantPageUI.DYNAMIC_TREE_BUTTON_BY_TENANT_ALIAS, tenantAlias);
    }

    public void clickEditButtonByTenantAlias(String tenantAlias) {
        waitForElementClickable(driver, TenantPageUI.DYNAMIC_EDIT_BUTTON_BY_TENANT_ALIAS, tenantAlias);
        clickToElement(driver, TenantPageUI.DYNAMIC_EDIT_BUTTON_BY_TENANT_ALIAS, tenantAlias);
    }


    public boolean isEnableProvisioningToggleTurnedOff() {
        ArrayList<String> currentSectionHeaderList = new ArrayList<String>();

        //Get all section header text
        List<WebElement> currentSectionHeaderText = getListWebElement(driver, TenantPageUI.SECTION_HEADER);

        for (WebElement sectionHeader : currentSectionHeaderText) {
            currentSectionHeaderList.add(sectionHeader.getText());
            System.out.println("SECTION HEADER TEXT: " + sectionHeader.getText());
        }

        for (int i = 0; i< currentSectionHeaderList.size(); i++) {
            if (currentSectionHeaderList.toString().contains("Provisioning Configurations"))
                return false;
        }
        return true;
    }


        public void clickEnableProvisioningToggle () {
            waitForElementClickable(driver, TenantPageUI.ENABLE_PROVISIONING_TOGGLE);
            clickToElement(driver, TenantPageUI.ENABLE_PROVISIONING_TOGGLE);
        }

        public void inputToTextboxByID (String textboxID, String value){
            waitForElementVisible(driver, TenantPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
            sendkeyToElement(driver, TenantPageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
        }

        public int getTheNumberOfGatewayName () {
            waitForElementVisible(driver, TenantPageUI.LIST_OF_DELETES_GATEWAY_NAME_ICON);
            return getElementSize(driver, TenantPageUI.LIST_OF_DELETES_GATEWAY_NAME_ICON);
        }

        public void clickTheFirstDeleteGatewayIcon () {
            waitForElementClickable(driver, TenantPageUI.LIST_OF_DELETES_GATEWAY_NAME_ICON);
            clickToFirstElement(driver, TenantPageUI.LIST_OF_DELETES_GATEWAY_NAME_ICON);
        }

        public void inputToGatewayNameTextbox (String gatewayName){
            waitForElementVisible(driver, TenantPageUI.GATEWAY_NAME_TEXTBOX);
            sendkeyToElement(driver, TenantPageUI.GATEWAY_NAME_TEXTBOX, gatewayName);
        }

        public int getTheNetworksListSize () {
            waitForElementVisible(driver, TenantPageUI.LIST_OF_NETWORKS);
            return getElementSize(driver, TenantPageUI.LIST_OF_NETWORKS);
        }

        public void clickTheFirstDeleteNetworkButton () {
            waitForElementClickable(driver, TenantPageUI.LIST_OF_DELETE_NETWORKS_BUTTON);
            clickToFirstElement(driver, TenantPageUI.LIST_OF_DELETE_NETWORKS_BUTTON);
        }

        public void clickAddNetworksButton () {
            waitForElementClickable(driver, TenantPageUI.ADD_NETWORKS_BUTTON);
            clickToElement(driver, TenantPageUI.ADD_NETWORKS_BUTTON);
        }

        public void clickAddNetworkButton () {
            waitForElementClickable(driver, TenantPageUI.ADD_NETWORK_BUTTON);
            clickToElement(driver, TenantPageUI.ADD_NETWORK_BUTTON);
        }

        public int getTheContactPointsListSize () {
            waitForElementVisible(driver, TenantPageUI.LIST_OF_CONTACT_POINTS);
            return getElementSize(driver, TenantPageUI.LIST_OF_CONTACT_POINTS);
        }

        public void clickTheFirstDeleteContactPointButton () {
            waitForElementClickable(driver, TenantPageUI.LIST_OF_DELETE_CONTACT_POINTS_BUTTON);
            clickToFirstElement(driver, TenantPageUI.LIST_OF_DELETE_CONTACT_POINTS_BUTTON);
        }

        public void clickAddContactPointsButton () {
            waitForElementClickable(driver, TenantPageUI.ADD_CONTACT_POINTS_BUTTON);
            clickToElement(driver, TenantPageUI.ADD_CONTACT_POINTS_BUTTON);
        }

        public void clickAddContactPointButton () {
            waitForElementClickable(driver, TenantPageUI.ADD_CONTACT_POINT_BUTTON);
            clickToElement(driver, TenantPageUI.ADD_CONTACT_POINT_BUTTON);
        }

        public void clickUpdateTenantButton () {
            waitForElementClickable(driver, TenantPageUI.UPDATE_TENANT_BUTTON);
            clickToElement(driver, TenantPageUI.UPDATE_TENANT_BUTTON);
        }
    }
