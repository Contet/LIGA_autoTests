package POL.dev;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.BasePage;

import java.time.Duration;

import static constants.BaseConst_DEV.*;
import static browser.Config.WAIT;

public class MainPOL_DEV {

    private WebDriver driver;
    private BasePage Base;
    public String bizKey;
    public String url_tasks = "https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/processes/";

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
        Base = new BasePage(driver);
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void step_02_Autorization_lkl() {
        driver.get(xDEV_START_PAGE);

        Base.click(xLOGIN_BUTTON);
        Base.send(xLOGIN_FIELD, "+79055681305");
        Base.send(xPASSWORD_FIELD, "Fcs2Dcx@^");
        Base.click(xSUBMIT_BUTTON);

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[5]");
        Base.timeOut(2000);
        Base.click(xLOGIN_BUTTON);

        Base.timeOut(1000);
    }

    @Test
    public void step_03_post_POL() {
        for (int i = 1; i < 2; i++) {
            Base.get(xDEV_START_PAGE);
            Base.timeOut(2000);

            Base.click(xDOCUMENT_LINK);
            Base.click(xDOCUMENT_DETAILS);

            Base.send(xDOCUMENT_INPUT, "120225-00040");
            Base.click(xDOCUMENT_SEARCH_BUTTON);

            Base.timeOut(3000);

            if (Base.isDisp(xCLOSE_BUTTON)) {
                Base.click(xCLOSE_BUTTON);
            }

            Base.timeOut(1000);
            Base.click(xNEXT_BUTTON);

//            Main.Click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/div/div/div/button");
            Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/div[1]/div/div/button");

            WebElement fileInput = driver.findElement(By.xpath(xFILE_INPUT));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInput);

            Base.send(xFILE_INPUT, "C:\\Users\\naknyazev\\Documents\\ПОЛЫ с СП\\forestDevelopmentProject(" + i + ").xml");

            Base.click(xSIGN_BUTTON);
            Base.click("/html/body/div[4]/div[3]/div/div/div[2]/div/div");
            Base.click("//*[@id=\"menu-\"]/div[3]/ul/li[4]");
            Base.click(xSIGN_CONFIRM_BUTTON);

            while (!Base.isDisp("/html/body/div[3]/div[3]/div/main/form/div/div[3]/div/div/button")) {
                Base.timeOut(1000);
            }

            Base.click("/html/body/div[3]/div[3]/div/main/form/div/div[1]/div/div/div/div/input");
            Base.arrowDown();
            Base.arrowDown();
            Base.arrowDown();
            Base.enter();

            Base.click("/html/body/div[3]/div[3]/div/footer/button[2]");

            Base.timeOut(1000);
            Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/button[2]");

            Base.timeOut(3000);
            Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/button[2]");

            Base.timeOut(3000);
            Base.click("/html/body/div[4]/div[3]/div/footer/button[2]");
            Base.click("/html/body/div[3]/div[3]/div/div/div[2]/div/div");
            Base.click("//*[@id=\"menu-\"]/div[3]/ul/li[4]");
            Base.click("/html/body/div[3]/div[3]/div/div/div[3]/button");
            Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/h2/a");
            Base.timeOut(3000);
            Base.refresh();
            Base.timeOut(2000);
            bizKey = Base.getText(xBIZ_KEY);
            Base.writeTextToFile(bizKey, "log_POL.txt");
        }
    }
    @Test
    public void step_04_Autorization_rmdl(){

        driver.get(String.valueOf("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/documents"));

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
       if(!Base.isDisp("//*[@id=\"login\"]")) {
           Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
           Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
           Base.click("/html/body/esia-root/div/esia-login/div/div[1]/form/esia-login-found/div/div[2]/button");
       }
        Base.send("//*[@id=\"login\"]", "+79524945159");
        Base.send("//*[@id=\"password\"]", "Dy2-6bn3WU" );
        Base.click("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button");

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[2]");
        Base.timeOut(2000);
        Base.click("/html/body/div/div[2]/div[2]/div[3]/button[1]");

        Base.timeOut(1000);

    }
    @Test
    public void step_05_Wait_POL(){
        String xTASK = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a";

        Base.timeOut(1000);
        Base.get(url_tasks + bizKey);
        Base.timeOut(2000);

        Base.waitTask(xTASK);
    }

    @Test
    public void step_06_POL_1(){
        Base.timeOut(2000);
        Base.click("/html/body/esia-root/div/esia-login/div/div[1]/form/esia-login-found/div/div[2]/button");
        Base.timeOut(2000);
        Base.click("//*[@id=\"panel-task\"]/div/div/div[3]/button[1]");
        Base.click("/html/body/div[3]/div[3]/div/div/div/button[2]");
        Base.click("//*[@id=\"app\"]/div[4]/div/div/div/div/div/div[1]/span/svg");
        Base.get(url_tasks + bizKey);
        step_05_Wait_POL();
    }

    @Test
    public void step_07_POL_2(){
        Base.timeOut(2000);

    }



}