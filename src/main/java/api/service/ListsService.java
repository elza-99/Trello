package api.service;

import static api.service.URI.GET_BOARD_LISTS_URL;
import static java.text.MessageFormat.format;

import api.dao.ListDto;
import io.qameta.allure.Step;

public class ListsService extends TrelloService {

    @Step(value = "Create List {0}")
    public ListDto createList(ListDto listDto, String boardId) {
        return parser(getPostResponse(listDto, format(GET_BOARD_LISTS_URL, boardId)), new ListDto());
    }

    @Step(value = "Get Lists")
    public ListDto[] getLists(String boardId) {
        return parser(getGetResponse(format(GET_BOARD_LISTS_URL, boardId)), new ListDto[]{});
    }
}
