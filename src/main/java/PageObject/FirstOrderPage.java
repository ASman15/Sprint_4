package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirstOrderPage {
    private final WebDriver driver;


    //Поле "Имя"
    private final By nameFieldLocator = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private final By lastNameFieldLocator = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес: куда привезти заказ"
    private final By addressFieldLocator = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By metroStationFieldLocator = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле "Телефон: на него позвонит курьер"
    private final By phoneNumberFieldLocator = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    //Кнопка "Далее"
    private final By nextButtonLocator = By.xpath(".//button[text() = 'Далее']");

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //Ожидание загрузки
    public void waitForLoadOrderPage() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(nameFieldLocator));
    }
    public void fillNameField(String username) {
        driver.findElement(nameFieldLocator).sendKeys(username);
    }
    public void fillLastNameField(String lastName) {
        driver.findElement(lastNameFieldLocator).sendKeys(lastName);
    }
    public void fillAddressField(String address) {
        driver.findElement(addressFieldLocator).sendKeys(address);
    }
    public void subwayInput(String station) {
        WebElement findSubwayStatinField = driver.findElement(metroStationFieldLocator);
        findSubwayStatinField.sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void phoneNumberInput(String phoneNumber) {
        driver.findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
    }
    public void clickNextButton() {
        driver.findElement(nextButtonLocator).click();
    }
    public void firstTestNewOrderSecondPage(String username, String lastName, String address, String station, String phoneNumber) {
        fillNameField(username);
        fillLastNameField(lastName);
        fillAddressField(address);
        subwayInput(station);
        phoneNumberInput(phoneNumber);
        clickNextButton();
    }

}

