package ui.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum WebDriverInstance {

    INSTANCE;

    private static final String CHROME = "CHROME";
    private WebDriver driver;
    private WebDriverWait wait;

    public void createdDriver(String browserName) {
        if (CHROME.equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
