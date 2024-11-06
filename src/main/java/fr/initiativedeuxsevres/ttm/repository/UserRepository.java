package fr.initiativedeuxsevres.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.initiativedeuxsevres.ttm.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {
}
