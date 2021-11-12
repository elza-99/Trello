package ui.actions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import ui.components.HeaderMenu;
import ui.pageobjects.AbstractPage;
import ui.pageobjects.LoginPage;

public class LoginActions extends AbstractPage {

    protected HeaderMenu headerMenu;
    protected LoginPage loginPage;

    public LoginActions(WebDriver driver) {
        super(driver);
    }

    public void loginWithSubmit(String username, String password) {
        headerMenu = new HeaderMenu(driver);
        loginPage = new LoginPage(driver);
        headerMenu.clickLoginLink();
        loginPage.sendKeysToUserInputField(username);
        loginPage.clickLogin();
        loginPage.enterPassword(password);
        loginPage.submitLogin();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
}
