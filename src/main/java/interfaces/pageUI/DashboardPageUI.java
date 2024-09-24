package interfaces.pageUI;

public class DashboardPageUI {
    public static final String PLAY_BUTTON = "//div[@class='playDashboard']/i[@class='fa-solid fa-play']";
    public static final String WIDGET_LIST = "//div[@class='react-grid-item widgetContainer react-draggable cssTransforms react-resizable']/div[@class='widget']";
    public static final String UNLOCK_EDIT_BUTTON = "//button[text()='Unlock / Edit']";
    public static final String GO_TO_DASHBOARD_LIST_BUTTON = "//span[text()='Go To Dashboard List']/parent::button";
    public static final String LOCK_BUTTON = "//button[text()='Lock']";
    public static final String WIDGET_ITEM_BY_NAME = "//div[text()='%s']/ancestor::div[@class='widget']";
    public static final String DELETE_WIDGET_ICON_BY_NAME = "//div[text()='%s']/parent::div/parent::div/following-sibling::div//button[@title='Delete widget']";
    public static final String EDIT_WIDGET_ICON_BY_NAME = "//div[text()='%s']/parent::div/parent::div/following-sibling::div//button[@title='Edit widget']";
    public static final String CANCEL_SEARCH_REQUEST_BUTTON = "//div[@class='searchCancelBtn']";
    //Dashboard List
    public static final String SUCCESS_MESSAGE = "//div[@class='toast-message']";
    public static final String DEFAULT_DASHBOARD ="//span[text()='Default']/preceding-sibling::a/span";

    public static final String CREATE_DASHBOARD_BUTTON = "//button[text()='Create dashboard']";
    public static final String TITLE_TEXTBOX = "//label[text()='Title:']/following-sibling::span/input";
    public static final String DESCRIPTION_TEXTBOX = "//label[text()='Description:']/following-sibling::span/input";
    public static final String SAVE_BUTTON = "//button[text()='Save']";
    public static final String CANCEL_BUTTON = "//button[text()='Cancel']";

    public static final String EDIT_DASHBOARD_BUTTON = "//button[text()='Edit dashboard']";
    public static final String MORE_ACTIONS_BUTTON = "//button[text()='More actions']";
    public static final String SET_AS_START_PAGE_OPTION = "//span[text()='Set as startpage']/parent::a";
    public static final String DELETE_THIS_DASHBOARD_OPTION = "//span[text()='Delete this dashboard']/parent::a";

    public static final String EDIT_DASHBOARD_BUTTON_BY_DASHBOARD_NAME = "//span[text()='%s']/ancestor::h2/following-sibling::div//button[text()='Edit dashboard']";
    public static final String MORE_ACTIONS_BUTTON_BY_DASHBOARD_NAME = "//span[text()='%s']/ancestor::h2/following-sibling::div//button[text()='More actions']";
    public static final String SET_AS_START_PAGE_OPTION_BY_DASHBOARD_NAME = "//span[text()='%s']/ancestor::h2/following-sibling::div//span[text()='Set as startpage']";
    public static final String DELETE_THIS_DASHBOARD_OPTION_BY_DASHBOARD_NAME = "//span[text()='%s']/ancestor::h2/following-sibling::div//span[text()='Delete this dashboard']";

    //Widget
    public static final String WIDGET_NAME_TEXTBOX = "//input[@id='title']";
    public static final String UPDATE_BUTTON = "//button[text()='Update']";


}
