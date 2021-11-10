package api.apitests;

import api.BaseApiTest;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class BoardTests extends BaseApiTest {

    private static final String BOARD_NAME_1 = "Kanban1";
    private static final String BOARD_NAME_2 = "Kanban2";
    private static final String LIST_NAME_1 = "TO DO";

    @Test(description = "Test1", groups = "Regression")
    public void createAndGetNewBoard() {
        boardDto.setName(BOARD_NAME_1);
        boardDto.setDefaultLists(false);
        String id = boardsService.createBoard(boardDto).getId();
        ids.add(id);
        boardsService.getBoard(id);
    }

    @Test(description = "Test2", groups = "Regression")
    public void updateNewBoard() {
        boardDto.setName(BOARD_NAME_1);
        boardDto.setDefaultLists(false);
        String id = boardsService.createBoard(boardDto).getId();
        ids.add(id);
        boardDto.setName(BOARD_NAME_2);
        String name = boardsService.updateBoard(boardDto, id).getName();
        Assertions.assertThat(name.equalsIgnoreCase(BOARD_NAME_2));
    }

    @Test(description = "Test3", groups = "Regression")
    public void createListAndGetLists() {
        boardDto.setName(BOARD_NAME_1);
        boardDto.setDefaultLists(false);
        String id1 = boardsService.createBoard(boardDto).getId();
        ids.add(id1);
        listDto.setName(LIST_NAME_1);
        listDto.setIdBoard(id1);
        listsService.createList(listDto, id1);
        listsService.getLists(id1);
    }
}
