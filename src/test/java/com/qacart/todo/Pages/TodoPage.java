package com.qacart.todo.Pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;
    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addBtn;
    @FindBy(css = "[data-testid=\"todo-text\"]")
    private WebElement todoItem;
    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteBtn;
    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodoMessage;


    @Step("Load the todo page")
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.API_TODO_PAGE_ENDPOINT);
        return this;
    }

    @Step("Check if welcome message is displayed")
    public boolean isWelcomeMessageDisplayed(){
        return welcomeMessage.isDisplayed();
    }
    public NewTodoPage clickPlusButton(){
        addBtn.click();
        return new NewTodoPage(driver);
    }

    @Step("Get the text of the todo item")
    public String getTodoText(){
        return todoItem.getText();
    }

    @Step("Click the delete button")
    public TodoPage clickDeleteButton(){
        deleteBtn.click();
        return this;
    }

    @Step("Check if no todo message is displayed")
    public boolean isNoTodoMessageDisplayed(){
        return noTodoMessage.isDisplayed();
    }

}
