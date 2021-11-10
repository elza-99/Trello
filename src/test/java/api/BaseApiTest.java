package api;

import api.dao.BoardDto;
import api.dao.ListDto;
import api.service.BoardsService;
import api.service.ListsService;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    public BoardsService boardsService;
    public ListsService listsService;
    public ListDto listDto;
    public BoardDto boardDto;
    public List<String> ids = new ArrayList<>();

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        boardsService = new BoardsService();
        listsService = new ListsService();
        listDto = new ListDto();
        boardDto = new BoardDto();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        if (!ids.isEmpty()) {
            for (String id : ids) {
                boardsService.deleteBoard(id);
            }
        }
    }
}
