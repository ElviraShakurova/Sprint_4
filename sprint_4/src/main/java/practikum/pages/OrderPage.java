package practikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class OrderPage {
    private final WebDriver driver;
    private static final By OrderHeader = By.className("Order_Header__BZXOb");// Заголовок "Для кого самокат"
    private static final By InputName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input"); // Поле ввода "Имя"
    private static final By InputSecondName = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[2]/input");//Поле ввода "Фамилия"
    private static final By InputAddress = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[3]/input"); //Поле ввод "Адрес"
    private static final By InputMetro = By.className("select-search__input");// Поле ввода "Метро"
    private static final By ChooseMetro = By.cssSelector("[data-index='4']"); // Выбор станции Метро в выпадающем списке
    private static final By InputPhone = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[5]/input");// Поле ввода "Телефон"
    private static final By ButtonDalee = By.className("Button_Middle__1CSJM"); // Кнопка "Далее"




    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public OrderPage waitOrderPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(OrderHeader));
        return this;
    }
    public void typeInputName(String name) {
        driver.findElement(InputName).sendKeys(name);
    }
    public void typeInputSecondName(String secondName) {
        driver.findElement(InputSecondName).sendKeys(secondName);
    }
    public void typeInputAddress(String address) {
        driver.findElement(InputAddress).sendKeys(address);
    }
    public void clickInputMetro(){
        driver.findElement(InputMetro).click();
    }
    public void chooseMetro(){
        driver.findElement(ChooseMetro).click();
    }
    public void typeInputPhone(String phone) {
        driver.findElement(InputPhone).sendKeys(phone);
    }
    public NextOrderPage clickButtonDalee() {
        driver.findElement(ButtonDalee).click();
        return new NextOrderPage(driver);
    }

}
