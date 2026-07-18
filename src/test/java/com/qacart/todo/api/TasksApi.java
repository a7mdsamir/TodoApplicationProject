package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {

    private static String taskID;
    private static String userID;

    public void addTask(String token){

        Task task = new Task("Playwright" , false);

        Response response = given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-Type", "application/json")
                .body(task)
                .auth().oauth2(token)
                .log().all()
                .when()
                .post(EndPoint.API_TASK_ENDPOINT)
                .then()
                .log().all()
                .extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Something went wrong in adding task");
        }

        //rsstAssuredCookies = response.detailedCookies().asList();
        taskID = response.path("_id");
        userID = response.path("userID");

    }
}
