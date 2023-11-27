package by.kryshtal;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;



public class SiteTestSecond {
    private static WebDriver driver;
    private BootsPage page;

    @BeforeClass()
    public static void init() {
        driver = new EdgeDriver();
    }

    @Before()
    public void openPages() throws InterruptedException {
        page = new BootsPage(driver);
        page.open();
        page.setMaxPrice("95");
        page.clickOnSearchButtonElement();
        Thread.sleep(6000);
    }

    @Test()
    public void shouldBeRedirectedToProductsPage() throws InterruptedException {
        List<Double> prices = page.getPrices();
        for (Double price : prices) {
            Assert.assertTrue(price <= 95);
        }
    }

    @AfterClass()
    public static void close() {
        driver.quit();
    }
}