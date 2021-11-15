package ui.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

public class BoardsApiAssertions {

    @Step
    public void assertThatBoardNameUpdated(String actualName, String expectedName) {
        Assertions.assertThat(actualName.equalsIgnoreCase(expectedName))
                .withFailMessage("The board name wasn't updated.");
    }
}
