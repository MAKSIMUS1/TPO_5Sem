package by.kryshtal;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
public class BootsPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookieElement;

    @FindBy(xpath = "//*[@id=\"buscar_productos\"]")
    private WebElement searchButtonElement;

    @FindBy(xpath = "//*[@id=\"dropdown_precio\"]")
    private WebElement priceGroupElement;

    @FindBy(xpath = "//*[@id=\"filtros_busqueda\"]/div/div[3]/div/div[1]/div[3]/div/input")
    private WebElement maxPriceElement;

    public BootsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() throws InterruptedException {
        driver.get("https://www.futbolemotion.com/neu/football-boots");
        Thread.sleep(1500);
        acceptCookieElement.click();
    }

    public void clickOnSearchButtonElement() {
        searchButtonElement.click();
    }

    public void setMaxPrice(String maxPrice) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,850)");
        Thread.sleep(1000);
        priceGroupElement.click();

        Thread.sleep(2000);
        maxPriceElement.clear();
        maxPriceElement.sendKeys(maxPrice);
        Thread.sleep(2000);
        priceGroupElement.click();
    }

    public List<Double> getPrices() {
        List<WebElement> elements = new ArrayList<>();
        for(int i = 4; i < 48; i++)
        {
            elements.add(driver.findElement(By.cssSelector("#listado_productos > div.row > div.col-lg-17.col-xl-18.col-xxl-19.listadoproductos > div:nth-child(2) > article:nth-child(" + i + ") > div > div.producto.overflow-hidden > div > div > div.producto-listado-precios > div > div.precio-rebajado.fw-bolder.fs-5.text-danger.font-style-currency")));
        }
        List<Double> prices = new ArrayList<Double>();

        for (WebElement el : elements) {
            String price = el.getText();
            System.out.println(price);
            price = price.substring(0, price.length() - 2);
            price = price.replace(",", ".");
            prices.add(Double.parseDouble(price));
        }

        return prices;
    }
}