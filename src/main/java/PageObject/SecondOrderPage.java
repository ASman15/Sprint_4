package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondOrderPage {
    private final WebDriver driver;

    //Поле "Когда привезти самокат"
    private final By whenBringScooterFieldLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле "Срок аренды"
    private final By rentalPeriodFieldLocator = By.className("Dropdown-arrow");
    //Выбор срока аренды "сутки"
    private static final By chooseOneDay = By.xpath(".//div[text() = 'сутки']");
    //Выбор срока аренды "двое суток"
    private static final By chooseTwoDays = By.xpath(".//div[text() = 'двое суток']");
    //Чекбокс выбора цвета "чёрный жемчуг"
    private final By blackCheckboxLocator = By.id("black");
    //Чекбокс выбора цвета "серая безысходность"
    private final By greyCheckBoxLocator = By.id("grey");
    //Поле "Комментарий для курьера"
    private final By commentForCourierFieldLocator = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка "Заказать" под полями заказа
    private final By footerOrderButtonLocator = By.xpath(".//button[contains(@class, '1C') and text() = 'Заказать']");
    //Окно "Хотите оформить заказ"
    private final By arrangeOfferViewLocator = By.className("Order_Modal__YZ-d3");
    //Кнопка "Да"
    private final By yesButtonLocator = By.xpath(".//button[text() = 'Да']");
    //Окно "Заказ оформлен"
    private final By checkStatusView = By.xpath(".//div[@class='Order_Modal__YZ-d3']");

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //Ожидание загрузки второй страницы создания заказа
    public void waitForDateField() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(whenBringScooterFieldLocator));
    }
    //Выбор даты доставки
    public void enterDateOrder(String date) {
        WebElement element = driver.findElement(whenBringScooterFieldLocator);
        element.sendKeys(date, Keys.ENTER);
    }
    //Выбор срока аренды - сутки
    public void chooseOneDayRentalPeriod() {
        driver.findElement(rentalPeriodFieldLocator).click();
        driver.findElement(chooseOneDay).click();
    }
    //Выбор срока аренды - двое суток
    public void chooseTwoDaysRentalPeriod() {
        driver.findElement(rentalPeriodFieldLocator).click();
        driver.findElement(chooseTwoDays).click();
    }
    //Выбор чёрного цвета
    public void chooseBlackColor() {
        WebElement blackButton = driver.findElement(blackCheckboxLocator);
        blackButton.click();
    }
    //Выбор серого цвета
    public void chooseGreyColor() {
        driver.findElement(greyCheckBoxLocator).click();
    }
    //Заполнение поля Комментария
    public void inputComment(String comment) {
        driver.findElement(commentForCourierFieldLocator).sendKeys(comment);
    }
    //Нажатие кнопки Заказать
    public void clickOrderButton() {
        driver.findElement(footerOrderButtonLocator).click();
    }
    //Ожидание загрузки поля подтверждения заказа
    public void waitForLoadConfirmView() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(arrangeOfferViewLocator));
    }
    //Нажатие на кнопку Да в окне подтверждения заказа
    public void clickYesButton() {
        WebElement yesButton = driver.findElement(yesButtonLocator);
        yesButton.click();
    }
    //Ожидание открытия окна с подтверждением создания заказа
    public void checkForLoadOrderView() {
        WebElement statusButton = driver.findElement(checkStatusView);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(checkStatusView));
        statusButton.isDisplayed();
    }
    //Метод для заполнения первого теста
    public void firstTestNewOrderSecondPage(String date, String comment) {
        waitForDateField();
        enterDateOrder(date);
        chooseOneDayRentalPeriod();
        chooseBlackColor();
        inputComment(comment);
        clickOrderButton();
        waitForLoadConfirmView();
        clickYesButton();
        checkForLoadOrderView();
    }
    public void secondTestNewOrderSecondPage(String date, String comment) {
        waitForDateField();
        enterDateOrder(date);
        chooseTwoDaysRentalPeriod();
        chooseGreyColor();
        inputComment(comment);
        clickOrderButton();
        waitForLoadConfirmView();
        clickYesButton();
        checkForLoadOrderView();
    }

}
