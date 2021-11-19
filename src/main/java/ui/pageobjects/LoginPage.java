package ui.pageobjects;

import static utils.ConfigProperties.TIME_OUT;

import io.qameta.allure.Step;
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
    
    @Step(value = "Send Keys To User Input Field {0}")
    public LoginPage sendKeysToUserInputField(String user) {
        userInputField.sendKeys(user);
        return this;
    }

    @Step(value = "Click Login")
    public LoginPage clickLogin() {
        login.click();
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(continueLogin));
        return this;
    }

    @Step(value = "Enter Password {0}")
    public LoginPage enterPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    @Step(value = "Submit Login")
    public LoginPage submitLogin() {
        loginSubmit.click();
        return this;
    }
}
