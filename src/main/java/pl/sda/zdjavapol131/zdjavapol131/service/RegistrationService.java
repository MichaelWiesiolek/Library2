package pl.sda.zdjavapol131.zdjavapol131.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol131.zdjavapol131.enums.UserRole;
import pl.sda.zdjavapol131.zdjavapol131.model.dto.UserDto;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public RegistrationService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;

    }

    public String userRegistration(UserDto userDto) {
        UserEntity existingUser = userService.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            return "There is already an account registered with that email";
        } else {
            userDto.setUserRole(UserRole.USER);
            userService.saveUser(userDto);
            return "Registered";
        }
    }
}
