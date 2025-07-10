package fr.initiativedeuxsevres.ttm.service.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import fr.initiativedeuxsevres.ttm.configuration.JwtTokenProvider;
import fr.initiativedeuxsevres.ttm.converter.in.UserDtoToUserEntityMapper;
import fr.initiativedeuxsevres.ttm.converter.out.UserEntityToUserOutputMapper;
import fr.initiativedeuxsevres.ttm.message.in.LoginDto;
import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.message.out.UserDtoOut;
import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import fr.initiativedeuxsevres.ttm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    //    @Autowired
    //    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //    public UserService(UserRepository userRepository, @Lazy AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
    //            BCryptPasswordEncoder bCryptPasswordEncoder) {
    //        this.userRepository = userRepository;
    //        this.authenticationManager = authenticationManager;
    //        this.jwtTokenProvider = jwtTokenProvider;
    //        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    //    }

    /**
     * Crée un nouvel utilisateur et le sauvegarde
     *
     * @param userDto L'entité user à créer
     * @return L'entité user créée et sauvegardée
     */
    public UserDtoOut createUser(@RequestBody UserDto userDto) {
        UserEntity user = UserDtoToUserEntityMapper.convertUserDtoToUserEntity(userDto);
        String motDePasseEncrypte = passwordEncoder.encode(user.getPassword());
        user.setPassword(motDePasseEncrypte);
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

    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<UserEntity> getUserByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }

}
