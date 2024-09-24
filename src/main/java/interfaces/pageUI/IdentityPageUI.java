package interfaces.pageUI;

public class IdentityPageUI {

    //Identity list
    public static final String FILTER_IDENTITY_TEXTBOX = "//input[@id='user-list-data-filter']";
    public static final String FILTER_BUTTON = "//button[text()='Filter']";
    public static final String RESET_BUTTON = "//button[text()='Reset']";
    public static final String NO_DATA_AVAILABLE_MESSAGE = "//table[@class='table table-hover']//p[text()='No Data Available']";

    public static final String ADD_NEW_IDENTITY_BUTTON = "//span[text()='Add new identity']/parent::button";
    public static final String DYNAMIC_EDIT_BUTTON_BY_IDENTITY_NAME = "//button[contains(@id,'edit-user-%s')]";
    public static final String DYNAMIC_PERSONATE_BUTTON_BY_IDENTITY_NAME = "//button[contains(@id,'personate-user-%s')]";
    public static final String DYNAMIC_DELETE_BUTTON_BY_IDENTITY_NAME = "//button[contains(@id,'delete-user-%s')]";
    public static final String DYNAMIC_USER_STATUS_BUTTON_BY_IDENTITY_NAME = "//button[contains(@id,'status-user-%s')]/parent::div";
    public static final String DYNAMIC_ENABLE_OPTION_BY_IDENTITY_NAME = "//ul[contains(@aria-labelledby,'status-user-%s')]//a[text()='Enable']/parent::li";
    public static final String DYNAMIC_DISABLE_OPTION_BY_IDENTITY_NAME = "//ul[contains(@aria-labelledby,'status-user-%s')]//a[text()='Disable']/parent::li";

    public static final String CLOSE_PERSONATE_ICON = "//div[@class='incognito']/following-sibling::div[@class='closeMore']";
    public static final String FULL_NAME_OF_USER = "//a[@id='user-menu-dropdown']//b";

    //Create new identity
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
//    public static final String IDENTITY_NAME_TEXTBOX = "//input[@id='username']";
//    public static final String FULL_NAME_TEXTBOX = "//input[@id='fullname']";
//    public static final String EMAIL_ADDRESS_TEXTBOX = "//input[@id='email']";
//    public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
//    public static final String REPEAT_PASSWORD_TEXTBOX = "//input[@id='password-repeat']";
    public static final String TENANT_DROPDOWN_LIST = "//select[@id='tenant-user']";
    public static final String GROUP_DROPDOWN_LIST = "//select[@label='Group']";
    public static final String CLEAR_TIME_ZONE_ICON = "//span[@class='Select-clear']";
    public static final String TIME_ZONE_TEXTBOX = "//div[@class='Select-input']/input";
    public static final String CREATE_IDENTITY_BUTTON = "//button[@type='submit']";
    public static final String CANCEL_BUTTON = "//button[text()='Cancel']";

    //Update identity
    public static final String UPDATE_IDENTITY_BUTTON = "//button[@type='submit']";


    public static final String TABLE_HEADER = "//thead";
}
