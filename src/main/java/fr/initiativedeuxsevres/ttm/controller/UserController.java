package fr.initiativedeuxsevres.ttm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.message.out.UserDtoOut;
import fr.initiativedeuxsevres.ttm.service.UserService;

/**
 * Controller générique pour la gestion des parrains et des porteurs.
 **/

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDtoOut createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
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