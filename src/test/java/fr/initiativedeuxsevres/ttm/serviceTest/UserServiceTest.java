//package fr.initiativedeuxsevres.ttm.serviceTest;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.ArgumentMatchers.any;
//
//import java.util.List;
//import java.util.Optional;
//
//import fr.initiativedeuxsevres.ttm.model.Role;
//import fr.initiativedeuxsevres.ttm.model.UserEntity;
//import fr.initiativedeuxsevres.ttm.repository.UserRepository;
//import fr.initiativedeuxsevres.ttm.service.UserService;
//
//@SpringBootTest
//public class UserServiceTest {
//
//    //Simulation du comportement de UserRepository
//    @Mock
//    UserRepository userRepository;
//
//    // Injection de Mock dans une instance de UserService
//    @InjectMocks
//    UserService userService;
//
//    private long idParrain;
//    private UserEntity userParrain;
//    String parrainName = "Doe";
//    String parrainFirstname = "John";
//    String parrainPlateformeInitiative = "Deux-Sèvres";
//    Role parrainRole = Role.PARRAIN;
//
//    @BeforeEach
//    public void setUp() {
//        idParrain = 1;
//        String parrainName = "Doe";
//        String parrainFirstname = "John";
//        String parrainPlateformeInitiative = "Deux-Sèvres";
//        Role parrainRole = Role.PARRAIN;
//
//        userParrain = UserEntity.builder()
//                .id(idParrain)
//                .nom(parrainName)
//                .prenom(parrainFirstname)
//                .plateformeInitiative(parrainPlateformeInitiative)
//                .role(parrainRole)
//                .build();
//    }
//
//    @DisplayName("Tester la méthode de création d'un utilisateur")
//    @Test
//    public void userCreationTest(){
//
//
//        UserEntity parrainDto = UserEntity.builder()
//                .nom(parrainName)
//                .prenom(parrainFirstname)
//                .plateformeInitiative(parrainPlateformeInitiative)
//                .role(parrainRole)
//                .build();
//
//
//        // Simuler le comportement de userRepository pour retourner l'utilisateur créé lorsque save est appelé
//        when(userRepository.save(any(UserEntity.class))).thenReturn(userParrain);
//
//        // Appeler la méthode createUser de UserService avec les paramètres spécifiés
//        UserEntity user = userService.createUser(parrainDto);
//
//        // Vérifier que les données utilisateurs ont bien été entrées et sont correctes
//        Assertions.assertEquals(user.getId(), idParrain);
//        Assertions.assertEquals(user.getNom(), parrainName);
//        Assertions.assertEquals(user.getPrenom(), parrainFirstname);
//        Assertions.assertEquals(user.getPlateformeInitiative(), parrainPlateformeInitiative);
//        Assertions.assertEquals(user.getRole(), parrainRole);
//
//    }
//
//    @DisplayName("Tester la méthode de suppression d'un utilisateur")
//    @Test
//    public void deleteUserByIdTest(){
//
//        // Simuler la présence de l'utilisateur dans le repository
//        when(userRepository.findById(idParrain)).thenReturn(Optional.of(userParrain));
//
//        userService.deleteUserById(idParrain);
//        verify(userRepository, times(1)).deleteById(idParrain);
//
//        //Vérifier que l'utilisateur a bien été supprimé
//        when(userRepository.findById(idParrain)).thenReturn(Optional.empty());
//        // Vérifier que l'utilisateur a bien été supprimé
//        Assertions.assertFalse(userRepository.findById(idParrain).isPresent());
//
//    }
//}
