package api.service;

import static api.service.URI.GET_BOARD_URL;
import static api.service.URI.GET_BOARDS_URL;
import static api.service.URI.GET_MEMBER_BOARDS_URL;
import static java.text.MessageFormat.format;
import static utils.ConfigProperties.getMemberId;

import api.dao.BoardDto;
import io.qameta.allure.Step;
import java.util.Arrays;

public class BoardsService extends TrelloService {

    @Step(value = "Create Board {0}")
    public BoardDto createBoard(BoardDto boardDto) {
        return parser(getPostResponse(boardDto, GET_BOARDS_URL), new BoardDto());
    }

    @Step(value = "Get Board {0}")
    public BoardDto getBoard(String boardId) {
        return parser(getGetResponse(format(GET_BOARD_URL, boardId)), new BoardDto());
    }

    @Step(value = "Delete Board {0}")
    public void deleteBoard(String boardId) {
        getDeleteResponse(format(GET_BOARD_URL, boardId));
    }

    @Step(value = "Update Board {0}")
    public BoardDto updateBoard(BoardDto boardDto, String boardId) {
        return parser(getPutResponse(boardDto, format(GET_BOARD_URL, boardId)), new BoardDto());
    }

    @Step(value = "Get All Boards")
    public BoardDto[] getAllBoards(String memberId) {
        return parser(getGetResponse(format(GET_MEMBER_BOARDS_URL, memberId)), new BoardDto[] {});
    }

    @Step(value = "Get Board Id {0}")
    public String getBoardId(String boardName) throws Exception {
        return Arrays.stream(getAllBoards(getMemberId()))
                .filter(x -> x.getName().equals(boardName))
                .findFirst().orElseThrow(Exception::new).getId();
       
    }
}
