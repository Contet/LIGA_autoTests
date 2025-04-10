package pages.RMDL.placement;

import dataSet.RMDL.PUD.ARENDA.DataRent;
import dataSet.RMDL.PUD.ARENDA.DocumentRent;
import dataSet.RMDL.PUD.DKP.DataDKP;
import dataSet.RMDL.PUD.DKP.DocumentDKP;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static pages.RMDL.placement.LinksPlacement.LINK_PLACEMENT_MAIN;
import static pages.RMDL.placement.xPlacement_Dirt.*;

public class PlacementPage extends BasePage {
    public PlacementPage(WebDriver driver) {
        super(driver);
    }

    public String cartDocLink;
    public String bizKey;


    // ДКП
    public void DKP(String data){
        DataDKP doc = DocumentDKP.valueOf(data.toUpperCase()).getDKPdata(); // Ищем по enum документ
        String date = dateNow(); // Сегодняшняя дата

//      Выбор типа документа
        get(LINK_PLACEMENT_MAIN.getUrl());
        send(xFIELD_FIND_DOCUMENT, "купли"); // передаваемое значение НЕ МЕНЯТЬ, иначе будет нестабильно работать
        timeOut(3000);
        listDown(xFIELD_FIND_DOCUMENT, 1);
        click(xBUTTON_FIND_DOCUMENT);

//      Блок информация о документе
        send(xFIELD_NAME_DOCUMENT, doc.getName() + data);
        send(xFIELD_AUTOR_DOCUMENT, doc.getAutor());

        // Сделано для отладки по документу AUTO
        if(doc.getName() == "DKP_AUTO_"){
            send(xFIELD_NUMBER_DOCUMENT, doc.getNumber() + randomNum(4));
            sendDate(xDATE_FIELD_DOCUMENT, doc.getDate() + date);
        }
        else {
            send(xFIELD_NUMBER_DOCUMENT, doc.getNumber());
            sendDate(xDATE_FIELD_DOCUMENT, doc.getDate());
        }
        //

//      Инпуты документа
        unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILE);
        unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILESIG);
        send(xHIDDEN_FIELD_INPUT_FILE, SYSTEM_PATH_TO_INPUT_FILE);
        send(xHIDDEN_FIELD_INPUT_FILESIG, SYSTEM_PATH_TO_INPUT_FILESIG);
        timeOut(1000);

//      Запись БК
        bizKey = getText(xTEXT_BIZ_KEY);
        writeTextToFile(bizKey, "log_DKP.txt"); // Для удобства лог

        click(xBUTTON_PLACE_DOCUMENT);
        click(xBUTTON_PLACE_DOCUMENT_SIG);
        timeOut(1000);
        cartDocLink = getUrl(xBUTTON_CLICK_TO_CARTDOC);
        click(xBUTTON_CLICK_TO_CARTDOC);
        timeOut(2000);
    }


    // Аренда
    public void rent(String data){
        DataRent doc = DocumentRent.valueOf(data.toUpperCase()).getRentData(); // Ищем по enum документ
        String date = dateNow(); // Сегодняшняя дата

//      Выбор типа документа
        get(LINK_PLACEMENT_MAIN.getUrl());
        send(xFIELD_FIND_DOCUMENT, "аренда"); // передаваемое значение НЕ МЕНЯТЬ, иначе будет нестабильно работать
        timeOut(3000);
        listDown(xFIELD_FIND_DOCUMENT, 1);
        click(xBUTTON_FIND_DOCUMENT);

//      Блок информация о документе
        send(xFIELD_NAME_DOCUMENT, doc.getName() + data);
        send(xFIELD_AUTOR_DOCUMENT, doc.getAutor());

        // Сделано для отладки по документу AUTO
        if(doc.getName() == "Rent_AUTO_"){
            send(xFIELD_NUMBER_DOCUMENT, doc.getNumber() + randomNum(4));
            sendDate(xDATE_FIELD_DOCUMENT, doc.getDate() + date);
        }
        else {
            send(xFIELD_NUMBER_DOCUMENT, doc.getNumber());
            sendDate(xDATE_FIELD_DOCUMENT, doc.getDate());
        }
        //

//      Инпуты документа, добавление документа
        unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILE);
        unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILESIG);
        send(xHIDDEN_FIELD_INPUT_FILE, SYSTEM_PATH_TO_INPUT_FILE);
        send(xHIDDEN_FIELD_INPUT_FILESIG, SYSTEM_PATH_TO_INPUT_FILESIG);
        timeOut(1000);

        // Добавление ЛУ
        click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[4]/div/button");
        send("//*[@id=\":re:\"]", "29:3:ЛУ486");
        timeOut(2000);
        arrowDown();
        enter();
        timeOut(2000);
        click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[3]/form/div/div[1]/div/div[2]/button[3]");
        timeOut(1000);
        click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr/td[1]/span");


        //      Запись БК
        bizKey = getText(xTEXT_BIZ_KEY);
        writeTextToFile(bizKey, "log_DKP.txt"); // Для удобства лог

//      Завершение
//        click(xBUTTON_PLACE_DOCUMENT);
//        click(xBUTTON_PLACE_DOCUMENT_SIG);
        click("//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div/div[4]/div/button");
        click("/html/body/div[3]/div[3]/div/div/div[2]/button[2]");
        timeOut(2000);
        cartDocLink = getUrl(xBUTTON_CLICK_TO_CARTDOC);
        click(xBUTTON_CLICK_TO_CARTDOC);
        timeOut(2000);
    }

}
