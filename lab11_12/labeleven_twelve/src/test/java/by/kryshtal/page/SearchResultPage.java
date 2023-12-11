package by.kryshtal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {

    private WebElement linkToProductPage;
    private String href = "";

    public SearchResultPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchResultPage openPage() throws InterruptedException {
        Thread.sleep(5000);

        By linkToProductPageSelector = By.xpath("//*[@id=\"search-content-empathy-broker\"]/div/div/div[3]/div[2]/figure[1]/div/div[1]/a");
        linkToProductPage = driver.findElement(linkToProductPageSelector);
        Thread.sleep(2000);

        String href = linkToProductPage.getAttribute("href");
        this.href = href;
        driver.navigate().to(href);
        return this;
    }
    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }
    public String getHref() {
        return href;
    }
}
