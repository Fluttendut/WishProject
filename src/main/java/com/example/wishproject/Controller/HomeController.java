package com.example.wishproject.Controller;

//import com.example.mysql.service.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import com.example.wishproject.service.WishService;

@Controller
public class HomeController
{
    private WishService service = new WishService();

    @GetMapping("/create")
    public String index()
    {
        return "index";
    }

    @PostMapping("/create")
    public String create(WebRequest req)
    {
        service.create(req);

        return "redirect:/";
    }



    @GetMapping("/wishes")
    public String students(Model model)
    {
        model.addAttribute("Wishes",service.getAllWishes());
        return "Wishes";
    }
}