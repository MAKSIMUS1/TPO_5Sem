package by.kryshtal.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
    protected WebDriver driver;

    protected abstract AbstractPage openPage() throws InterruptedException;
    protected final int WAIT_TIMEOUT_SECONDS = 8;
    protected final int WAIT_TIMEOUT_MILLISECONDS = WAIT_TIMEOUT_SECONDS * 1000;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
