package ui;

import static utils.ConfigProperties.getPassword;
import static utils.ConfigProperties.getUrl;
import static utils.ConfigProperties.getUser;

import api.dao.BoardDto;
import api.service.BoardsService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.actions.BoardsActions;
import ui.actions.LoginActions;
import ui.assertions.BoardsUIAssertions;
import ui.assertions.HeaderMenuAssertions;
import ui.assertions.WorkspacesAssertions;
import ui.components.HeaderMenu;
import ui.components.Workspaces;
import ui.pageobjects.BoardsPage;
import ui.pageobjects.HomePage;
import ui.pageobjects.LoginPage;
import ui.webdriver.WebDriverInstance;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUITest {

    private static final Logger LOGGER = Logger.getLogger(BaseUITest.class.getName());

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected Workspaces workspaces;
    protected HeaderMenu headerMenu;
    protected HomePage homePage;
    protected BoardsPage boardsPage;
    protected BoardsUIAssertions boardsAssertions;
    protected HeaderMenuAssertions headerMenuAssertions;
    protected WorkspacesAssertions workspacesAssertions;
    protected BoardsService boardsService;
    protected BoardDto boardDto;
    protected LoginActions loginActions;
    protected BoardsActions boardsActions;
    protected List<String> ids = new ArrayList<>();

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriverInstance.INSTANCE.createdDriver("chrome");
        driver = WebDriverInstance.INSTANCE.getDriver();
        wait = WebDriverInstance.INSTANCE.getWait();
        loginPage = new LoginPage(driver);
        workspaces = new Workspaces(driver);
        headerMenu = new HeaderMenu(driver);
        homePage = new HomePage(driver);
        boardsPage = new BoardsPage(driver);
        boardsAssertions = new BoardsUIAssertions(driver);
        headerMenuAssertions = new HeaderMenuAssertions(driver);
        workspacesAssertions = new WorkspacesAssertions(driver);
        boardsService = new BoardsService();
        boardDto = new BoardDto();
        loginActions = new LoginActions(driver);
        boardsActions = new BoardsActions(driver);

        openSite();
        loginActions.loginWithSubmit(getUser(), getPassword());
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        if (!ids.isEmpty()) {
            for (String id : ids) {
                try {
                    boardsService.deleteBoard(id);
                } catch (AssertionError e) {
                    LOGGER.log(Level.WARNING, e.getMessage());
                }
            }
        }
        driver.quit();
    }

    public void openSite() {
        driver.get(getUrl());
        driver.manage().window().maximize();
    }
}
