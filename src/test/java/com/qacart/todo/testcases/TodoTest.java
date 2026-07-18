package com.qacart.todo.testcases;

import com.qacart.todo.Pages.NewTodoPage;
import com.qacart.todo.Pages.TodoPage;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add a new todo item")
    @Test (description = "Verify that a user can add a new todo item")
    public void shouldBeAbleToAddNewTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult = newTodoPage
                .load()
                .addNewTask("Playwright")
                .getTodoText();
        Assert.assertEquals(actualResult, "Playwright");
    }

    @Story("Delete a todo item")
    @Test (description = "Verify that a user can delete a todo item")
    public void shouldBeAbleToDeleteTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());

        boolean isNoAvailableTodosDisplayed = todoPage
                .load()
                .clickDeleteButton()
                .isNoTodoMessageDisplayed();
        Assert.assertTrue(isNoAvailableTodosDisplayed);

    }


}
