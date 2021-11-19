package ui.actions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ui.pageobjects.AbstractPage;
import ui.pageobjects.BoardsPage;

public class BoardsActions extends AbstractPage {

    protected BoardsPage boardsPage;

    public BoardsActions(WebDriver driver, BoardsPage boardsPage) {
        super(driver);
        this.boardsPage = boardsPage;
    }

    @Step(value = "Create Board {0}")
    public void createBoard(String name) {
        workspaces.clickCreateBoardTile()
                .inputBoardName(name)
                .clickCreateBoardSubmitButton();
    }

    @Step(value = "Delete Board")
    public void deleteBoard() {
        boardsPage.clickBoardsMenu()
                .clickBoardsMenuMore()
                .clickCloseBoardLink()
                .clickCloseConfirmButton()
                .clickDeleteBoardButton()
                .clickDeleteConfirmButton();
    }

    @Step(value = "Add New List to Board {0}")
    public void addNewListToBoard(String name) {
        boardsPage.addNewList()
                .inputListName(name)
                .clickSubmitAddListButton();
    }
}
