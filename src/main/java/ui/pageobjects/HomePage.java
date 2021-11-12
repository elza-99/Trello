package ui.pageobjects;

import org.openqa.selenium.WebDriver;
import ui.components.HeaderMenu;
import ui.components.SidebarMenu;
import ui.components.Workspaces;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.workspaces = new Workspaces(driver);
        this.sideBarMenu = new SidebarMenu(driver);
    }
}
