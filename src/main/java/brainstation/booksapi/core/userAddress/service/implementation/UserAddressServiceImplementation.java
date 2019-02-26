package brainstation.booksapi.core.userAddress.service.implementation;

import brainstation.booksapi.core.userAddress.repository.UserAddressRepository;
import brainstation.booksapi.core.userAddress.service.UserAddressService;
import brainstation.booksapi.model.UserAddress.UserAddress;
import brainstation.booksapi.model.UserAddress.UserAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserAddressServiceImplementation implements UserAddressService {

    private UserAddressRepository userAddressRepository;

    @Autowired
    public UserAddressServiceImplementation(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public List<UserAddress> getAllAddressesFromUserById(Long id) {
        return this.getUserAddressListFromUserAddressDTOList(this.userAddressRepository.getAllByUserId(id));
    }

    private List<UserAddress> getUserAddressListFromUserAddressDTOList(@NotNull List<UserAddressDTO> userAddressDTOList){
        List<UserAddress> userAddressList = new LinkedList<>();
        for (UserAddressDTO userAddressDTO : userAddressDTOList) {
            userAddressList.add(new UserAddress(userAddressDTO));
        }
        return userAddressList;
    }
}
