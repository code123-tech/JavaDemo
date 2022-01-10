package com.books.bootbooks.services;

import java.util.List;
import java.util.Optional;

import com.books.bootbooks.entities.Author;
import com.books.bootbooks.entities.Blog;
import com.books.bootbooks.repository.AuthorRepository;
import com.books.bootbooks.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BlogService {
    private final BlogRepository blogRepository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }
    
    public List<Blog> getBlogs(){
        List<Blog> blogs = this.blogRepository.finAllOrderByCreationDateDesc();
        return blogs;
    }

    public String addBlog(Blog blog) {
        try {
            Author author = blog.getAuthorId();
            Optional<Author> authorInfo = authorRepository.findById(author.getId());
            if(authorInfo.isPresent()){
                blog.setAuthorId(authorInfo.get());
                this.blogRepository.save(blog);
                return "Blog added";
            } else {
                return "Author not found";
            }
        } catch (Exception e) {
            return "Error adding blog";
        }
    }

    public Blog getBlog(int id) {
        try{
            Blog blog = this.blogRepository.getById(id);
            if(blog != null){
                return blog;
            } else {
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }

}
