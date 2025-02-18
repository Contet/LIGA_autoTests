package pages.theInternet;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;



public class MainPage {
    protected WebDriver driver;
    protected Actions actions;



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void TimeOut(int wait){
        try {
            // Пауза на 1000 миллисекунд (1 секунда)
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean IsDisp(String key){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ожидание 10 секунд
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    public void Click(String key){

//        TimeOut(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(key)));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(key)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        button.click();

    }


    public void ClickCSS(String key){
        TimeOut(100);
        while(!IsDisp(key)){
            TimeOut(100);
        }
        driver.findElement(By.cssSelector(String.valueOf(key))).click();
    }


    public void Send(String key, String value) {
        if(IsDisp(key)){
            driver.findElement(By.xpath(String.valueOf(key))).sendKeys(value);
        }
    }


    public void SendDate(String key, String value) {
        Click(key);
        TimeOut(100);
        if(IsDisp(key)){
            driver.findElement(By.xpath(String.valueOf(key))).sendKeys(value);
        }
        else{TimeOut(1000);}
    }


    public void OpenUrl(String key){
        driver.get(key);
    }


    public void Enter(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }


    public void Scroll_down(String key){

        WebElement body = driver.findElement(By.xpath(key));
        Actions actions = new Actions(driver);
        actions.moveToElement(body).sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
    }


    public void ArrowDown(){
        Actions actions = new Actions(driver);

        // Эмулируем нажатие клавиши "Стрелка вниз"
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        }


    public void ArrowUp(){
        Actions actions = new Actions(driver);

        // Эмулируем нажатие клавиши "Стрелка вниз"
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

    public void Refresh(){
        driver.navigate().refresh();
    }


    public String GetText(String key) {
        WebElement element = driver.findElement(By.xpath(key));
        return element.getText();
    }


    public void WriteTextToFile(String text, String fileName) {
        String filePath = "src/log/" + fileName;
        try (FileWriter fileWriter = new FileWriter(filePath, true)) { // true для добавления в конец файла
            fileWriter.write(text + "\n"); // Добавляем новую строку
            System.out.println("Лог успешно записан в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }


    public void Get(String key){
        driver.get(key);
    }


    public String DateNow(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Создаем форматировщик для преобразования даты в строку
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMYYYY");

        // Преобразуем дату в строку
        String formattedDate = currentDateTime.format(formatter);

        // Выводим результат
        System.out.println("Текущая дата в формате ddMMYYYY: " + formattedDate);
        return formattedDate;
    }


    public String GetUrl(String key){
        WebElement button = driver.findElement(By.xpath(key)); // Замените на ваш локатор
        String url = button.getAttribute("href");
        return url;
    }


    public String RandomDateToday(){
        // Текущая дата
        LocalDate today = LocalDate.now();
        // Максимальное количество дней для добавления (например, 365 дней)
        int maxDays = 365;
        // Генерация случайной даты после сегодняшней внутри main
        Random random = new Random();
        int randomDays = random.nextInt(maxDays) + 1; // Генерация числа от 1 до maxDays
        LocalDate randomDate = today.plusDays(randomDays); // Добавление случайного количества дней
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMYYYY");
        String formattedDate = randomDate.format(formatter);

        return formattedDate;
    }


    public void ListDown(String key, Integer k){
        Click(key);
        for(int i = 0; i < k; i++){
            ArrowDown();
        }
        Enter();
    }


    public void ListUp(String key, Integer k){
        Click(key);
        for(int i = 0; i < k; i++){
            ArrowUp();
        }
        Enter();
    }


    public String RandomNum(Integer n){
        if (n <= 0) {
        throw new IllegalArgumentException("Количество цифр должно быть положительным числом.");
    }

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Генерация первой цифры (не может быть 0)
        sb.append(random.nextInt(9) + 1);

        // Генерация остальных цифр
        for (int i = 1; i < n; i++) {
            sb.append(random.nextInt(10)); // Генерация цифры от 0 до 9
        }

        return String.valueOf(sb);
    }


    public void CheckBoxTrue(String key){
        WebElement checkbox = driver.findElement(By.xpath(key));

// Используем JavaScript для установки состояния checked
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", checkbox);
    }
}
