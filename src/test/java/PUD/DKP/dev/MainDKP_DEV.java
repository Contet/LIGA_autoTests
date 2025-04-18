package PUD.DKP.dev;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;
import pages.RMDL.PUD.DKP.DKP;

import java.time.Duration;

import static browser.Config.EXPLICIT_WAIT;
import static pages.RMDL.placement.LinksPlacement.LINK_PLACEMENT_MAIN;

public class MainDKP_DEV {

    public static final String xFIELD_FIND_DOCUMENT = "//*[@id=\":r3:\"]";
    public static final String xBUTTON_FIND_DOCUMENT = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div/div[2]/div/div[3]/button[2]";
    public static final String xFIELD_NAME_DOCUMENT = "//*[@id=\":r5:\"]";
    public static final String xFIELD_AUTOR_DOCUMENT = "//*[@id=\":r6:\"]";
    public static final String xFIELD_NUMBER_DOCUMENT = "//*[@id=\":r7:\"]";
    public static final String xDATE_FIELD_DOCUMENT = "//*[@id=\":r8:\"]";
    public static final String xHIDDEN_FIELD_INPUT_FILE = "//*[@id=\"file\"]";
    public static final String xHIDDEN_FIELD_INPUT_FILESIG = "//*[@id=\"fileSig\"]";
    public static final String SYSTEM_PATH_TO_INPUT_FILE = "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\ДКПkna.pdf";
    public static final String SYSTEM_PATH_TO_INPUT_FILESIG = "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\ДКПkna.pdf.sig";
    public static final String xTEXT_BIZ_KEY = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/p[2]";
    public static final String xBUTTON_ADD_DOCUMENT = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[3]/div/button";
    public static final String xBUTTON_ADD_DOCUMENT_SIG = "/html/body/div[3]/div[3]/div/div/div[2]/button[2]";
    public static final String xBUTTON_CLICK_TO_CARTDOC = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[1]/div/a";
    public static final String xBUTTON_GO_TO_TASK = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a";
    public static final String BUTTON_1 = "//*[@id=\":r2:\"]";

    private WebDriver driver;
    private BasePage Base;
    private String urlPudOutputter;
    private String cartDocLink;
    private String urlIntoGLR;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EXPLICIT_WAIT));
        Base = new BasePage(driver);

    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void step_01_Autorization_rmdl(){

        Base.get("https://dev.fgislk.at-consulting.ru/rmdl/#/workplace/documents");
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
    public void step_02_post_DKP() {
        for (int i = 1; i < 2; i++) {
            String date = Base.dateNow();
            Base.get(LINK_PLACEMENT_MAIN.getUrl());
            Base.send(xFIELD_FIND_DOCUMENT, "купли");
            Base.timeOut(3000);
            Base.listDown(xFIELD_FIND_DOCUMENT, 1);
            Base.click(xBUTTON_FIND_DOCUMENT);

            Base.send(xFIELD_NAME_DOCUMENT, "DKP_AUTO_" + date);
            Base.send(xFIELD_AUTOR_DOCUMENT, "ОРГАНИЗАЦИЯ -1635872784");
            Base.send(xFIELD_NUMBER_DOCUMENT, "DKP_auto_doc_no_" + date);
            Base.sendDate(xDATE_FIELD_DOCUMENT, date);

            Base.unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILE);
            Base.unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILESIG);

            Base.send(xHIDDEN_FIELD_INPUT_FILE, SYSTEM_PATH_TO_INPUT_FILE);
            Base.send(xHIDDEN_FIELD_INPUT_FILESIG, SYSTEM_PATH_TO_INPUT_FILESIG);
            Base.timeOut(1000);

            String bizKey = Base.getText(xTEXT_BIZ_KEY);
            Base.writeTextToFile(bizKey, "log_DKP.txt");

            Base.click(xBUTTON_ADD_DOCUMENT);
            Base.click(xBUTTON_ADD_DOCUMENT_SIG);
            Base.timeOut(1000);
            cartDocLink = Base.getUrl(xBUTTON_CLICK_TO_CARTDOC);
            Base.click(xBUTTON_CLICK_TO_CARTDOC);
            Base.timeOut(2000);
        }
    }


    @Test(enabled = true)
    public void step_03_wait_outputDKP() {

        Base.timeOut(5000);
        Base.refresh();

        Base.waitTask(null);

        urlPudOutputter = Base.getUrl(xBUTTON_GO_TO_TASK);
        Base.writeTextToFile(urlPudOutputter, "log_DKP.txt");

        Base.click(xBUTTON_GO_TO_TASK);
    }

    @Test(enabled = true)
    public void step_04_output_DKP() {

        Base.get(urlPudOutputter);

//        Main.Get("https://fgislk-test.gov.ru/rmdl/#/workplace/pud/view/7b2ef702-f9ca-11ef-95d2-6e819d5ee989");
        Base.timeOut(3000);
        Base.refresh();
        Base.timeOut(3000);

        String date = Base.dateNow();
        String end_date = Base.randomDateToday();
// Шапка
        Base.send(BUTTON_1, Base.randomNum(5)); // Дата заключения
        Base.send("//*[@id=\":r5:\"]", Base.randomNum(8));
        Base.sendDate("//*[@id=\":r3:\"]", date);
        Base.sendDate("//*[@id=\":r6:\"]", date);
        Base.sendDate("//*[@id=\":r8:\"]", end_date);
// Сведения о продавце
        Base.click("/html/body/div[1]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[8]/div[2]/div/button");

        try {
            Base.send("//*[@id=\":r33:\"]", "7708237747");
        } catch (Exception e) {
            Base.send("//*[@id=\":r43:\"]", "7708237747");
        }

        Base.timeOut(1000);
        Base.click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
        Base.timeOut(1000);
        Base.click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]/span");
        Base.click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
        Base.timeOut(2000);

        Base.listDown("//*[@id=\":r2l:\"]", 1);

        Base.send("//*[@id=\":r1c:\"]", "Дубки, кв. дубовый, дувецкое");
        Base.send("//*[@id=\":r1g:\"]", Base.randomNum(5));
