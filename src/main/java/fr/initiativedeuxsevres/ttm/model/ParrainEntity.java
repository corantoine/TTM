package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "parrains")
public class ParrainEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String entrepriseRepresentee;
    private String presentationParcours;
    private String typeDeReseau;
    private String domaineExpertise;
    private String lieuxDeplacement;

}