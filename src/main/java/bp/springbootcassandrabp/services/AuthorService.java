package bp.springbootcassandrabp.services;

import bp.springbootcassandrabp.model.Author;
import bp.springbootcassandrabp.repository.AuthorRepository;
import bp.springbootcassandrabp.repository.FilmRepository;
import bp.springbootcassandrabp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static bp.springbootcassandrabp.config.NameGenerator.generateName;
import static bp.springbootcassandrabp.config.RandomDates.getRandomNumberInRange;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public Author create(String firstName,String lastName, int age ){
        UUID id = UUID.randomUUID();
        return authorRepository.save(new Author(id,firstName,lastName,age));
    }

    public void createN(int n){
        int i;
        for(i=0;i<n;i++){
            UUID id = UUID.randomUUID();
            Author author = new Author(id,generateName(),generateName(),getRandomNumberInRange(30,90));
            this.authorRepository.save(author);
        }
    }
    public List<Author> getAll(){
        return (List<Author>) authorRepository.findAll();
    }

    public Author getById(UUID id){
        return authorRepository.findAuthorByUid(id);
    }
    public Author getByName(String name){
        Author author =authorRepository.findAuthorByFirstName(name);
        return author;
    }
    public Author getByFirstNameAndLastName(String firstName, String lastName){
        Author author = authorRepository.findAuthorByFirstNameAndLastName(firstName,lastName);
        return author;
    }
    public List<Author> getAuthorsByAge(int age){
        List<Author> authors = authorRepository.findAuthorsByAge(age);
        return authors;
    }
    public List<Author> getAuthorsByAgeLessThan(int age){
        List<Author> authors = authorRepository.findAuthorsByAgeLessThan(age);
        return authors;
    }
    public List<Author> getAuthorsByAgeGreaterThan(int age){
        List<Author> authors = authorRepository.findAuthorsByAgeGreaterThan(age);
        return authors;
    }
}
