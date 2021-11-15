package ui.actions;

import org.openqa.selenium.WebDriver;
import ui.components.AbstractContainer;
import ui.pageobjects.LoginPage;

public class LoginPageBuilder extends AbstractContainer {

    protected LoginPage loginPage;

    public LoginPageBuilder(WebDriver driver) {
        super (driver);
        this.loginPage = new LoginPage(driver);
    }

    public LoginPageBuilder sendKeysToUserInputField(String userName) {
        this.loginPage.sendKeysToUserInputField(userName);
        return this;
    }
    
    public LoginPageBuilder clickLogin() {
        this.loginPage.clickLogin();
        return this;
    }

    public LoginPageBuilder enterPassword(String password) {
        this.loginPage.enterPassword(password);
        return this;
    }

    public LoginPageBuilder submitLogin() {
        this.loginPage.submitLogin();
        return this;
    }

    public LoginPage build() {
        return this.loginPage; }
}
