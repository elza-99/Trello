package ui.pageobjects;

import org.openqa.selenium.WebDriver;
import ui.components.AbstractContainer;
import ui.components.HeaderMenu;
import ui.components.SidebarMenu;
import ui.components.Workspaces;

public abstract class AbstractPage extends AbstractContainer {

    protected HeaderMenu headerMenu;
    protected Workspaces workspaces;
    protected SidebarMenu sideBarMenu;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
        workspaces = new Workspaces(driver);
        sideBarMenu = new SidebarMenu(driver);
    }
}
