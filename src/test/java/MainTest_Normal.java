
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.BaseConst.*;

public class MainTest_Normal {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.get(String.valueOf(MAIN_PAGE_URL));
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    // В данном шаге все ( красиво сделать не успел )
    @Test
    public void step_01(){

        // Поле текста
        driver.findElement(By.xpath(String.valueOf(xTEXT_INPUT))).sendKeys("Князев Николай Анатольевич");

        boolean isDispEl_Text_Input = driver.findElement(By.xpath(String.valueOf(xTEXT_INPUT))).isDisplayed();

        System.out.println(isDispEl_Text_Input);

        driver.findElement(By.xpath(String.valueOf(xPASSWORD))).sendKeys("Qwer123");

        boolean isDispEl_Password_Input = driver.findElement(By.xpath(String.valueOf(xPASSWORD))).isDisplayed();

        System.out.println(isDispEl_Password_Input);

        driver.findElement(By.xpath(String.valueOf(xTEXT_AREA))).sendKeys("Князев Николай Анатольевич");

        boolean isDispEl_Text_Area = driver.findElement(By.xpath(String.valueOf(xTEXT_AREA))).isDisplayed();

        System.out.println(isDispEl_Text_Area);

        // Селекторы
        driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select/option[3]")).click();

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input")).sendKeys("Seattle");

        // Чекбоксы

        // Находим чекбокс по XPath
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"my-check-1\"]"));

        // Проверяем, отмечен ли чекбокс
        if (!checkbox1.isSelected()) {
            checkbox1.click(); // Отмечаем чекбокс, если он не отмечен
            System.out.println("Чекбокс отмечен.");
        } else {
            System.out.println("Чекбокс уже отмечен.");
        }

        // Находим чекбокс по XPath
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"my-check-2\"]"));

        // Проверяем, отмечен ли чекбокс
        if (!checkbox2.isSelected()) {
            checkbox2.click(); // Отмечаем чекбокс, если он не отмечен
            System.out.println("Чекбокс отмечен.");
        } else {
            System.out.println("Чекбокс уже отмечен.");
        }

        // Радиобокс
        WebElement radioBox = driver.findElement(By.xpath("//*[@id=\"my-radio-2\"]"));

        // Проверяем, отмечен ли радиоБокс
        if (!radioBox.isSelected()) {
            radioBox.click(); // Отмечаем радиоБокс, если он не отмечен
            System.out.println("Чекбокс отмечен.");
        } else {
            System.out.println("Чекбокс уже отмечен.");
        }

        // Выбираем дату 09/11/2022
        driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[2]/input")).sendKeys("09/11/2022");

        // Выбираем белый цвет
        driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[1]/input")).sendKeys("#FFFFFF");

        driver.findElement(By.xpath("//*[@id=\"my-text-id\"]")).click();

        // Переводим ползунок в максимальное положение
        WebElement rangeInput = driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[3]/input"));
        rangeInput.sendKeys("10");

        // Кнопка Sumbit
        driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button")).click();

        // Сравниваем заголовок с ожидаемым заголовком
        String zagolovok = driver.findElement(By.xpath("/html/body/main/div/div[1]/div/h1")).getText();
        String mustZagolovok = "Form submitted";

        if (zagolovok.equals(mustZagolovok)) {
            System.out.println("Текст заголовка верный!");
        } else {
            System.out.println("Текст заголовка не совпадает! Ожидаемый: " + mustZagolovok + ", Фактический: " + zagolovok);
        }

        // Сравниваем текст с ожидаемым текстом
        String text = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
        String mustText = "Received!";

        if (text.equals(mustText)) {
            System.out.println("Текст верный!");
        } else {
            System.out.println("Текст не совпадает! Ожидаемый: " + mustText + ", Фактический: " + text);
        }



    }

    // Заполнение полей текстом
    @Test
    public void step_02() {

        driver.findElement(By.xpath("//*[@id=\"my-text-id\"]")).sendKeys("Князев Николай Анатольевич");

        boolean isDispEl_Text_Input = driver.findElement(By.xpath("//*[@id=\"my-text-id\"]")).isDisplayed();

        System.out.println(isDispEl_Text_Input);

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input")).sendKeys("Qwer123");

        boolean isDispEl_Password_Input = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input")).isDisplayed();

        System.out.println(isDispEl_Password_Input);

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea")).sendKeys("Князев Николай Анатольевич");

        boolean isDispEl_Text_Area = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea")).isDisplayed();

        System.out.println(isDispEl_Text_Area);
    }

    // Селекторы
    @Test
    public void step_03(){

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select/option[3]")).click();

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input")).sendKeys("Seattle");
    }

    // Чекбоксы
    @Test
    public void step_04(){

        // Находим чекбокс по XPath
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"my-check-1\"]"));

        // Проверяем, отмечен ли чекбокс
        if (!checkbox1.isSelected()) {
            checkbox1.click(); // Отмечаем чекбокс, если он не отмечен
            System.out.println("Чекбокс отмечен.");
        } else {
            System.out.println("Чекбокс уже отмечен.");
        }

        // Находим чекбокс по XPath
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"my-check-2\"]"));

        // Проверяем, отмечен ли чекбокс
        if (!checkbox2.isSelected()) {
            checkbox2.click(); // Отмечаем чекбокс, если он не отмечен
            System.out.println("Чекбокс отмечен.");
        } else {
            System.out.println("Чекбокс уже отмечен.");
        }
    }

    // Радиобокс
    @Test
    public void step_05(){

        WebElement radioBox = driver.findElement(By.xpath("//*[@id=\"my-radio-2\"]"));

        // Проверяем, отмечен ли радиоБокс
        if (!radioBox.isSelected()) {
            radioBox.click(); // Отмечаем радиоБокс, если он не отмечен
            System.out.println("Чекбокс отмечен.");
        } else {
            System.out.println("Чекбокс уже отмечен.");
        }

    }
    //Выбираем дату 09/11/2022
    @Test
    public void step_06(){

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[2]/input")).sendKeys("09/11/2022");

    }
    // Выбираем белый цвет
    @Test
    public void step_07(){

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[1]/input")).sendKeys("#FFFFFF");

        driver.findElement(By.xpath("//*[@id=\"my-text-id\"]")).click();
    }

    // Переводим ползунок в максимальное положение
    @Test
    public void step_08() {

        WebElement rangeInput = driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[3]/input"));
        rangeInput.sendKeys("10");
    }

    // Кнопка Sumbit
    @Test
    public void step_09() {

        driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button")).click();
    }

    // Проверка текста, после нажатия на кнопку Sumbit
    @Test
    public void step_10() {
        // Сравниваем заголовок с ожидаемым заголовком
        String zagolovok = driver.findElement(By.xpath("/html/body/main/div/div[1]/div/h1")).getText();
        String mustZagolovok = "Form submitted";

        if (zagolovok.equals(mustZagolovok)) {
            System.out.println("Текст заголовка верный!");
        } else {
            System.out.println("Текст заголовка не совпадает! Ожидаемый: " + mustZagolovok + ", Фактический: " + zagolovok);
        }

        // Сравниваем текст с ожидаемым текстом
        String text = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
        String mustText = "Received!";

        if (text.equals(mustText)) {
            System.out.println("Текст верный!");
        } else {
            System.out.println("Текст не совпадает! Ожидаемый: " + mustText + ", Фактический: " + text);
        }
    }
}
