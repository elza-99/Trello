package ui.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.components.Workspaces;

public class WorkspacesAssertions extends UIAsserts {

    protected Workspaces workspaces;

    public WorkspacesAssertions(WebDriver driver) {
        super(driver);
    }

    @Step
    public void assertThatListDoesNotContainCreatedBoard(String boardName) {
        workspaces = new Workspaces(driver);
        Assertions.assertThat(workspaces.getBoards().contains(boardName)).isFalse()
                .withFailMessage("The board is still in the list.");
    }
}
