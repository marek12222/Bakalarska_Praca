package bp.springbootcassandrabp.controller;


import bp.springbootcassandrabp.model.Author;
import bp.springbootcassandrabp.repository.AuthorRepository;
import bp.springbootcassandrabp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/create")
    public Author create(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age){
        Author author = authorService.create(firstName,lastName,age);
        return author;
    }

    @RequestMapping("/createN")
    public void createN(@RequestParam int n){
        this.authorService.createN(n);
    }

    @RequestMapping("/getAll")
    public List<Author> getAll() {
        return authorService.getAll();
    }
    @RequestMapping("/getById")
    public Author getAuthorById(@RequestParam UUID id) {
        Author author = authorService.getById(id);
        return author;
    }
    @RequestMapping("/getAuthorByName")
    public Author getAuthorByName(@RequestParam String name) {
        Author author = authorService.getByName(name);
        return author;
    }
    @RequestMapping("/getAuthorByFirstNameAndLastName")
    public Author getAuthorByFirstNameAndLastName(@RequestParam String firstName,@RequestParam String lastName) {
        Author author = authorService.getByFirstNameAndLastName(firstName,lastName);
        return author;
    }
    @RequestMapping("/getAuthorsByAge")
    public List<Author> getAuthorsByAge(@RequestParam int age){
        List<Author> authors = authorService.getAuthorsByAge(age);
        return authors;
    }
    @RequestMapping("/getAuthorsByAgeLessThan")
    public List<Author> getAuthorsByAgeLessThan(@RequestParam int age){
        List<Author> authors = authorService.getAuthorsByAgeLessThan(age);
        return authors;
    }
    @RequestMapping("/getAuthorsByAgeGreaterThan")
    public List<Author> getAuthorsByAgeGreaterThan(@RequestParam int age){
        List<Author> authors = authorService.getAuthorsByAgeGreaterThan(age);
        return authors;
    }

}
