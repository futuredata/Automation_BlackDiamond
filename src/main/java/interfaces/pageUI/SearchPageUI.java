package interfaces.pageUI;

public class SearchPageUI {

    public static final String CANCEL_SEARCH_REQUEST_BUTTON = "//div[@class='searchCancelBtn']";
    public static final String SEARCH_ICON = "//button[@type='submit']";
    public static final String RELATIVE_TIMERANGE_DROPDOWN = "//button[@id='dropdown-timevalue-selector']";
    public static final String DYNAMIC_RELATIVE_TIMERANGE = "//ul[@aria-labelledby='dropdown-timevalue-selector']//li[text()='%s']";
    public static final String SEARCH_TEXTBOX = "//input[@id='search-field']";
    public static final String MESSAGE_LIST = "//div[@class='message-wrapper']";
    public static final String MESSAGE_DETAILS = "//dl[@class='message-details message-details-fields']";
    public static final String NOTHING_FOUND_MESSAGE = "//span[text()='Nothing found']";

    public static final String EXPORT_LIST_BUTTON = "//button[@title='Show all exported files']";

    public static final String SAVED_SEARCH_DROPDOWN = "//button[@id='saved-search-actions-dropdown']";
    public static final String SAVE_SEARCH_CRITERIA_OPTION = "//a[text()='Save search criteria']/parent::li";
    public static final String UPDATE_SEARCH_CRITERIA_OPTION = "//span[text()='Update saved search title']/ancestor::li";
    public static final String DELETE_SAVED_SEARCH_OPTION = "//span[text()='Delete saved search']/ancestor::li";

    public static final String SAVED_SEARCHES_TEXTBOX = "//div[@id='react-select-2--value']//input";
    public static final String SAVED_SEARCHES_ARROW_ICON = "//span[@class='Select-arrow-zone']";

    //Save search criteria popup
    public static final String SAVE_SEARCH_TITLE = "//input[@id='saved-search-title']";
    public static final String SAVE_BUTTON = "//button[text()='Save']";

    public static final String MORE_ACTIONS_DROPDOWN = "//button[@id='search-more-actions-dropdown']";
    public static final String EXPORT_AS_CSV_OPTION = "//span[text()='Export as CSV']/ancestor::li";
    public static final String SHOW_QUERY_OPTION = "//span[text()='Show query']/ancestor::li";

    /* 'Export search results as CSV' popup */
    public static final String FILE_NAME_TEXTBOX = "//input[@id='fileName']";
    public static final String EMAIL_ADDRESS_TEXTBOX = "//input[@aria-label='Email Address']";
    public static final String EXPORT_BUTTON = "//button[text()='Export']";
    public static final String DYNACMIC_EXPORT_FILE_STATUS_BY_FILE_NAME = "//td[text()='%s']/following-sibling::td[3]";

    /*'Export list' popup*/
    public static final String DYNACMIC_DELETE_ICON_BY_FILE_NAME = "//td[text()='%s']//following-sibling::td//button[@title='Delete']";
    public static final String CLOSE_POPUP_ICON = "//button[@class='close']";

    public static final String POPUP_TITLE = "//h4[@class='modal-title']";

    public static final String VIEW_TRIGGER_BUTTON_LIST = "//button[text()='View Trigger']";
    public static final String TRIGGERED_EVT_LIST = "//div[@class='triggerId']/a";
    public static final String NUMBER_OF_MESSAGE_FOUND = "//span[text()='Search result']/ancestor::h2/following-sibling::p//strong";
    public static final String TRIGGERED_TAB_LIST = "//span[text()='Triggered']/ancestor::li";
    public static final String CLOSE_TRIGGERED_TAB_ICON_LIST = "//span[text()='Triggered']/following-sibling::div/button";

    //Chart
    public static final String FILTER_FIELDS_TEXTBOX = "//input[@placeholder='Filter fields']";

    public static final String DYNAMIC_FIELD_BY_ID = "//div[@id='%s']/label";
    public static final String DYNAMIC_TYPE_OF_CHART_BY_NAME = "//div[@class='panel-body']//a[text()='%s']";

    public static final String DYNAMIC_GENERATE_CHART_RESULTS_BY_ID = "//h1[contains(text(), '%s')]/ancestor::div[@id='field-graphs']";
    public static final String DYNAMIC_QUICK_VALUES_RESULTS_BY_ID = "//em[text()='%s']/ancestor::div[@id='field-quick-values']";
    public static final String DYNAMIC_STATISTICS_RESULTS_BY_ID = "//td[contains(text(), '%s')]/ancestor::div[@id='field-statistics']";

    public static final String CLOSE_GENERATE_CHART_RESULTS_ICON = "//div[@id='field-graphs']//i[@class='fa fa-close']/parent::button";
    public static final String CLOSE_QUICK_VALUES_RESULTS_ICON = "//div[@id='field-quick-values']//i[@class='fa fa-close']/parent::button";
    public static final String CLOSE_STATISTICS_RESULTS_ICON = "//div[@id='field-statistics']//i[@class='fa fa-close']/parent::button";

    public static final String WORLD_MAP_RESULTS = "//h1[contains(text(), 'Map for field:')]/ancestor::div[@id='field-map']";
    public static final String CLOSE_WORLD_MAP_RESULTS_ICON = "//div[@id='field-map']//i[@class='fa fa-close']/parent::button";

    //Create dashboard
    public static final String ADD_COUNT_TO_DASHBOARD_BUTTON = "//span[text()='Search result']/ancestor::div[@id='sidebar']//button[@id='dashboard-selector-dropdown']";
    public static final String CREATE_NEW_DASHBOARD_BUTTON = "//span[text()='Search result']/ancestor::div[@id='sidebar']//i[text()='Create new dashboard']/ancestor::li";
    public static final String DASHBOARD_TITLE_TEXTBOX = "//input[@id='undefined-title']";
    public static final String DASHBOARD_DESCRIPTION_TEXTBOX = "//input[@id='undefined-description']";

    //Create Dashboard Widget
    public static final String WIDGET_TITLE_TEXTBOX = "//input[@id='widget-title']";
    public static final String CREATE_BUTTON = "//button[text()='Create']";
    public static final String CREATE_AND_GO_TO_DASHBOARD_BUTTON = "//button[text()='Create & Go to Dashboard']";
    public static final String CANCEL_BUTTON = "//button[text()='Cancel']";

    public static final String DYNAMIC_ADD_TO_DASHBOARD_BUTTON_BY_CHART_TYPE = "//div[@id='field-%s']//button[@id='dashboard-selector-dropdown']";
    public static final String DYNAMIC_DASHBOARD_NAME_BY_CHART_TYPE = "//div[@id='field-%s']//a[text()='%s']/parent::li";

}
