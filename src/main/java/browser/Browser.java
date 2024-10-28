package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

import static browser.Config.WAIT;

public class Browser {

    public static WebDriver driver;

    public static WebDriver createDriver(){

                // Вводим опции стратегию

                // делаем божеский вид и выставляем таймер
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));

                return driver;
    }
}
