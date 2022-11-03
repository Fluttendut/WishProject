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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private WishService service = new WishService();
    private LoginService loginService = new LoginService();
    private WishRepository repository = new WishRepository();


    public class htmlController {
        @GetMapping("/")
        public String index() {
            return "index";
        }
    }

    @GetMapping("/sic")
    public String sic() {
        return "SIC";
    }

    @PostMapping("/wishlist")
    public String loginAttempt(@ModelAttribute LoginAttempt loginAttempt, Model model, HttpSession session) {
        User usr=loginService.returnUser(loginAttempt);
        if (usr!=null) {
            session.setAttribute("user",usr);
            model.addAttribute("wishList", service.getUserWishes(usr));
            model.addAttribute("user",usr);

            return "loggedInWishlist";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/createWish")
    public String createWish(@ModelAttribute Wish wish, Model model, HttpSession session) {
            User usr = (User)session.getAttribute("user");
            repository.createWish(wish);
            model.addAttribute("wishList", service.getUserWishes(usr));
            model.addAttribute("user",usr);
            return "loggedInWishlist";
    }

    @PostMapping("/deleteWish")
    public String deleteWish(@ModelAttribute Wish wish, int wishId, Model model, HttpSession session) {
            User usr = (User)session.getAttribute("user");
            repository.deleteWish(wishId);
            model.addAttribute("wishList", service.getAllWishes());
            model.addAttribute("user",usr);
            return "loggedInWishlist";
        }




        //TODO guest login with reserve function
        //TODO
        //TODO

}