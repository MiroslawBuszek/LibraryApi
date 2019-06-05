package com.buszek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String bookPage() {
        return "books";
    }
}