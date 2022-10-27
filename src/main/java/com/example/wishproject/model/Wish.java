package com.example.wishproject.model;

//import com.example.mysql.service.WishService;

import java.util.List;

public class Wish
{
    private int id;
    private String name;
    private double price;
    private boolean reserved;

    public Wish(int id, String name, double price, boolean reserved)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reserved = reserved;
    }

    public Wish(String name, double price, boolean reserved)
    {
        this.name = name;
        this.price = price;
        this.reserved = reserved;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getprice()
    {
        return price;
    }

    public void setEmail(double price)
    {
        this.price = price;
    }

    public boolean isReserved()
    {
        return reserved;
    }

    public void setReserved(boolean reserved)
    {
        this.reserved = reserved;
    }


    @Override
    public String toString()
    {
        if(reserved == true){
            return name + ", " + price + "kr." +
                    ", " +  "Wish is reserved";
        } else {
            return name + ", " + price + "kr." +
                    ", " + "Wish is not reserved";
        }


}

}
