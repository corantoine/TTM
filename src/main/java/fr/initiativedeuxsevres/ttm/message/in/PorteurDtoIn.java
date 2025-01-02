package fr.initiativedeuxsevres.ttm.message.in;

import lombok.Data;

@Data
public class PorteurDtoIn {
    private String entreprise;
    private String dateLancement;
    private String domaineActivite;
    private String description;
    private String besoinsPotentiels;
    private String lieuActivite;
}
