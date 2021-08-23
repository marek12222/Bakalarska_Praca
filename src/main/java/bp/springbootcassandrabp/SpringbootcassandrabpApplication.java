package bp.springbootcassandrabp;

import bp.springbootcassandrabp.model.Author;
import bp.springbootcassandrabp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static java.lang.invoke.MethodHandles.lookup;

@SpringBootApplication
public class SpringbootcassandrabpApplication implements CommandLineRunner {


    @Autowired
    AuthorRepository authorRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootcassandrabpApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        clearData();
//        saveData();
//        lookup();
    }

    public void clearData(){
        authorRepository.deleteAll();
    }
//    public void saveData(){
//        System.out.println("===================Save Customers to Cassandra===================");
//        Author cust_1 = new Author(1, "Peter", "Smith", "20");
//        Author cust_2 = new Author(2, "Mary", "Taylor", "25");
//        Author cust_3 = new Author(3, "Peter", "Brown", "30");
//        Author cust_4 = new Author(4, "Lauren", "Taylor", "20");
//        Author cust_5 = new Author(5, "Lauren", "Flores", "45");
//        Author cust_6 = new Author(6, "Peter", "Williams", "20");
//
//        // save customers to ElasticSearch
//        authorRepository.save(cust_1);
//        authorRepository.save(cust_2);
//        authorRepository.save(cust_3);
//        authorRepository.save(cust_4);
//        authorRepository.save(cust_5);
//        authorRepository.save(cust_6);
//    }

    public void lookup(){
        System.out.println("===================Lookup Customers from Cassandra by Firstname===================");
        List<Author> peters = authorRepository.findByFirstname("Peter");
        peters.forEach(System.out::println);

//        System.out.println("===================Lookup Customers from Cassandra by Age===================");
//        List<Author> custsAgeGreaterThan25 = authorRepository.findCustomerHasAgeGreaterThan(25);
//        custsAgeGreaterThan25.forEach(System.out::println);
    }

}
