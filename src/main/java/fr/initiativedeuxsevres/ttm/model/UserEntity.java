package fr.initiativedeuxsevres.ttm.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// Lombok génère automatiquement les getters, setters, toString, etc.
@Data
@AllArgsConstructor
@NoArgsConstructor
// Lombok permet de créer des objets avec un builder tout en supportant l'héritage
@Builder
// Indique que cette classe est une superclasse mappée, utilisée comme base pour d'autres entités
// Aucune table ne sera créée pour cette classe dans la base de données
//@MappedSuperclass
@Entity
@Table(name = "users")
public class UserEntity {
    // Indique que ce champ est la clé primaire de l'entité
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;

    // Champ pour le nom d'utilisateur, doit être unique et non nul
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String email;
    private String disponibilites;
    private String plateformeInitiative;
    //TODO : LIQUIBASE
    @OneToOne
    @JoinColumn(name = "id_parrain", nullable = true)
    private ParrainEntity parrain;
    @OneToOne
    @JoinColumn(name = "id_porteur", nullable = true)
    private PorteurEntity porteur;
//TODO : creationDate & modificationDate
    // Indique que ce champ est une collection de rôles, stockée dans une table séparée dans la base de données
    //TODO : Voir si pour utiliser Fetch join ou Entity Graph pour remplacer FetchType.EAGER
//    @ElementCollection(fetch = FetchType.EAGER)
    // Indique que les rôles seront stockés sous forme de chaînes de caractères dans la base de données
    @Enumerated(EnumType.STRING)
    private Role role;

}