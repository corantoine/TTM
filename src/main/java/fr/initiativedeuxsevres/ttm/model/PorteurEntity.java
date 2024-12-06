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
    public String entreprise;
    public String dateLancement;
    public String domaineActivite;
    public String description;
    public String besoinsPotentiels;
    public String lieuActivite;
    public String disponibilites;



}