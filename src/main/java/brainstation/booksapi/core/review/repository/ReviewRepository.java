package brainstation.booksapi.core.review.repository;

import brainstation.booksapi.model.Review.ReviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewDTO, Long> {
    @Query("select r from ReviewDTO r where r.productDTO.id = :id")
    List<ReviewDTO> getAllByProduct_Id(long id);
}
