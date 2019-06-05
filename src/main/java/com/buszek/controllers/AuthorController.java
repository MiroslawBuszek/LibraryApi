package com.buszek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String authorPage() {
        return "authors";
    }

}
