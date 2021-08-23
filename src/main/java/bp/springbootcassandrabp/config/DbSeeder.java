package bp.springbootcassandrabp.config;

import bp.springbootcassandrabp.model.Author;
import bp.springbootcassandrabp.model.Film;
import bp.springbootcassandrabp.model.FilmsByAuthor;
import bp.springbootcassandrabp.model.Review;
import bp.springbootcassandrabp.repository.AuthorRepository;
import bp.springbootcassandrabp.repository.FilmRepository;
import bp.springbootcassandrabp.repository.FilmsByAuthorRepository;
import bp.springbootcassandrabp.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static bp.springbootcassandrabp.config.NameGenerator.generateGenre;
import static bp.springbootcassandrabp.config.NameGenerator.generateName;
import static bp.springbootcassandrabp.config.RandomDates.createRandomDate;
import static bp.springbootcassandrabp.config.RandomDates.getRandomNumberInRange;
import static bp.springbootcassandrabp.config.RandomSentence.generateSentence;

@Component
public class DbSeeder implements CommandLineRunner {

    private FilmRepository filmRepository;
    private AuthorRepository authorRepository;
    private ReviewRepository reviewRepository;
    private FilmsByAuthorRepository filmsByAuthorRepository;

    public DbSeeder(FilmRepository filmRepository, AuthorRepository authorRepository, ReviewRepository reviewRepository,FilmsByAuthorRepository filmsByAuthorRepository) {
        this.filmRepository = filmRepository;
        this.authorRepository = authorRepository;
        this.reviewRepository = reviewRepository;
        this.filmsByAuthorRepository = filmsByAuthorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //delete old files
        this.filmRepository.deleteAll();
        this.authorRepository.deleteAll();
        this.reviewRepository.deleteAll();
        this.filmsByAuthorRepository.deleteAll();

        //generating new files
//        int i;
//        for(i=0;i<1000;i++){
//
//            UUID authorID = UUID.randomUUID();
//            String firstName = generateName();
//            String lastName = generateName();
//            int age =   getRandomNumberInRange(30,90);
//
//            Author author = new Author(authorID,firstName,lastName,age);
//            this.authorRepository.save(author);
//
//            List<Review> revs = new ArrayList<>();
//            List<UUID> reviewIDs = new ArrayList<>();
//            int revAmount = getRandomNumberInRange(1,3);
//            int allRatings = 0;
//            for(int j=0;j<revAmount;j++){
//                UUID revID = UUID.randomUUID();
//                int rating = getRandomNumberInRange(1,10);
//                Review review = new Review(revID,generateName(),rating,generateSentence(5));
//                revs.add(review);
//                reviewIDs.add(revID);
//                allRatings+=rating;
//            }
//            int avrgRating = allRatings/revAmount;
//            this.reviewRepository.saveAll(revs);
//
//
//            UUID filmID = UUID.randomUUID();
//            String filmName = generateName();
//            int filmPrice = getRandomNumberInRange(1,30);
//            String date = createRandomDate(1990, 2020);
//            String genre = generateGenre();
//
//            Film film = new Film(filmID,
//                    filmName,
//                    filmPrice,
//                    date,
//                    genre,
//                    avrgRating,
//                    authorID,
//                    reviewIDs
//            );
//            this.filmRepository.save(film);
//            FilmsByAuthor filmByAuthor = new FilmsByAuthor(
//                    filmID,
//                    filmName,
//                    filmPrice,
//                    date,
//                    genre,
//                    avrgRating,
//                    authorID,
//                    reviewIDs,
//                    firstName,
//                    lastName,
//                    age
//            );
//            this.filmsByAuthorRepository.save(filmByAuthor);
//        }
    }
}
