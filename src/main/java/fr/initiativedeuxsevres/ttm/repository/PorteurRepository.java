package fr.initiativedeuxsevres.ttm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.initiativedeuxsevres.ttm.model.PorteurEntity;

@Repository
public interface PorteurRepository extends JpaRepository<PorteurEntity, Long> {
    Optional<PorteurEntity> findByUsername (String username);
}