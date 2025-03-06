package PUD.DKP.st;

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

public class MainDKP_ST {
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
    public void step_02_post_DKP() {
        for (int i = 1; i < 2; i++) {
            String date = Main.DateNow();
            Main.Get("https://fgislk-test.gov.ru/rmdl/#/workplace/documents");
            Main.Send("//*[@id=\":r3:\"]", "купли");
            Main.TimeOut(3000);
            Main.ArrowDown();
            Main.Enter();
            Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[2]/div/div[3]/button[2]");

            Main.Send("//*[@id=\":r5:\"]", "DKP_AUTO_" + date);
            Main.Send("//*[@id=\":r6:\"]", "ОРГАНИЗАЦИЯ -1635872784");
            Main.Send("//*[@id=\":r7:\"]", "DKP_auto_doc_no_" + date);
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
            Main.WriteTextToFile(bizKey, "log_DKP.txt");

            Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[3]/div/button");
            Main.TimeOut(1000);
            Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/button[2]");
            Main.TimeOut(1000);
            cartDoc = Main.GetUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Main.TimeOut(2000);
        }
    }

    @Test(enabled = true)
    public void step_03_wait_outputDKP() {

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

    @Test(enabled = true)
    public void step_04_output_DKP() {


        Main.Get(urlPudOutputter);

//        Main.Get("https://fgislk-test.gov.ru/rmdl/#/workplace/pud/view/7b2ef702-f9ca-11ef-95d2-6e819d5ee989");
        Main.TimeOut(3000);
        Main.Refresh();
        Main.TimeOut(3000);

        String date = Main.DateNow();
        String end_date = Main.RandomDateToday();
// Шапка
        Main.Send("//*[@id=\":r2:\"]", Main.RandomNum(5)); // Дата заключения
        Main.Send("//*[@id=\":r5:\"]", Main.RandomNum(8));
        Main.SendDate("//*[@id=\":r3:\"]", date);
        Main.SendDate("//*[@id=\":r6:\"]", date);
        Main.SendDate("//*[@id=\":r8:\"]", end_date);
// Сведения о продавце
        Main.Click("/html/body/div[1]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[8]/div[2]/div/button");

        try {
            Main.Send("//*[@id=\":r33:\"]", "7708237747");
        } catch (Exception e) {
            Main.Send("//*[@id=\":r43:\"]", "7708237747");
        }

        Main.TimeOut(1000);
        Main.Click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
        Main.TimeOut(1000);
        Main.Click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]/span");
        Main.Click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
        Main.TimeOut(2000);

        Main.ListDown("//*[@id=\":r2l:\"]", 1);

        Main.Send("//*[@id=\":r1c:\"]", "Дубки, кв. дубовый, дувецкое");
        Main.Send("//*[@id=\":r1g:\"]", Main.RandomNum(5));
// Банковские реквизиты
        Main.Send("//*[@id=\":r1n:\"]", "Дубки, кв. дубовый, дувецкое");
        Main.Send("//*[@id=\":r1o:\"]", Main.RandomNum(20));
        Main.Send("//*[@id=\":r1p:\"]", Main.RandomNum(20));
        Main.Send("//*[@id=\":r1q:\"]", Main.RandomNum(9));
// Данные сотрудника
        Main.Send("//*[@id=\":r1r:\"]", "Павел");
        Main.Send("//*[@id=\":r1s:\"]", "Орлов");
        Main.Send("//*[@id=\":r1t:\"]", "Автоматизирович");
        Main.Send("//*[@id=\":r1u:\"]", "Автоматизатор");
        Main.Send("//*[@id=\":r1v:\"]", "Уполномоченный робот");
        Main.Send("//*[@id=\":r20:\"]", Main.RandomNum(6));
        Main.SendDate("//*[@id=\":r21:\"]", date);
        Main.Send("//*[@id=\":r23:\"]", "+7(222)2222222");
        Main.SendDate("//*[@id=\":r24:\"]", date);
        Main.SendDate("//*[@id=\":r26:\"]", "Организация ООО РГА");
// Сведения о заявителе

        Main.ListDown("//*[@id=\":rb:\"]", 1);
        Main.Click("/html/body/div[1]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[9]/div[1]/div[3]/div/button");
        Main.Send("//*[@id=\":r4c:\"]", "7840346335");
        Main.TimeOut(2000);
        Main.Click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
        Main.TimeOut(3000);
        try {
            Main.Click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]/div[1]/span");
            Main.TimeOut(1000);
            Main.Click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
            Main.TimeOut(2000);
        } catch (Exception e) {
            System.out.println("Контрагент не найден");
        }

