package com.books.bootbooks.controllers;

import com.books.bootbooks.entities.Blog;
import com.books.bootbooks.services.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController implements ErrorController {
    
    private final BlogService blogService;
    private static final String PATH = "/error";

    @Autowired
    public HomeController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<Blog> blogs = this.blogService.getBlogs();
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @RequestMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @RequestMapping("/blog/{id}")
    public String getBlogPage(Model model, @PathVariable int id) {
        Blog blog = this.blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "blog";
    }

    @RequestMapping(PATH)
    public String myError() {
        return "error";
    }
}
