package com.qacart.todo.Pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;
    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmitBtn;


    @Step("Load the new todo page")
    public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.API_NEW_TODO_ENDPOINT);
        return this;
    }

    @Step("Add new task: {item}")
    public TodoPage addNewTask(String item){
        newTodoInput.sendKeys(item);
        newTodoSubmitBtn.click();
        return new TodoPage(driver);
    }

}
