package actions.commons;

import java.io.File;

public class GlobalConstants {
    public static final String MP_HK_DEV_PAGE_URL = "http://192.168.100.123:8081/";
    public static final String MP_VN_DEV_PAGE_URL = "http://192.168.1.164:8081/";

    public static final int LONG_TIMEOUT = 40;
    public static final int SHORT_TIMEOUT = 10;

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

    public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;

    public static final String JAVA_VERSION = System.getProperty("java.version");
}
