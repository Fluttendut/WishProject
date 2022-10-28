package com.example.wishproject.Controller;


import com.example.wishproject.dataTransferObject.WishDTO;
import com.example.wishproject.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import com.example.wishproject.service.WishService;
import com.example.wishproject.model.LoginAttempt;

import java.util.List;

@Controller
public class HomeController {
    private WishService service = new WishService();
    private LoginService loginService = new LoginService();


    @GetMapping("/create")
    public String wishywashy() {
        return "wishywashy";
    }

    @PostMapping("/create")
    public String create(WebRequest req) {
        service.create(req);

        return "redirect:/";
    }


    @GetMapping("/wishes")
    public String wishes(Model model) {
        model.addAttribute("Wishes", service.getAllWishes());
        return "Wishes";
    }

    @PostMapping("/wishlist")
    public String loginAttempt(@ModelAttribute LoginAttempt loginAttempt, Model model) {
        if(loginService.login(loginAttempt.getEmail(),loginAttempt.getPassword())){
            model.addAttribute("wishList",service.getAllWishes());
            return "loggedInWishlist";
        }
        else {
            return "redirect:/"; //TODO ret til annonym html
        }
    }



    @GetMapping("/wishList")
    public String listOfWishes(Model model)
    {
        model.addAttribute("wishList",service.getAllWishes());
        return "loggedInWishList";
    }

}