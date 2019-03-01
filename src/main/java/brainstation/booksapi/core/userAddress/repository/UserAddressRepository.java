package brainstation.booksapi.core.userAddress.repository;

import brainstation.booksapi.model.UserAddress.UserAddressDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddressDTO, Long> {
    @Query("select r from UserAddressDTO r where r.user.id = :id")
    List<UserAddressDTO> getAllByUserId(Long id);


}
