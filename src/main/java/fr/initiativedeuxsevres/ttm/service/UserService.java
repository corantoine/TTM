package fr.initiativedeuxsevres.ttm.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.initiativedeuxsevres.ttm.model.ParrainEntity;
import fr.initiativedeuxsevres.ttm.model.PorteurEntity;
import fr.initiativedeuxsevres.ttm.model.Role;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.ParrainRepository;
import fr.initiativedeuxsevres.ttm.repository.PorteurRepository;

//@Service
//public class UserService {



    //TODO: Implémenter ce service en utilisant la généricité afin de supprimer le PorteurService et ParrainService



//    private final PorteurRepository porteurRepository;
//    private final ParrainRepository parrainRepository;
//
//    @Autowired
//    public UserService(PorteurRepository porteurRepository, ParrainRepository parrainRepository) {
//        this.porteurRepository = porteurRepository;
//        this.parrainRepository = parrainRepository;
//    }
//
//    /**
//     * Crée un nouvel utilisateur et le sauvegarde
//     *
//     * @param user L'entité user à créer
//     * @return L'entité user créée et sauvegardée
//     */
//    public PorteurEntity createPorteur(PorteurEntity porteur) {
//        return porteurRepository.save(porteur);
//    }
//
//    public ParrainEntity createParrain(ParrainEntity parrain) {
//        return parrainRepository.save(parrain);
//    }
//}
////
////    public void deleteUserById(Long userId) {
////        Optional<UserEntity> maybeUser = userRepository.findById(userId);
////        if (maybeUser.isPresent()) {
////            userRepository.deleteById(userId);
////            return;
////        }
////        String erreurMessage = String.format("L'utilisateur %d n'existe pas", userId);
////        throw new NoSuchElementException(erreurMessage);
////    }
//}



