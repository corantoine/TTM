package fr.initiativedeuxsevres.ttm.message.out;

import fr.initiativedeuxsevres.ttm.model.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserProfileDtoOut {
    private String nom;
    private String prenom;
    private String username;
    private String plateformeInitiative;
    private String disponibilites;
    private String email;
    private Role role;
}
