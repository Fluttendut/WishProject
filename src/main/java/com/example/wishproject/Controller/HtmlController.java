package com.example.wishproject.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class HtmlController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
