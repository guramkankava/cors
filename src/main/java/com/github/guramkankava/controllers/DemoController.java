package com.github.guramkankava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController{

    @GetMapping(path = "demo")
    public String demo () {
        return "Main.html";
    }

}
