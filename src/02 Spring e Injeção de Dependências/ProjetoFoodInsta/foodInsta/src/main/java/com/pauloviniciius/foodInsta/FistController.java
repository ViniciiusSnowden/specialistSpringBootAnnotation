package com.pauloviniciius.foodInsta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FistController {


    @GetMapping("/hello")
    @ResponseBody
    public String getHello(@RequestParam String param) {
        return "Hello";
    }
    

    
}
