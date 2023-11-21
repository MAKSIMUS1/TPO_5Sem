package by.tponine;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class AppWebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.futbolemotion.com/neu");

        By searchInputSelector = By.xpath("//*[@id=\"caja_buscador\"]");

        WebElement searchInput = driver.findElement(searchInputSelector);

        searchInput.sendKeys("ADIDAS PREDATOR ACCURACY.3 LL FG FOOTBALL BOOTS");
        //searchButton.click();

        Thread.sleep(5000);
        By linkToProductPageSelector = By.xpath("//*[@id=\"search-content-empathy-broker\"]/div/div/div[3]/div[2]/figure[1]/div/div[1]/a");
        WebElement linkToProductPage = driver.findElement(linkToProductPageSelector);
        Thread.sleep(5000);

        String href = linkToProductPage.getAttribute("href");
        driver.get(href);
        Thread.sleep(2000);

        driver.quit();
    }
}