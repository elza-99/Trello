package ui.components;

import static utils.ConfigProperties.TIME_OUT;

import io.qameta.allure.Step;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Workspaces extends AbstractContainer {

    @FindBy(className = "board-tile")
    List<WebElement> boardTiles;
    @FindBy(css = "li[data-test-id='create-board-tile']")
    private WebElement createBoardTile;
    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement createBoardTitleInput;
    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement createBoardSubmitButton;
    @FindBy(css = "li[class='boards-page-board-section-list-item']")
    private List<WebElement> boards;

    public Workspaces(WebDriver driver) {
        super(driver);
    }
    
    @Step(value = "Click Create Board Tile")
    public Workspaces clickCreateBoardTile() {
        wait.until(ExpectedConditions.visibilityOf(createBoardTile));
        createBoardTile.click();
        return this;
    }

    @Step(value = "Input Board Name {0}")
    public Workspaces inputBoardName(String boardName) {
        wait.until(ExpectedConditions.visibilityOf(createBoardTitleInput));
        createBoardTitleInput.sendKeys(boardName);
        return this;
    }

    @Step(value = "Click Create Board Submit Button")
    public Workspaces clickCreateBoardSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createBoardSubmitButton));
        createBoardSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        return this;
    }

    @Step(value = "Get Boards")
    public List<String> getBoards() {
        return boards.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    
    @Step(value = "Get Board By Name {0}")
    public WebElement getBoardByName(String name) throws Exception {
        return boards.stream().filter(x -> x.getText().contains(name)).findFirst().orElseThrow(Exception::new);
    }

    @Step(value = "Click Board By Name {0}")
    public Workspaces clickBoardByName(String name) throws Exception {
        getBoardByName(name).click();
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        return this;
    }
}
