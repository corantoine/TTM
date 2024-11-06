package fr.initiativedeuxsevres.ttm.service;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    public void deleteUserById(Long userId) {
        Optional<UserEntity> maybeUser = userRepository.findById(userId);
        if (maybeUser.isPresent()) {
            userRepository.deleteById(userId);
            return;
        }
        String erreurMessage = String.format("L'utilisateur %d n'existe pas", userId);
        throw new NoSuchElementException(erreurMessage);
    }
}
