package fr.initiativedeuxsevres.ttm.converter.in;

import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.model.UserEntity;

public class UserDtoToUserEntityMapper {

    public static UserEntity convertUserDtoToUserEntity(UserDto userDto) {
        return UserEntity.builder()
                .nom(userDto.getNom())
                .prenom(userDto.getPrenom())
                .username(userDto.getUsername())
                .plateformeInitiative(userDto.getPlateformeInitiative())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .disponibilites(userDto.getDisponibilites())
                .role(userDto.getRole())
                .build();
    }

}
