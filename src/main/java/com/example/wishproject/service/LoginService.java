package com.example.wishproject.service;

import com.example.wishproject.model.LoginAttempt;
import com.example.wishproject.model.User;
import com.example.wishproject.repository.LoginRepository;


public class LoginService
{
    LoginRepository repo = new LoginRepository();

    public User returnUser(LoginAttempt loginAttempt) {

        return repo.returnUser(loginAttempt);
    }

}
