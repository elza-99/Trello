package ui.actions;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.openqa.selenium.WebDriver;
import ui.components.AbstractContainer;
import ui.components.Workspaces;
import ui.pageobjects.BoardsPage;

public class BoardsActionsBuilder extends AbstractContainer {

    protected BoardsPage boardsPage;
    protected Workspaces workspaces;

    public BoardsActionsBuilder(WebDriver driver) {
        super (driver);
        this.boardsPage = new BoardsPage(driver);
        this.workspaces = new Workspaces(driver);
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

    public BoardsActionsBuilder addList() {
        this.boardsPage.addNewList();
        return this;
    }

    public BoardsActionsBuilder inputNameOfList(String name) {
        this.boardsPage.inputListName(name);
        return this;
    }
    
    public BoardsActionsBuilder clickSubmitAddList() {
        this.boardsPage.clickSubmitAddListButton();
        return this;
    }
    
    public BoardsActionsBuilder clickCreateBoard() {
        this.workspaces.clickCreateBoardTile();
        return this;
    }

    public BoardsActionsBuilder inputNameOfBoard(String name) {
        this.workspaces.inputBoardName(name);
        return this;
    }

    public BoardsActionsBuilder clickSubmitCreateBoardButton() {
        this.workspaces.clickCreateBoardSubmitButton();
        return this;
    }
}
