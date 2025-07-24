package fr.initiativedeuxsevres.ttm.message.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDtoIn {
    private String prenom;
    private String nom;
    private String disponibilites;

}
