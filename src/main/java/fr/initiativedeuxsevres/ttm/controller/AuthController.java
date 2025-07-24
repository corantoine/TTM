package fr.initiativedeuxsevres.ttm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.initiativedeuxsevres.ttm.message.in.JwtAuthResponse;
import fr.initiativedeuxsevres.ttm.message.in.LoginDto;
import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.message.out.LoginResult;
import fr.initiativedeuxsevres.ttm.message.out.UserDtoOut;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import fr.initiativedeuxsevres.ttm.service.UserService;

@RestController
@RequestMapping
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;

    public AuthController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/register")
    public UserDtoOut createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    //    @PostMapping("/login")
    //    public ResponseEntity<JwtAuthResponse> logInUser(@RequestBody LoginDto loginDto) {
    //        String token = userService.login(loginDto);
    //
    //        Optional<UserEntity> maybeUser =
    //                userService.getUserByUsername(loginDto.getUsername());
    //        boolean firstLogin = maybeUser.map(UserEntity::isFirstLogin).orElse(false);
    //
    //        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(token, firstLogin);
    //        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    //    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> logInUser(@RequestBody LoginDto loginDto) {
        LoginResult result = userService.login(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(result.getToken(), result.isFirstLogin());
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}
