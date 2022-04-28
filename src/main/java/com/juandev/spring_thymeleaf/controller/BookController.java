package com.juandev.spring_thymeleaf.controller;

import com.juandev.spring_thymeleaf.BookDTO;
import com.juandev.spring_thymeleaf.entity.Book;
import com.juandev.spring_thymeleaf.service.AuthorService;
import com.juandev.spring_thymeleaf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Validated
public class BookController {

    private final BookService service;

    private final AuthorService authorService;

    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd(){
        ModelAndView mv = new ModelAndView("bookform");

        var authorList = authorService.getAuthorList();
        mv.addObject("authorList", authorList);

        return mv;
    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid  Book book, BindingResult result, RedirectAttributes redirect){

    if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "verifique os campos obrigatórios");
        return "redirect:/book/form/add";
    }

        service.save(book);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editBook(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView("bookform");

        var authorList = authorService.getAuthorList();
        mv.addObject("authorList", authorList);

        var book = this.service.findById(id);

        mv.addObject("book", book);

        return mv;
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){

        service.delete(id);

        return "redirect:/";
    }


}
