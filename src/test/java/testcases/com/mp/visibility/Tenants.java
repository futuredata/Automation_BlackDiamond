package testcases.com.mp.visibility;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.DashboardPageObject;
import actions.pageObjects.TenantPageObject;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Tenants extends BaseTest {

    // Declare + Init
    private DashboardPageObject dashboardPage;
    private TenantPageObject tenantPage;

    private String nonExistTenant = "Non-exist Tenant" + randomNumber();

    private String tenantAlias = "Selenium";

    private String tenantNameEdited = "Tenant Name " + randomNumber();
    private String provisioningAddressEdited = "HO CHI MINH " + randomNumber();
    private String gatewayName = "Gateway Name " + randomNumber();
    private String checkpointNameEdited = "10.10.5.210";
    private String checkpointIPEdited = "10.10.5.440";
    private String checkpointCNEdited = "10.10.5.299";
    private String networkName = "Network " + randomNumber();
    private String ipAndSubnetMask = "58.63.38.24/255.255.255.252";

    private String contactPointsName = "Contact Points Name " + randomNumber();
    private String officeNumber = "+8526666666";
    private String mobileNumber = "+85266666677";
    private String emailAddress = "selenium_" + randomNumber() + "@gmail.com";

    @BeforeClass
    public void beforeClass() {
        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        tenantPage = dashboardPage.goToTenantPage(driver);
    }

    @Test
    public void Tenants_01_Sort_Descending_By_Tenant_Company_Name(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the Tenant Company Name is ordered descending correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Click descending icon of Tenant Company Name");
        tenantPage.clickDescendingIconOfTenantCompanyName();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Verify that the Tenant Company Name is sorted descending correctly");
        verifyTrue(tenantPage.isTenantCompanyNameSortedDescending());
    }

    @Test
    public void Tenants_02_Sort_Ascending_By_Tenant_Company_Name(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the Tenant Company Name is ordered ascending correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Click ascending icon of Tenant Company Name");
        tenantPage.clickAscendingIconOfTenantCompanyName();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Verify that the Tenant Company Name is sorted ascending correctly");
        verifyTrue(tenantPage.isTenantCompanyNameSortedAscending());
    }

    @Test
    public void Tenants_03_Sort_Descending_By_Tenant_Alias(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the Tenant Alias is ordered descending correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Click descending icon of Tenant Alias");
        tenantPage.clickDescendingIconOfTenantAlias();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Verify that the Tenant Alias is sorted descending correctly");
        verifyTrue(tenantPage.isTenantAliasSortedDescending());
    }

    @Test
    public void Tenants_04_Sort_Ascending_By_Tenant_Alias(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the Tenant Alias is ordered ascending correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Click ascending icon of Tenant Alias");
        tenantPage.clickAscendingIconOfTenantAlias();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Verify that the Tenant Alias is sorted ascending correctly");
        verifyTrue(tenantPage.isTenantAliasSortedAscending());
    }

    @Test
    public void Tenants_05_No_Data_Available(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the 'No Data Available' message displays when searching with non-exist tenant");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Enter keywords into search textbox");
        tenantPage.inputToTenantSearchTextbox(nonExistTenant);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Click Filter button");
        tenantPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 03: Verify that the message 'No Data Available' is displayed");
        verifyTrue(tenantPage.isNoDataAvailableMessageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 04: Click Reset button");
        tenantPage.clickResetButton();
    }

    @Test
    public void Tenants_06_Health_Check(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the health check popup displays when clicking Healthcheck button");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Enter keywords into search textbox");
        tenantPage.inputToTenantSearchTextbox(tenantAlias);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Click Filter button");
        tenantPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 03:  Click HealthCheck button");
        if (tenantPage.getTheNumberOfTenantsFoundByTenantAlias(tenantAlias) == 1) {
            if (tenantPage.getTenantStatusByTenantAlias(tenantAlias).equals("Disable")) {
                tenantPage.clickTenantStatusButtonByTenantAlias(tenantAlias);
                tenantPage.selectEnableOptionByTenantAlias(tenantAlias);
                tenantPage.acceptAlert(driver);
                tenantPage.waitForSuccessMessageUndisplayed(driver);
                tenantPage.clickHealthCheckButtonByTenantAlias(tenantAlias);
            } else {
                tenantPage.clickHealthCheckButtonByTenantAlias(tenantAlias);
            }
        }

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 04: Verify the popup header is correctly");
        verifyEquals(tenantPage.getPopupHeader(), "Healthcheck Infomation of tenant " + tenantAlias);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 05: Click close popup icon");
        tenantPage.clickClosePopupIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 06: Reset filter textbox by clicking Reset button");
        tenantPage.clickResetButton();
    }

    @Test
    public void Tenants_07_Tree(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the Tenant Tree popup displays when clicking Tree button");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Enter keywords into search textbox");
        tenantPage.inputToTenantSearchTextbox(tenantAlias);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Click Filter button");
        tenantPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 03:  Click Tree button");
        tenantPage.clickTreeButtonByTenantAlias(tenantAlias);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 04: Verify the popup header is correctly");
        verifyEquals(tenantPage.getPopupHeader(), "Tenant Tree");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 05: Click close popup icon");
        tenantPage.clickClosePopupIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 06: Reset filter textbox by clicking Reset button");
        tenantPage.clickResetButton();
    }


    @Test
    public void Tenants_08_Edit_Tenant(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the tenant is updated successfully");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Enter keywords into search textbox");
        tenantPage.inputToTenantSearchTextbox(tenantAlias);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Click Filter button");
        tenantPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 03:  Click Edit button");
        if (tenantPage.getTheNumberOfTenantsFoundByTenantAlias(tenantAlias) == 1)
            tenantPage.clickEditButtonByTenantAlias(tenantAlias);
        else
            ExtentTestManager.getTest().skip("Exception: There is no tenant for testing. Please check the test data again.");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 04: Enter new Tenant Company Name is: " + tenantNameEdited);
        tenantPage.inputToTextboxByID("tenantName", tenantNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 05: Enter new Provisioning Address is: " + provisioningAddressEdited);
        tenantPage.inputToTextboxByID("companyAddress", provisioningAddressEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 06: Turn on Enable Provisioning toggle if it is turned off");
        if (tenantPage.isEnableProvisioningToggleTurnedOff() == true) {
            tenantPage.clickEnableProvisioningToggle();
        }

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 07: Delete a gateway if there are more than 3 gateway names");
        if (tenantPage.getTheNumberOfGatewayName() >= 3)
            tenantPage.clickTheFirstDeleteGatewayIcon();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 08:  Enter gateway name is: " + gatewayName);
        tenantPage.inputToGatewayNameTextbox(gatewayName);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 09: Enter Checkpoint Domain Server Name is: " + checkpointNameEdited);
        tenantPage.inputToTextboxByID("checkpointName", checkpointNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 10: Enter Checkpoint Domain IP is: " + checkpointIPEdited);
        tenantPage.inputToTextboxByID("checkpointIP", checkpointIPEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 11: Enter Checkpoint Domain CN is: " + checkpointCNEdited);
        tenantPage.inputToTextboxByID("checkpointCN", checkpointCNEdited);

        //Collectors

        //Networks
        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 12: Delete a network if there are more than 3 networks");
        if (tenantPage.getTheNetworksListSize() >= 3) {

            ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 13: Click delete Network button");
            tenantPage.clickTheFirstDeleteNetworkButton();

            ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 14: Accept the alert");
            tenantPage.acceptAlert(driver);
        }

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 15: Click '+Add' network button");
        tenantPage.clickAddNetworksButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 16: Enter Networks name is: " + networkName);
        tenantPage.inputToTextboxByID("name", networkName);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 17: Enter IP & Subnet mask is: " + ipAndSubnetMask);
        tenantPage.inputToTextboxByID("ip", ipAndSubnetMask);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 18: Click Add button");
        tenantPage.clickAddNetworkButton();

        //Contact Points
        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 19: Delete a contact if there are more than 3 contacts");
        if (tenantPage.getTheContactPointsListSize() >= 3) {
            tenantPage.clickTheFirstDeleteContactPointButton();
            tenantPage.acceptAlert(driver);
        }
        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 20: Click Add button");
        tenantPage.clickAddContactPointsButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 21: Enter contact points name is: " + contactPointsName);
        tenantPage.inputToTextboxByID("name", contactPointsName);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 22: Enter office number is: " + officeNumber);
        tenantPage.inputToTextboxByID("officeNumber", officeNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 23: Enter Mobile Number is: " + mobileNumber);
        tenantPage.inputToTextboxByID("mobileNumber", mobileNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 24: Enter email is: " + emailAddress);
        tenantPage.inputToTextboxByID("email", emailAddress);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 25: Click '+Add' Contact Points button");
        tenantPage.clickAddContactPointButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 26: Click Update Tenant button");
        tenantPage.clickUpdateTenantButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 27: Verify the the tenant is updated successfully");
        verifyEquals(tenantPage.getSuccessMessage(driver), "Tenant " + tenantNameEdited + " was updated successfully!");
        tenantPage.waitForSuccessMessageUndisplayed(driver);
    }

    @Test
    public void Tenants_09_Enable_Disable_Tenant(Method method) {
        ExtentTestManager.startTest(method.getName(), "Tenants: Verify that the tenant is enabled/disabled correctly");

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 01: Enter keywords into search textbox");
        tenantPage.inputToTenantSearchTextbox(tenantAlias);

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 02: Click Filter button");
        tenantPage.clickFilterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 03:  Click tenant status (Enable/Disable) button");
        if (tenantPage.getTheNumberOfTenantsFoundByTenantAlias(tenantAlias) == 1) {
            if (tenantPage.getTenantStatusByTenantAlias(tenantAlias).equals("Disable")) {
                System.out.println("Case Disable: " + tenantPage.getTenantStatusByTenantAlias(tenantAlias));
                tenantPage.clickTenantStatusButtonByTenantAlias(tenantAlias);
                tenantPage.selectEnableOptionByTenantAlias(tenantAlias);
                tenantPage.acceptAlert(driver);

                ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 04: Verify the the tenant is enabled successfully");
                verifyEquals(tenantPage.getSuccessMessage(driver), "Tenant " + tenantAlias + " was enable successfully!");
                tenantPage.waitForSuccessMessageUndisplayed(driver);

            } else {
                System.out.println("Case Enable: " + tenantPage.getTenantStatusByTenantAlias(tenantAlias));
                tenantPage.clickTenantStatusButtonByTenantAlias(tenantAlias);
                tenantPage.selectDisableOptionByTenantAlias(tenantAlias);
                tenantPage.acceptAlert(driver);

                ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 04: Verify the the tenant is disabled successfully");
                verifyEquals(tenantPage.getSuccessMessage(driver), "Tenant " + tenantNameEdited + " was disable successfully!");
                tenantPage.waitForSuccessMessageUndisplayed(driver);
            }
        }

        ExtentTestManager.getTest().log(Status.INFO, "Tenants - Step 05: Reset filter textbox by clicking Reset button");
        tenantPage.clickResetButton();
    }
}
