package ui.actions;

import org.openqa.selenium.WebDriver;
import ui.pageobjects.AbstractPage;

public class BoardsActions extends AbstractPage {

    protected BoardsActionsBuilder boardsActionsBuilder;

    public BoardsActions(WebDriver driver, BoardsActionsBuilder boardsActionsBuilder) {
        super(driver);
        this.boardsActionsBuilder = boardsActionsBuilder;
    }

    public void createBoard(String name) {
        boardsActionsBuilder.clickCreateBoard()
                .inputNameOfBoard(name)
                .clickSubmitCreateBoardButton();
    }
    
    public void deleteBoard() {
        boardsActionsBuilder.clickBoardsMenu()
                .clickBoardsMenuMore()
                .clickCloseBoardLink()
                .clickCloseConfirmButton()
                .clickDeleteBoardButton()
                .clickDeleteConfirmButton();
    }
    
    public void addNewListToBoard(String name) {
        boardsActionsBuilder.addList()
                .inputNameOfList(name)
                .clickSubmitAddList();
    }
}
