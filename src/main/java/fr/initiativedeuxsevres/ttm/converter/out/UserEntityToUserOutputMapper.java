package fr.initiativedeuxsevres.ttm.converter.out;

import fr.initiativedeuxsevres.ttm.message.out.UserDtoOut;
import fr.initiativedeuxsevres.ttm.model.UserEntity;

public class UserEntityToUserOutputMapper {
    /**
     * Convertit une entité utilisateur en un DTO utilisateur.
     * Cette méthode prend une entité utilisateur en entrée et retourne un objet DTO
     * contenant les mêmes informations. Cela permet de transférer les données utilisateur
     * de manière sécurisée et structurée entre les différentes couches de l'application.
     *
     * @param userEntity l'entité utilisateur à convertir
     * @return un objet UserDtoOut contenant les informations de l'utilisateur
     */
    public static UserDtoOut convertUserEntityToUserDtoOut(UserEntity userEntity) {
        return UserDtoOut.builder()
                .id(userEntity.getId())
                .nom(userEntity.getNom())
                .prenom(userEntity.getPrenom())
                .username(userEntity.getUsername())
                .plateformeInitiative(userEntity.getPlateformeInitiative())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .disponibilites(userEntity.getDisponibilites())
                .role(userEntity.getRole())
                .build();
    }
}
