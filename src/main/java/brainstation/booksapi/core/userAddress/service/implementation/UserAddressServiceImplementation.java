package brainstation.booksapi.core.userAddress.service.implementation;

import brainstation.booksapi.core.applicationUser.service.ApplicationUserService;
import brainstation.booksapi.core.userAddress.repository.UserAddressRepository;
import brainstation.booksapi.core.userAddress.service.UserAddressService;
import brainstation.booksapi.model.ApplicationUser;
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
        //Get the user by id, access its list of addresses and insert the userAddress that i received
        ApplicationUser user = this.applicationUserService.getUserById(userId);
        if(user == null) {
            return null;
        }

        //this.userAddressRepository.save()
        //Save the user address and then save the user

        user.getUserAddressList().add(new UserAddressDTO(userAddress));


        ApplicationUser storedUser = this.applicationUserService.saveUser(user);
        for (UserAddressDTO userAddressDTO : storedUser.getUserAddressList()) {
            if(userAddressDTO.getAddress().equals(userAddress.getAddress())){
                return new UserAddress(userAddressDTO);
            }
        }
        return null;
    }

    private List<UserAddress> getUserAddressListFromUserAddressDTOList(@NotNull List<UserAddressDTO> userAddressDTOList){
        List<UserAddress> userAddressList = new LinkedList<>();
        for (UserAddressDTO userAddressDTO : userAddressDTOList) {
            userAddressList.add(new UserAddress(userAddressDTO));
        }
        return userAddressList;
    }
}
