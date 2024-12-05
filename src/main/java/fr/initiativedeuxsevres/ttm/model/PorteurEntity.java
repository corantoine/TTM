package fr.initiativedeuxsevres.ttm.model;

import lombok.Data;

@Data
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