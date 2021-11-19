package ui.actions;

import org.openqa.selenium.WebDriver;
import ui.pageobjects.AbstractPage;
import ui.pageobjects.BoardsPage;

public class BoardsActions extends AbstractPage {

    protected BoardsPage boardsPage;

    public BoardsActions(WebDriver driver, BoardsPage boardsPage) {
        super(driver);
        this.boardsPage = boardsPage;
    }

    public void createBoard(String name) {
        workspaces.clickCreateBoardTile()
                .inputBoardName(name)
                .clickCreateBoardSubmitButton();
    }
    
    public void deleteBoard() {
        boardsPage.clickBoardsMenu()
                .clickBoardsMenuMore()
                .clickCloseBoardLink()
                .clickCloseConfirmButton()
                .clickDeleteBoardButton()
                .clickDeleteConfirmButton();
    }
    
    public void addNewListToBoard(String name) {
        boardsPage.addNewList()
                .inputListName(name)
                .clickSubmitAddListButton();
    }
}
