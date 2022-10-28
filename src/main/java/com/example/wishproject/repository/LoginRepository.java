package com.example.wishproject.repository;


import com.example.wishproject.model.Wish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepository
{
    private Connection conn = DatabaseConnectionManager.getConnection();


    public Boolean login(String username, String password)
    {
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from Wish.passwordandusername where username=? and password=?");
            psts.setString(1, username);
            psts.setString(2, password);
            ResultSet resultSet = psts.executeQuery();

            if (resultSet.next())
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }


}
