package bp.springbootcassandrabp.services;

import bp.springbootcassandrabp.model.Film;
import bp.springbootcassandrabp.model.Review;
import bp.springbootcassandrabp.repository.AuthorRepository;
import bp.springbootcassandrabp.repository.FilmRepository;
import bp.springbootcassandrabp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ReviewRepository reviewRepository;


    public void create (String name, String userName,int rating,String revText){
        Film film = filmRepository.findByName(name);
        List<UUID> reviewIds = film.getReviewIds();
        UUID newReviewId = UUID.randomUUID();
        Review newReview = new Review(newReviewId,userName,rating,revText);
        reviewIds.add(newReviewId);
        this.reviewRepository.save(newReview);
        film.setReviewIds(reviewIds);
        this.filmRepository.save(film);
    }


    public Review getReviewById(UUID id){
        return reviewRepository.findReviewByUid(id);
    }
    public List<Review> getReviewsByUserName(String userName){
        return reviewRepository.findReviewsByUserName(userName);
    }
    public List<Review> getReviewsByRating(int rating){
        return reviewRepository.findReviewsByRating(rating);
    }
    public List<Review> getReviewsByRatingLessThan(int rating){
        return reviewRepository.findReviewsByRatingLessThan(rating);
    }
    public List<Review> getReviewsByRatingGreaterThan(int rating){
        return reviewRepository.findReviewsByRatingGreaterThan(rating);
    }
}
