package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Кнопка "Да все привыкли"
    private final By ConfirmCookieLocator = By.xpath(".//button[contains(@class, '3cvqF')]");
    //Кнопка "Заказать" в хидере
    private final By headerOrderButtonLocator = By.className("Button_Button__ra12g");
    //Поле кнопки Заказать в теле сайта
    public final By bodyOrderButtonFieldLocator = By.className("Home_FinishButton__1_cWm");
    //Кнопка "Заказать" в теле сайта
    private final By bodyOrderButtonLocator = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Поле "Вопросы о важном"
    private final By questionsAboutImportantField = By.xpath(".//div[text()='Вопросы о важном']");
    //Поля вопросов
    private final String questionLocator = "accordion__heading-%s";
    //Поля ответов
    private final String answerLocator = "accordion__panel-%s";
    public void clickConfirmCookie () {
        driver.findElement(ConfirmCookieLocator).click();
    }
    public void clickHeaderOrderButton() {
        WebElement headerOrderButton = driver.findElement(headerOrderButtonLocator);
        headerOrderButton.click();
        new WebDriverWait(driver, 3);
    }
    //Ожидание для кнопки Заказать в теле страницы
    public void findBodyOrderButton() {
        WebElement bodyOrderButtonField = driver.findElement(bodyOrderButtonFieldLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bodyOrderButtonField);
    }
    public void clickBodyOrderButton() {
        driver.findElement(bodyOrderButtonLocator).click();
    }
    public void findQuestionsField() {
        WebElement questionsField = driver.findElement(questionsAboutImportantField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionsField);
    }
    public void clickQuestion (int index) {
        WebElement questionField = driver.findElement(By.id(String.format(questionLocator, index)));
        questionField.click();
    }
    public boolean IsAnswerCorrect(int index, String expectedAnswer) {
        WebElement firstAnswer = driver.findElement(By.id(String.format(answerLocator, index)));
        return firstAnswer.getText().equals(expectedAnswer);
    }
    public void firstTestNewOrder() {
        clickConfirmCookie();
        clickHeaderOrderButton();
    }
    public void secondTestNewOrder() {
        clickConfirmCookie();
        findBodyOrderButton();
        clickBodyOrderButton();
    }
    public void questionsFieldListTest(int index, String expectedAnswer) {
        clickConfirmCookie();
        findQuestionsField();
        clickQuestion(index);
        IsAnswerCorrect(index, expectedAnswer);
    }
}