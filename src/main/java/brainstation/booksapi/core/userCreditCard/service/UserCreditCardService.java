package brainstation.booksapi.core.userCreditCard.service;

import brainstation.booksapi.model.UserCreditCard.UserCreditCard;

import java.util.List;

public interface UserCreditCardService {

    List<UserCreditCard> getAllCreditCardsForUserById(Long id);

    UserCreditCard createUserCreditCardForUserById(Long userId, UserCreditCard userCreditCard);

}
