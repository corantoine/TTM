package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    Long id;
    String nom;
    String prenom;
    String plateformeInitiative;
    Role role;
}