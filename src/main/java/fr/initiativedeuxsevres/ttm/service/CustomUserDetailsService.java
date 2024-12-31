package fr.initiativedeuxsevres.ttm.service;

import fr.initiativedeuxsevres.ttm.model.UserEntity;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Indique que cette classe est un service Spring
@Service
// Lombok génère un constructeur avec tous les arguments
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // Dépendance injectée pour accéder aux utilisateurs dans la base de données
    private UserRepository userRepository;

    // La méthode loadUserByUsername est utilisée pour récupérer les détails d'un utilisateur à partir de son nom d'utilisateur ou de son email
    // Elle vérifie si l'utilisateur existe dans la base de données et renvoie ses informations
    // Si l'utilisateur n'est pas trouvé, elle lance une exception
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Recherche l'utilisateur par son nom d'utilisateur ou son email
        UserEntity user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        // GrantedAuthority est une interface de Spring Security qui représente une autorité accordée à un utilisateur.
        // Une autorité peut être un rôle ou une permission.
        GrantedAuthority authorities =
        new SimpleGrantedAuthority(user.getRole().name());


        // Retourne un objet UserDetails avec les informations de l'utilisateur
        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                user.getPassword(),
                List.of(authorities)
        );
    }
}