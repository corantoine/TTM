package fr.initiativedeuxsevres.ttm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.initiativedeuxsevres.ttm.model.ParrainEntity;
import fr.initiativedeuxsevres.ttm.model.PorteurEntity;
import fr.initiativedeuxsevres.ttm.service.ParrainService;
import fr.initiativedeuxsevres.ttm.service.PorteurService;
import fr.initiativedeuxsevres.ttm.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PorteurService porteurService;

    @Autowired
    private ParrainService parrainService;



    @PostMapping("/porteur")
    public PorteurEntity createPorteur(@RequestBody PorteurEntity porteur) {
        return PorteurService.createPorteur(porteur);
    }

    @PostMapping("/parrain")
    public ParrainEntity createParrain(@RequestBody ParrainEntity parrain) {
        return ParrainService.createParrain(parrain);
    }
}