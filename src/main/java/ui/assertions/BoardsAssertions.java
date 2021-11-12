package ui.assertions;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.pageobjects.BoardsPage;

public class BoardsAssertions extends UIAsserts {

    private BoardsPage boardsPage;

    public BoardsAssertions(WebDriver driver) {
        super(driver);
    }

    public void assertThatBoardContainsCreatedList(String listName) {
        boardsPage = new BoardsPage(driver);
        Assertions.assertThat(boardsPage.getLists().contains(listName))
                .withFailMessage("The board does not contain the defined list.");
    }
}
