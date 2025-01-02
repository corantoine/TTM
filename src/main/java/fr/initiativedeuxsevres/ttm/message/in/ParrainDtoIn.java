package fr.initiativedeuxsevres.ttm.message.in;

import lombok.Data;

@Data
public class ParrainDtoIn {
    private String entrepriseRepresentee;
    private String presentationParcours;
    private String typeDeReseau;
    private String domaineExpertise;
    private String lieuxDeplacement;
}
