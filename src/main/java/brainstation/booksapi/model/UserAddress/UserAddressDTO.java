package brainstation.booksapi.model.UserAddress;

import brainstation.booksapi.model.ApplicationUser;
import javax.persistence.*;

@Entity(name = "UserAddressDTO")
@Table(name = "user_address")
public class UserAddressDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El join column es a la columna de mi tabla
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    @Column(name = "second_address")
    private String secondAddress;

    @Column(name = "city_town")
    private String cityTown;

    private String phone;

    @Column(name = "postal_code")
    private String postalCode;

    public UserAddressDTO() {}

    public UserAddressDTO(UserAddress userAddress) {
        this.id = userAddress.getId();
        //User skipped on purpose
        this.firstName = userAddress.getFirstName();
        this.lastName = userAddress.getLastName();
        this.address = userAddress.getAddress();
        this.secondAddress = userAddress.getSecondAddress();
        this.cityTown = userAddress.getCityTown();
        this.phone = userAddress.getPhone();
        this.postalCode = userAddress.getPostalCode();
    }

    public UserAddressDTO(ApplicationUser user, String firstName, String lastName, String address, String secondAddress, String cityTown, String phone, String postalCode) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.secondAddress = secondAddress;
        this.cityTown = cityTown;
        this.phone = phone;
        this.postalCode = postalCode;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(String cityTown) {
        this.cityTown = cityTown;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
