package PUD.DKP.dev;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.theInternet.MainPage;
import java.time.Duration;

import static browser.Config.WAIT;

public class MainDKP_DEV {
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

    @Test
    public void step_02_post_DKP() {
        for (int i = 1; i < 2; i++) {
            String date = Main.DateNow();
            Main.Get("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/documents");
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
            Main.Click("/html/body/div[3]/div[3]/div/div/div[2]/button[2]");
            cartDoc = Main.GetUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Main.TimeOut(2000);
        }
    }

    @Test
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

    @Test
    public void step_04_output_DKP() {

        Main.Get(urlPudOutputter);
//        Main.Get("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/pud/view/ddd40dd5-e9e1-11ef-9359-3a05138088e9");
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
        Main.ListDown("//*[@id=\":r2k:\"]", 1);
        Main.Send("//*[@id=\":r1a:\"]", "Дубки, кв. дубовый, дувецкое");
        Main.Send("//*[@id=\":r1b:\"]", "Дубки, кв. дубовый, дувецкое, дубни");
        Main.Send("//*[@id=\":r1c:\"]", "7970476159");
        Main.Send("//*[@id=\":r1d:\"]", "426944808");
        Main.Send("//*[@id=\":r1e:\"]", "1097793655222");
        Main.Send("//*[@id=\":r1f:\"]", "1097793655222");
// Банковские реквизиты
        Main.Send("//*[@id=\":r1m:\"]", "Дубки, кв. дубовый, дувецкое");
        Main.Send("//*[@id=\":r1n:\"]", Main.RandomNum(20));
        Main.Send("//*[@id=\":r1o:\"]", Main.RandomNum(20));
        Main.Send("//*[@id=\":r1p:\"]", Main.RandomNum(9));
// Данные сотрудника
        Main.Send("//*[@id=\":r1q:\"]", "Павел");
        Main.Send("//*[@id=\":r1r:\"]", "Орлов");
        Main.Send("//*[@id=\":r1s:\"]", "Автоматизирович");
        Main.Send("//*[@id=\":r1t:\"]", "Автоматизатор");
        Main.Send("//*[@id=\":r1u:\"]", "Уполномоченный робот");
        Main.Send("//*[@id=\":r1v:\"]", Main.RandomNum(6));
        Main.SendDate("//*[@id=\":r20:\"]", date);
        Main.Send("//*[@id=\":r22:\"]", "+79999999999");
        Main.SendDate("//*[@id=\":r23:\"]", date);
        Main.SendDate("//*[@id=\":r25:\"]", date);
// Сведения о заявителе

        Main.ListDown("//*[@id=\":ra:\"]", 1);
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[9]/div[1]/div[3]/div/button");
        Main.Send("//*[@id=\":r3s:\"]", "ОРГАНИЗАЦИЯ -1635872784");
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

        Main.Send("//*[@id=\":r36:\"]", "г. Дубки, ул. Дубовая, кв. Дубовый, д. 12");
        Main.Send("//*[@id=\":r3a:\"]", "glinkov@fciit.ru");
// Сведения о представителе
        Main.Send("//*[@id=\":r3c:\"]", "Иванов");
        Main.Send("//*[@id=\":r3d:\"]", "Иван");
        Main.Send("//*[@id=\":r3e:\"]", "Автоматизирович");
        Main.Send("//*[@id=\":r3f:\"]", Main.RandomNum(11));
// Тип документа
        Main.Click("//*[@id=\":r3q:\"]");
        for(int i = 0; i < 12; i++){
            Main.ArrowDown();
        }
        Main.Enter();
        Main.Send("//*[@id=\":r3g:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r3h:\"]", Main.RandomNum(8));
        Main.Send("//*[@id=\":r3i:\"]", "УМДВ АВТОМАТИЗИРОВЛЯНДИИ ПО ГОРОДУ АВТОМАТИЗАТОР");
        Main.SendDate("//*[@id=\":r3j:\"]", "01012003");
        Main.Send("//*[@id=\":r3l:\"]", Main.RandomNum(6));
        Main.Send("//*[@id=\":r3m:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
        Main.Send("//*[@id=\":r3n:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
        Main.Send("//*[@id=\":r3o:\"]", "current_email_adress@bk.ru");
        Main.Send("//*[@id=\":r3p:\"]", "+79523995155");
// Предмет договора
        Main.Click("//*[@id=\":r1g:\"]");
        Main.Enter();

        Main.ListDown("//*[@id=\":r4b:\"]", 1);
        Main.Send("//*[@id=\":r4c:\"]", Main.RandomNum(4));
        Main.SendDate("//*[@id=\":r4d:\"]", date);
        Main.ListDown("//*[@id=\":r2m:\"]", 1);
        Main.ListDown("//*[@id=\":r2o:\"]", 1);
// Цель приобретения
        Main.Send("//*[@id=\":r27:\"]", "Вывоз в ...");
// Характеристика лесных насаждений
        Main.ListDown("//*[@id=\":r2q:\"]", 1);
        Main.ListDown("//*[@id=\":r2s:\"]", 1);
        Main.Send("//*[@id=\":r28:\"]", "500");
        Main.SendDate("//*[@id=\":r29:\"]", date);
        Main.Send("//*[@id=\":r2b:\"]", "Прекрасные условия");
        Main.Send("//*[@id=\":r2c:\"]", "500");
        Main.SendDate("//*[@id=\":r2d:\"]", end_date);
        Main.Send("//*[@id=\":r2h:\"]", "Очистка дергающим методом");
        Main.Send("//*[@id=\":r1h:\"]", "Крыжовник");
// Местоположение лесных насаждений
        Main.Send("//*[@id=\":r2u:\"]", "Вельское");
        Main.TimeOut(1000);
        for(int i = 0; i < 3; i++){
            Main.ArrowDown();
        }
        Main.Enter();

        Main.Send("//*[@id=\":r30:\"]", "Тегринское");
        Main.TimeOut(1000);
        Main.ArrowDown();
        Main.Enter();
// Размер платы
        Main.Send("//*[@id=\":rb:\"]", "180000000");
        Main.Send("//*[@id=\":r19:\"]", "180000000");
// Объем заготовки
        Main.ListDown("//*[@id=\":rc:\"]", 2);
        Main.TimeOut(1000);

        Main.ListDown("//*[@id=\":r4f:\"]", 2);
        Main.TimeOut(1000);

        Main.Send("//*[@id=\":r4v:\"]", "29:3:10:66"); // Учетный номер квартала

        Main.ListDown("//*[@id=\":r4h:\"]", 2);

        Main.Send("//*[@id=\":r50:\"]", "29:3:10:66:38"); // Учетный номер выдела

        Main.Send("//*[@id=\":r4i:\"]", "500");
        Main.ListDown("//*[@id=\":r4p:\"]", 1);
        Main.ListDown("//*[@id=\":r4r:\"]", 1);
        Main.ListDown("//*[@id=\":r4t:\"]", 1);
        Main.Send("//*[@id=\":r4j:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r4k:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r4l:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r4m:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r4n:\"]", Main.RandomNum(4));
        Main.Send("//*[@id=\":r4o:\"]", Main.RandomNum(4));
// Сведения об акте приема - передачи
        Main.Send("//*[@id=\":r1i:\"]", Main.RandomNum(6));
        Main.SendDate("//*[@id=\":r1j:\"]", date);
        Main.SendDate("//*[@id=\":r1l:\"]", date);
// Внесение
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Main.TimeOut(5000);
        Main.Click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Main.TimeOut(2000);
        Main.Click("/html/body/div[3]/div[3]/div/div[2]/button");
    }

    @Test(successPercentage=100)
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
    @Test
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