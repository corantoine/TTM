package fr.initiativedeuxsevres.ttm.message.in;

import fr.initiativedeuxsevres.ttm.model.Role;
import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
    private String email;
    private Role role;
}
