package brainstation.booksapi.core.review.service.implementation;

import brainstation.booksapi.core.review.repository.ReviewRepository;
import brainstation.booksapi.core.review.service.ReviewService;
import brainstation.booksapi.model.Review.Review;
import brainstation.booksapi.model.Review.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository){ this.reviewRepository = reviewRepository; }

    @Override
    public List<Review> getAllReviewsFromProductById(Long id) {
        return this.getReviewListFromReviewDTOList(this.reviewRepository.getAllByProduct_Id(id));
    }

    private List<Review> getReviewListFromReviewDTOList(@NotNull List<ReviewDTO> reviewDTOList){
        List<Review> reviewList = new LinkedList<>();
        for (ReviewDTO reviewDTO : reviewDTOList) {
            reviewList.add(new Review(reviewDTO));
        }
        return reviewList;
    }
}
