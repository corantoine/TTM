package fr.initiativedeuxsevres.ttm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
    String nom;
    String prenom;
    @Column(nullable = false, unique = true)
    String username;
    String password;
    String email;
    String plateformeInitiative;
    Role role;

    public UserEntity() {
    }
}