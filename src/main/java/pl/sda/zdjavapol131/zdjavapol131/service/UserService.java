package pl.sda.zdjavapol131.zdjavapol131.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.UserDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.ReservationEntity;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void saveUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setSurname(userDto.getSurname());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhoneNumber(userDto.getPhoneNumber());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setUserRole(userDto.getUserRole());
        userRepository.save(userEntity);
    }
    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<UserEntity> getAllUsers(){
        List<UserEntity> users = userRepository.findAll();
        return users;
    }

//    public void createReservation(String email, String phoneNumber){
//        ReservationEntity reservationEntity = new ReservationEntity();
//        reservationEntity.setEmail(email);
//        reservationEntity.setPhoneNumber(phoneNumber);
//        reservationEntity.setLendingDate(LocalDate.now());
//        reservationEntity.setReturnDate(LocalDate.now().plusDays(14));
//    }

    public UserDto userEntityToUserDtoConverter(UserEntity userEntity){
        UserDto newUser = new UserDto();
        newUser.setName(userEntity.getName());
        newUser.setSurname(userEntity.getSurname());
        newUser.setEmail(userEntity.getEmail());
        newUser.setPhoneNumber(userEntity.getPhoneNumber());
        newUser.setPassword(userEntity.getPassword());
        newUser.setUserRole(userEntity.getUserRole());
        return newUser;
    }

}
