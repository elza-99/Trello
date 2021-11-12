package ui.apiworkflow;

import static utils.ConfigProperties.getMemberId;

import api.dao.BoardDto;

import api.service.BoardsService;
import java.util.Arrays;

public class ApiBoardsWorkflow extends BoardsService {

    public BoardDto createBoardViaApi(BoardDto boardDto) {
        boardDto.setDefaultLists(false);
        return createBoard(boardDto);
    }

    public void deleteBoardViaApi(String id) {
        deleteBoard(id);
    }

    public String getBoardId(String boardName) {
        return Arrays.stream(getAllBoards(getMemberId()))
                .filter(x -> x.getName().equals(boardName))
                .findFirst().get().getId();
    }
}
