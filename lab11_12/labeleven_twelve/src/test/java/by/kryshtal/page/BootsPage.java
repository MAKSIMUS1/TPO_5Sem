package by.kryshtal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BootsPage extends AbstractPage {
    private final String PAGE_URL = "https://www.futbolemotion.com/neu/football-boots";
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookieElement;

    @FindBy(xpath = "//*[@id=\"buscar_productos\"]")
    private WebElement searchButtonElement;

    @FindBy(xpath = "//*[@id=\"dropdown_precio\"]")
    private WebElement priceGroupElement;

    @FindBy(xpath = "//*[@id=\"filtros_busqueda\"]/div/div[3]/div/div[1]/div[3]/div/input")
    private WebElement maxPriceElement;

    public BootsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BootsPage openPage() throws InterruptedException {
        driver.navigate().to(PAGE_URL);
        Thread.sleep(1500);
        acceptCookieElement.click();
        return this;
    }

    public BootsPage clickOnSearchButtonElement() throws InterruptedException {
        searchButtonElement.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS);
        return this;
    }

    public BootsPage setMaxPrice(String maxPrice) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,650)");
        Thread.sleep(1000);
        priceGroupElement.click();

        Thread.sleep(2000);
        maxPriceElement.clear();
        maxPriceElement.sendKeys(maxPrice);
        Thread.sleep(2000);
        priceGroupElement.click();
        return this;
    }

    public List<Double> getPrices() {
        List<WebElement> elements = new ArrayList<>();
        for(int i = 4; i < 48; i++)
        {
            elements.add(driver.findElement(By.cssSelector("#listado_productos > div.row > div.col-lg-17.col-xl-18.col-xxl-19.listadoproductos > div:nth-child(2) > article:nth-child(" + i + ") > div > div.producto.overflow-hidden > div > div > div.producto-listado-precios > div > div")));
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
