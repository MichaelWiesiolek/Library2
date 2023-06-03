package pl.sda.zdjavapol131.zdjavapol131.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import pl.sda.zdjavapol131.zdjavapol131.enums.UserRole;

@Data
public class UserDto {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @Email
    private String email;
    private int phoneNumber;
    @NotEmpty
    private String password;
    private UserRole userRole;
}
