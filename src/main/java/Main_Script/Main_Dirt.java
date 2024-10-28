package Main_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;


public class Main_Dirt {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com");

        boolean isDispEl = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).isDisplayed();
        System.out.println(isDispEl);

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[4]/a")).click();

        WebElement image = driver.findElement(By.cssSelector("#content > div > img:nth-child(2)"));

        String imageUrl = image.getAttribute("src");

        driver.get(imageUrl);


    }
}

