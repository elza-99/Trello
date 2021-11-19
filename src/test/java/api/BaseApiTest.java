package api;

import api.assertions.BoardsApiAssertions;
import api.dao.BoardDto;
import api.dao.ListDto;
import api.service.BoardsService;
import api.service.ListsService;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    protected BoardsService boardsService;
    protected ListsService listsService;
    protected ListDto listDto;
    protected BoardDto boardDto;
    protected BoardsApiAssertions boardsApiAssertions;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        boardsService = new BoardsService();
        listsService = new ListsService();
        listDto = new ListDto();
        boardDto = new BoardDto();
        boardsApiAssertions = new BoardsApiAssertions();
    }
}
