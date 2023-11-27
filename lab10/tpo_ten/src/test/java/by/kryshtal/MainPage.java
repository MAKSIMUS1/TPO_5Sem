package by.kryshtal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"caja_buscador\"]")
    private WebElement searchInput;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.futbolemotion.com/neu");
    }

    public void search(String text) {
        searchInput.sendKeys(text);
    }
}