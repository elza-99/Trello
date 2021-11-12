package ui.uitests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import ui.BaseUITest;

public class BoardUITests extends BaseUITest {

    private static final String BOARD_NAME_1 = "BOARD_1_";
    private static final String BOARD_NAME_2 = "BOARD_2_";
    private static final String BOARD_NAME_3 = "BOARD_3_";
    private static final String LIST_NAME_1 = "TO DO_1_";

    private String boardName1;
    private String boardName2;
    private String boardName3;
    private String listName1;

    @Test(description = "Test1", groups = "Regression")
    public void headerTest() {
        headerMenu.isHeaderDisplayed();
    }

    @Test(description = "Test2", groups = "Regression")
    public void createBoardTest() {
        boardName1 = BOARD_NAME_1 + RandomStringUtils.randomAlphabetic(4);
        workspaces.clickCreateBoardTile();
        workspaces.inputBoardName(boardName1);
        workspaces.clickCreateBoardSubmitButton();
        headerMenu.clickRecentlyViewedBoards();
        headerMenuAssertions.assertThatBoardIsCreated(boardName1);
        String id = apiBoardsWorkflow.getBoardId(boardName1);
        ids.add(id);
    }

    @Test(description = "Test3", groups = "Regression")
    public void createListTest() {
        boardName2 = BOARD_NAME_2 + RandomStringUtils.randomAlphabetic(4);
        listName1 = LIST_NAME_1 + RandomStringUtils.randomAlphabetic(4);
        boardDto.setName(boardName2);
        String id = apiBoardsWorkflow.createBoardViaApi(boardDto).getId();
        ids.add(id);
        workspaces.clickBoardByName(boardName2);
        boardsPage.addNewList();
        boardsPage.inputListName(listName1);
        boardsPage.clickSubmitAddListButton();
        boardsAssertions.assertThatBoardContainsCreatedList(listName1);
    }

    @Test(description = "Test4", groups = "Regression")
    public void deleteBoardTest() {
        boardName3 = BOARD_NAME_3 + RandomStringUtils.randomAlphabetic(4);
        boardDto.setName(boardName3);
        String id = apiBoardsWorkflow.createBoard(boardDto).getId();
        ids.add(id);
        workspaces.clickBoardByName(boardName3);
        boardsActions.deleteBoard();
        workspacesAssertions.assertThatListDoesNotContainCreatedBoard(boardName3);
    }
}