package pages.RMDL.placement;

import dataSet.RMDL.PUD.DKP.DataDKP;
import dataSet.RMDL.PUD.DKP.Document;
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

    public void DKP(String data){
        DataDKP doc = Document.valueOf(data.toUpperCase()).getDKPdata(); // Ищем по enum документ
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

//      Добавление документа ПДФ
        click(xBUTTON_ADD_DOCUMENT);
        click(xBUTTON_ADD_DOCUMENT_SIG);
        timeOut(1000);
        cartDocLink = getUrl(xBUTTON_CLICK_TO_CARTDOC);
        click(xBUTTON_CLICK_TO_CARTDOC);
        timeOut(2000);
    }


}
