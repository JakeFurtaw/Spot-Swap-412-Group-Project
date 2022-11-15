package com.example.myapplication.data;

import com.example.myapplication.data.model.LoggedInUser;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class UserDataSource {
    public Result<LoggedInUser> register(String username, String password) {

        Scanner input = new Scanner(System.in);
        try {
            FileWriter output = new FileWriter("AndroidStudio/app/src/main/java/com/example/myapplication/data/UserRepo.txt", true);
            output.append("\n" + username);
            output.append("#" + password);
            output.flush();
            output.close();
            // TODO: handle loggedInUser authentication

            return new Result.Error(new Exception("User not registered."));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
