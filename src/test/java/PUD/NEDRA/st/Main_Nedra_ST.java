package PUD.NEDRA.st;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.theInternet.MainPage;

import java.time.Duration;

import static browser.Config.WAIT;

public class Main_Nedra_ST {

    private WebDriver driver;
    private MainPage Main;
    private String urlPudOutputter;
    private String cartDoc;
    private String urlIntoGLR;

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

//    @Test
//    public void step_02_Autorization_lkl() {
//        driver.get(String.valueOf("https://pub.fgislk-test.gov.ru/lkl/#/cabinet"));
//        Main.Click(xLOGIN_BUTTON);
//        Main.Send(xLOGIN_FIELD, "+79055681305");
//        Main.Send(xPASSWORD_FIELD, "Fcs2Dcx@^");
//        Main.Click(xSUBMIT_LOGIN_BUTTON);
//        Main.Click(xCONTINUE_BUTTON);
//        Main.TimeOut(2000);
//        Main.Click(xLOGIN_BUTTON);
//        Main.TimeOut(1000);
//    }
    @Test
    public void step_01_Autorization_rmdl(){

        driver.get(String.valueOf("https://fgislk-test.gov.ru/rmdl/#/workplace/documents"));

        Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
        Main.Send("//*[@id=\"login\"]", "+79524945159");
        Main.Send("//*[@id=\"password\"]", "Dy2-6bn3WU" );
        Main.Click("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button");

        Main.Click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[2]");
        Main.TimeOut(2000);
        Main.Click("/html/body/div/div[2]/div[2]/div[3]/button[1]");

        Main.TimeOut(1000);

    }

