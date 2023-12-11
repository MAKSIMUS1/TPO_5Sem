package by.kryshtal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends AbstractPage {
    @FindBy(xpath = "/html/body/main/div/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/ul/li[4]/div/input")
    private WebElement quantityInput;
    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BasketPage openPage() throws InterruptedException {
        return this;
    }
    public String getQuanity(){
        return quantityInput.getAttribute("value");
    }
}

