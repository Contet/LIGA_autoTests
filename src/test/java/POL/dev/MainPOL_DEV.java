package POL.dev;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.theInternet.MainPage;

import java.time.Duration;

import static constants.BaseConst_DEV.*;
import static browser.Config.WAIT;

public class MainPOL_DEV {

    private WebDriver driver;
    private MainPage Main;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
        Main = new MainPage(driver);
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

//   @Test
//    public void step_01_Autorization_rmdl() {
//        driver.get(xLKL_START_PAGE);
//
//        Main.Click(xLOGIN_BUTTON);
//        Main.Send(xLOGIN_FIELD, "+79524945159");
//        Main.Send(xPASSWORD_FIELD, "Dy2-6bn3WU");
//        Main.Click(xSUBMIT_BUTTON);
//
//        Main.Click(xCONFIRM_BUTTON);
//        Main.TimeOut(2000);
//        Main.Click(xACCEPT_BUTTON);
//
//        Main.TimeOut(1000);
//    }

    @Test
    public void step_02_Autorization_lkl() {
        driver.get(xDEV_START_PAGE);

        Main.Click(xLOGIN_BUTTON);
        Main.Send(xLOGIN_FIELD, "+79055681305");
        Main.Send(xPASSWORD_FIELD, "Fcs2Dcx@^");
        Main.Click(xSUBMIT_BUTTON);

        Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[5]");
        Main.TimeOut(2000);
        Main.Click(xLOGIN_BUTTON);

        Main.TimeOut(1000);
    }

    @Test
    public void step_03_post_POL() {
        for (int i = 1; i < 2; i++) {
            Main.Get(xDEV_START_PAGE);
            Main.TimeOut(2000);

            Main.Click(xDOCUMENT_LINK);
            Main.Click(xDOCUMENT_DETAILS);

            Main.Send(xDOCUMENT_INPUT, "120225-00040");
            Main.Click(xDOCUMENT_SEARCH_BUTTON);

            Main.TimeOut(3000);

            if (Main.IsDisp(xCLOSE_BUTTON)) {
                Main.Click(xCLOSE_BUTTON);
            }

            Main.TimeOut(1000);
            Main.Click(xNEXT_BUTTON);

//            Main.Click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/div/div/div/button");
            Main.Click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/div[1]/div/div/button");

            WebElement fileInput = driver.findElement(By.xpath(xFILE_INPUT));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInput);

            Main.Send(xFILE_INPUT, "C:\\Users\\naknyazev\\Documents\\ПОЛЫ с СП\\forestDevelopmentProject(" + i + ").xml");

            Main.Click(xSIGN_BUTTON);
            Main.Click("/html/body/div[4]/div[3]/div/div/div[2]/div/div");
            Main.Click("//*[@id=\"menu-\"]/div[3]/ul/li[4]");
            Main.Click(xSIGN_CONFIRM_BUTTON);

            while (!Main.IsDisp("/html/body/div[3]/div[3]/div/main/form/div/div[3]/div/div/button")) {
                Main.TimeOut(1000);
            }

            Main.Click("/html/body/div[3]/div[3]/div/main/form/div/div[1]/div/div/div/div/input");
            Main.ArrowDown();
            Main.ArrowDown();
            Main.ArrowDown();
            Main.Enter();

            Main.Click("/html/body/div[3]/div[3]/div/footer/button[2]");

            Main.TimeOut(1000);
            Main.Click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/button[2]");

            Main.TimeOut(3000);
            Main.Click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/button[2]");

            Main.TimeOut(3000);
            Main.Click("/html/body/div[4]/div[3]/div/footer/button[2]");
            Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/div/div");
            Main.Click("//*[@id=\"menu-\"]/div[3]/ul/li[4]");
            Main.Click("/html/body/div[3]/div[3]/div/div/div[3]/button");
            Main.Click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/h2/a");
            Main.TimeOut(3000);
            Main.Refresh();
            Main.TimeOut(2000);
            String bizKey = Main.GetText(xBIZ_KEY);
            Main.WriteTextToFile(bizKey, "log_POL.txt");
        }
    }
    @Test(enabled = false)
    public void step_04_Autorization_rmdl(){

        driver.get(String.valueOf("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/documents"));

        Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
        Main.Send("//*[@id=\"login\"]", "+79524945159");
        Main.Send("//*[@id=\"password\"]", "Dy2-6bn3WU" );
        Main.Click("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button");

        Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[2]");
        Main.TimeOut(2000);
        Main.Click("/html/body/div/div[2]/div[2]/div[3]/button[1]");

        Main.TimeOut(1000);

    }

}