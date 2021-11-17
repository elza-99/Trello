package api.assertions;

import api.service.BoardsService;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class BoardsApiAssertions {
    
    protected BoardsService boardsService;
    
    @Step(value = "Assert that Board {0} was created")
    public void assertThatBoardWasCreated(String id, String name) {
        boardsService = new BoardsService();
        Assertions.assertThat(boardsService.getBoard(id).getName().equalsIgnoreCase(name))
                .withFailMessage("The board wasn't created.");
    }
    
    @Step(value = "Assert that Board {0} name was updated")
    public void assertThatBoardNameUpdated(String actualName, String expectedName) {
        Assertions.assertThat(actualName.equalsIgnoreCase(expectedName))
                .withFailMessage("The board name wasn't updated.");
    }
}
