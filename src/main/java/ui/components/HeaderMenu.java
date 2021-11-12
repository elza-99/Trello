package ui.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenu extends AbstractContainer {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    @FindBy(css = "button[data-test-id='header-member-menu-button']")
    private WebElement headerMemberMenuButton;
    @FindBy(css = "li[data-test-id='create-board-tile']")
    private WebElement createBoardTile;
    @FindBy(id = "header")
    private WebElement header;
    @FindBy(css = "button[data-test-id='workspace-switcher']")
    private WebElement workspaceSwitcher;
    @FindBy(className = "_2ft40Nx3NZII2i")
    private WebElement homePageIcon;
    @FindBy(css = "button[data-test-id='recently-viewed-boards-menu']")
    private WebElement recentlyViewedBoardsMenu;
    @FindBy(css = "li[class=UtX-sCYI8xMcaV]")
    private List<WebElement> boards;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public boolean isHeaderDisplayed() {
        return header.isDisplayed();
    }

    public void clickRecentlyViewedBoards() {
        wait.until(ExpectedConditions.visibilityOf(recentlyViewedBoardsMenu));
        recentlyViewedBoardsMenu.click();
    }

    public List<String> getBoards() {
        return boards.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
