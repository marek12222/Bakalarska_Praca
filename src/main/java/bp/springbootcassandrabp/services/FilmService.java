package bp.springbootcassandrabp.services;

import bp.springbootcassandrabp.model.Author;
import bp.springbootcassandrabp.model.Film;
import bp.springbootcassandrabp.model.FilmsByAuthor;
import bp.springbootcassandrabp.model.Review;
import bp.springbootcassandrabp.repository.AuthorRepository;
import bp.springbootcassandrabp.repository.FilmRepository;
import bp.springbootcassandrabp.repository.FilmsByAuthorRepository;
import bp.springbootcassandrabp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static bp.springbootcassandrabp.config.NameGenerator.generateGenre;
import static bp.springbootcassandrabp.config.NameGenerator.generateName;
import static bp.springbootcassandrabp.config.RandomDates.createRandomDate;
import static bp.springbootcassandrabp.config.RandomDates.getRandomNumberInRange;
import static bp.springbootcassandrabp.config.RandomSentence.generateSentence;

@Service
public class FilmService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private FilmsByAuthorRepository filmsByAuthorRepository;


    //create este
    public Film create(String filmName, int price, String releaseDate,String genre,int rating,String authorFirstName,String authorlastName,int age){
        UUID autorId = UUID.randomUUID();
        Author author = new Author(autorId,authorFirstName,authorlastName,age);
        UUID filmId = UUID.randomUUID();
        Film film =new Film(filmId,filmName,price,releaseDate,genre,rating,autorId);
        this.authorRepository.save(author);
        return filmRepository.save(film);

    }

    public void createN(int n){
        int i;
        for(i=0;i<n;i++){

            UUID authorID = UUID.randomUUID();
            String firstName = generateName();
            String lastName = generateName();
            int age =   getRandomNumberInRange(30,90);

            Author author = new Author(authorID,firstName,lastName,age);
            this.authorRepository.save(author);

            List<Review> revs = new ArrayList<>();
            List<UUID> reviewIDs = new ArrayList<>();
            int revAmount = getRandomNumberInRange(1,3);
            int allRatings = 0;
            for(int j=0;j<revAmount;j++){
                UUID revID = UUID.randomUUID();
                int rating = getRandomNumberInRange(1,10);
                Review review = new Review(revID,generateName(),rating,generateSentence(5));
                revs.add(review);
                reviewIDs.add(revID);
                allRatings+=rating;
            }
            int avrgRating = allRatings/revAmount;
            this.reviewRepository.saveAll(revs);


            UUID filmID = UUID.randomUUID();
            String filmName = generateName();
            int filmPrice = getRandomNumberInRange(1,30);
            String date = createRandomDate(1990, 2020);
            String genre = generateGenre();

            Film film = new Film(filmID,
                    filmName,
                    filmPrice,
                    date,
                    genre,
                    avrgRating,
                    authorID,
                    reviewIDs
            );
            this.filmRepository.save(film);
            FilmsByAuthor filmByAuthor = new FilmsByAuthor(
                    filmID,
                    filmName,
                    filmPrice,
                    date,
                    genre,
                    avrgRating,
                    authorID,
                    reviewIDs,
                    firstName,
                    lastName,
                    age
            );
            this.filmsByAuthorRepository.save(filmByAuthor);
        }
    }

    public List<Film> getAll(){
        return (List<Film>) filmRepository.findAll();
    }

    public Film getById(UUID id){
        return filmRepository.findFilmByUid(id);
    }
    public Film getByName(String name){
        Film film =filmRepository.findByName(name);
        return film;
    }
    public List<Film> getByPrice(int price){
        List<Film> films = filmRepository.findByPrice(price);
        return films;
    }
    public Film getByReleaseDate(String releaseDate){
        Film film =filmRepository.findByReleaseDate(releaseDate);
        return film;
    }

    public List<Film> getByRating(int rating){
        List<Film> films = filmRepository.findByRating(rating);
        return films;
    }
    public List<Film> getByRatingLessThan(int rating){
        List<Film> films = filmRepository.findByRatingLessThan(rating);
        return  films;
    }
    public List<Film> getByRatingGreaterThan(int rating){
        List<Film> films = filmRepository.findByRatingGreaterThan(rating);
        return  films;
    }
    public List<Film> getByPriceLessThan(int price){
        List<Film> films = filmRepository.findByPriceLessThan(price);
        return  films;
    }
    public List<Film> getByPriceGreaterThan(int price){
        List<Film> films = filmRepository.findByPriceGreaterThan(price);
        return  films;
    }
    public List<Film> getFilmsByGenre(String genre){
        List<Film> films = filmRepository.findByGenre(genre);
        return films;
    }

    public List<Film> getByRatingGreaterThanAndPriceLessThan(int rating, int price){
        List <Film> films = filmRepository.findFilmsByRatingGreaterThanAndPriceLessThan(rating,price);
        return films;
    }

    public List<FilmsByAuthor> getByAgeAndGenreAndRatingGreaterThan(int age, String genre, int rating){
        List<FilmsByAuthor> films = filmsByAuthorRepository.findAllByAgeAndGenreAndRatingGreaterThan(age,genre,rating);
        return films;
    }

    public FilmsByAuthor getFilmByAuthorID(UUID id){
        FilmsByAuthor film = filmsByAuthorRepository.findByAutorId(id);
        return film;
    }






    public Film updatePrice(String name, int price){
        Film film = filmRepository.findByName(name);
        film.setPrice(price);
        return filmRepository.save(film);
    }
    public void deleteAll(){
        filmRepository.deleteAll();
        reviewRepository.deleteAll();
        authorRepository.deleteAll();

    }
    public void delete(String name){
        Film film = filmRepository.findByName(name);
        filmRepository.delete(film);
    }
    public void deleteById(UUID id){
        filmRepository.deleteById(id);
    }
}
