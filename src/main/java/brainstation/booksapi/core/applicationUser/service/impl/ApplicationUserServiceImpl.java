package brainstation.booksapi.core.applicationUser.service.impl;

import brainstation.booksapi.core.applicationUser.repository.ApplicationUserRepository;
import brainstation.booksapi.core.applicationUser.service.ApplicationUserService;
import brainstation.booksapi.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static java.util.Collections.emptyList;


@Service
public class ApplicationUserServiceImpl implements ApplicationUserService{

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
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }

    @Override
    public ApplicationUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }
}
