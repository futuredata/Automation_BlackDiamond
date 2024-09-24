package interfaces.pageUI;

public class BasePageUI {
    public static final String SEARCH_MENU = "//a[@id='search-menu-dropdown']";

    public static final String SEARCH_PAGE = "//a[@href='#/search']";
    public static final String COLD_SEARCH_PAGE = "//a[@href='#/cold-search']";

    public static final String CORRELATION_MENU = "//div[@class='container-fluid']//span[text()='Correlation']";

    public static final String VISIBILITY_MENU = "//b[text()='Visibility']/parent::a[@id='visibility-menu-dropdown']";
    public static final String IDENTITY_MENU = "//span[text()='Identity']/ancestor::a[@href='#/user']";
    public static final String TENANTS_MENU = "//span[text()='Tenants']/ancestor::a[@href='#/tenant']";
    public static final String ASSET_INVENTORY_MENU = "//span[text()='Asset Inventory']/ancestor::a[@href='#/assets']";


    public static final String SUCCESS_MESSAGE = "//div[@class='toast-message']";

}
