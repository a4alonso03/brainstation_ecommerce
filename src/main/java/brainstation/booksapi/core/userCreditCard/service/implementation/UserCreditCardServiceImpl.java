package brainstation.booksapi.core.userCreditCard.service.implementation;

import brainstation.booksapi.core.applicationUser.service.ApplicationUserService;
import brainstation.booksapi.core.userCreditCard.repository.UserCreditCardRepository;
import brainstation.booksapi.core.userCreditCard.service.UserCreditCardService;
import brainstation.booksapi.model.ApplicationUser;
import brainstation.booksapi.model.UserCreditCard.UserCreditCard;
import brainstation.booksapi.model.UserCreditCard.UserCreditCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class UserCreditCardServiceImpl implements UserCreditCardService {
    private UserCreditCardRepository userCreditCardRepository;
    private ApplicationUserService applicationUserService;

    @Autowired
    public UserCreditCardServiceImpl(UserCreditCardRepository userCreditCardRepository, ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
        this.userCreditCardRepository = userCreditCardRepository;
    }

    @Override
    public List<UserCreditCard> getAllCreditCardsForUserById(Long id) {
        return this.getCreditCardListFromCreditCardDTOList(this.userCreditCardRepository.getAllByUserId(id));
    }

    @Override
    public UserCreditCard createUserCreditCardForUserById(Long userId, UserCreditCard userCreditCard) {
        ApplicationUser user = this.applicationUserService.getUserById(userId);
        if(user == null) {
            return null;
        }

        UserCreditCardDTO userCreditCardDTO = new UserCreditCardDTO(userCreditCard);
        userCreditCardDTO.setUser(user);
        UserCreditCardDTO savedUserCreditCardDTO = this.userCreditCardRepository.save(userCreditCardDTO);

        return new UserCreditCard(savedUserCreditCardDTO);
    }

    private List<UserCreditCard> getCreditCardListFromCreditCardDTOList(@NotNull List<UserCreditCardDTO> userCreditCardDTOList) {
        List<UserCreditCard> userCreditCardList = new LinkedList<>();
        for (UserCreditCardDTO userCreditCardDTO : userCreditCardDTOList) {
            userCreditCardList.add(new UserCreditCard(userCreditCardDTO));
        }
        return userCreditCardList;
    }
}
