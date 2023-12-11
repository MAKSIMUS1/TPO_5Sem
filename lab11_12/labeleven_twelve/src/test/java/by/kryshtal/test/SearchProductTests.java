package by.kryshtal.test;

import by.kryshtal.page.MainPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchProductTests extends CommonConditions {

    private static String searchProduct = "ADIDAS PREDATOR ACCURACY.3 LL FG FOOTBALL BOOTS";
    @Test()
    public void shouldBeRedirectedToProductsPage() throws InterruptedException {
        String productHref = new MainPage(driver)
                .openPage()
                .search(searchProduct)
                .openPage()
                .getHref();
        Assert.assertEquals(driver.getCurrentUrl(), productHref);
    }

    @Test()
    public void shouldBeRedirectedToTheSameProductPage() throws InterruptedException {
        String productName = new MainPage(driver)
                .openPage()
                .search(searchProduct)
                .openPage()
                .getProductPage()
                .getProductName();
        Assert.assertEquals(searchProduct, productName);
    }
}
