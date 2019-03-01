package brainstation.booksapi.core.review.service;

import brainstation.booksapi.model.Review.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviewsFromProductById(Long id);



}
