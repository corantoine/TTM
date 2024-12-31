package fr.initiativedeuxsevres.ttm.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import fr.initiativedeuxsevres.ttm.converter.in.UserDtoToUserEntityMapper;
import fr.initiativedeuxsevres.ttm.converter.out.UserEntityToUserOutputMapper;
import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.message.out.UserDtoOut;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Crée un nouvel utilisateur et le sauvegarde
     *
     * @param userDto L'entité user à créer
     * @return L'entité user créée et sauvegardée
     */
    public UserDtoOut createUser(@RequestBody UserDto userDto) {
        UserEntity user = UserDtoToUserEntityMapper.convertUserDtoToUserEntity(userDto);
        return UserEntityToUserOutputMapper.convertUserEntityToUserDtoOut(userRepository.save(user));
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



