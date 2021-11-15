package ui.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.components.HeaderMenu;

public class HeaderMenuAssertions extends UIAsserts {

    protected HeaderMenu headerMenu;

    public HeaderMenuAssertions(WebDriver driver) {
        super(driver);
    }

    @Step
    public void assertThatBoardIsCreated(String boardName) {
        headerMenu = new HeaderMenu(driver);
        Assertions.assertThat(headerMenu.getBoards().contains(boardName))
                .withFailMessage("The defined board does not exist.");
    }
}
