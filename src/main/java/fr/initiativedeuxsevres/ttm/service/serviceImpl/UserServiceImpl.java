package fr.initiativedeuxsevres.ttm.service.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import fr.initiativedeuxsevres.ttm.configuration.JwtTokenProvider;
import fr.initiativedeuxsevres.ttm.converter.in.UserDtoToUserEntityMapper;
import fr.initiativedeuxsevres.ttm.converter.out.UserEntityToUserOutputMapper;
import fr.initiativedeuxsevres.ttm.message.in.LoginDto;
import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.message.out.LoginResult;
import fr.initiativedeuxsevres.ttm.message.out.UserDtoOut;
import fr.initiativedeuxsevres.ttm.message.out.UserProfileDtoOut;
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
    //    public UserDtoOut createUser(@RequestBody UserDto userDto) {
    //        UserEntity user = UserDtoToUserEntityMapper.convertUserDtoToUserEntity(userDto);
    //        String motDePasseEncrypte = passwordEncoder.encode(user.getPassword());
    //        user.setPassword(motDePasseEncrypte);
    //        return UserEntityToUserOutputMapper.convertUserEntityToUserDtoOut(userRepository.save(user));
    //    }
    @Override
    public UserDtoOut createUser(@RequestBody UserDto userDto) {
        // Vérification des mots de passe
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            throw new IllegalArgumentException("Les mots de passe ne correspondent pas.");
        }

        if (!isPasswordStrong(userDto.getPassword())) {
            throw new IllegalArgumentException("Le mot de passe ne respecte pas les critères de sécurité.");
        }

        // Conversion DTO -> Entity
        UserEntity user = UserDtoToUserEntityMapper.convertUserDtoToUserEntity(userDto);

        // Hachage du mot de passe
        String motDePasseEncrypte = passwordEncoder.encode(user.getPassword());
        user.setPassword(motDePasseEncrypte);
        user.setFirstLogin(true);

        // Sauvegarde en base
        UserEntity savedUser = userRepository.save(user);

        // Conversion Entity -> DTO de sortie
        return UserEntityToUserOutputMapper.convertUserEntityToUserDtoOut(savedUser);
    }

    private boolean isPasswordStrong(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$";
        return password != null && password.matches(regex);
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

    //    public String login(LoginDto loginDto) {
    //        Authentication authentication = authenticationManager.authenticate(
    //                new UsernamePasswordAuthenticationToken(
    //                        loginDto.getUsername(),
    //                        loginDto.getPassword()
    //                )
    //        );
    //        SecurityContextHolder.getContext().setAuthentication(authentication);
    //        //TODO si ca ne marche pas
    //        // Récupération du user
    //        Optional<UserEntity> maybeUser = userRepository.findByUsername(
    //                loginDto.getUsername()
    //        );
    //        if (maybeUser.isPresent()) {
    //            UserEntity user = maybeUser.get();
    //            // Mise à jour de firstLogin si 1ere connexion
    //            if (user.isFirstLogin()) {
    //                user.setFirstLogin(false);
    //                userRepository.save(user);
    //            }
    //        }
    //
    //        return jwtTokenProvider.generateToken(authentication);
    //    }

    //    @Override
    //    public String login(LoginDto loginDto) {
    //        Authentication authentication = authenticationManager.authenticate(
    //                new UsernamePasswordAuthenticationToken(
    //                        loginDto.getUsername(),
    //                        loginDto.getPassword()
    //                )
    //        );
    //        SecurityContextHolder.getContext().setAuthentication(authentication);
    //
    //        Optional<UserEntity> maybeUser = userRepository.findByUsername(loginDto.getUsername());
    //        maybeUser.ifPresent(user -> {
    //            if (user.isFirstLogin()) {
    //                user.setFirstLogin(false);
    //                userRepository.save(user);
    //            }
    //        });
    //
    //        return jwtTokenProvider.generateToken(authentication);
    //    }

    @Override
    public LoginResult login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Optional<UserEntity> maybeUser = userRepository.findByUsername(loginDto.getUsername());
        boolean firstLogin = false;

        if (maybeUser.isPresent()) {
            UserEntity user = maybeUser.get();
            firstLogin = user.isFirstLogin();

            if (firstLogin) {
                System.out.println("Premiere co detectée, maj de FIRST LOGIN a false.");
                user.setFirstLogin(false);
                userRepository.save(user);
            }
        }

        String token = jwtTokenProvider.generateToken(authentication);
        return new LoginResult(token, firstLogin);
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

    @Override
    public UserProfileDtoOut getUserProfile(String usernameOrEmail) {
        UserEntity user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        return UserProfileDtoOut.builder()
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .username(user.getUsername())
                .role(user.getRole())
                .plateformeInitiative(user.getPlateformeInitiative())
                .build();
    }

}
