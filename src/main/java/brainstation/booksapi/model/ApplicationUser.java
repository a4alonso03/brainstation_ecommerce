package brainstation.booksapi.model;

import brainstation.booksapi.exceptions.CustomRestExceptionHandler;
import brainstation.booksapi.model.UserAddress.UserAddressDTO;
import brainstation.booksapi.model.UserCreditCard.UserCreditCardDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "ApplicationUser")
@Table(name = "application_user")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(groups = {CustomRestExceptionHandler.class}, message = "An username is required when creating an user")
    private String username;
    @NotNull(groups = {CustomRestExceptionHandler.class}, message = "A password is required when creating an user")
    private String password;
    @NotNull(groups = {CustomRestExceptionHandler.class}, message = "A Name is required when creating an user")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(orphanRemoval = true, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserAddressDTO> userAddressList = new HashSet<>();

    @OneToMany(orphanRemoval = true, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserCreditCardDTO> userCreditCardDTOList = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationUser that = (ApplicationUser) o;
        return id == that.id &&
                username.equals(that.username) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    public Set<UserAddressDTO> getUserAddressList() {
        return userAddressList;
    }

    public void setUserAddressList(Set<UserAddressDTO> userAddressList) {
        this.userAddressList = userAddressList;
    }

    public Set<UserCreditCardDTO> getUserCreditCardDTOList() {
        return userCreditCardDTOList;
    }

    public void setUserCreditCardDTOList(Set<UserCreditCardDTO> userCreditCardDTOList) {
        this.userCreditCardDTOList = userCreditCardDTOList;
    }
}
