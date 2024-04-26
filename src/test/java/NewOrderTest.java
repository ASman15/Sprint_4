import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import PageObject.FirstOrderPage;
import PageObject.MainPage;
import PageObject.SecondOrderPage;
import org.openqa.selenium.firefox.FirefoxDriver;


public class NewOrderTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void FirstOrderTest() {
        MainPage objMainPage = new MainPage(driver);
        FirstOrderPage objFirstPage = new FirstOrderPage(driver);
        SecondOrderPage objSecondPage = new SecondOrderPage(driver);
        objMainPage.firstTestNewOrder();
        objFirstPage.firstTestNewOrderSecondPage("Иосиф", "Бродский", "ул.Ленина д.26", "Лубянка", "89662517826");
        objSecondPage.firstTestNewOrderSecondPage("25.12.2024", "Первый комментарий");

    }
    @Test
    public void SecondOrderTest() {
        MainPage objMainPage = new MainPage(driver);
        FirstOrderPage objFirstPage = new FirstOrderPage(driver);
        SecondOrderPage objSecondPage = new SecondOrderPage(driver);
        objMainPage.secondTestNewOrder();
        objFirstPage.firstTestNewOrderSecondPage("Николай", "Гоголь", "ул.Покровская д.1", "ВДНХ", "89422473847");
        objSecondPage.secondTestNewOrderSecondPage("15.08.2024", "Второй комментарий");
    }

    @After

    public void tearDown() {
        driver.quit();
    }
}