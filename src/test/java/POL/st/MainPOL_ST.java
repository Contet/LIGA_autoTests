package POL.st;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.theInternet.MainPage;
import java.time.Duration;
import static browser.Config.WAIT;
import static constants.BaseConst_ST.*;

public class MainPOL_ST {
    private WebDriver driver;
    private MainPage Main;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
        Main = new MainPage(driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void step_02_Autorization_lkl() {
        driver.get(String.valueOf("https://pub.fgislk-test.gov.ru/lkl/#/cabinet"));
        Main.Click(xLOGIN_BUTTON);
        Main.Send(xLOGIN_FIELD, "+79055681305");
        Main.Send(xPASSWORD_FIELD, "Fcs2Dcx@^");
        Main.Click(xSUBMIT_LOGIN_BUTTON);
        Main.Click(xCONTINUE_BUTTON);
        Main.TimeOut(2000);
        Main.Click(xLOGIN_BUTTON);
        Main.TimeOut(1000);
    }

    @Test
    public void step_03_post_POL() {
        for (int i = 34; i < 35; i++) {
            Main.Get("https://pub.fgislk-test.gov.ru/lkl/#/cabinet");
            Main.TimeOut(2000);
            Main.Click(xSEARCH_REQUEST_BUTTON);
            Main.Click(xSEARCH_REQUEST_BUTTON + "/div");
            Main.Send(xREQUEST_INPUT_FIELD, "070225-00095");
            Main.Click(xSELECT_REQUEST_BUTTON);
            Main.TimeOut(3000);

            if (Main.IsDisp(xCLOSE_ICON)) {
                Main.Click(xCLOSE_ICON);
            }
            Main.TimeOut(1000);
            Main.Click(xNEXT_BUTTON);
            Main.TimeOut(3000);

            Main.Click(xDOCUMENT_FORM_BUTTON);

            WebElement fileInput = driver.findElement(By.xpath(xHIDDEN_FILE_INPUT));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInput);

            Main.Send(xHIDDEN_FILE_INPUT, "C:\\Users\\naknyazev\\Documents\\ПОЛЫ с СП\\forestDevelopmentProject(" + i + ").xml");

            Main.Click(xSIGN_DOCUMENT_BUTTON);
            Main.Click(xSIGNATURE_CONTAINER);
            Main.Click(xCERTIFICATE_SELECTION_MENU);
            Main.Click(xCONFIRM_SIGNATURE_BUTTON);

            while (!Main.IsDisp("/html/body/div[3]/div[3]/div/main/form/div/div[3]/div/div/button")) {
                Main.TimeOut(1000);
            }

            Main.Click(xDOCUMENT_TYPE_SELECTOR);
            Main.ArrowDown();
            Main.ArrowDown();
            Main.ArrowDown();
            Main.Enter();
            Main.Click(xFINAL_SUBMIT_BUTTON);
            Main.TimeOut(1000);
            Main.Click(xFINISH_BUTTON);
            Main.TimeOut(3000);
            Main.Click(xFINISH_BUTTON);

            Main.TimeOut(3000);
            Main.Click(xFINISH_BUTTON);

            Main.TimeOut(3000);
            Main.Click("/html/body/div[4]/div[3]/div/footer/button[2]");
            Main.Click(xSIGNATURE_CONTAINER);
            Main.Click(xCERTIFICATE_SELECTION_MENU);
            Main.Click(xCONFIRM_SIGNATURE_BUTTON);
            Main.TimeOut(1000);

            Main.Click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/h2/a");
            Main.TimeOut(3000);
            Main.Refresh();
            Main.TimeOut(3000);

            String bizKey = Main.GetText(xBIZ_KEY_TEXT);
            Main.WriteTextToFile(bizKey, "log_POL.txt");
        }
    }
}