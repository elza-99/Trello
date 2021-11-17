package ui.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.components.Workspaces;

public class WorkspacesAssertions extends UIAsserts {

    protected Workspaces workspaces;

    public WorkspacesAssertions(WebDriver driver, Workspaces workspaces) {
        super(driver);
        this.workspaces = workspaces;
    }

    @Step(value = "Assert that List does not contain created Board {0}")
    public void assertThatListDoesNotContainCreatedBoard(String boardName) {
        Assertions.assertThat(workspaces.getBoards().contains(boardName)).isFalse()
                .withFailMessage("The board is still in the list.");
    }
}
