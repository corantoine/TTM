package fr.initiativedeuxsevres.ttm.message.in;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDtoIn {
    private String prenom;
    private String nom;
    private List<String> disponibilites;

}
