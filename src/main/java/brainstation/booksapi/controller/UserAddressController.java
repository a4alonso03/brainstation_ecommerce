package brainstation.booksapi.controller;

import brainstation.booksapi.core.userAddress.service.UserAddressService;
import brainstation.booksapi.model.UserAddress.UserAddress;
import brainstation.booksapi.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/user-address")
public class UserAddressController {

    private UserAddressService userAddressService;

    @Autowired
    public UserAddressController(@NotNull UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CustomResponse> getAllUserAddressesByUserId(@PathVariable("userId") Long userId){
        List<UserAddress> retrievedUserAddressList = this.userAddressService.getAllAddressesFromUserById(userId);
        if(retrievedUserAddressList == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't retrieve the user address list from an user id", null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CustomResponse("ok", retrievedUserAddressList), HttpStatus.OK);
    }


}

