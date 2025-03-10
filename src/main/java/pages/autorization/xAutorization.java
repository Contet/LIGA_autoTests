package pages.autorization;

import org.openqa.selenium.By;

public enum xAutorization {
    // Локаторы для страницы авторизации
    xBUTTON_LOGIN(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[3]/button")),
    xUSERNAME_FIELD(By.xpath("//input[@id='username']")),
    xPASSWORD_FIELD(By.xpath("//input[@id='password']")),
    xLOGIN_BUTTON(By.xpath("//button[@type='submit']"));


    // Поле для хранения локатора
    private final By locator;


    // Конструктор enum
    xAutorization(By locator) {
        this.locator = locator;
    }


    // Метод для получения локатора
    public By getLocator() {
        return locator;
    }

}
