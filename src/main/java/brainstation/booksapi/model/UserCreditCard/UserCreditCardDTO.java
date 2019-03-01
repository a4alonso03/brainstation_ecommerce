package brainstation.booksapi.model.UserCreditCard;

import brainstation.booksapi.model.ApplicationUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "UserCreditCardDTO")
@Table(name = "user_credit_card")
public class UserCreditCardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El join column es a la columna de mi tabla
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    private String number;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "expiry_date")
    private String expiryDate;

    private String cvc;

    public UserCreditCardDTO() {}

    public UserCreditCardDTO(@NotNull UserCreditCard userCreditCard){
        this.id = userCreditCard.getId();
        //User skipped
        this.number = userCreditCard.getNumber();
        this.cardName = userCreditCard.getCardName();
        this.expiryDate = userCreditCard.getExpiryDate();
        this.cvc = userCreditCard.getCvc();
    }

    public UserCreditCardDTO(ApplicationUser user, String number, String cardName, String expiryDate, String cvc) {
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
