package com.example.wishproject.service;

//import com.example.mysql.model.Student;
//import com.example.mysql.repository.StudentsRepository;
import com.example.wishproject.model.Wish;
import org.springframework.web.context.request.WebRequest;
import com.example.wishproject.repository.WishRepository;

import java.util.List;

public class WishService
{
    WishRepository repo = new WishRepository();

    public List<Wish> getAllWishes()
    {
        return repo.getAllWishes();
    }

    public Wish getWish(int id)
    {
        return repo.getWish(id);
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