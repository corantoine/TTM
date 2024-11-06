package fr.initiativedeuxsevres.ttm.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import fr.initiativedeuxsevres.ttm.model.Role;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import fr.initiativedeuxsevres.ttm.service.UserService;

@SpringBootTest
public class UserServiceTest {

    //Simulation du comportement de UserRepository
    @Mock
    UserRepository userRepository;

    // Injection de Mock dans une instance de UserService
    @InjectMocks
    UserService userService;

    @Test
    public void userCreationTest(){
        // Définir l'ID de l'utilisateur qui va créer le profil
        long idAdmin = 1;

        // Créer un objet User avec l'ID et le nom d'utilisateur spécifiés pour l'admin
        UserEntity admin = UserEntity.builder()
                .id(idAdmin)
                .nom("Admin")
                .prenom("Admin")
                .plateformeInitiative("Deux-sèvres")
                .role(Role.ADMIN)
                .build();
        // Simuler le comportement de userRepository pour retourner l'utilisateur créé lorsque findById est appelé
        when(userRepository.findById(idAdmin)).thenReturn(Optional.of(admin));

        // Préciser les détails de l'utilisateur à créer
        long idParrain = 2;
        String parrainName = "Doe";
        String parrainFirstname = "John";
        String parrainPlateformeInitiative = "Deux-Sèvres";
        Role parrainRole = Role.PARRAIN;

        UserEntity parrain = UserEntity.builder()
                .id(idParrain)
                .nom(parrainName)
                .prenom(parrainFirstname)
                .plateformeInitiative(parrainPlateformeInitiative)
                .role(parrainRole)
                .build();

        // Simuler le comportement de userRepository pour retourner l'utilisateur créé lorsque save est appelé
        when(userRepository.save(any(UserEntity.class))).thenReturn(parrain);

        // Appeler la méthode createUser de UserService avec les paramètres spécifiés
        UserEntity user = userService.createUser(parrain);

        // Vérifier que les données utilisateurs ont bien été entrées et sont corrects
        Assertions.assertEquals(user.getId(), idParrain);
        Assertions.assertEquals(user.getNom(), parrainName);
        Assertions.assertEquals(user.getPrenom(), parrainFirstname);
        Assertions.assertEquals(user.getPlateformeInitiative(), parrainPlateformeInitiative);
        Assertions.assertEquals(user.getRole(), parrainRole);




    }

}
