package by.kryshtal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;

    private WebElement product;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() throws InterruptedException {
        product = driver.findElement(By.xpath("/html/body/main/div/div[2]/section/div[2]/div/div/div[2]/div/h1"));
        return product.getText();
    }
}
