package fr.initiativedeuxsevres.ttm.converter.in;

import fr.initiativedeuxsevres.ttm.message.in.UserDto;
import fr.initiativedeuxsevres.ttm.model.UserEntity;

public class UserDtoToUserEntityMapper {

    /**
     * Convertit un DTO utilisateur en une entité utilisateur.
     * Cette méthode prend un objet UserDto en entrée et retourne un objet UserEntity
     * contenant les mêmes informations. Cela permet de transférer les données utilisateur
     * de manière sécurisée et structurée entre les différentes couches de l'application.
     *
     * @param userDto le DTO utilisateur à convertir
     * @return un objet UserEntity contenant les informations de l'utilisateur
     */
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
