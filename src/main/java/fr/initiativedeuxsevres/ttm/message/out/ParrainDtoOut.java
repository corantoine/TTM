package fr.initiativedeuxsevres.ttm.message.out;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParrainDtoOut {
    private Long id;
    private String entrepriseRepresentee;
    private String presentationParcours;
    private String typeDeReseau;
    private String domaineExpertise;
    private String lieuxDeplacement;
}
