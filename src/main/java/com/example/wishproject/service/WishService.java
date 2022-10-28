package com.example.wishproject.service;

import com.example.wishproject.dataTransferObject.WishDTO;
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

    public WishDTO getWish(int id)
    {
         Wish wish = repo.getWish(id);
         return WishDTO.from(wish);
    }

    public void create(WebRequest req)
    {
        boolean reserved = false;
        if (req.getParameter("reserved") == "ja")
        {
            reserved = true;
        }
        /*
        Dette kode svare til det understående aktive kode.
        Wish wish = new Wish(
                req.getParameter("name"),
                Double.valueOf(req.getParameter( "1.0")),
                reserved);
         */

        repo.create(
                new Wish(req.getParameter("name"),
                        Double.valueOf(req.getParameter("price")),
                        reserved));


    }

}