package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {
    public static User generateRandomUser(){

        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        User user = new User(email , password , firstName , lastName);
        return user;

}
}