package brainstation.booksapi.core.applicationUser.service;


import brainstation.booksapi.model.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ApplicationUserService extends UserDetailsService {

    void createUser(ApplicationUser user);

}
