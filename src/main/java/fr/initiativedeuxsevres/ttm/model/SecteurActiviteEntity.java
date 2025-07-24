package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "secteurs")
@Data
@Builder
public class SecteurActiviteEntity {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    int idNumber;
}
