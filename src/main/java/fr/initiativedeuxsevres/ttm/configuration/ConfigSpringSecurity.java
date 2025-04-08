package fr.initiativedeuxsevres.ttm.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import fr.initiativedeuxsevres.ttm.model.Role;

@Configuration // Annotation indiquant que cette classe contient des config Spring
@EnableWebSecurity // Active la securité web Spring
public class ConfigSpringSecurity {

    //    private final UserDetailsService userDetailsService; // Interface utilisée pour récupérer les informations des utilisateurs
    //    private final PasswordEncoder passwordEncoder; // Interface utilisée pour encoder les passwords
    private final JwtAuthenticationFilter jwtAuthenticationFilter; // Votre filtre JWT
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public ConfigSpringSecurity(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
    //    passwordEncoder, UserDetailsService userDetailsService,
    //            JwtAuthenticationFilter jwtAuthenticationFilter) {
    //        this.passwordEncoder = passwordEncoder;
    //        this.userDetailsService = userDetailsService;
    //        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    //    }

    @Bean
    //TODO effectuer des tests pour les autorisations mises en place
    //Définition d'un bean pour l'encodage des mots de passe utilisant BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configure la stratégie de gestion du contexte de sécurité
    @Bean
    public SecurityContextHolderStrategy securityContextHolderStrategy() {
        return SecurityContextHolder.getContextHolderStrategy();
    }

    // sauvegarde de sessions http
    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //configuration des règles de sécurité pour les requêtes http
        // Configure la page de connexion
        //TODO : Quand ma page login sera créee --> rajouter .loginPage("/cheminDeMaPageLogin") pour spécifier l'URL de ma page de login personnalisée
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> {
                    auth
                            // Autorise l'accès à tout le monde pour les pages d'accueil et d'inscription + la version stylisée du site
                            //TODO : autoriser route register seulement a ladmin
                            .requestMatchers("/", "/register").permitAll()
                            .requestMatchers("/css/**", "/favicon.ico").permitAll()
                            .requestMatchers("/picture/**").permitAll()
                            // Autoriser uniquement les ADMIN a acceder à ces pages
                            .requestMatchers("/kpis").hasRole(Role.ADMIN.name())
                            //TODO ici on utilise %20 pour représenter l'espace car c'est la manière standard d'encoder les espaces selon les spécifications des URL
                            //TODO dans mon controller, mettre "/gestion d'utilisateurs"
                            .requestMatchers("/gestion%20d'utilisateurs").hasRole(Role.ADMIN.name())
                            // Autoriser uniquement l'accès aux "PARRAIN" ou "PORTEUR"
                            .requestMatchers("/espace%20d'echange").hasAnyRole(Role.PARRAIN.name(),
                                    Role.PORTEUR.name()) // Utilisation de hasAnyRole pour spécifier plusieurs rôles pouvant avoir acès a une route
                            .requestMatchers("/matchs").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name())
                            .requestMatchers("/profile").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name())
                            .requestMatchers("/rendez-vous").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name())
                            // Autoriser l'accès aux parrains / porteurs / admin
                            .requestMatchers("/fil%20des%20profils").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name(), Role.ADMIN.name())
                            .requestMatchers("/notifications").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name(), Role.ADMIN.name())
                            .requestMatchers("/boite%20a%20outils").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name(), Role.ADMIN.name());
                    // On transforme la fonction lambda
                }).formLogin(login -> login
                        .loginPage("/login")
                        //                        .defaultSuccessUrl("/", true)// Configure la page de connexion
                        .permitAll()) // Permet à tout le monde d'accéder à la page de connexion
                .logout(logout -> logout// Configure la déconnexion
                        //TODO : ajouter redirection sur la page d'accueil lors d'une déconnexion
                        .permitAll()) // Permet à tout le monde de se déconnecter
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Ajout du filtre JWT
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}