package api.apitests;

import api.BaseApiTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class BoardApiTests extends BaseApiTest {

    private static final String BOARD_NAME_1 = "BOARD_1_";
    private static final String BOARD_NAME_2 = "BOARD_2_";
    private static final String BOARD_NAME_3 = "BOARD_3_";
    private static final String BOARD_NAME_4 = "BOARD_4_";
    private static final String LIST_NAME_1 = "TO DO_1_";

    private String boardName1;
    private String boardName2;
    private String boardName3;
    private String boardName4;
    private String listName1;

    @Test(description = "Test1", groups = "Regression")
    public void createAndGetNewBoard() {
        boardName1 = BOARD_NAME_1 + RandomStringUtils.randomAlphabetic(4);
        boardDto.setName(boardName1);
        boardDto.setDefaultLists(false);
        String id = boardsService.createBoard(boardDto).getId();
        boardsService.getBoard(id);
        boardsService.deleteBoard(id);
    }

    @Test(description = "Test2", groups = "Regression")
    public void updateNewBoard() {
        boardName2 = BOARD_NAME_2 + RandomStringUtils.randomAlphabetic(4);
        boardName3 = BOARD_NAME_3 + RandomStringUtils.randomAlphabetic(4);
        boardDto.setName(boardName2);
        boardDto.setDefaultLists(false);
        String id = boardsService.createBoard(boardDto).getId();
        boardDto.setName(boardName3);
        String name = boardsService.updateBoard(boardDto, id).getName();
        boardsApiAssertions.assertThatBoardNameUpdated(name, boardName3);
        boardsService.deleteBoard(id);
    }

    @Test(description = "Test3", groups = "Regression")
    public void createListAndGetLists() {
        boardName4 = BOARD_NAME_4 + RandomStringUtils.randomAlphabetic(4);
        listName1 = LIST_NAME_1 + RandomStringUtils.randomAlphabetic(4);
        boardDto.setName(boardName4);
        boardDto.setDefaultLists(false);
        String id = boardsService.createBoard(boardDto).getId();
        listDto.setName(listName1);
        listDto.setIdBoard(id);
        listsService.createList(listDto, id);
        listsService.getLists(id);
        boardsService.deleteBoard(id);
    }
}
