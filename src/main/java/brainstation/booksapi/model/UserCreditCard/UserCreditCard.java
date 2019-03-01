package brainstation.booksapi.model.UserCreditCard;

import brainstation.booksapi.model.ApplicationUser;

import javax.validation.constraints.NotNull;


public class UserCreditCard {

    public Long id;


    private ApplicationUser user;

    private String number;

    private String cardName;

    private String expiryDate;

    private String cvc;

    public UserCreditCard() {
    }

    public UserCreditCard(@NotNull UserCreditCardDTO userCreditCardDTO) {
        this.id = userCreditCardDTO.getId();
        //User skipped
        this.number = userCreditCardDTO.getNumber();
        this.cardName = userCreditCardDTO.getCardName();
        this.expiryDate = userCreditCardDTO.getExpiryDate();
        this.cvc = userCreditCardDTO.getCvc();
    }

    public UserCreditCard(Long id, ApplicationUser user, String number, String cardName, String expiryDate, String cvc) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.cardName = cardName;
        this.expiryDate = expiryDate;
        this.cvc = cvc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
