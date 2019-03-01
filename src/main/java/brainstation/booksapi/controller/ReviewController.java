package brainstation.booksapi.controller;

import brainstation.booksapi.core.review.service.ReviewService;
import brainstation.booksapi.model.Review.Review;
import brainstation.booksapi.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CustomResponse> getAllReviewsByProductId(@PathVariable("productId")Long productId ){
        List<Review> retrievedReviewList = this.reviewService.getAllReviewsFromProductById(productId);
        if(retrievedReviewList == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't retrieve the review list from a product id", null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CustomResponse("ok", retrievedReviewList), HttpStatus.OK);
    }


}
