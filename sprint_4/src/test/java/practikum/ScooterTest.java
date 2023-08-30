package practikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import practikum.pages.MainPage;
import practikum.pages.NextOrderPage;
import practikum.pages.OrderPage;


@RunWith(Parameterized.class)
public class ScooterTest {
    private final int goButton;
    private final String name;
    private final String secondName;
    private final String address;
    private final String phone;
    private final int rentDuration;
    private final int chooseColor;
    private final String data;

    public ScooterTest(int goButton, String name, String secondName, String address, String phone, int rentDuration, int chooseColor, String data) {
        this.goButton = goButton;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
        this.rentDuration = rentDuration;
        this.chooseColor = chooseColor;
        this.data = data;
    }
        @Parameterized.Parameters
        public static Object[][] getCredentials() {
            return new Object[][]{
                    {0, "Мэрилин", "Монро","ул. Ленина, 1", "89998885554", 3, 1, "29.08.2023"},
                    {1, "Моника", "Белуччи","ул. Московская, 1", "89992220000", 1, 0, "01.09.2023"},
            };
        }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
        public void invalidOrder() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open();
        mainPage.clickOnCookie();
        OrderPage orderPage = mainPage.clickGoButton(goButton);
        orderPage.waitOrderPage();
        orderPage.typeInputName(name);
        orderPage.typeInputSecondName(secondName);
        orderPage.typeInputAddress(address);
        orderPage.clickInputMetro();
        orderPage.chooseMetro();
        orderPage.typeInputPhone(phone);
        NextOrderPage nextOrderPage = orderPage.clickButtonDalee();
        nextOrderPage.clickRentDuration();
        nextOrderPage.chooseRentDuration(rentDuration);
        nextOrderPage.clickOnChooseColour(chooseColor);
        nextOrderPage.clickInputData(data);
        nextOrderPage.clickOnOrder();
        nextOrderPage.ClickOnYesButton();
        nextOrderPage.waitForOrderWindow();
        }
}


