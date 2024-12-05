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
@Table(name = "porteurs")
public class PorteurEntity extends UserEntity {
    private String entreprise;
    private String plateformeInitiative;
    private String dateLancement;
    private String domaineActivite;
    private String description;
    private String besoinsPotentiels;
    private String lieuActivite;
    private String disponibilites;

}