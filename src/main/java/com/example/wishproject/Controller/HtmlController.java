package com.example.wishproject.Controller;


import org.springframework.web.bind.annotation.GetMapping;


public class HtmlController {
    @GetMapping("/")
    public String index() {
        return "index";
    }


}
