//package fr.initiativedeuxsevres.ttm.configuration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import fr.initiativedeuxsevres.ttm.model.Role;
//@Configuration // Annotation indiquant que cette classe contient des config Spring
//@EnableWebSecurity // Active la securité web Spring
//public class ConfigSpringSecurity {
//    private final UserDetailsService userDetailsService; // Interface utilisée pour récupérer les informations des utilisateurs
//    private final PasswordEncoder passwordEncoder; // Interface utilisée pour encoder les passwords
//    @Autowired
//    public ConfigSpringSecurity(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
//        this.passwordEncoder = passwordEncoder;
//        this.userDetailsService = userDetailsService;
//    }
//    @Bean
//    //TODO effectuer des tests pour les autorisations mises en place
//    //Définition d'un bean pour l'encodage des mots de passe utilisant BCryptPasswordEncoder
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    //Créer un utilisateur en dur pour tester l'accès aux différentes routes de l'application sans avoir besoin de configurer la bdd
//    // Ne pas oublier d'ajuster les perm sur les routes pour faire les tests !
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        return new InMemoryUserDetailsManager(
//                User .builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("pass"))
//                        .roles("PARRAIN")
//                        .build(),
//                User.builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("pass"))
//                        .roles("PORTEUR")
//                        .build()
//                //             User.builder()
//                //                 .username("admin")
//                //                 .password(passwordEncoder().encode("pass"))
//                //                 .roles("ADMIN")
//                //                 .build()
//        );
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        //configuration des règles de sécurité pour les requêtes http
//        // Configure la page de connexion
//        //TODO : Quand ma page login sera créee --> rajouter .loginPage("/cheminDeMaPageLogin") pour spécifier l'URL de ma page de login personnalisée
//        return http.authorizeHttpRequests((auth) -> {
//                    auth
//                            // Autorise l'accès à tout le monde pour les pages d'accueil et d'inscription + la version stylisée du site
//                            .requestMatchers("/", "/register/**").permitAll()
//                            .requestMatchers("/css/**", "/favicon.ico").permitAll()
//                            .requestMatchers("/picture/**").permitAll()
//                            // Autoriser uniquement les ADMIN a acceder à ces pages
//                            .requestMatchers("/kpis").hasRole(Role.ADMIN.name())
//                            //TODO ici on utilise %20 pour représenter l'espace car c'est la manière standard d'encoder les espaces selon les spécifications des URL
//                            //TODO dans mon controller, mettre "/gestion d'utilisateurs"
//                            .requestMatchers("/gestion%20d'utilisateurs").hasRole(Role.ADMIN.name())
//                            // Autoriser uniquement l'accès aux "PARRAIN" ou "PORTEUR"
//                            .requestMatchers("/espace%20d'echange").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name()) // Utilisation de hasAnyRole pour spécifier plusieurs rôles pouvant avoir acès a une route
//                            .requestMatchers("/matchs").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name())
//                            .requestMatchers("/profile").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name())
//                            .requestMatchers("/rendez-vous").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name())
//                            // Autoriser l'accès aux parrains / porteurs / admin
//                            .requestMatchers("/fil%20des%20profils").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name(), Role.ADMIN.name())
//                            .requestMatchers("/notifications").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name(), Role.ADMIN.name())
//                            .requestMatchers("/boite%20a%20outils").hasAnyRole(Role.PARRAIN.name(), Role.PORTEUR.name(), Role.ADMIN.name());
//                    // On transforme la fonction lambda
//                    // }).formLogin(login -> login // Configure la page de connexion
//                    //TODO : Quand ma page login sera créee --> rajouter .loginPage("/cheminDeMaPageLogin") pour spécifier l'URL de ma page de login personnalisée
//                    //.permitAll()) // Permet à tout le monde d'accéder à la page de connexion
//                    // par une méthode de référence :
//                }).formLogin(AbstractAuthenticationFilterConfigurer::permitAll) // Permet à tout le monde d'accéder à la page de connexion
//                .logout(logout -> logout // Configure la déconnexion
//                        //TODO : ajouter redirection sur la page d'accueil lors d'une déconnexion
//                        .permitAll()) // Permet à tout le monde de se déconnecter
//                .build();
//    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder);
//    }
//}