// Банковские реквизиты
        Base.send("//*[@id=\":r1n:\"]", "Дубки, кв. дубовый, дувецкое");
        Base.send("//*[@id=\":r1o:\"]", Base.randomNum(20));
        Base.send("//*[@id=\":r1p:\"]", Base.randomNum(20));
        Base.send("//*[@id=\":r1q:\"]", Base.randomNum(9));
// Данные сотрудника
        Base.send("//*[@id=\":r1r:\"]", "Павел");
        Base.send("//*[@id=\":r1s:\"]", "Орлов");
        Base.send("//*[@id=\":r1t:\"]", "Автоматизирович");
        Base.send("//*[@id=\":r1u:\"]", "Автоматизатор");
        Base.send("//*[@id=\":r1v:\"]", "Уполномоченный робот");
        Base.send("//*[@id=\":r20:\"]", Base.randomNum(6));
        Base.sendDate("//*[@id=\":r21:\"]", date);
        Base.send("//*[@id=\":r23:\"]", "+7(222)2222222");
        Base.sendDate("//*[@id=\":r24:\"]", date);
        Base.sendDate("//*[@id=\":r26:\"]", "Организация ООО РГА");
// Сведения о заявителе

        Base.listDown("//*[@id=\":rb:\"]", 1);
        Base.click("/html/body/div[1]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[9]/div[1]/div[3]/div/button");
        Base.send("//*[@id=\":r4c:\"]", "7840346335");
        Base.timeOut(2000);
        Base.click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
        Base.timeOut(3000);

        try {
            Base.click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]/div[1]/span");
            Base.timeOut(1000);
            Base.click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
            Base.timeOut(2000);
        } catch (Exception e) {
            System.out.println("Контрагент не найден");
        }

        Base.send("//*[@id=\":r3r:\"]", "glinkov@fciit.ru");
        Base.send("//*[@id=\":r3s:\"]", "+7(222)2222222");
// Сведения о представителе
        Base.send("//*[@id=\":r3t:\"]", "Иванов");
        Base.send("//*[@id=\":r3u:\"]", "Иван");
        Base.send("//*[@id=\":r3v:\"]", "Автоматизирович");
        Base.send("//*[@id=\":r40:\"]", Base.randomNum(11));
