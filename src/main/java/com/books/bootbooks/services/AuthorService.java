package com.books.bootbooks.services;

import com.books.bootbooks.entities.Author;
import com.books.bootbooks.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorService {
    
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public String addAuthor(Author author){
        try{
            this.authorRepository.save(author);
            return "Author added";
        }catch(Exception e){
            return "Error adding author";
        }
    }
}
