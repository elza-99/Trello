package ui.actions;

import static utils.ConfigProperties.TIME_OUT;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import ui.pageobjects.AbstractPage;
import ui.pageobjects.LoginPage;

public class LoginActions extends AbstractPage {
    
    protected LoginPage loginPage;

    public LoginActions(WebDriver driver, LoginPage loginPage) {
        super(driver);
        this.loginPage = loginPage;
    }

    public void loginWithSubmit(String username, String password) {
        headerMenu.clickLoginLink();
        loginPage
                .sendKeysToUserInputField(username)
                .clickLogin()
                .enterPassword(password)
                .submitLogin();
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
    }
}
