package fr.initiativedeuxsevres.ttm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.initiativedeuxsevres.ttm.model.Role;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Crée un nouvel utilisateur et le sauvegarde
     * @param user L'entité user à créer
     * @return L'entité user créée et sauvegardée
     */
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
}
