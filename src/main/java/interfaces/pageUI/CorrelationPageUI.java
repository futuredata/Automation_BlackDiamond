package interfaces.pageUI;

public class CorrelationPageUI {
    public static final String CORRELATION_MENU = "//h2[text()='Correlation Engine']";
    public static final String ADD_NEW_CE_NODE = "//button[@class='floatRight btn btn-success']";
    public static final String IP_TEXTBOX = "//input[@type='text']";
    public static final String SAVE_BUTTON = "//button[@type='submit']";
    public static final String SUCCESS_MESSAGE = "//div[@class='toast-message']";

    public static final String EDIT_NODE_ICON = "//b[contains(text(), '%s')]/parent::div/parent::div/preceding-sibling::div//button[@title='Edit']";
    public static final String DELETE_NODE_ICON = "//b[contains(text(), '%s')]/parent::div/parent::div/preceding-sibling::div//button[@title='Delete']";


    public static final String RULES_PAGE_NAME = "//div[@class='divHeaderCor']//span[contains(text(), 'Rules')]";

}
