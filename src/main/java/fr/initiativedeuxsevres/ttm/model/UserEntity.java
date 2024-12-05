package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@MappedSuperclass
public class UserEntity {
    @Id
    @GeneratedValue
    Long id;
    String username;
    String nom;
    String prenom;
    String plateformeInitiative;
    Role role;

    public UserEntity() {
    }
}