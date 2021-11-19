package ui.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.pageobjects.BoardsPage;

public class BoardsUIAssertions extends UIAsserts {

    private BoardsPage boardsPage;

    public BoardsUIAssertions(WebDriver driver, BoardsPage boardsPage) {
        super(driver);
        this.boardsPage = boardsPage;
    }
    
    @Step(value = "Assert that Board contains List {0}")
    public void assertThatBoardContainsCreatedList(String listName) {
        Assertions.assertThat(boardsPage.getLists().contains(listName))
                .withFailMessage("The board does not contain the defined list.");
    }
}
