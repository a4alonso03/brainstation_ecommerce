package brainstation.booksapi.core.applicationUser.service;


import brainstation.booksapi.model.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ApplicationUserService extends UserDetailsService {

    ApplicationUser createUser(ApplicationUser user);

    ApplicationUser getUserByUsername(String username);

    ApplicationUser getUserById(Long id);

    ApplicationUser saveUser(ApplicationUser user);

}
