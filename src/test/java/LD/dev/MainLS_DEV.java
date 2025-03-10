package LD.dev;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;

import java.time.Duration;

import static browser.Config.WAIT;

public class MainLS_DEV {

    private WebDriver driver;
    private BasePage Base;

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));
        Base = new BasePage(driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

//    @Test
//    public void step_01_Autorization_rmdl(){
//
//        driver.get(String.valueOf("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/pil/scheduler"));
//
//        Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
//        Main.Send("//*[@id=\"login\"]", "+79524945159");
//        Main.Send("//*[@id=\"password\"]", "Dy2-6bn3WU" );
//        Main.Click("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button");
//
//        Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[2]");
//        Main.TimeOut(2000);
//        Main.Click("/html/body/div/div[2]/div[2]/div[3]/button[1]");
//
//        Main.TimeOut(1000);
//
//    }

    @Test
    public void step_02_Autorization_lkl(){

        driver.get(String.valueOf("https://pub.dev.fgislk.at-consulting.ru/lkl/#/cabinet"));

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
        Base.send("//*[@id=\"login\"]", "+79055681305");
        Base.send("//*[@id=\"password\"]", "Fcs2Dcx@^" );
        Base.click("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button");

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[5]");
       // Main.Scroll_down("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div");
       // Main.TimeOut(1000);
        //Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[5]");

        Base.timeOut(2000);

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");

        Base.timeOut(1000);
    }

    @Test
    public void step_03_post_LD() {

        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div/div[1]/a");
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div/div[1]/a/div");

        Base.send("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[1]/div[1]/div/div/div/input", "231224-00094");
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div[8]/div/button");

        Base.timeOut(3000);

        // Крестики
        Base.click("//*[@id=\"app\"]/div[4]/div[1]/div/div/div/div/div/span");
        Base.click("//*[@id=\"app\"]/div[4]/div[2]/div/div/div/div/div[1]/span");

//        WebElement dalee = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[2]/button[2]"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", dalee);
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[2]/button[2]");

        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/div[3]/div/div[2]/div[2]/div/div/div/div/div[6]/div/div/div[1]/button");

        // COORDS
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[5]/div[4]/div/button");
        Base.timeOut(1000);
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[5]/div[4]/button[1]");

        Base.send("/html/body/div[3]/div[3]/div/main/div/div[1]/div/div/input", "1");
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[2]/div/div/input", "46.72311828459392"); // Coord 1-1
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[3]/div/div/input", "53.96178040587847"); // Coord 1-2
        Base.click("/html/body/div[3]/div[3]/div/footer/button[2]");

        Base.send("/html/body/div[3]/div[3]/div/main/div/div[1]/div/div/input", "2");
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[2]/div/div/input", "46.723181156833686"); // Coord 2-1
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[3]/div/div/input", "53.96172942845535"); // Coord 2-2
        Base.click("/html/body/div[3]/div[3]/div/footer/button[2]");

        Base.send("/html/body/div[3]/div[3]/div/main/div/div[1]/div/div/input", "3");
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[2]/div/div/input", "46.72334322753031"); // Coord 3-1
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[3]/div/div/input", "53.9618264499563"); // Coord 3-2
        Base.click("/html/body/div[3]/div[3]/div/footer/button[2]");

        Base.click("/html/body/div[3]/div[3]/div/footer/button[1]");

        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[5]/div[4]/button[2]"); // Contur

        // Privazka
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[6]/div[4]/button");
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[1]/div/div/input", "1");
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[2]/div/div/input", "46.72311828459392"); // Coord 1-1
        Base.send("/html/body/div[3]/div[3]/div/main/div/div[3]/div/div/input", "53.96178040587847"); // Coord 1-2
        Base.click("/html/body/div[3]/div[3]/div/footer/button[2]");
        Base.click("/html/body/div[3]/div[3]/div/footer/button[1]");
        //
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/form/div[8]/button");
        //
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[6]/button[2]");
        //
        Base.timeOut(3000);
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/button[2]");
        // Podpis
        Base.timeOut(3000);
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[3]/button[2]");
        Base.click("/html/body/div[4]/div[3]/div/footer/button[2]");
        Base.click("/html/body/div[3]/div[3]/div/div/div[2]/div/div");
        Base.click("//*[@id=\"menu-\"]/div[3]/ul/li[4]");
        Base.click("/html/body/div[3]/div[3]/div/div/div[3]/button");
        Base.click("//*[@id=\"app\"]/div[3]/main/div/div[1]/div/div[2]/h2/a");

    }
}
