package api.service;

import static api.service.URI.GET_BOARD_URL;
import static api.service.URI.GET_BOARDS_URL;
import static api.service.URI.GET_MEMBER_BOARDS_URL;
import static java.text.MessageFormat.format;

import api.dao.BoardDto;
import io.qameta.allure.Step;

public class BoardsService extends TrelloService {

    @Step(value="Create Board {0}")
    public BoardDto createBoard(BoardDto boardDto) {
        return parser(getPostResponse(boardDto, GET_BOARDS_URL), new BoardDto());
    }

    @Step
    public BoardDto getBoard(String boardId) {
        return parser(getGetResponse(format(GET_BOARD_URL, boardId)), new BoardDto());
    }

    @Step
    public void deleteBoard(String boardId) {
        getDeleteResponse(format(GET_BOARD_URL, boardId));
    }

    @Step
    public BoardDto updateBoard(BoardDto boardDto, String boardId) {
        return parser(getPutResponse(boardDto, format(GET_BOARD_URL, boardId)), new BoardDto());
    }

    @Step
    public BoardDto[] getAllBoards(String memberId) {
        return parser(getGetResponse(format(GET_MEMBER_BOARDS_URL, memberId)), new BoardDto[] {});
    }
}
