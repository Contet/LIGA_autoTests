package pages.RMDL.cartDoc;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static pages.RMDL.cartDoc.xCartDoc_Dirt.*;

public class CartDocPage extends BasePage {
    public CartDocPage(WebDriver driver){
        super(driver);
    }

    public String urlPudOutputter;

    public void waitTaskFirst(){
        waitTask(null);
        urlPudOutputter = getUrl(xBUTTON_GO_TO_TASK);
        writeTextToFile("Ссылка на форму ПУД 'Извлечение сведений': \n" + urlPudOutputter, "log_DKP.txt");
        click(xBUTTON_GO_TO_TASK);
    }
}
