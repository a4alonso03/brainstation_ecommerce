package brainstation.booksapi.controller;

import brainstation.booksapi.core.userCreditCard.service.UserCreditCardService;
import brainstation.booksapi.model.UserCreditCard.UserCreditCard;
import brainstation.booksapi.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/card")
public class UserCreditCardController {

    private UserCreditCardService userCreditCardService;

    @Autowired
    public UserCreditCardController(@NotNull UserCreditCardService userCreditCardService) {
        this.userCreditCardService = userCreditCardService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomResponse> getAllUserCreditCardsByUserId(@PathVariable("userId")Long userId){
        List<UserCreditCard> retrievedUserCreditCardList = this.userCreditCardService.getAllCreditCardsForUserById(userId);
        if(retrievedUserCreditCardList == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't retrieve the user credit card list from an user id", null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CustomResponse("ok", retrievedUserCreditCardList), HttpStatus.OK);
    }
}
