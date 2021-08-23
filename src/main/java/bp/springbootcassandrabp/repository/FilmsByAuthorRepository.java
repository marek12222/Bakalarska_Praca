package bp.springbootcassandrabp.repository;

import bp.springbootcassandrabp.model.Film;
import bp.springbootcassandrabp.model.FilmsByAuthor;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface FilmsByAuthorRepository extends CrudRepository<FilmsByAuthor, UUID> {

    @AllowFiltering
    List<FilmsByAuthor> findAllByReviewIdsEqualsAndAgeGreaterThan(int numOfRev,int age);

    @AllowFiltering
    List<FilmsByAuthor> findAllByAgeAndGenreAndRatingGreaterThan(int age, String genre, int rating);

    @AllowFiltering
    FilmsByAuthor findByAutorId(UUID id);

}
