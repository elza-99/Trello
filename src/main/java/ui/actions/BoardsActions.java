package ui.actions;

import org.openqa.selenium.WebDriver;
import ui.pageobjects.AbstractPage;
import ui.pageobjects.BoardsPage;

public class BoardsActions extends AbstractPage {

    protected BoardsPage boardsPage;

    public BoardsActions(WebDriver driver) {
        super(driver);
    }

    public void deleteBoard() {
        boardsPage = new BoardsPage(driver);
        boardsPage.clickBoardsMenu();
        boardsPage.clickBoardsMenuMore();
        boardsPage.clickCloseBoardLink();
        boardsPage.clickCloseConfirmButton();
        boardsPage.clickDeleteBoardButton();
        boardsPage.clickDeleteConfirmButton();
    }
}
