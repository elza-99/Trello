package ui.pageobjects;

import static utils.ConfigProperties.TIME_OUT;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoardsPage extends AbstractPage {

    @FindBy(className = "list-name-input")
    private WebElement listNameInput;
    @FindBy(css = "input[value='Добавить список']")
    private WebElement submitAddListButton;
    @FindBy(css = "div[class='js-list list-wrapper']")
    private List<WebElement> lists;
    @FindBy(linkText = "Меню")
    private WebElement boardsMenu;
    @FindBy(linkText = "Ещё")
    private WebElement boardsMenuMore;
    @FindBy(linkText = "Закрыть доску…")
    private WebElement closeBoardLink;
    @FindBy(xpath = "//input[@value='Закрыть']")
    private WebElement closeConfirmButton;
    @FindBy(css = "button[data-test-id='close-board-delete-board-button']")
    private WebElement deleteBoardButton;
    @FindBy(css = "button[data-test-id='close-board-delete-board-confirm-button']")
    private WebElement deleteConfirmButton;
    @FindBy(xpath = "//span[contains(text(), 'Добавить список')]/span")
    private WebElement addNewListTile;

    public BoardsPage(WebDriver driver) {
        super(driver);
    }

    public void addNewList() {
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        addNewListTile.click();
    }

    public void inputListName(String listName) {
        listNameInput.sendKeys(listName);
    }

    public void clickSubmitAddListButton() {
        submitAddListButton.click();
    }

    public List<String> getLists() {
        return lists.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickBoardsMenu() {
        boardsMenu.click();
    }

    public void clickBoardsMenuMore() {
        boardsMenuMore.click();
    }

    public void clickCloseBoardLink() {
        wait.until(ExpectedConditions.visibilityOf(closeBoardLink));
        closeBoardLink.click();
    }

    public void clickCloseConfirmButton() {
        wait.until(ExpectedConditions.visibilityOf(closeConfirmButton));
        closeConfirmButton.click();
    }

    public void clickDeleteBoardButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteBoardButton));
        deleteBoardButton.click();
    }

    public void clickDeleteConfirmButton() {
        deleteConfirmButton.click();
    }
}
