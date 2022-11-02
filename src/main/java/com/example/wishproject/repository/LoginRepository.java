package com.example.wishproject.repository;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository
{
    private static Connection conn = DatabaseConnectionManager.getConnection();


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


    public static int getIDUser(String username) {
        try {

            PreparedStatement psts = conn.prepareStatement("select id_user from Wish.passwordandusername where username=?");
            psts.setString(1,username);
            psts.executeQuery();
            ResultSet resultSet = psts.getResultSet();
            return resultSet.getInt("id_user");

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
