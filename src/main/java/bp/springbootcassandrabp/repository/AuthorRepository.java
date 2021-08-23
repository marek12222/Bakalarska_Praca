package bp.springbootcassandrabp.repository;

import bp.springbootcassandrabp.model.Author;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorRepository extends CrudRepository<Author, UUID> {

    @Query(value="SELECT * FROM Author WHERE firstName=?0")
    public List<Author> findByFirstname(String firstname);

//    @Query("SELECT * FROM Author WHERE age > ?0 ALLOW FILTERING")
//    public List<Author> findCustomerHasAgeGreaterThan(int age);
    @AllowFiltering
    Author findAuthorByUid(UUID uid );
    @AllowFiltering
    Author findAuthorByFirstName(String name);
    @AllowFiltering
    Author findAuthorByFirstNameAndLastName(String firstName,String lastName);
    @AllowFiltering
    List<Author> findAuthorsByAge(int age);
    @AllowFiltering
    List<Author> findAuthorsByAgeLessThan(int age);
    @AllowFiltering
    List<Author> findAuthorsByAgeGreaterThan(int age);


}
