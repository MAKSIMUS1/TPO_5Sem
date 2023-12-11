package by.kryshtal.test;

import by.kryshtal.page.BootsPage;
import by.kryshtal.page.MainPage;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PriceFilterTests extends CommonConditions{
    private static int filterMaxPrice = 95;
    @Test()
    public void checkPricesPage() throws InterruptedException {
        List<Double> prices = new BootsPage(driver)
                .openPage()
                .setMaxPrice(String.valueOf(filterMaxPrice))
                .clickOnSearchButtonElement()
                .getPrices();

        for (Double price : prices) {
            Assert.assertTrue(price <= filterMaxPrice);
        }
    }
}
