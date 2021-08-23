package bp.springbootcassandrabp.repository;

import bp.springbootcassandrabp.model.Author;
import bp.springbootcassandrabp.model.Film;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmRepository extends CrudRepository<Film, UUID> {
    @AllowFiltering
    List<Film> findByPrice(int price);
    @AllowFiltering
    List<Film> findByPriceLessThan(int price);
    @AllowFiltering
    List<Film> findByPriceGreaterThan(int price);
    @AllowFiltering
    Film findByName (String name);


    @AllowFiltering
    List<Film> findByGenre(String genre);
    @AllowFiltering
    Film findFilmByUid(UUID id);
    @AllowFiltering
    Film findByReleaseDate(String releaseDate);
    @AllowFiltering
    List<Film> findByRating(int rating);
    @AllowFiltering
    List<Film> findByRatingLessThan(int rating);
    @AllowFiltering
    List<Film> findByRatingGreaterThan(int rating);

    @AllowFiltering
    List<Film> findFilmsByRatingGreaterThanAndPriceLessThan(int rating, int price);

}
