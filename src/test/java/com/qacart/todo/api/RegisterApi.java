package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {



    private static List<Cookie> rsstAssuredCookies;
    private static String accessToken;
    private static String userID;
    private static String firstName;
    public List<Cookie> getCookies() {
        return this.rsstAssuredCookies;
    }
    public String getAccessToken() {
        return this.accessToken;
    }
    public String getUserID() {
        return this.userID;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void register(){

        User user = UserUtils.generateRandomUser();
        //User user = new User("ah6@gmail.com" , "Test@123" , "ahmed" , "samir");
/*
        String requestBody = "{\n" +
                "    \"email\": \"ah4@gmail.com\",\n" +
                "    \"password\": \"Test@123\",\n" +
                "    \"firstName\": \"ahmed\",\n" +
                "    \"lastName\": \"samir\"\n" +
                "}";
*/

        Response response = given()
                    .baseUri(ConfigUtils.getInstance().getBaseUrl())
                    .header("Content-Type", "application/json")
                    .body(user)
                    .log().all()
                .when()
                    .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                    .log().all()
                    .extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Something went wrong");
        }

        rsstAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");
        firstName = response.path("firstName");

    }
}
