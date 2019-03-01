package brainstation.booksapi.core.userAddress.service.implementation;

import brainstation.booksapi.core.applicationUser.service.ApplicationUserService;
import brainstation.booksapi.core.userAddress.repository.UserAddressRepository;
import brainstation.booksapi.core.userAddress.service.UserAddressService;
import brainstation.booksapi.model.ApplicationUser;
import brainstation.booksapi.model.UserAddress.UserAddress;
import brainstation.booksapi.model.UserAddress.UserAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class UserAddressServiceImplementation implements UserAddressService {
    //Transactional added, if something breaks take it out
    private UserAddressRepository userAddressRepository;
    private ApplicationUserService applicationUserService;


    @Autowired
    public UserAddressServiceImplementation(UserAddressRepository userAddressRepository, ApplicationUserService applicationUserService) {
        this.userAddressRepository = userAddressRepository;
        this.applicationUserService = applicationUserService;
    }

    @Override
    public List<UserAddress> getAllAddressesFromUserById(Long id) {
        return this.getUserAddressListFromUserAddressDTOList(this.userAddressRepository.getAllByUserId(id));
    }

    @Override
    public UserAddress createUserAddressForUserById(Long userId, UserAddress userAddress) {
        ApplicationUser user = this.applicationUserService.getUserById(userId);
        if(user == null) {
            return null;
        }
        UserAddressDTO userAddressDTO = new UserAddressDTO(userAddress);
        userAddressDTO.setUser(user);
        UserAddressDTO savedUserAddressDTO = this.userAddressRepository.save(userAddressDTO);

        return new UserAddress(savedUserAddressDTO);
    }

    private List<UserAddress> getUserAddressListFromUserAddressDTOList(@NotNull List<UserAddressDTO> userAddressDTOList){
        List<UserAddress> userAddressList = new LinkedList<>();
        for (UserAddressDTO userAddressDTO : userAddressDTOList) {
            userAddressList.add(new UserAddress(userAddressDTO));
        }
        return userAddressList;
    }

    @Override
    public void deleteAddressById(Long addressId) {
        this.userAddressRepository.findById(addressId);
    }
}
