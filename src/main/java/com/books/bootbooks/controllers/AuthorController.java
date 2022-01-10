package com.books.bootbooks.controllers;

import com.books.bootbooks.entities.Author;
import com.books.bootbooks.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;

    @GetMapping("/get/authors")
    public String getAuthors() {
        return "Authors";
    }

    @PostMapping("/add/author")
    public ResponseEntity<String> addNewAuthor(@RequestBody Author author){
        String message = this.authorService.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
