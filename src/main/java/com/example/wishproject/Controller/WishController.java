package com.example.wishproject.Controller;

//import com.example.mysql.model.Wish;
//import com.example.mysql.service.WishService;
import com.example.wishproject.model.Wish;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.wishproject.service.WishService;

import java.util.List;


@RestController
public class WishController
{
    WishService service = new WishService();


    @GetMapping("/")
    public List<Wish> index()
    {
        return service.getAllWishes();
    }

    @GetMapping("/student")
    public Wish getWish(@RequestParam int id)
    {
        return service.getWish(id);
    }
}


