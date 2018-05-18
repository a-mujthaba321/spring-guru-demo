/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.guru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.guru.repository.BookRepo;

/**
 *
 * @author Ali Mujthaba
 */
@Controller
public class BookController {
    
    @Autowired
    private BookRepo bookRepo;
    
    @RequestMapping("/books")
    public String getBooks(Model model) {
        System.err.println("AAA");
        model.addAttribute("books", bookRepo.findAll());
        
        return "books";
    }
        
    
}
