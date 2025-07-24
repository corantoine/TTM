package fr.initiativedeuxsevres.ttm.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
//@EntityListeners(AuditingEntityListener.class) : Va avec @CreatedDate
public class UserEntity {
    // Indique que ce champ est la clé primaire de l'entité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    //    FIXME: voir si c'est mieux que @PrePersist : @CreatedDate
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    //TODO : LIQUIBASE
    @OneToOne
    @JoinColumn(name = "id_parrain", nullable = true)
    private ParrainEntity parrain;
    @OneToOne
    @JoinColumn(name = "id_porteur", nullable = true)
    private PorteurEntity porteur;
    @Enumerated(EnumType.STRING)
    private Role role;
    // Champ permettant de vérifier si c'est la premiere connexion de l'utilisateur afin qu'il complète son profil
    @Column(name = "first_login")
    private Boolean firstLogin;

    // Annotation permettant d'exécuter une méthode spécifique avant qu'une entité ne soit persistée en bdd.
    // Ici, cela permet d'entrer la date du jour dans la colonne creationDate en BDD avant d'enregistrer l'utilisateur.
    @PrePersist
    private void setCreationDate() {
        creationDate = LocalDateTime.now();
    }

    @PreUpdate
    private void setAccountLastUpdatedTime() {
        modificationDate = LocalDateTime.now();
    }

    public boolean isFirstLogin() {
        return Boolean.TRUE.equals(firstLogin);
    }

}