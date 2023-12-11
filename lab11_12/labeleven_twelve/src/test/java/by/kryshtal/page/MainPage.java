package by.kryshtal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainPage extends AbstractPage
{
    private final String BASE_URL = "https://www.futbolemotion.com/neu";

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookieElement;
    @FindBy(xpath = "//*[@id=\"caja_buscador\"]")
    private WebElement searchInput;
    @FindBy(xpath = "/html/body/footer/div[3]/div/div[1]/div/div[1]/div[2]/div/button")
    private WebElement priceButton;
    @FindBy(xpath = "/html/body/footer/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/a")
    private WebElement secondValueOfPriceButton;
    @FindBy(xpath = "/html/body/footer/div[3]/div/div[1]/div/div[1]/div[2]/div/button/span[2]")
    private WebElement spanWithValueOfMoney;
    @FindBy(xpath = "/html/body/footer/div[3]/div/div[1]/div/div[3]/a")
    private WebElement map;
    @FindBy(xpath = "/html/body/header/div/header/nav/div/div/div[2]/ul[1]/li[9]/a")
    private WebElement sales;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SearchResultPage search(String text) {
        searchInput.sendKeys(text);
        return new SearchResultPage(driver);
    }
    public String changeCurrency() throws InterruptedException {
        Thread.sleep(1500);
        acceptCookieElement.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", priceButton);
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        priceButton.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/8);
        secondValueOfPriceButton.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        return spanWithValueOfMoney.getText();
    }
    public String goToMapHref() throws InterruptedException {
        Thread.sleep(1500);
        acceptCookieElement.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/8);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/2);
        map.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/2);
        return driver.getCurrentUrl();
    }
    public String goToSalesHref() throws InterruptedException {
        Thread.sleep(1500);
        acceptCookieElement.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/2);
        sales.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS*2);
        return driver.getCurrentUrl();
    }
}