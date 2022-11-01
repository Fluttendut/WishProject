package com.example.wishproject.Controller;


import com.example.wishproject.model.Wish;
import com.example.wishproject.repository.WishRepository;
import com.example.wishproject.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.wishproject.service.WishService;
import com.example.wishproject.model.LoginAttempt;

import java.util.List;

@Controller
public class HomeController {
    private WishService service = new WishService();
    private LoginService loginService = new LoginService();
    private WishRepository repository = new WishRepository();


    public class HtmlController {
        @GetMapping("/")
        public String index() {
            return "index";
        }
    }

    @PostMapping("/wishlist")
    public String loginAttempt(@ModelAttribute LoginAttempt loginAttempt, Model model) {
        if (loginService.login(loginAttempt.getEmail(), loginAttempt.getPassword())) {
            model.addAttribute("wishList", service.getAllWishes());
            return "loggedInWishlist";
        } else {
            return "redirect:/";
        }
    }

    /*
        @PostMapping("/createWish")
        public String createWish(@ModelAttribute Model model, Wish wish) {
            model.addAttribute("id_user",wish.getId_user());
            repository.createWish(wish);
            return "redirect:/";
        }

    @PostMapping("/createWish")
    public String createWish(String name,double price) {
        Wish wish = new Wish(name,price,-1);
        model.addAttribute("id_user", wish.getId_user());
        repository.createWish(wish);
        return "redirect:/";
    }
     */
    @PostMapping("/createWish")
    public String createWish(@ModelAttribute Wish wish, Model model) {
        repository.createWish(wish);
        model.addAttribute("wishList", service.getAllWishes());
        return "loggedInWishlist";
    }

    @PostMapping("/deleteWish")
    public String deleteWish(@ModelAttribute Wish wish, String wishId, Model model) {


        if(wishId.length()<1) {
            model.addAttribute("wishList", service.getAllWishes());
            return "loggedInWishlist";
        } else
        repository.deleteWish(wishId);
        model.addAttribute("wishList", service.getAllWishes());
        return "loggedInWishlist";
    }


}