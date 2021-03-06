package brainstation.booksapi.controller;

import brainstation.booksapi.core.userAddress.service.UserAddressService;
import brainstation.booksapi.exceptions.RestExceptionInterceptor;
import brainstation.booksapi.model.UserAddress.UserAddress;
import brainstation.booksapi.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("/{userId}")
    public ResponseEntity<CustomResponse> crateUserAddressForUserById(@PathVariable("userId") Long userId,
                                                                      @Validated(RestExceptionInterceptor.class) @RequestBody UserAddress userAddress){

       UserAddress createdUserAddress =  this.userAddressService.createUserAddressForUserById(userId, userAddress);
       if(createdUserAddress == null){
           return new ResponseEntity<>(new CustomResponse("Couldn't create the user address by an user id", null), HttpStatus.BAD_REQUEST);
       }
        return new ResponseEntity<>(new CustomResponse("ok", createdUserAddress), HttpStatus.OK);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<CustomResponse> deleteAddressById (@PathVariable("addressId")Long addressId){
        this.userAddressService.deleteAddressById(addressId);
        return new ResponseEntity<>(new CustomResponse("ok", null), HttpStatus.OK);
    }
}