// Тип документа
        Base.listDown("//*[@id=\":r4b:\"]", 12);
        Base.send("//*[@id=\":r41:\"]", Base.randomNum(4));
        Base.send("//*[@id=\":r42:\"]", Base.randomNum(8));
        Base.send("//*[@id=\":r43:\"]", "УМДВ АВТОМАТИЗИРОВЛЯНДИИ ПО ГОРОДУ АВТОМАТИЗАТОР");
        Base.sendDate("//*[@id=\":r44:\"]", "01012003");
        Base.send("//*[@id=\":r46:\"]", Base.randomNum(6));
        Base.send("//*[@id=\":r47:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
        Base.send("//*[@id=\":r48:\"]", "г. Автоматизатор, ул. От слова, д. Матиз");
        Base.send("//*[@id=\":r49:\"]", "current_email_adress@bk.ru");
        Base.send("//*[@id=\":r4a:\"]", "+7(222)2222222");
// Предмет договора
        Base.listUp("//*[@id=\":r1h:\"]", 1);
        Base.timeOut(1000);
        Base.listDown("//*[@id=\":r4s:\"]", 1);
        Base.timeOut(1000);
        Base.send("//*[@id=\":r4t:\"]", Base.randomNum(4));
        Base.sendDate("//*[@id=\":r4u:\"]", date);
        Base.listDown("//*[@id=\":r2n:\"]", 1);
        Base.listDown("//*[@id=\":r2p:\"]", 1);
// Цель приобретения
        Base.send("//*[@id=\":r28:\"]", "Вывоз в ...");
// Характеристика лесных насаждений
        Base.listDown("//*[@id=\":r2r:\"]", 1);
        Base.listDown("//*[@id=\":r2t:\"]", 1);
        Base.send("//*[@id=\":r29:\"]", "500");
        Base.sendDate("//*[@id=\":r2a:\"]", date);
        Base.send("//*[@id=\":r2c:\"]", "Прекрасные условия");
        Base.send("//*[@id=\":r2d:\"]", "500");
        Base.sendDate("//*[@id=\":r2e:\"]", end_date);
        Base.send("//*[@id=\":r2i:\"]", "Очистка дергающим методом");
        Base.send("//*[@id=\":r1i:\"]", "Крыжовник");
// Местоположение лесных насаждений
        Base.send("//*[@id=\":r2v:\"]", "Вельское");
        Base.timeOut(1000);
        for (int i = 0; i < 3; i++) {
            Base.arrowDown();
        }
        Base.enter();

        Base.send("//*[@id=\":r31:\"]", "Тегринское");
        Base.timeOut(1000);
        Base.arrowDown();
        Base.enter();

        Base.listDown("//*[@id=\":r2h:\"]", 1);
// Размер платы
        Base.send("//*[@id=\":rc:\"]", "180000000");
        Base.send("//*[@id=\":r1a:\"]", "180000000");
// Объем заготовки
        Base.listDown("//*[@id=\":rd:\"]", 2);
        Base.timeOut(1000);
        //
//            // Учетный
//            Main.ListDown("//*[@id=\":r50:\"]", 2);
//            Main.TimeOut(1000);
//
//            Main.Send("//*[@id=\":r5g:\"]", "29:3:10:66"); // Учетный номер квартала
//            Main.ListDown("//*[@id=\":r52:\"]", 2);
//            Main.Send("//*[@id=\":r5h:\"]", "29:3:10:66:38"); // Учетный номер выдела

        // Лесоустроительный
        Base.listUp("//*[@id=\":r50:\"]", 2);
        Base.timeOut(1000);

        Base.send("//*[@id=\":r5g:\"]", "65"); // Лесоустроительный номер квартала
        Base.listUp("//*[@id=\":r52:\"]", 2);
        Base.send("//*[@id=\":r5h:\"]", "40"); // Лесоустроительный номер выдела
        //
        Base.listDown("//*[@id=\":r51:\"]", 8); // Урочище
        Base.send("//*[@id=\":r53:\"]", "500");
        Base.listDown("//*[@id=\":r5a:\"]", 1);
        Base.listDown("//*[@id=\":r5c:\"]", 1);
//Объем породы древесины лесных насаждений, подлежащих заготовке
        Base.listDown("//*[@id=\":r5e:\"]", 1);
        Base.send("//*[@id=\":r54:\"]", Base.randomNum(4));
        Base.send("//*[@id=\":r55:\"]", Base.randomNum(4));
        Base.send("//*[@id=\":r56:\"]", Base.randomNum(4));
        Base.send("//*[@id=\":r57:\"]", Base.randomNum(4));
        Base.send("//*[@id=\":r58:\"]", Base.randomNum(4));
        Base.send("//*[@id=\":r59:\"]", Base.randomNum(4));
// Сведения об акте приема - передачи
        Base.send("//*[@id=\":r1j:\"]", Base.randomNum(6));
        Base.sendDate("//*[@id=\":r1k:\"]", date);
        Base.sendDate("//*[@id=\":r1m:\"]", date);
// Внесение
        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Base.timeOut(5000);
        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[4]/div/button[2]");
        Base.timeOut(2000);
        Base.click("/html/body/div[3]/div[3]/div/div[2]/button");
    }

    @Test(enabled = true)
    public void step_05_wait_intoGLR() {
        Base.timeOut(3000);
        Base.get(cartDocLink);

        while(!Base.isDisp("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a")){
            Base.refresh();
        }

        urlIntoGLR = Base.getUrl("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Base.writeTextToFile(urlIntoGLR, "log_DKP.txt");

        Base.click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a");
        Base.timeOut(3000);
    }

    @Test(enabled = true)
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