package brainstation.booksapi.controller;

import brainstation.booksapi.core.applicationUser.service.ApplicationUserService;
import brainstation.booksapi.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
public class UserController {

    private ApplicationUserService userService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(@NotNull ApplicationUserService applicationUserService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userService = applicationUserService;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        //TODO: Check for duplicated users
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
    }
}
