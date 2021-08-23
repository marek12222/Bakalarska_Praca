package bp.springbootcassandrabp.repository;

import bp.springbootcassandrabp.model.Author;
import bp.springbootcassandrabp.model.Review;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends CrudRepository<Review, UUID> {
    @AllowFiltering
    Review findReviewByUid(UUID uid);
    @AllowFiltering
    List<Review> findReviewsByUserName(String userName);
    @AllowFiltering
    List<Review> findReviewsByRating(int rating);
    @AllowFiltering
    List<Review> findReviewsByRatingLessThan(int rating);
    @AllowFiltering
    List<Review> findReviewsByRatingGreaterThan(int rating);
}
