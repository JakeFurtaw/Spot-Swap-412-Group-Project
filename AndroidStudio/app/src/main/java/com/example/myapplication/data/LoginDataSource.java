package com.example.myapplication.data;

import com.example.myapplication.data.model.LoggedInUser;
import java.io.*;
import java.util.*;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            File file = new File("UserRepo.txt");
            Scanner input = new Scanner(file);
            //Read from file to see if username/password is stored.
                while(input.hasNext()){
                    if(input.nextLine().equals(username +"#"+ password)){
                        LoggedInUser user = new LoggedInUser(username, username);
                        return new Result.Success<>(user);
                    }
                }
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}