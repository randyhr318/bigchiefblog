package com.techtalentsouth.bigchiefblog.Controller;

import com.techtalentsouth.bigchiefblog.model.BlogPost;
import com.techtalentsouth.bigchiefblog.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogPostController {

    //@Autowired allows us to implement whats known as dependency injection
    //allows dependency injection allows us to give certain objects the dependencies that it needs


    @Autowired
    private BlogPostRepository blogPostRepository;
    private static List<BlogPost> posts = new ArrayList<>();
    //below is a constructor based dependency injection
    //if you only have one dependency, this is considered best practice
//    public BlogPostController(BlogPostRepository blogPostRepository) {
//        this.blogPostRepository = blogPostRepository;
//    }


    @GetMapping("/")
    public String index(BlogPost blogPost, Model model) {
        model.addAttribute("posts",posts);
        //since we are utilizing thymeleaf
        //out output will generated in a template
        //returning a reference to said template
        //will allow us to show the data that we want
        return "blogpost/index";
    }
    //method

    @GetMapping(value = "/blogpost/new")
    public String newBlog (BlogPost blogPost) {
        return "blogpost/new";
    }


    //this is where we are mapping our post requests in our project
    private BlogPost blogPost;
    @PostMapping(value="/blogpost")
    public String addNewBlogPost(BlogPost blogPost, Model model){
        blogPostRepository.save(blogPost);
        //blogPost from our parameter is the object that we're getting from
        //the thymeleaf form, we can simply save it in our repository
        model.addAttribute( "title", blogPost.getTitle());
        model.addAttribute( "author", blogPost.getAuthor());
        model.addAttribute( "blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }


    //



    @RequestMapping(value = "/blogpost/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable long id, BlogPost blogPost){
        blogPostRepository.deleteById(id);
        return "blogpost/Index";
    }
}
