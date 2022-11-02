package com.example.wishproject.model;



public class Wish
{
    private String id;
    private String name;
    private int price;
    private boolean reserved;
    private int id_user;

    public Wish(String id, String name, int price, boolean reserved, int id_user)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reserved = reserved;
        this.id_user = id_user;
    }

    public Wish(String name, int price, int id_user)
    {
        this.name = name;
        this.price = price;
        this.id_user = id_user;
    }

    public Wish() {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public int getprice()
    {
        return price;
    }

    public void setPrice(int price)
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