        Main.Send("//*[@id=\":r3r:\"]", "glinkov@fciit.ru");
        Main.Send("//*[@id=\":r3s:\"]", "+7(222)2222222");
// Сведения о представителе
        Main.Send("//*[@id=\":r3t:\"]", "Иванов");
        Main.Send("//*[@id=\":r3u:\"]", "Иван");
        Main.Send("//*[@id=\":r3v:\"]", "Автоматизирович");
        Main.Send("//*[@id=\":r40:\"]", Main.RandomNum(11));
// Тип документа
        Main.ListDown("//*[@id=\":r4b:\"]", 12);
        Main.Send("//*[@id=\":r41:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r42:\"]", Main.RandomNum(8));
        Main.Send("//*[@id=\":r43:\"]", "УМДВ АВТОМАТИЗИРОВЛЯНДИИ ПО ГОРОДУ АВТОМАТИЗАТОР");
        Main.SendDate("//*[@id=\":r44:\"]", "01012003");
        Main.Send("//*[@id=\":r46:\"]", Main.RandomNum(6));
        Main.Send("//*[@id=\":r47:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
        Main.Send("//*[@id=\":r48:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
        Main.Send("//*[@id=\":r49:\"]", "current_email_adress@bk.ru");
        Main.Send("//*[@id=\":r4a:\"]", "+7(222)2222222");
// Предмет договора
        Main.ListUp("//*[@id=\":r1h:\"]", 1);
        Main.TimeOut(1000);
        Main.ListDown("//*[@id=\":r4s:\"]", 1);
        Main.TimeOut(1000);
        Main.Send("//*[@id=\":r4t:\"]", Main.RandomNum(4));
        Main.SendDate("//*[@id=\":r4u:\"]", date);
        Main.ListDown("//*[@id=\":r2n:\"]", 1);
        Main.ListDown("//*[@id=\":r2p:\"]", 1);
// Цель приобретения
        Main.Send("//*[@id=\":r28:\"]", "Вывоз в ...");
// Характеристика лесных насаждений
        Main.ListDown("//*[@id=\":r2r:\"]", 1);
        Main.ListDown("//*[@id=\":r2t:\"]", 1);
        Main.Send("//*[@id=\":r29:\"]", "500");
        Main.SendDate("//*[@id=\":r2a:\"]", date);
        Main.Send("//*[@id=\":r2c:\"]", "Прекрасные условия");
        Main.Send("//*[@id=\":r2d:\"]", "500");
        Main.SendDate("//*[@id=\":r2e:\"]", end_date);
        Main.Send("//*[@id=\":r2i:\"]", "Очистка дергающим методом");
        Main.Send("//*[@id=\":r1i:\"]", "Крыжовник");
// Местоположение лесных насаждений
        Main.Send("//*[@id=\":r2v:\"]", "Вельское");
        Main.TimeOut(1000);
        for (int i = 0; i < 3; i++) {
            Main.ArrowDown();
        }
        Main.Enter();

        Main.Send("//*[@id=\":r31:\"]", "Тегринское");
        Main.TimeOut(1000);
        Main.ArrowDown();
        Main.Enter();

        Main.ListDown("//*[@id=\":r2h:\"]", 1);
// Размер платы
        Main.Send("//*[@id=\":rc:\"]", "180000000");
        Main.Send("//*[@id=\":r1a:\"]", "180000000");
// Объем заготовки
        Main.ListDown("//*[@id=\":rd:\"]", 2);
        Main.TimeOut(1000);
        //
//            // Учетный
//            Main.ListDown("//*[@id=\":r50:\"]", 2);
//            Main.TimeOut(1000);
//
//            Main.Send("//*[@id=\":r5g:\"]", "29:3:10:66"); // Учетный номер квартала
//            Main.ListDown("//*[@id=\":r52:\"]", 2);
//            Main.Send("//*[@id=\":r5h:\"]", "29:3:10:66:38"); // Учетный номер выдела

        // Лесоустроительный
        Main.ListUp("//*[@id=\":r50:\"]", 2);
        Main.TimeOut(1000);

        Main.Send("//*[@id=\":r5g:\"]", "65"); // Лесоустроительный номер квартала
        Main.ListUp("//*[@id=\":r52:\"]", 2);
        Main.Send("//*[@id=\":r5h:\"]", "40"); // Лесоустроительный номер выдела
        //
        Main.Send("//*[@id=\":r53:\"]", "500");
        Main.ListDown("//*[@id=\":r5a:\"]", 1);
        Main.ListDown("//*[@id=\":r5c:\"]", 1);
//Объем породы древесины лесных насаждений, подлежащих заготовке
        Main.ListDown("//*[@id=\":r5e:\"]", 1);
        Main.Send("//*[@id=\":r54:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r55:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r56:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r57:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r58:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r59:\"]", Main.RandomNum(4));
// Сведения об акте приема - передачи
        Main.Send("//*[@id=\":r1j:\"]", Main.RandomNum(6));
        Main.SendDate("//*[@id=\":r1k:\"]", date);
        Main.SendDate("//*[@id=\":r1m:\"]", date);
// Внесение
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Main.TimeOut(5000);
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Main.TimeOut(2000);
        Main.Click("/html/body/div[3]/div[3]/div/div[2]/button");
//
////        Main.Get(urlPudOutputter);
//
//        Main.Get("https://fgislk-test.gov.ru/rmdl/#/workplace/pud/view/67f2f0ba-f35c-11ef-95d2-6e819d5ee989");
//        Main.TimeOut(3000);
//        Main.Refresh();
//        Main.TimeOut(3000);
//
//        String date = Main.DateNow();
//        String end_date = Main.RandomDateToday();
//// Шапка
//        Main.Send("//*[@id=\":r2:\"]", Main.RandomNum(5)); // Дата заключения
//        Main.Send("//*[@id=\":r5:\"]", Main.RandomNum(8));
//        Main.SendDate("//*[@id=\":r3:\"]", date);
//        Main.SendDate("//*[@id=\":r6:\"]", date);
//        Main.SendDate("//*[@id=\":r8:\"]", end_date);
//// Сведения о продавце
//        Main.Click("/html/body/div[1]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[8]/div[2]/div/button");
//
//        try {
//            Main.Send("//*[@id=\":r33:\"]", "7708237747");
//        }
//        catch (Exception e){
//            Main.Send("//*[@id=\":r43:\"]", "7708237747");
//        }
//
//        Main.TimeOut(1000);
//        Main.Click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
//        Main.TimeOut(1000);
//        Main.Click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]/span");
//        Main.Click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
//        Main.TimeOut(2000);
//
//        Main.ListDown("//*[@id=\":r2l:\"]", 1);
//
//        Main.Send("//*[@id=\":r1c:\"]", "Дубки, кв. дубовый, дувецкое");
//        Main.Send("//*[@id=\":r1g:\"]", Main.RandomNum(5));
//// Банковские реквизиты
//        Main.Send("//*[@id=\":r1n:\"]", "Дубки, кв. дубовый, дувецкое");
//        Main.Send("//*[@id=\":r1o:\"]", Main.RandomNum(20));
//        Main.Send("//*[@id=\":r1p:\"]", Main.RandomNum(20));
//        Main.Send("//*[@id=\":r1q:\"]", Main.RandomNum(9));
//// Данные сотрудника
//        Main.Send("//*[@id=\":r1r:\"]", "Павел");
//        Main.Send("//*[@id=\":r1s:\"]", "Орлов");
//        Main.Send("//*[@id=\":r1t:\"]", "Автоматизирович");
//        Main.Send("//*[@id=\":r1u:\"]", "Автоматизатор");
//        Main.Send("//*[@id=\":r1v:\"]", "Уполномоченный робот");
//        Main.Send("//*[@id=\":r20:\"]", Main.RandomNum(6));
//        Main.SendDate("//*[@id=\":r21:\"]", date);
//        Main.SendDate("//*[@id=\":r23:\"]", "+79999999999");
//        Main.SendDate("//*[@id=\":r24:\"]", date);
//        Main.SendDate("//*[@id=\":r26:\"]", "Организация ООО РГА");
//// Сведения о заявителе
//
//        Main.ListDown("//*[@id=\":rb:\"]", 1);
//        Main.Click("/html/body/div[1]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[9]/div[1]/div[3]/div/button");
//        Main.Send("//*[@id=\":r4d:\"]", "ОРГАНИЗАЦИЯ -1635872784");
//        Main.TimeOut(2000);
//        Main.Click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
//        Main.TimeOut(3000);
//        try{
//            Main.Click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]/div[1]/span");
//            Main.TimeOut(1000);
//            Main.Click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
//            Main.TimeOut(2000);
//        }
//        catch (Exception e){
//            System.out.println("Контрагент не найден");
//        }
//
//        Main.Send("//*[@id=\":r3r:\"]", "glinkov@fciit.ru");
//// Сведения о представителе
//        Main.Send("//*[@id=\":r3t:\"]", "Иванов");
//        Main.Send("//*[@id=\":r3u:\"]", "Иван");
//        Main.Send("//*[@id=\":r3v:\"]", "Автоматизирович");
//        Main.Send("//*[@id=\":r40:\"]", Main.RandomNum(11));
//// Тип документа
//        Main.ListDown("//*[@id=\":r4b:\"]", 12);
//        Main.Send("//*[@id=\":r41:\"]", Main.RandomNum(4));
//        Main.Send("//*[@id=\":r42:\"]", Main.RandomNum(8));
//        Main.Send("//*[@id=\":r43:\"]", "УМДВ АВТОМАТИЗИРОВЛЯНДИИ ПО ГОРОДУ АВТОМАТИЗАТОР");
//        Main.SendDate("//*[@id=\":r44:\"]", "01012003");
//        Main.Send("//*[@id=\":r46:\"]", Main.RandomNum(6));
//        Main.Send("//*[@id=\":r47:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
//        Main.Send("//*[@id=\":r48:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
//        Main.Send("//*[@id=\":r49:\"]", "current_email_adress@bk.ru");
//        Main.Send("//*[@id=\":r4a:\"]", "+79523995155");
//// Предмет договора
//        Main.ListUp("//*[@id=\":r1h:\"]", 1);
//        Main.TimeOut(1000);
//        Main.ListDown("//*[@id=\":r4s:\"]", 1);
//        Main.TimeOut(1000);
//        Main.Send("//*[@id=\":r4t:\"]", Main.RandomNum(4));
//        Main.SendDate("//*[@id=\":r4u:\"]", date);
//        Main.ListDown("//*[@id=\":r2n:\"]", 1);
//        Main.ListDown("//*[@id=\":r2p:\"]", 1);
//// Цель приобретения
//        Main.Send("//*[@id=\":r28:\"]", "Вывоз в ...");
//// Характеристика лесных насаждений
//        Main.ListDown("//*[@id=\":r2r:\"]", 1);
//        Main.ListDown("//*[@id=\":r2t:\"]", 1);
//        Main.Send("//*[@id=\":r29:\"]", "500");
//        Main.SendDate("//*[@id=\":r2a:\"]", date);
//        Main.Send("//*[@id=\":r2c:\"]", "Прекрасные условия");
//        Main.Send("//*[@id=\":r2d:\"]", "500");
//        Main.SendDate("//*[@id=\":r2e:\"]", end_date);
//        Main.Send("//*[@id=\":r2i:\"]", "Очистка дергающим методом");
//        Main.Send("//*[@id=\":r1i:\"]", "Крыжовник");
//// Местоположение лесных насаждений
//        Main.Send("//*[@id=\":r2v:\"]", "Вельское");
//        Main.TimeOut(1000);
//        for(int i = 0; i < 3; i++){
//            Main.ArrowDown();
//        }
//        Main.Enter();
//
//        Main.Send("//*[@id=\":r31:\"]", "Тегринское");
//        Main.TimeOut(1000);
//        Main.ArrowDown();
//        Main.Enter();
//
//        Main.ListDown("//*[@id=\":r2h:\"]", 1);
//// Размер платы
//        Main.Send("//*[@id=\":rc:\"]", "180000000");
//        Main.Send("//*[@id=\":r1a:\"]", "180000000");
//// Объем заготовки
//        Main.ListDown("//*[@id=\":rd:\"]", 2);
//        Main.TimeOut(1000);
//
//        Main.ListDown("//*[@id=\":r50:\"]", 2);
//        Main.TimeOut(1000);
//
//        Main.Send("//*[@id=\":r5g:\"]", "29:3:10:66"); // Учетный номер квартала
//
//        Main.ListDown("//*[@id=\":r52:\"]", 2);
//
//        Main.Send("//*[@id=\":r5h:\"]", "29:3:10:66:38"); // Учетный номер выдела
//
//        Main.Send("//*[@id=\":r53:\"]", "500");
//        Main.ListDown("//*[@id=\":r5a:\"]", 1);
//        Main.ListDown("//*[@id=\":r5c:\"]", 1);
////Объем породы древесины лесных насаждений, подлежащих заготовке
//        Main.ListDown("//*[@id=\":r5e:\"]", 1);
//        Main.Send("//*[@id=\":r54:\"]", Main.RandomNum(4));
//        Main.Send("//*[@id=\":r55:\"]", Main.RandomNum(4));
//        Main.Send("//*[@id=\":r56:\"]", Main.RandomNum(4));
//        Main.Send("//*[@id=\":r57:\"]", Main.RandomNum(4));
//        Main.Send("//*[@id=\":r58:\"]", Main.RandomNum(4));
//        Main.Send("//*[@id=\":r59:\"]", Main.RandomNum(4));
//// Сведения об акте приема - передачи
//        Main.Send("//*[@id=\":r1j:\"]", Main.RandomNum(6));
//        Main.SendDate("//*[@id=\":r1k:\"]", date);
//        Main.SendDate("//*[@id=\":r1m:\"]", date);
//// Внесение
//        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
//        Main.TimeOut(5000);
//        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
//        Main.TimeOut(2000);
//        Main.Click("/html/body/div[3]/div[3]/div/div[2]/button");
//    }
    }
    @Test(enabled = true)
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
    @Test(enabled = true)
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