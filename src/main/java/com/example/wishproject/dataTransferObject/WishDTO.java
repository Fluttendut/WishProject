package com.example.wishproject.dataTransferObject;

import com.example.wishproject.model.Wish;

import java.util.ArrayList;
import java.util.List;

public class WishDTO {
    String name;
    double price;
    String reserved;


    private WishDTO(Wish wish){
        this.name=wish.getName();
        this.price= wish.getprice();
        //this following is a way of writing if statemtents, the 2 statements after the ? are executed in order if true and if false
        this.reserved= wish.isReserved() ? " this product is reserved" : " this product is not reserved";
    }

    public static WishDTO from(Wish wish){
        return new WishDTO(wish);
    }

    public static List<WishDTO> from(List<Wish> wishlist){
        List<WishDTO> DTOS= new ArrayList<>();
        for (Wish wish: wishlist)
        {
            DTOS.add(new WishDTO(wish));
        }
        return DTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    }

