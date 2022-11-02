package com.example.wishproject.service;

import com.example.wishproject.repository.LoginRepository;


public class LoginService
{
    LoginRepository repo = new LoginRepository();

    public Boolean login(String username, String password)
    {
        return repo.login(username, password);
    }
}
