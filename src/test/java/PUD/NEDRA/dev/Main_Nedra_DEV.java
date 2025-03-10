package PUD.NEDRA.dev;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.BasePage;
import java.time.Duration;

import static browser.Config.WAIT;

public class Main_Nedra_DEV {

    private WebDriver driver;
    private BasePage Base;
    private String urlPudOutputter;
    private String cartDoc;
    private String urlIntoGLR;

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
    public void step_01_Autorization_rmdl(){

        driver.get(String.valueOf("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/documents"));

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button");
        Base.send("//*[@id=\"login\"]", "+79524945159");
        Base.send("//*[@id=\"password\"]", "Dy2-6bn3WU" );
        Base.click("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/button");

        Base.click("//*[@id=\"app\"]/div[2]/div[2]/div[3]/div/button[2]");
        Base.timeOut(2000);
        Base.click("/html/body/div/div[2]/div[2]/div[3]/button[1]");

        Base.timeOut(1000);

    }

    @Test(enabled = true)
    public void step_02_post_nedra() {
        for (int i = 1; i < 2; i++) {
            String date = Base.dateNow();
            Base.get("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/documents");
            Base.send("//*[@id=\":r3:\"]", "недра");
            Base.timeOut(2000);
            Base.arrowDown();
            Base.enter();
            Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[2]/div/div[3]/button[2]");

            Base.send("//*[@id=\":r5:\"]", "NEDRA_AUTO_" + date);
            Base.send("//*[@id=\":r6:\"]", "ОРГАНИЗАЦИЯ -1635872784");
            Base.send("//*[@id=\":r7:\"]", "NEDRA_auto_doc_no_" + date + "_" + Base.randomNum(3));
            Base.click("//*[@id=\":r8:\"]");
            Base.send("//*[@id=\":r8:\"]", date);

            WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"file\"]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInput);

            WebElement fileInputSig = driver.findElement(By.xpath("//*[@id=\"fileSig\"]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInputSig);

            Base.send("//*[@id=\"file\"]", "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\ДКПkna.pdf");
            Base.send("//*[@id=\"fileSig\"]", "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\ДКПkna.pdf.sig");
            Base.timeOut(1000);
            String bizKey = Base.getText("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/p[2]");
            Base.writeTextToFile(bizKey, "log_NEDRA.txt");

            Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[3]/div/button");
            Base.click("/html/body/div[3]/div[3]/div/div/div[2]/button[2]");
            cartDoc = Base.getUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a");
            Base.timeOut(2000);
        }
    }

    @Test(enabled = true)
    public void step_03_wait_outputNedra() {

        Base.timeOut(5000);
        Base.refresh();

        while(!Base.isDisp("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a")){
            Base.refresh();
        }

        Boolean b = Base.isDisp("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]");
        System.out.println(b);

        urlPudOutputter = Base.getUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Base.writeTextToFile(urlPudOutputter, "log_DKP.txt");

        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
    }

    @Test
    public void step_04_output_nedra() {

        Base.get(urlPudOutputter);
//        Main.Get("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/pud/task?target=formKeyPudExtractInformation&id=3ad3eade-f8cf-11ef-a9ef-66b1b5185b8c&key=formKeyPudExtractInformation&process=pud_digitize_doc");
        Base.timeOut(5000);
        Base.refresh();
        Base.timeOut(5000);

        String date = Base.dateNow();
        String end_date = Base.randomDateToday();
// Шапка
        Base.sendDate("//*[@id=\":r3:\"]", date);
        Base.sendDate("//*[@id=\":r7:\"]", date);
        Base.sendDate("//*[@id=\":ra:\"]", date);
        Base.sendDate("//*[@id=\":rc:\"]", date);

        Base.listDown("//*[@id=\":r1k:\"]", 1);
        Base.listDown("//*[@id=\":r1m:\"]", 1);
        Base.listDown("//*[@id=\":r1o:\"]", 1);

        Base.send("//*[@id=\":r2:\"]", Base.randomNum(3));
        Base.send("//*[@id=\":r5:\"]", Base.randomNum(3));
        Base.send("//*[@id=\":r6:\"]", Base.randomNum(5));
        Base.send("//*[@id=\":r9:\"]", Base.randomNum(8));

// Сведения о лесопользователе

        Base.listDown("//*[@id=\":re:\"]", 2);
        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[14]/div[1]/div[3]/div/button");
        Base.timeOut(3000);
        try {
            Base.send("//*[@id=\":r2s:\"]", "7708237747");
        }
        catch (Exception e){
            Base.send("//*[@id=\":r2c:\"]", "7708237747");
        }
        Base.timeOut(3000);
        Base.click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
        Base.timeOut(3000);
            try{
                Base.click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]/span");
                Base.timeOut(1000);
                Base.click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
                Base.timeOut(2000);
            }
            catch (Exception e){
                System.out.println("Контрагент не найден");
            }

        Base.send("//*[@id=\":r26:\"]", "г. Дубки, ул. Дубовая, кв. Дубовый, д. 12");
        Base.send("//*[@id=\":r2a:\"]", "glinkov@fciit.ru");

// Сведения об участке недр

        Base.listDown("//*[@id=\":r1d:\"]", 1);
        Base.send("//*[@id=\":r1e:\"]", Base.randomNum(4));
        Base.send("//*[@id=\":r1q:\"]", "Вельское");
        Base.timeOut(1500);
        Base.listDown("//*[@id=\":r1q:\"]", 3);
        Base.send("//*[@id=\":r1f:\"]", "Работы");
// Местоположение
        Base.listDown("//*[@id=\":r1s:\"]", 1);
        Base.send("//*[@id=\":r1u:\"]", "Тегринское");
        Base.timeOut(1500);
        Base.listDown("//*[@id=\":r1u:\"]", 1);
// Лесные кварталы \ выделы

//        Main.ListDown("//*[@id=\":r1h:\"]", 2); // Учетный квартал
//        Main.Send("//*[@id=\":r22:\"]", "29:3:10:66");

        Base.listUp("//*[@id=\":r1h:\"]", 2);   // Лесоустроительный квартал
        Base.send("//*[@id=\":r2s:\"]", "65");

        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[16]/div[3]/div[4]/div[3]/div[6]/div[3]/div[2]/div/div[2]/button");

//        Main.ListDown("//*[@id=\":r23:\"]", 2);// Учетный выдел
//        Main.Send("//*[@id=\":r24:\"]", "29:3:10:66:49");

        Base.listUp("//*[@id=\":r2t:\"]", 2);// Лесоустроительный выдел
        Base.send("//*[@id=\":r2u:\"]", "40");
// Цели
        Base.send("//*[@id=\":rf:\"]", "Импорт");
        Base.send("//*[@id=\":r1c:\"]", "Без особенностей");
// Внесение
        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Base.timeOut(5000);
        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Base.timeOut(2000);
        Base.click("/html/body/div[3]/div[3]/div/div[2]/button");
    }

    @Test(successPercentage=100)
    public void step_05_wait_intoGLR() {
        Base.timeOut(3000);
        Base.get(cartDoc);

        while(!Base.isDisp("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a")){
            Base.refresh();
        }

        urlIntoGLR = Base.getUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Base.writeTextToFile(urlIntoGLR, "log_DKP.txt");

        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Base.timeOut(3000);
    }
    @Test
    public void step_06_intoGLR() {

        Base.get(urlIntoGLR);

// Кнопка внесения
        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[7]/button");
        Base.timeOut(3000);
        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[7]/button[1]");
        Base.timeOut(4000);
// Чекбоксы
        Base.click("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div/div/div/label/span[1]");
        Base.click("/html/body/div[3]/div[3]/div/div/div[2]/div[2]/div/div/div/label/span[1]");
        Base.click("/html/body/div[3]/div[3]/div/div/div[2]/div[3]/div/div/div/label/span[1]");

        Base.click("/html/body/div[3]/div[3]/div/div/div[3]/button");
// Подпись
        Base.click("/html/body/div[3]/div[3]/div/div/div[2]/div/div");
        Base.click("//*[@id=\"menu-\"]/div[3]/ul/li[3]");
        Base.click("/html/body/div[3]/div[3]/div/div/div[3]/button");
        Base.timeOut(3000);
        Base.click("/html/body/div[3]/div[3]/div/div/div/button");
        Base.timeOut(4000);
        Base.click("/html/body/div[3]/div[3]/div/div/div/button");
        Base.timeOut(5000);
// Проверка оповещения
        if(Base.isDisp("//*[@id=\"app\"]/div[4]/div/div/div/div/div/div[1]/svg")){
            System.out.println("Внесение произошло");
        }
        else {
            System.out.println("Вероятно произошла ошибка, оповещение об успешности не отобразилось");
        }
    }
}