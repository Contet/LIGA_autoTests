package pages;

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



public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void timeOut(int wait){
        try {
            // Пауза на 1000 миллисекунд (1 секунда)
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean isDisp(String key){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ожидание 10 секунд
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
            System.out.println("Элемент " + key + " отобразился на интерфейсе");
            return element.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Элемент " + key + " НЕ отобразился на интерфейсе");
            return false;
        }
    }


    public void click(String key) {
        try {
            // Создаем WebDriverWait для ожидания до 15 секунд
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Ожидаем, пока элемент станет кликабельным
            WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(key)));
            System.out.println("Элемент стал кликабельным: " + key);

            // Прокручиваем элемент в область видимости (если это необходимо)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickableButton);
            System.out.println("Элемент прокручен в область видимости: " + key);

            // Кликаем по элементу
            clickableButton.click();
            System.out.println("Клик выполнен по элементу: " + key);

        } catch (TimeoutException e) {
            // Обработка случая, если элемент не стал кликабельным за отведенное время
            System.err.println("Элемент не стал кликабельным за отведенное время: " + key);
            throw e; // Перебрасываем исключение дальше, если нужно
        } catch (Exception e) {
            // Обработка других возможных ошибок
            System.err.println("Произошла ошибка при выполнении клика: " + e.getMessage());
            throw e;
        }
    }


    public void send(String key, String value) {
        if(isDisp(key)){
            driver.findElement(By.xpath(String.valueOf(key))).sendKeys(value);
        }
    }


    public void sendDate(String key, String value) {
        click(key);
        timeOut(100);
        if(isDisp(key)){
            driver.findElement(By.xpath(String.valueOf(key))).sendKeys(value);
        }
        else{
            timeOut(1000);}
    }


    public void enter(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }


    public void arrowDown(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }


    public void arrowUp(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

    public void refresh(){
        driver.navigate().refresh();
    }


    public String getText(String key) {
        WebElement element = driver.findElement(By.xpath(key));
        return element.getText();
    }


    public void writeTextToFile(String text, String fileName) {
        String filePath = "src/log/" + fileName;
        try (FileWriter fileWriter = new FileWriter(filePath, true)) { // true для добавления в конец файла
            fileWriter.write(text + "\n"); // Добавляем новую строку
            System.out.println("Лог успешно записан в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }


    public void get(String key){
        driver.get(key);
    }


    public String dateNow(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Создаем форматировщик для преобразования даты в строку
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMYYYY");

        // Преобразуем дату в строку
        String formattedDate = currentDateTime.format(formatter);

        // Выводим результат
        System.out.println("Текущая дата в формате ddMMYYYY: " + formattedDate);
        return formattedDate;
    }


    public String getUrl(String key){
        WebElement button = driver.findElement(By.xpath(key)); // Замените на ваш локатор
        String url = button.getAttribute("href");
        return url;
    }


    public String randomDateToday(){
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


    public void listDown(String key, Integer k){
        click(key);
        for(int i = 0; i < k; i++){
            arrowDown();
        }
        enter();
    }


    public void listUp(String key, Integer k){
        click(key);
        for(int i = 0; i < k; i++){
            arrowUp();
        }
        enter();
    }


    public String randomNum(Integer n){
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

        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", checkbox);
    }


    public void waitTask(String key){
        if(key == null){
            key = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/div/div[7]/a"; // Значение по умолчанию
        }

        while(!isDisp(key)){
            refresh();
        }

        Boolean b = isDisp(key);
        System.out.println("Отобразилась задача в карточке: " + b);

        click(key);
    }


    public void unInvisibalyInput(String key){
        WebElement input_element = driver.findElement(By.xpath(key));

        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", input_element);
    }
}
