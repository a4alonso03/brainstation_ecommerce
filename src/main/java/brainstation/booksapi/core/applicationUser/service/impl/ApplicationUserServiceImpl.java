package brainstation.booksapi.core.applicationUser.service.impl;

import brainstation.booksapi.core.applicationUser.repository.ApplicationUserRepository;
import brainstation.booksapi.core.applicationUser.service.ApplicationUserService;
import brainstation.booksapi.model.ApplicationUser;
import brainstation.booksapi.model.UserAddress.UserAddressDTO;
import brainstation.booksapi.model.UserCreditCard.UserCreditCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static java.util.Collections.emptyList;


@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private ApplicationUserRepository userRepository;

    @Autowired
    public ApplicationUserServiceImpl(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApplicationUser createUser(ApplicationUser user) {
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }

    @Override
    public ApplicationUser getUserByUsername(String username) {
        ApplicationUser returnedUser = this.userRepository.findByUsername(username);
        if (returnedUser != null) {
            returnedUser.setPassword(null);
            for (UserAddressDTO userAddressDTO : returnedUser.getUserAddressList()) {
                userAddressDTO.setUser(null);
            }
            for (UserCreditCardDTO userCreditCardDTO : returnedUser.getUserCreditCardDTOList()) {
                userCreditCardDTO.setUser(null);
            }
            return returnedUser;
        }
        return null;
    }

    @Override
    public ApplicationUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public ApplicationUser saveUser(ApplicationUser user) {
        return userRepository.save(user);
    }

    @Override
    public ApplicationUser updateUser(ApplicationUser user) {
        ApplicationUser retrievedUser = userRepository.findById(user.getId()).orElse(null);
        if(retrievedUser == null){
            return null;
        }

        retrievedUser.setPassword(null);
        for (UserAddressDTO userAddressDTO : retrievedUser.getUserAddressList()) {
            userAddressDTO.setUser(null);
        }
        for (UserCreditCardDTO userCreditCardDTO : retrievedUser.getUserCreditCardDTOList()) {
            userCreditCardDTO.setUser(null);
        }

        retrievedUser.setName(user.getName());
        retrievedUser.setLastName(user.getLastName());
        return userRepository.save(retrievedUser);
    }
}
