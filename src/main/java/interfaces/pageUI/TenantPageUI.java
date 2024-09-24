package interfaces.pageUI;

public class TenantPageUI {
    //Tenant list
    public static final String TENANT_COMPANY_NAME_ASCENDING_SORT_ICON = "//th[text()='Tenant Company Name']//span[@title='Ascending']";
    public static final String TENANT_COMPANY_NAME_DESCENDING_SORT_ICON = "//th[text()='Tenant Company Name']//span[@title='Descending']";
    public static final String LIST_OF_TENANT_COMPANY_NAME = "//body//tr/td[2]";

    public static final String TENANT_ALIAS_ASCENDING_SORT_ICON = "//th[text()='Tenant Alias']//span[@title='Ascending']";
    public static final String TENANT_ALIAS_DESCENDING_SORT_ICON = "//th[text()='Tenant Alias']//span[@title='Descending']";
    public static final String LIST_OF_TENANT_ALIAS = "//body//tr/td[3]";

    public static final String LIST_OF_TENANT_STATUS = "//body//tr/td[7]";

    public static final String FILTER_TENANTS_TEXTBOX = "//input[@id='tenant-list-data-filter']";
    public static final String FILTER_BUTTON = "//button[text()='Filter']";
    public static final String RESET_BUTTON = "//button[text()='Reset']";
    public static final String NO_DATA_AVAILABLE_MESSAGE = "//table[@class='table table-hover']//p[text()='No Data Available']";

    public static final String DYNAMIC_EDIT_BUTTON_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td/div/a[text()='Edit']";
    public static final String DYNAMIC_DEPLOY_BUTTON_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td/div/a[text()='Deploy']";
    public static final String DYNAMIC_REVERT_BUTTON_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td/div/a[text()='Revert']";
    public static final String DYNAMIC_HEALTH_CHECK_BUTTON_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td/div/button[text()='Healthcheck']";
    public static final String DYNAMIC_TENANT_STATUS_BUTTON_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td//div//button[contains(@id,'status-tenant')]";
    public static final String DYNAMIC_ENABLE_OPTION_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td//div//a[text()='Enable']/parent::li";
    public static final String DYNAMIC_DISABLE_OPTION_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td//div//a[text()='Disable']/parent::li";
    public static final String DYNAMIC_TREE_BUTTON_BY_TENANT_ALIAS = "//td[text()='%s']/parent::tr//td//div//button[text()='Tree']";

    public static final String CLOSE_POPUP_ICON = "//button[@class='close']";
    public static final String POPUP_HEADER = "//button[@class='close']/following::h4";

    //Tenant details
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String ENABLE_PROVISIONING_TOGGLE = "//label[text()='Enable Provisioning']/following-sibling::div/label";
    public static final String SECTION_HEADER = "//div[@class='newsEntryBox']//b";
    public static final String GATEWAY_NAME_TEXTBOX = "//input[@placeholder='Gateway Name']";
    public static final String LIST_OF_DELETES_GATEWAY_NAME_ICON = "//div[@id='gateway']//a[@class='ReactTags__remove']";
    public static final String CLEAR_ALL_COLLECTORS_ICON = "//span[@title='Clear all']";

    /*Networks*/
    public static final String LIST_OF_NETWORKS = "//table[@id='list-network-info']//tbody//tr";
    public static final String ADD_NETWORKS_BUTTON = "//table[@id='list-network-info']//button[text()='Add']";
    public static final String ADD_NETWORK_BUTTON = "//button[@id='save-network-info-undefined']";
    public static final String LIST_OF_DELETE_NETWORKS_BUTTON = "//table[@id='list-network-info']//button[@title='Delete']";

    /*Contact Points*/
    public static final String LIST_OF_CONTACT_POINTS = "//table[@id='list-contact-point']//tbody//tr";
    public static final String ADD_CONTACT_POINTS_BUTTON = "//table[@id='list-contact-point']//button[@class='btn btn-success']";
    public static final String ADD_CONTACT_POINT_BUTTON = "//table[@id='list-contact-point']//button[@title='Add']";
    public static final String LIST_OF_DELETE_CONTACT_POINTS_BUTTON = "//table[@id='list-contact-point']//button[@title='Delete']";


    public static final String UPDATE_TENANT_BUTTON = "//button[@type='submit']";

    public static final String TABLE_HEADER = "//thead";
    public static final String TABLE_BODY = "//tbody";
}
