package com.juandev.spring_thymeleaf.controller;

import com.juandev.spring_thymeleaf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private final BookService bookService;

    @GetMapping("/")
    public ModelAndView getList(){

        var bookList = bookService.findAll();

        var mv = new ModelAndView("index");
        mv.addObject("bookList", bookList);

        return mv;
    }
}
