package constants;

public class BaseConst_ST {
    // Локаторы для авторизации LKL
    public static final String xLOGIN_BUTTON = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/button";
    public static final String xLOGIN_FIELD = "//*[@id=\"login\"]";
    public static final String xPASSWORD_FIELD = "//*[@id=\"password\"]";
    public static final String xSUBMIT_LOGIN_BUTTON = "/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button";
    public static final String xCONTINUE_BUTTON = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[5]";

    // Локаторы для поиска заявки
    public static final String xSEARCH_REQUEST_BUTTON = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div/div[1]/a";
    public static final String xREQUEST_INPUT_FIELD = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[1]/div[1]/div/div/div/input";
    public static final String xSELECT_REQUEST_BUTTON = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div[8]/div/button";

    // Локаторы для крестиков
    public static final String xCLOSE_ICON = "//*[@id=\"app\"]/div[4]/div[1]/div/div/div/div/div/span";

    // Локаторы для кнопки "Далее"
    public static final String xNEXT_BUTTON = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[2]/button[2]";

    // Локаторы для формирования документа
    public static final String xDOCUMENT_FORM_BUTTON = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/div[1]/div/div/button";
    public static final String xHIDDEN_FILE_INPUT = "/html/body/div[3]/div[3]/div/main/form/div/div[2]/div/input";
    public static final String xSIGN_DOCUMENT_BUTTON = "/html/body/div[3]/div[3]/div/main/form/div/div[3]/div/button";

    // Локаторы для подписи документа
    public static final String xSIGNATURE_CONTAINER = "/html/body/div[4]/div[3]/div/div/div[2]/div/div";
    public static final String xCERTIFICATE_SELECTION_MENU = "//*[@id=\"menu-\"]/div[3]/ul/li[4]";
    public static final String xCONFIRM_SIGNATURE_BUTTON = "/html/body/div[4]/div[3]/div/div/div[3]/button";

    // Локаторы для завершения создания заявки
    public static final String xDOCUMENT_TYPE_SELECTOR = "/html/body/div[3]/div[3]/div/main/form/div/div[1]/div/div/div/div/input";
    public static final String xFINAL_SUBMIT_BUTTON = "/html/body/div[3]/div[3]/div/footer/button[2]";
    public static final String xFINISH_BUTTON = "/html/body/div[1]/div[3]/main/div/div[1]/div/div[3]/button[2]";

    // Локатор для получения bizKey
    public static final String xBIZ_KEY_TEXT = "/html/body/div[1]/div[3]/main/div/div[1]/div/div[1]/section/div[2]/p[2]";
}
