package practikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {
    private final WebDriver driver;
    private static final By goButtonOrder = By.cssSelector("button[class^='Button_Button__ra12g']");// кнопка «Заказать» вверху страницы
    private static final By cookieButton = By.id("rcc-confirm-button"); //Кнопка Куки
    private static final By finishGoButton = By.xpath(".//*[@id=\'root\']/div/div/div[4]/div[2]/div[5]/button");// кнопка «Заказать» внизу страницы

    private static final By accordionItemHeading = By.xpath("//*[starts-with(@id, 'accordion__heading-')]"); // кнопка со стрелкой в разделе «Вопросы о важном»
    private static final By accordionItemPanel = By.xpath(".//*[starts-with(@id, 'accordion__panel-')]/p"); // Соответствующий текст после тапа на кнопку со стрелкой
    private final Duration duration = Duration.ofSeconds(10);


    private static final By subHeader = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]"); // Заголовок "Вопросы о важном"

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOnCookie() {

        driver.findElement(cookieButton).click();
    }

    public void scrollSubHeader() {
        WebElement element = driver.findElement(subHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public MainPage clickAccordionItemHeading(int accordionLocator) {
        driver.findElements(accordionItemHeading).get(accordionLocator).click();
        return this;
    }
    public String getAccordionItemPanelText(int accordionLocator) {
        return driver.findElements(accordionItemPanel).get(accordionLocator).getText();
    }

    public OrderPage clickGoButton(int goButton){
        if (goButton == 0){
            driver.findElements(goButtonOrder).get(0).click();
        } else {
            WebElement element = driver.findElement(finishGoButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(finishGoButton).click();
        }
        return new OrderPage(driver);
    }
}
