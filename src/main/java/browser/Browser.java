package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.time.Duration;

import static browser.Config.WAIT;
import static browser.Config.browserType;

public class Browser {

    public static WebDriver driver;

    public static WebDriver createDriver(){

        switch (browserType){
            case "chrome":

                // Вводим опции стратегию
                ChromeOptions options_cr = new ChromeOptions();
                options_cr.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

                // Укажите путь к расширению
                options_cr.addExtensions(new File("src/data/IIFCHHFNNMPDBIBIFMLJNFJHPIFIFFOG_1_2_13_0.crx")); // или путь к распакованной папке

                driver = new ChromeDriver(options_cr);

                // делаем божеский вид и выставляем таймер
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));

                return driver;


            case "fire":

                // Укажите путь к geckodriver
                   System.setProperty("webdriver.gecko.driver", "src/data/geckodriver.exe");

                  Proxy proxy = new Proxy();
//                  proxy.setHttpProxy("192.168.158.8:1080");
                  proxy.setSocksProxy("192.168.158.9:1080");
                  proxy.setSocksVersion(5);

                // Настройте опции Firefox
                FirefoxOptions options_fr = new FirefoxOptions();
                // Укажите путь к исполняемому файлу Firefox
                options_fr.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

                // Создаем профиль Firefox и добавляем расширение
                FirefoxProfile profile = new FirefoxProfile();
                profile.addExtension(new java.io.File("src/data/firefox_cryptopro_extension_latest.xpi"));

                // Применяем профиль к нашим опциям
                options_fr.setProfile(profile);
                options_fr.setProxy(proxy);

                // Создайте экземпляр WebDriver с заданными опциями
                driver = new FirefoxDriver(options_fr);
                // делаем божеский вид и выставляем таймер
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));

                return driver;

            default:
                throw new IllegalArgumentException("Browser type not supported: " + browserType);
        }

    }
}
