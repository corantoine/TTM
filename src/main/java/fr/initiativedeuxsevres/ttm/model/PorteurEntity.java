package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Builder
@Table(name = "porteurs")
public class PorteurEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String entreprise;
    private String dateLancement;
    private String domaineActivite;
    private String description;
    private String besoinsPotentiels;
    private String lieuActivite;

}