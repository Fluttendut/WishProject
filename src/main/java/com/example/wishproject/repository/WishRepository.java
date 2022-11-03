package com.example.wishproject.repository;


import com.example.wishproject.model.User;
import com.example.wishproject.model.Wish;
import com.example.wishproject.service.LoginService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishRepository
{
    private Connection conn = DatabaseConnectionManager.getConnection();


    public List<Wish> getUserWishes(User user)
    {

        List<Wish> wishes = new ArrayList<>();
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from wish.wishlist where id_user =?");
            psts.setInt(1, user.getId_user());
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next())
            {
                wishes.add(new Wish(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getBoolean("reserved"),
                        resultSet.getInt("id_user")));

            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return wishes;
    }



    public List<Wish> getAllWishes()
    {

        List<Wish> wishes = new ArrayList<>();
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from wish.wishlist");
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next())
            {
                wishes.add(new Wish(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getBoolean("reserved"),
                        resultSet.getInt("id_user")));

            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return wishes;
    }

    //metode til kun at vælge en af emnerne i databasen
    public Wish getWish(int id)
    {
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from wish.wishlist where id=?"); // spørgsmålstegnet gør vores querry dynamisk i stedet for statisk
            psts.setInt(1, id);
            ResultSet resultSet = psts.executeQuery();

            if (resultSet.next())
            {
                return new Wish(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getBoolean("reserved"),
                        resultSet.getInt("id_user"));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return null; // normalt ville den returnere et wish
    }

    public void createWish(Wish wish) throws RuntimeException
    {

        try
        {
            PreparedStatement psts = conn.prepareStatement("insert into wish.wishlist(name, price, reserved,id_user) values(?,?,?,?)"); // spørgsmålstegnet gør vores querry dynamisk i stedet for statisk
            psts.setString(1, wish.getName());
            psts.setInt(2, wish.getprice());
            psts.setBoolean(3, wish.isReserved());
            psts.setInt(4,wish.getId_user());


            psts.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void deleteWish(int wishId) throws RuntimeException
    {
        try
        {
            PreparedStatement psts = conn.prepareStatement("delete from wish.wishlist where id=? ");
            psts.setInt(1,wishId);
            psts.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }




}
