package com.example.wishproject.Controller;



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
        if(loginService.login(loginAttempt.getEmail(),loginAttempt.getPassword())){
            model.addAttribute("wishList",service.getAllWishes());
            return "loggedInWishlist";
        }
        else {
            return "redirect:/";
        }
    }

    /* TODO fix this!
    @GetMapping()
    public String deleteWish(int wishId) {
        repository.deleteWish(wishId);
        return "loggedInWishlist";
    }

     */







}