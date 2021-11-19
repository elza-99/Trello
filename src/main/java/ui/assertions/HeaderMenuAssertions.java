package ui.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.components.HeaderMenu;

public class HeaderMenuAssertions extends UIAsserts {

    protected HeaderMenu headerMenu;

    public HeaderMenuAssertions(WebDriver driver, HeaderMenu headerMenu) {
        super(driver);
        this.headerMenu = headerMenu;
    }

    @Step(value = "Assert that Board {0} is created")
    public void assertThatBoardIsCreated(String boardName) {
        Assertions.assertThat(headerMenu.getBoards().contains(boardName))
                .withFailMessage("The defined board does not exist.");
    }
}
