package by.kryshtal.page;

import by.kryshtal.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://www.futbolemotion.com/neu";

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement acceptCookieElement;
    @FindBy(xpath = "//*[@id=\"top_header\"]/div[2]/div/div[2]/button[1]")
    private WebElement loginButton;

    @FindBy(xpath ="//*[@id=\"form-login\"]/form/div[1]/input")
    private WebElement inputLogin;

    @FindBy(xpath = "/html/body/header/div/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/form/div[2]/input")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"form-login\"]/form/div[3]/input")
    private WebElement buttonSubmit;
    @FindBy(xpath = "/html/body/header/div/header/div[2]/div/div[2]/button[1]")
    private WebElement buttonAccount;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() throws InterruptedException {
        driver.navigate().to(PAGE_URL);
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        acceptCookieElement.click();
        loginButton.click();
        logger.info("Login page opened");
        return this;
    }

    public LoginPage login(User user) throws InterruptedException {
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        inputLogin.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonSubmit.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS);
        logger.info("Login performed");
        return this;
    }
    public ProfilePage openAccount() throws InterruptedException {
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        buttonAccount.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        return new ProfilePage(driver);
    }
}