package fr.initiativedeuxsevres.ttm.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.initiativedeuxsevres.ttm.message.out.UserProfileDtoOut;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import fr.initiativedeuxsevres.ttm.service.UserService;

/**
 * Controller générique pour la gestion des parrains et des porteurs.
 **/

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    //    @GetMapping("/myprofil")
    //    public ResponseEntity<UserProfileDtoOut> getMyProfil(Authentication authentication) {
    //        String username = authentication.getName(); // récupère le username connecté
    //        UserEntity user = userService.getUserByUsername(username)
    //                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
    //
    //        UserProfileDtoOut profileDtoOut = UserProfileDtoOut.builder()
    //                .nom(user.getNom())
    //                .prenom(user.getPrenom())
    //                .username(user.getUsername())
    //                .role(user.getRole())
    //                .plateformeInitiative(user.getPlateformeInitiative())
    //                .build();
    //
    //        return ResponseEntity.ok(profileDtoOut);
    //    }

    //    @GetMapping("/{userId}")
    //    public ResponseEntity<UserDto> getUserById(@PathVariable UUID userId) {
    //        UserEntity findUser = userService.findById(userId);
    //        UserDto userDto = userMapperDto.mapUserToUserDto(findUser);
    //        return ResponseEntity.ok(userDto);
    //    }
    //    @GetMapping("/myprofil")
    //    public ResponseEntity<UserProfileDtoOut> getMyProfil(Authentication authentication) {
    //        String usernameOrEmail = authentication.getName(); // récupère le username connecté
    //        UserEntity user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
    //                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
    //
    //        UserProfileDtoOut profileDtoOut = UserProfileDtoOut.builder()
    //                .nom(user.getNom())
    //                .prenom(user.getPrenom())
    //                .username(user.getUsername())
    //                .role(user.getRole())
    //                .plateformeInitiative(user.getPlateformeInitiative())
    //                .build();
    //
    //        return ResponseEntity.ok(profileDtoOut);
    //
    //    }

    @GetMapping("/myprofil")
    public ResponseEntity<UserProfileDtoOut> getMyProfil(Authentication authentication) {
        System.out.println("Appel du endpoint /users/myprofil");

        String usernameOrEmail = authentication.getName();
        UserProfileDtoOut profile = userService.getUserProfile(usernameOrEmail);
        return ResponseEntity.ok(profile);
    }

}