package fr.initiativedeuxsevres.ttm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.initiativedeuxsevres.ttm.message.in.LoginDto;
import fr.initiativedeuxsevres.ttm.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsernameOrEmail(String username, String email);

    String login(LoginDto loginDto);
}
