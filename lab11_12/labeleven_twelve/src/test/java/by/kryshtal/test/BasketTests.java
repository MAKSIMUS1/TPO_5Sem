package by.kryshtal.test;

import by.kryshtal.page.BasketPage;
import by.kryshtal.page.MainPage;
import by.kryshtal.page.ProductPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class BasketTests extends CommonConditions{
    @Test()
    public void addBootsToBasket() throws InterruptedException {
        String quanity = new ProductPage(driver)
                .openPageByHref("https://www.futbolemotion.com/neu/buy/football-boot/adidas/strung-fg-red")
                .addToBasket()
                .getQuanity();
        Thread.sleep(2000);
        Assert.assertEquals(quanity, "1");
    }
}
