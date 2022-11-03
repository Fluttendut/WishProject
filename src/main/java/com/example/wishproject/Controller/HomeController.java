package com.example.wishproject.Controller;


import com.example.wishproject.model.User;
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
        User usr=loginService.returnUser(loginAttempt);
        if (usr!=null) {
            model.addAttribute("wishList", service.getUserWishes(usr));

            return "loggedInWishlist";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/createWish")
    public String createWish(@ModelAttribute Wish wish, Model model) {
            repository.createWish(wish);
            model.addAttribute("wishList", service.getAllWishes());
            return "loggedInWishlist";
    }

    @PostMapping("/deleteWish")
    public String deleteWish(@ModelAttribute Wish wish, int wishId, Model model) {
            repository.deleteWish(wishId);
            model.addAttribute("wishList", service.getAllWishes());
            return "loggedInWishlist";
        }


}