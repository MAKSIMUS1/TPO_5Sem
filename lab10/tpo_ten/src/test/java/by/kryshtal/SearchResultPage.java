package by.kryshtal;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {
    private final WebDriver driver;

    private WebElement linkToProductPage;
    private String href = "";

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProduct() throws InterruptedException {
        Thread.sleep(5000);

        By linkToProductPageSelector = By.xpath("//*[@id=\"search-content-empathy-broker\"]/div/div/div[3]/div[2]/figure[1]/div/div[1]/a");
        linkToProductPage = driver.findElement(linkToProductPageSelector);
        Thread.sleep(2000);

        String href = linkToProductPage.getAttribute("href");
        this.href = href;
        driver.get(href);
    }

    public String getHref() {
        return href;
    }
}