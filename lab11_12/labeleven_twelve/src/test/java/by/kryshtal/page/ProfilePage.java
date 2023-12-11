package by.kryshtal.page;

import by.kryshtal.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage  extends AbstractPage
{
    @FindBy(xpath = "/html/body/main/div/div[2]/div/div[2]/div/div[4]/div/div/a")
    private WebElement myInterestsHref;
    @FindBy(xpath = "/html/body/main/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/input")
    private WebElement teamInput;
    @FindBy(xpath = "/html/body/main/div/div[2]/div/div/div[2]/div/div/div[1]/div[2]/ul/li")
    private WebElement team_in_li;
    @FindBy(xpath = "/html/body/main/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/ul/li/span[2]")
    private WebElement teamName_span;
    @FindBy(xpath = "/html/body/main/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/ul/li/span[3]/i")
    private WebElement deleteTeam_i;

    public ProfilePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public ProfilePage openPage() {
        return this;
    }
    public ProfilePage openMyInterests(){
        String link = myInterestsHref.getAttribute("href");
        driver.navigate().to(link);
        return this;
    }
    public String setFavouriteTeam(String team) throws InterruptedException {
        teamInput.sendKeys(team);
        team_in_li.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/2);
        String team_name = teamName_span.getText();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/2);
        deleteTeam_i.click();
        Thread.sleep(WAIT_TIMEOUT_MILLISECONDS/4);
        return team_name;
    }

}