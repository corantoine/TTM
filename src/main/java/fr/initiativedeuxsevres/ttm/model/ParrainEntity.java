package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private String presentationParcours;
    private String typeDeReseau;
    private String domaineExpertise;
    private String lieuxDeplacement;
    private String disponibilites;


}