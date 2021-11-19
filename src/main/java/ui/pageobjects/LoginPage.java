package ui.pageobjects;

import static utils.ConfigProperties.TIME_OUT;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.components.HeaderMenu;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user")
    private WebElement userInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login")
    private WebElement login;
    @FindBy(id = "login-submit")
    private WebElement loginSubmit;
    @FindBy(xpath = "//div[contains(text(), 'Log in to continue to:')]")
    private WebElement continueLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
    }

    public LoginPage sendKeysToUserInputField(String user) {
        userInputField.sendKeys(user);
        return this;
    }

    public LoginPage clickLogin() {
        login.click();
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(continueLogin));
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    public LoginPage submitLogin() {
        loginSubmit.click();
        return this;
    }
}
