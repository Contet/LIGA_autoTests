package POL.st;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.BasePage;
import java.time.Duration;
import static browser.Config.WAIT;
import static constants.BaseConst_ST.*;

public class MainPOL_ST {
    private WebDriver driver;
    private BasePage Base;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
        Base = new BasePage(driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void step_02_Autorization_lkl() {
        driver.get(String.valueOf("https://pub.fgislk-test.gov.ru/lkl/#/cabinet"));
        Base.click(xLOGIN_BUTTON);
        Base.send(xLOGIN_FIELD, "+79055681305");
        Base.send(xPASSWORD_FIELD, "Fcs2Dcx@^");
        Base.click(xSUBMIT_LOGIN_BUTTON);
        Base.click(xCONTINUE_BUTTON);
        Base.timeOut(2000);
        Base.click(xLOGIN_BUTTON);
        Base.timeOut(1000);
    }

    @Test
    public void step_03_post_POL() {
        for (int i = 34; i < 35; i++) {
            Base.get("https://pub.fgislk-test.gov.ru/lkl/#/cabinet");
            Base.timeOut(2000);
            Base.click(xSEARCH_REQUEST_BUTTON);
            Base.click(xSEARCH_REQUEST_BUTTON + "/div");
            Base.send(xREQUEST_INPUT_FIELD, "070225-00095");
            Base.click(xSELECT_REQUEST_BUTTON);
            Base.timeOut(3000);

            if (Base.isDisp(xCLOSE_ICON)) {
                Base.click(xCLOSE_ICON);
            }
            Base.timeOut(2000);
            Base.click(xNEXT_BUTTON);
            Base.timeOut(3000);

            Base.click(xDOCUMENT_FORM_BUTTON);

            WebElement fileInput = driver.findElement(By.xpath(xHIDDEN_FILE_INPUT));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInput);

            Base.send(xHIDDEN_FILE_INPUT, "C:\\Users\\naknyazev\\Documents\\ПОЛЫ с СП\\forestDevelopmentProject(" + i + ").xml");

            Base.click(xSIGN_DOCUMENT_BUTTON);
            Base.click(xSIGNATURE_CONTAINER);
            Base.click(xCERTIFICATE_SELECTION_MENU);
            Base.timeOut(1000);
            Base.click(xCONFIRM_SIGNATURE_BUTTON);

            while (!Base.isDisp("/html/body/div[3]/div[3]/div/main/form/div/div[3]/div/div/button")) {
                Base.timeOut(1000);
            }

            Base.click(xDOCUMENT_TYPE_SELECTOR);
            Base.arrowDown();
            Base.arrowDown();
            Base.arrowDown();
            Base.enter();
            Base.timeOut(1000);
            Base.click(xFINAL_SUBMIT_BUTTON);
            Base.timeOut(1000);
            Base.click(xFINISH_BUTTON);
            Base.timeOut(3000);
            Base.click(xFINISH_BUTTON);

            Base.timeOut(3000);
            Base.click(xFINISH_BUTTON);

            Base.timeOut(3000);
            Base.click("/html/body/div[4]/div[3]/div/footer/button[2]");
            Base.click(xSIGNATURE_CONTAINER);
            Base.click(xCERTIFICATE_SELECTION_MENU);
            Base.click(xCONFIRM_SIGNATURE_BUTTON);
            Base.timeOut(1000);

            Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/h2/a");
            Base.timeOut(3000);
            Base.refresh();
            Base.timeOut(3000);

            String bizKey = Base.getText(xBIZ_KEY_TEXT);
            Base.writeTextToFile(bizKey, "log_POL.txt");
        }
    }
}