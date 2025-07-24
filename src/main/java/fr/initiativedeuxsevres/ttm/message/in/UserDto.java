package fr.initiativedeuxsevres.ttm.message.in;

import fr.initiativedeuxsevres.ttm.model.Role;
import lombok.Data;

@Data
public class UserDto {
    private String nom;
    private String prenom;
    private String username;
    private String plateformeInitiative;
    private String disponibilites;
    private String password;
    private String confirmPassword;
    private String email;
    private Role role;
}
