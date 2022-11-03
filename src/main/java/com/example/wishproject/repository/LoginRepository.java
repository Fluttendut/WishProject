package com.example.wishproject.repository;



import com.example.wishproject.model.LoginAttempt;
import com.example.wishproject.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository
{
    private static Connection conn = DatabaseConnectionManager.getConnection();


    public Boolean login(LoginAttempt loginAttempt)
    {
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from Wish.passwordandusername where username=? and password=?");
            psts.setString(1, loginAttempt.getEmail());
            psts.setString(2, loginAttempt.getPassword());
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

    public User returnUser(LoginAttempt loginAttempt){
        if(login(loginAttempt)){
            return new User(getIDUser(loginAttempt), loginAttempt.getEmail(), loginAttempt.getPassword());
        }
        else{
            return null;
        }
    }

    private int getIDUser(LoginAttempt loginAttempt) {
        try {

            PreparedStatement psts = conn.prepareStatement("select id_user from Wish.passwordandusername where username=? and password=?");
            psts.setString(1, loginAttempt.getEmail());
            psts.setString(2, loginAttempt.getPassword());
            psts.executeQuery();
            ResultSet resultSet = psts.getResultSet();
            resultSet.next();
            return resultSet.getInt("id_user");

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

}
