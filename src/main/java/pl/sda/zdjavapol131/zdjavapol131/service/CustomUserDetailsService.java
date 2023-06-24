package pl.sda.zdjavapol131.zdjavapol131.service;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol131.zdjavapol131.enums.UserRole;
import pl.sda.zdjavapol131.zdjavapol131.repository.UserRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.UserEntity;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    createRolesList(user.getUserRole()));

        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection < ? extends GrantedAuthority> createRolesList(UserRole userRole) {
        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
        String role = userRole.name().toUpperCase();
        roles.add(new SimpleGrantedAuthority(role));
        return roles;
    }
}
