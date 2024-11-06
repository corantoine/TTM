package fr.initiativedeuxsevres.ttm.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.initiativedeuxsevres.ttm.model.Role;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserEntity createUser(UserEntity user1) {
        return userRepository.save(user1);
    }
}
