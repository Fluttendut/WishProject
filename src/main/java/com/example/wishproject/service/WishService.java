package com.example.wishproject.service;

import com.example.wishproject.dataTransferObject.WishDTO;
import com.example.wishproject.model.User;
import com.example.wishproject.model.Wish;
import org.springframework.web.context.request.WebRequest;
import com.example.wishproject.repository.WishRepository;

import java.util.List;

public class WishService
{
    WishRepository repo = new WishRepository();

    public List<WishDTO> getAllWishes()
    {
        return WishDTO.from(repo.getAllWishes());
    }


    public List<WishDTO> getUserWishes(User user)
    {
        return WishDTO.from(repo.getUserWishes(user));
    }



    public WishDTO getWish(int id)
    {
         Wish wish = repo.getWish(id);
         return WishDTO.from(wish);
    }

}