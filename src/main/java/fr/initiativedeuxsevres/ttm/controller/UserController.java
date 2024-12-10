package fr.initiativedeuxsevres.ttm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import fr.initiativedeuxsevres.ttm.model.ParrainEntity;
import fr.initiativedeuxsevres.ttm.model.PorteurEntity;
import fr.initiativedeuxsevres.ttm.model.Role;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.service.ParrainService;
import fr.initiativedeuxsevres.ttm.service.PorteurService;

/**
 * Controller générique pour la gestion des parrains et des porteurs.
 **/

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private PorteurService porteurService;

    @Autowired
    private ParrainService parrainService;

    @PostMapping("/register")
    public UserEntity createUser(@RequestBody UserEntity user){
        if(user.getRole() == Role.PORTEUR){
            PorteurEntity porteur = PorteurEntity.builder()
                    .nom(user.getNom())
                    .prenom(user.getPrenom())
                    .username(user.getUsername())
                    .plateformeInitiative(user.getPlateformeInitiative())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .build();
            return porteurService.createPorteur(porteur);
        } else if (user.getRole() == Role.PARRAIN) {
            ParrainEntity parrain = ParrainEntity.builder()
                    .nom(user.getNom()).prenom(user.getPrenom())
                    .username(user.getUsername())
                    .plateformeInitiative(user.getPlateformeInitiative())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .build();
            return parrainService.createParrain(parrain);
        } else {
            throw new IllegalArgumentException("Une erreur est survenue") ;
        }
    }
//    @PostMapping("/register")
//    public UserEntity createUser(@RequestBody UserEntity user){
//        if(user.getRole() == Role.PORTEUR){
//            return porteurService.createPorteur((PorteurEntity) user);
//        } else if (user.getRole() == Role.PARRAIN) {
//            return parrainService.createParrain((ParrainEntity) user);
//        } else {
//            throw new IllegalArgumentException("Une erreur est survenue") ;
//        }
//    }


//    @PostMapping
//    public PorteurEntity createPorteur(@RequestBody PorteurEntity porteur) {
//        return porteurService.createPorteur(porteur);
//    }
//
//    @PostMapping
//    public ParrainEntity createParrain(@RequestBody ParrainEntity parrain) {
//        return parrainService.createParrain(parrain);
//    }
}