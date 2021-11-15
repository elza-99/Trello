package ui.actions;

import org.openqa.selenium.WebDriver;
import ui.pageobjects.AbstractPage;

public class BoardsActions extends AbstractPage {

    protected BoardsActionsBuilder boardsActionsBuilder;

    public BoardsActions(WebDriver driver) {
        super(driver);
    }

    public void deleteBoard() {
        boardsActionsBuilder = new BoardsActionsBuilder(driver);
        boardsActionsBuilder.clickBoardsMenu()
                .clickBoardsMenuMore()
                .clickCloseBoardLink()
                .clickCloseConfirmButton()
                .clickDeleteBoardButton()
                .clickDeleteConfirmButton()
                .build();
    }
}
