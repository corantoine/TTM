package fr.initiativedeuxsevres.ttm.message.out;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PorteurDtoOut {
    private Long id;
    private String entreprise;
    private String dateLancement;
    private String domaineActivite;
    private String description;
    private String besoinsPotentiels;
    private String lieuActivite;
}
