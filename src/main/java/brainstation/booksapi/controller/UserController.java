package brainstation.booksapi.controller;

import brainstation.booksapi.core.applicationUser.service.ApplicationUserService;
import brainstation.booksapi.model.ApplicationUser;
import brainstation.booksapi.model.UserAddress.UserAddressDTO;
import brainstation.booksapi.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CustomResponse> signUp(@RequestBody ApplicationUser user) {
        ApplicationUser retrievedUser = this.userService.getUserByUsername(user.getUsername());
        if(retrievedUser != null){
            new ResponseEntity<>(new CustomResponse("User already exists", null), HttpStatus.CONFLICT);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ApplicationUser createdUser =  userService.createUser(user);
        createdUser.setPassword(null);
        if(createdUser == null){
            return new ResponseEntity<>(new CustomResponse("User creation error", null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CustomResponse("ok", createdUser), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<CustomResponse> getUserByUsername(@PathVariable("username")String username){
        ApplicationUser user = userService.getUserByUsername(username);
        if(user == null){
            return new ResponseEntity<>(new CustomResponse("User not found", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CustomResponse("ok", user), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse> updateUser(@RequestBody ApplicationUser user){
        ApplicationUser updatedUser = userService.updateUser(user);
        if(updatedUser == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't update user", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CustomResponse("ok", updatedUser), HttpStatus.OK);
    }
}
