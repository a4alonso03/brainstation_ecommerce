package brainstation.booksapi.core.userAddress.service;

import brainstation.booksapi.model.UserAddress.UserAddress;

import java.util.List;

public interface UserAddressService {

    List<UserAddress> getAllAddressesFromUserById(Long id);

    UserAddress createUserAddressForUserById(Long userId, UserAddress userAddress);

    void deleteAddressById(Long addressId);
}
