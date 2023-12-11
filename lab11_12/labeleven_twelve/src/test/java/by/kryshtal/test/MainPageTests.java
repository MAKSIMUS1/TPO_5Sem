package by.kryshtal.test;

import by.kryshtal.page.BootsPage;
import by.kryshtal.page.MainPage;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends CommonConditions{
    @Test()
    public void changePriceValue() throws InterruptedException {
        String str = new MainPage(driver)
                .openPage()
                .changeCurrency();
        Thread.sleep(1000);
        Assert.assertEquals(str, "USD");
    }
    @Test()
    public void goToMap() throws InterruptedException {
        String str = new MainPage(driver)
                .openPage()
                .goToMapHref();
        Thread.sleep(1000);
        Assert.assertEquals(str, "https://www.futbolemotion.com/en/stores");
    }
    @Test()
    public void goToSales() throws InterruptedException {
        String str = new MainPage(driver)
                .openPage()
                .goToSalesHref();
        Assert.assertEquals(str, "https://www.futbolemotion.com/neu/deals");
    }
}

