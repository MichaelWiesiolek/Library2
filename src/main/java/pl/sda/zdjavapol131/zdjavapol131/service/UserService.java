package pl.sda.zdjavapol131.zdjavapol131.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;


    }
    public void logIn(){}
    public void registration (){}
}
