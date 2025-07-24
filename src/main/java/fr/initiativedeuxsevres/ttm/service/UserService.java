package fr.initiativedeuxsevres.ttm.service;

import java.util.List;
import java.util.Optional;

import fr.initiativedeuxsevres.ttm.message.in.LoginDto;
import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.message.out.LoginResult;
import fr.initiativedeuxsevres.ttm.message.out.UserDtoOut;
import fr.initiativedeuxsevres.ttm.model.UserEntity;

//@Service
public interface UserService {
    //    @Autowired
    //    private UserRepository userRepository;
    //    @Autowired
    //    private AuthenticationManager authenticationManager;
    //    @Autowired
    //    private JwtTokenProvider jwtTokenProvider;
    //    @Autowired
    //    private BCryptPasswordEncoder bCryptPasswordEncoder;
    //
    //    //    public UserService(UserRepository userRepository, @Lazy AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
    //    //            BCryptPasswordEncoder bCryptPasswordEncoder) {
    //    //        this.userRepository = userRepository;
    //    //        this.authenticationManager = authenticationManager;
    //    //        this.jwtTokenProvider = jwtTokenProvider;
    //    //        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    //    //    }
    //
    //    /**
    //     * Crée un nouvel utilisateur et le sauvegarde
    //     *
    //     * @param userDto L'entité user à créer
    //     * @return L'entité user créée et sauvegardée
    //     */
    //    public UserDtoOut createUser(@RequestBody UserDto userDto) {
    //        UserEntity user = UserDtoToUserEntityMapper.convertUserDtoToUserEntity(userDto);
    //        String motDePasseEncrypte = bCryptPasswordEncoder.encode(user.getPassword());
    //        user.setPassword(motDePasseEncrypte);
    //        return UserEntityToUserOutputMapper.convertUserEntityToUserDtoOut(userRepository.save(user));
    //    }
    //
    //    public void deleteUserById(Long userId) {
    //        Optional<UserEntity> maybeUser = userRepository.findById(userId);
    //        if (maybeUser.isPresent()) {
    //            userRepository.deleteById(userId);
    //            return;
    //        }
    //        String erreurMessage = String.format("L'utilisateur %d n'existe pas", userId);
    //        throw new NoSuchElementException(erreurMessage);
    //    }
    //
    //    public String login(LoginDto loginDto) {
    //        Authentication authentication = authenticationManager.authenticate(
    //                new UsernamePasswordAuthenticationToken(
    //                        loginDto.getUsername(),
    //                        loginDto.getPassword()
    //                )
    //        );
    //        SecurityContextHolder.getContext().setAuthentication(authentication);
    //        return jwtTokenProvider.generateToken(authentication);
    //    }

    UserDtoOut createUser(UserDto userDto);

    //    String login(LoginDto loginDto);
    LoginResult login(LoginDto loginDto);

    List<UserEntity> findAllUsers();

    Optional<UserEntity> getUserByUsername(String username);

    Optional<UserEntity> getUserByUsernameOrEmail(String usernameOrEmail);

}



