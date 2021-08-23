package bp.springbootcassandrabp.controller;

import bp.springbootcassandrabp.model.Review;
import bp.springbootcassandrabp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @RequestMapping("/create")
    public void create(@RequestParam String name, @RequestParam String userName,
                       @RequestParam int rating, @RequestParam String revText) {
        reviewService.create(name, userName, rating, revText);
    }

    @RequestMapping("/getReviewById")
    public Review getReviewById(@RequestParam UUID id){
        Review review = reviewService.getReviewById(id);
        return review;
    }
    @RequestMapping("/getReviewsByUserName")
    public List<Review> getReviewsByUserName(@RequestParam String userName){
        List<Review> reviews = reviewService.getReviewsByUserName(userName);
        return reviews;
    }
    @RequestMapping("/getReviewsByRating")
    public List<Review> getReviewsByRating(@RequestParam int rating){
        List<Review> reviews = reviewService.getReviewsByRating(rating);
        return reviews;
    }
    @RequestMapping("/getReviewsByRatingLessThan")
    public List<Review> getReviewsByRatingLessThan(@RequestParam int rating){
        List<Review> reviews = reviewService.getReviewsByRatingLessThan(rating);
        return reviews;
    }
    @RequestMapping("/getReviewsByRatingGreaterThan")
    public List<Review> getReviewsByRatingGreaterThan(@RequestParam int rating){
        List<Review> reviews = reviewService.getReviewsByRatingGreaterThan(rating);
        return reviews;
    }
}