    @Test(enabled = true)
    public void step_02_post_nedra() {
        for (int i = 1; i < 2; i++) {
            String date = Main.DateNow();
            Main.Get("https://fgislk-test.gov.ru/rmdl/#/workplace/documents");
            Main.Send("//*[@id=\":r3:\"]", "недра");
            Main.TimeOut(2000);
            Main.ArrowDown();
            Main.Enter();
            Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[2]/div/div[3]/button[2]");

            Main.Send("//*[@id=\":r5:\"]", "NEDRA_AUTO_" + date);
            Main.Send("//*[@id=\":r6:\"]", "ОРГАНИЗАЦИЯ -1635872784");
            Main.Send("//*[@id=\":r7:\"]", "NEDRA_auto_doc_no_" + date + "_" + Main.RandomNum(3));
            Main.Click("//*[@id=\":r8:\"]");
            Main.Send("//*[@id=\":r8:\"]", date);

            WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"file\"]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInput);

            WebElement fileInputSig = driver.findElement(By.xpath("//*[@id=\"fileSig\"]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInputSig);

            Main.Send("//*[@id=\"file\"]", "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\ДКПkna.pdf");
            Main.Send("//*[@id=\"fileSig\"]", "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\ДКПkna.pdf.sig");
            Main.TimeOut(1000);
            String bizKey = Main.GetText("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/p[2]");
            Main.WriteTextToFile(bizKey, "log_NEDRA.txt");

            Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[3]/div/button");
            Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/button[2]");
            Main.TimeOut(1000);
            cartDoc = Main.GetUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Main.TimeOut(2000);
        }
    }

    @Test(enabled = true)
    public void step_03_wait_outputNedra() {

        Main.TimeOut(5000);
        Main.Refresh();

        while(!Main.IsDisp("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a")){
            Main.Refresh();
        }

        Boolean b = Main.IsDisp("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]");
        System.out.println(b);

        urlPudOutputter = Main.GetUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Main.WriteTextToFile(urlPudOutputter, "log_DKP.txt");

        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
    }

    @Test
    public void step_04_output_nedra() {

        Main.Get(urlPudOutputter);
//        Main.Get("https://fgislk-test.gov.ru/rmdl/#/workplace/pud/view/ca2e3773-f049-11ef-95d2-6e819d5ee989");
        Main.TimeOut(3000);
        Main.Refresh();
        Main.TimeOut(3000);

        String date = Main.DateNow();
        String end_date = Main.RandomDateToday();
// Шапка
        Main.SendDate("//*[@id=\":r3:\"]", date);
        Main.SendDate("//*[@id=\":r7:\"]", date);
        Main.SendDate("//*[@id=\":ra:\"]", date);
        Main.SendDate("//*[@id=\":rc:\"]", end_date);

        Main.ListDown("//*[@id=\":r1k:\"]", 1);
        Main.ListDown("//*[@id=\":r1m:\"]", 1);
        Main.ListDown("//*[@id=\":r1o:\"]", 1);

        Main.Send("//*[@id=\":r2:\"]", Main.RandomNum(3));
        Main.Send("//*[@id=\":r5:\"]", Main.RandomNum(3));
        Main.Send("//*[@id=\":r6:\"]", Main.RandomNum(5));
        Main.Send("//*[@id=\":r9:\"]", Main.RandomNum(8));

// Сведения о лесопользователе

        Main.ListDown("//*[@id=\":re:\"]", 2);
        Main.TimeOut(1000);
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[14]/div[1]/div[3]/div/button");
        Main.TimeOut(2000);
        Main.Send("//*[@id=\":r2c:\"]", "7708237747");
        Main.TimeOut(2000);
        Main.Click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
        Main.TimeOut(3000);
            try{
                Main.Click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]/span");
                Main.TimeOut(1000);
                Main.Click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
                Main.TimeOut(2000);
            }
            catch (Exception e){
                System.out.println("Контрагент не найден");
            }

        Main.Send("//*[@id=\":r26:\"]", "г. Дубки, ул. Дубовая, кв. Дубовый, д. 12");
        Main.Send("//*[@id=\":r2a:\"]", "glinkov@fciit.ru");
// Сведения о представителе
//        Main.Send("//*[@id=\":r3c:\"]", "Иванов");
//        Main.Send("//*[@id=\":r3d:\"]", "Иван");
//        Main.Send("//*[@id=\":r3e:\"]", "Автоматизирович");
//        Main.Send("//*[@id=\":r3f:\"]", Main.RandomNum(11));

// Сведения об участке недр

        Main.ListDown("//*[@id=\":r1d:\"]", 1);
        Main.Send("//*[@id=\":r1e:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r1q:\"]", "Вельское");
        Main.TimeOut(1500);
        Main.ListDown("//*[@id=\":r1q:\"]", 3);
        Main.Send("//*[@id=\":r1f:\"]", "Работы");

        Main.ListDown("//*[@id=\":r1s:\"]", 1);
        Main.ListDown("//*[@id=\":r1u:\"]", 1);
        Main.Send("//*[@id=\":r20:\"]", "Тегринское");
        Main.TimeOut(1500);
        Main.ListDown("//*[@id=\":r20:\"]", 1);
// Лесные кварталы \ выделы

        Main.ListDown("//*[@id=\":r1h:\"]", 2); // Учетный квартал
        Main.Send("//*[@id=\":r22:\"]", "29:3:10:66");

//        Main.ListUp("//*[@id=\":r1h:\"]", 2);   // Лесоустроительный квартал
//        Main.Send("//*[@id=\":r2s:\"]", "65");
        Main.TimeOut(1000);
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[16]/div[3]/div[4]/div[3]/div[6]/div[3]/div[2]/div/div[2]/button");
        Main.TimeOut(1000);

//        Main.ListDown("//*[@id=\":r23:\"]", 2);// Учетный выдел
//        Main.Send("//*[@id=\":r24:\"]", "29:3:10:66:49");

        Main.ListUp("//*[@id=\":r2t:\"]", 2);// Лесоустроительный выдел
        Main.Send("//*[@id=\":r2u:\"]", "40");
// Цели
        Main.Send("//*[@id=\":rf:\"]", "Импорт");
        Main.Send("//*[@id=\":r1c:\"]", "Без особенностей");
// Внесение
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Main.TimeOut(5000);
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Main.TimeOut(2000);
        Main.Click("/html/body/div[3]/div[3]/div/div[2]/button");
    }

    @Test(enabled = false)
    public void step_05_wait_intoGLR() {
        Main.TimeOut(3000);
        Main.Get(cartDoc);

        while(!Main.IsDisp("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a")){
            Main.Refresh();
        }

        urlIntoGLR = Main.GetUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Main.WriteTextToFile(urlIntoGLR, "log_DKP.txt");

        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Main.TimeOut(3000);
    }
    @Test(enabled = false)
    public void step_06_intoGLR() {

        Main.Get(urlIntoGLR);

// Кнопка внесения
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[7]/button");
        Main.TimeOut(3000);
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[7]/button[1]");
        Main.TimeOut(4000);
// Чекбоксы
        Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div/div/div/label/span[1]");
        Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/div[2]/div/div/div/label/span[1]");
        Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/div[3]/div/div/div/label/span[1]");

        Main.Click("/html/body/div[3]/div[3]/div/div/div[3]/button");
// Подпись
        Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/div/div");
        Main.Click("//*[@id=\"menu-\"]/div[3]/ul/li[3]");
        Main.Click("/html/body/div[3]/div[3]/div/div/div[3]/button");
        Main.TimeOut(3000);
        Main.Click("/html/body/div[3]/div[3]/div/div/div/button");
        Main.TimeOut(4000);
        Main.Click("/html/body/div[3]/div[3]/div/div/div/button");
        Main.TimeOut(5000);
// Проверка оповещения
        if(Main.IsDisp("//*[@id=\"app\"]/div[4]/div/div/div/div/div/div[1]/svg")){
            System.out.println("Внесение произошло");
        }
        else {
            System.out.println("Вероятно произошла ошибка, оповещение об успешности не отобразилось");
        }
    }
}