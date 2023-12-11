package by.kryshtal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {

    private WebElement product;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookieElement;
    @FindBy(xpath = "//*[@id=\"seleccion_talla\"]")
    private WebElement chooseSizeButton;
    @FindBy(xpath = "//*[@id=\"productoprincipal_talla0\"]/tbody/tr[4]")
    private WebElement size42EU;
    @FindBy(xpath = "//*[@id=\"btn_comprar\"]")
    private WebElement addToBusketButton;

    public ProductPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ProductPage openPage() throws InterruptedException {
        return this;
    }
    public String getProductName() throws InterruptedException {
        product = driver.findElement(By.xpath("/html/body/main/div/div[2]/section/div[2]/div/div/div[2]/div/h1"));
        return product.getText();
    }
    public ProductPage openPageByHref(String href) throws InterruptedException {
        driver.navigate().to(href);
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        acceptCookieElement.click();
        return this;
    }
    public BasketPage addToBasket() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)");
        chooseSizeButton.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/8);
        size42EU.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/8);
        addToBusketButton.click();
        return new BasketPage(driver);
    }
}
