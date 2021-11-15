package ui.actions;

import org.openqa.selenium.WebDriver;
import ui.components.AbstractContainer;
import ui.pageobjects.BoardsPage;

public class BoardsActionsBuilder extends AbstractContainer {

    protected BoardsPage boardsPage;

    public BoardsActionsBuilder(WebDriver driver) {
        super (driver);
        this.boardsPage = new BoardsPage(driver);
    }

    public BoardsActionsBuilder clickBoardsMenu() {
        this.boardsPage.clickBoardsMenu();
        return this;
    }

    public BoardsActionsBuilder clickBoardsMenuMore() {
        this.boardsPage.clickBoardsMenuMore();
        return this;
    }

    public BoardsActionsBuilder clickCloseBoardLink() {
        this.boardsPage.clickCloseBoardLink();
        return this;
    }

    public BoardsActionsBuilder clickCloseConfirmButton() {
        this.boardsPage.clickCloseConfirmButton();
        return this;
    }

    public BoardsActionsBuilder clickDeleteBoardButton() {
        this.boardsPage.clickDeleteBoardButton();
        return this;
    }

    public BoardsActionsBuilder clickDeleteConfirmButton() {
        this.boardsPage.clickDeleteConfirmButton();
        return this;
    }

    public BoardsPage build() {
        return this.boardsPage; }
}
