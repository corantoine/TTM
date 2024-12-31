package fr.initiativedeuxsevres.ttm.repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.initiativedeuxsevres.ttm.model.ParrainEntity;

@Repository
public interface ParrainRepository extends JpaRepository<ParrainEntity, Long> {

}
