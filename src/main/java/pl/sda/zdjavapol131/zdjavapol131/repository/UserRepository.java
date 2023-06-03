package pl.sda.zdjavapol131.zdjavapol131.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    //@Query(nativeQuery = true, value = "")
    UserEntity findByEmail(String email);

}
