package ui.actions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import ui.components.HeaderMenu;
import ui.pageobjects.AbstractPage;

public class LoginActions extends AbstractPage {
    
    protected LoginPageBuilder loginPageBuilder;

    public LoginActions(WebDriver driver) {
        super(driver);
    }

    public void loginWithSubmit(String username, String password) {
        headerMenu = new HeaderMenu(driver);
        loginPageBuilder = new LoginPageBuilder(driver);
        headerMenu.clickLoginLink();
        loginPageBuilder
                .sendKeysToUserInputField(username)
                .clickLogin()
                .enterPassword(password)
                .submitLogin()
                .build();
        driver.manage()
                .timeouts()
                .implicitlyWait(40, TimeUnit.SECONDS);
    }
}
