package practikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NextOrderPage {
    private final WebDriver driver;

    private static final By Date = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");// Поле ввода "Когда привезти самокат"
    private static final By RentDuration = By.className("Dropdown-placeholder");// Поле ввода "Срок аренды"
    private static final By ChooseRentDuration = By.className("Dropdown-option"); // Выбор срока аренды в выпадающем списке
    private static final By ChooseColour = By.className("Checkbox_Input__14A2w"); // Выбор Цвета самоката
    private static final By Order = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");// Кнопка "Заказать"
    private static final By YesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]"); // Кнопка "Да" в диалоговом окне, всплывающее после тапа на кнопку "Заказать"
    private static final By OrderWindow = By.cssSelector("[div.Order_ModalHeader__3FDaJ]");// Всплывающее окно с сообщением об успешном создании заказа.

    public NextOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInputData(String data){
        driver.findElement(Date).sendKeys(data);
    }
    public void clickRentDuration(){
        driver.findElement(RentDuration).click();
    }
    public void chooseRentDuration(int rentDuration){
        driver.findElements(ChooseRentDuration).get(rentDuration).click();
    }
    public void clickOnChooseColour(int chooseColor){
        driver.findElements(ChooseColour).get(chooseColor).click();
    }
    public void clickOnOrder(){
        driver.findElement(Order).click();
    }
    public void ClickOnYesButton(){
        driver.findElement(YesButton).click();
    }
    public void waitForOrderWindow(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(OrderWindow));
    }
}
