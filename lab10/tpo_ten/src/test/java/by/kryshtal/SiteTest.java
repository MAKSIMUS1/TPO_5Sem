package by.kryshtal;


import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SiteTest {
    private static WebDriver driver;

    private static MainPage mainPage;
    private static SearchResultPage searchResultPage;
    private static ProductPage productPage;
    private static String searchProduct;

    @BeforeClass()
    public static void init() {
        driver = new EdgeDriver();
        mainPage = new MainPage(driver);
        searchProduct = "ADIDAS PREDATOR ACCURACY.3 LL FG FOOTBALL BOOTS";
    }

    @Before
    public void openPages() throws InterruptedException {
        mainPage.open();
        mainPage.search(searchProduct);

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOnProduct();

        Thread.sleep(2000);
        productPage = new ProductPage(driver);
    }

    @Test()
    public void shouldBeRedirectedToProductsPage() throws InterruptedException {
        String productName = productPage.getProductName();
        Assert.assertEquals(searchProduct, productName);
    }

    @Test()
    public void shouldBeRedirectedToTheSameProductPage() throws InterruptedException {
        String href = searchResultPage.getHref();
        Assert.assertEquals(href, driver.getCurrentUrl());
    }

    @AfterClass()
    public static void close() {
        driver.quit();
    }
}
