package api;

import api.dao.BoardDto;
import api.dao.ListDto;
import api.service.BoardsService;
import api.service.ListsService;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.assertions.BoardsApiAssertions;

public class BaseApiTest {

    protected BoardsService boardsService;
    protected ListsService listsService;
    protected ListDto listDto;
    protected BoardDto boardDto;
    protected BoardsApiAssertions boardsApiAssertions;
    protected List<String> ids = new ArrayList<>();

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        boardsService = new BoardsService();
        listsService = new ListsService();
        listDto = new ListDto();
        boardDto = new BoardDto();
        boardsApiAssertions = new BoardsApiAssertions();
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
