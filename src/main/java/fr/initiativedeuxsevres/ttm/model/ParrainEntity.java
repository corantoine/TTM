package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Table(name = "parrains")
public class ParrainEntity extends UserEntity {
    private String entrepriseRepresentee;
    private String plateformeInitiative;
    private String presentationParcours;
    private String branchesBonReseau;
    private String domaineExpertise;
    private String lieuxDeplacement;
    private String disponibilites;
}