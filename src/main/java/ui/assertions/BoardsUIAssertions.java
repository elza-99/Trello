package ui.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.pageobjects.BoardsPage;

public class BoardsUIAssertions extends UIAsserts {

    private BoardsPage boardsPage;

    public BoardsUIAssertions(WebDriver driver) {
        super(driver);
    }
    
    @Step
    public void assertThatBoardContainsCreatedList(String listName) {
        boardsPage = new BoardsPage(driver);
        Assertions.assertThat(boardsPage.getLists().contains(listName))
                .withFailMessage("The board does not contain the defined list.");
    }
}
