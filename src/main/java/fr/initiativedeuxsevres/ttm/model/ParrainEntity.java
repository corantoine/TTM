package fr.initiativedeuxsevres.ttm.model;

import lombok.Data;

@Data
public class ParrainEntity extends UserEntity {
    private String entrepriseRepresentee;
    private String plateformeInitiative;
    private String codeAcces;
    private String presentationParcours;
    private String branchesBonReseau;
    private String domaineExpertise;
    private String lieuxDeplacement;
    private String disponibilites;
}