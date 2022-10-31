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


//TODO HTMl / CSS

//todo lav input felt i html hvor en "url" kan  postes til en specifik liste