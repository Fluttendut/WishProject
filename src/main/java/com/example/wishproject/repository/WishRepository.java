package com.example.wishproject.repository;


import com.example.wishproject.model.Wish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishRepository
{
    private Connection conn = DatabaseConnectionManager.getConnection();


    public List<Wish> getAllWishes()
    {

        List<Wish> wishes = new ArrayList<>();
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from wish.wishlist");
            ResultSet resaultSet = psts.executeQuery();
            while (resaultSet.next())
            {
                wishes.add(new Wish(
                        resaultSet.getInt("id"),
                        resaultSet.getString("name"),
                        resaultSet.getDouble("price"),
                        resaultSet.getBoolean("reserved")));

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
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("reserved"));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return null; // normalt ville den returnere et wish
    }

    public void create(Wish wish) throws RuntimeException
    {
        try
        {
            PreparedStatement psts = conn.prepareStatement("insert into wish.wishlist(name, price, reserved)values(?,?,?)"); // spørgsmålstegnet gør vores querry dynamisk i stedet for statisk
            psts.setString(1, wish.getName());
            psts.setDouble(2, wish.getprice());
            psts.setBoolean(3, wish.isReserved());

            psts.executeUpdate();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }


}
