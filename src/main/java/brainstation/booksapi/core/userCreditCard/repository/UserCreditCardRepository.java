package brainstation.booksapi.core.userCreditCard.repository;

import brainstation.booksapi.model.UserCreditCard.UserCreditCardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserCreditCardRepository extends JpaRepository<UserCreditCardDTO, Long> {

    @Query("select r from UserCreditCardDTO r where r.user.id = :id")
    List<UserCreditCardDTO> getAllByUserId(Long id);

}
