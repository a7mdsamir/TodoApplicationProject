package com.qacart.todo.testcases;

import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login with email and password")
    @Description("Verify that a user can login with email and password")
    @Test (description = "Verify that a user can login with email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();


        Assert.assertTrue(isWelcomeDisplayed);
    }


}
