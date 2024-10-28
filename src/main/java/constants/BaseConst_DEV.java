package constants;

public final class BaseConst_DEV {

 // Приватный конструктор для предотвращения создания экземпляров класса
 private BaseConst_DEV() {
  throw new UnsupportedOperationException("Utility class");
 }

 // URL
 public static final String xDEV_START_PAGE = "https://pub.dev.fgislk.at-consulting.ru/lkl/#/cabinet";

 // XPath выражения для авторизации
 public static final String xLOGIN_BUTTON = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/button";
 public static final String xLOGIN_FIELD = "//*[@id=\"login\"]";
 public static final String xPASSWORD_FIELD = "//*[@id=\"password\"]";
 public static final String xSUBMIT_BUTTON = "/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button";
 public static final String xCONFIRM_BUTTON = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[2]";
 public static final String xACCEPT_BUTTON = "/html/body/div/div[2]/div[2]/div[3]/button[1]";

 // XPath выражения для работы с документами
 public static final String xDOCUMENT_LINK = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div/div[1]/a";
 public static final String xDOCUMENT_DETAILS = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div/div[1]/a/div";
 public static final String xDOCUMENT_INPUT = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[1]/div[1]/div/div/div/input";
 public static final String xDOCUMENT_SEARCH_BUTTON = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div[8]/div/button";
 public static final String xCLOSE_BUTTON = "//*[@id=\"app\"]/div[4]/div[1]/div/div/div/div/div/span";
 public static final String xNEXT_BUTTON = "//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[2]/button[2]";
 public static final String xFILE_INPUT = "/html/body/div[3]/div[3]/div/main/form/div/div[2]/div/input";
 public static final String xSIGN_BUTTON = "/html/body/div[3]/div[3]/div/main/form/div/div[3]/div/button";
 public static final String xSIGN_CONFIRM_BUTTON = "/html/body/div[4]/div[3]/div/div/div[3]/button";
 public static final String xBIZ_KEY = "/html/body/div[1]/div[3]/main/div/div[1]/div/div[1]/section/div[2]/p[2]";
}
