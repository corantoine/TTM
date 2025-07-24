package fr.initiativedeuxsevres.ttm.message.out;

import fr.initiativedeuxsevres.ttm.model.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDtoOut {
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String plateformeInitiative;
    private String disponibilites;
    private String password;
    private String email;
    private Role role;
    private PorteurDtoOut porteur;
    private ParrainDtoOut parrain;
}
