package brainstation.booksapi.model.UserAddress;

import brainstation.booksapi.model.ApplicationUser;

import javax.validation.constraints.NotNull;

public class UserAddress {

    private Long id;

    private ApplicationUser user;

    private String firstName;

    private String lastName;

    private String address;

    private String secondAddress;

    private String cityTown;

    private String phone;

    private String postalCode;

    public UserAddress() {}

    public UserAddress(Long id, ApplicationUser user, String firstName, String lastName, String address, String secondAddress, String cityTown, String phone, String postalCode) {
        this.id = id;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.secondAddress = secondAddress;
        this.cityTown = cityTown;
        this.phone = phone;
        this.postalCode = postalCode;
    }

    public UserAddress(@NotNull UserAddressDTO userAddressDTO){
        this.id = userAddressDTO.getId();
        //User skipped on purpose
        this.firstName = userAddressDTO.getFirstName();
        this.lastName = userAddressDTO.getLastName();
        this.address = userAddressDTO.getAddress();
        this.secondAddress = userAddressDTO.getSecondAddress();
        this.cityTown = userAddressDTO.getCityTown();
        this.phone = userAddressDTO.getPhone();
        this.postalCode = userAddressDTO.getPostalCode();
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
