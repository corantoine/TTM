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

import jakarta.servlet.Filter;

@Configuration // Annotation indiquant que cette classe contient des config Spring
@EnableWebSecurity // Active la securité web Spring
public class ConfigSpringSecurity {

    //    private final UserDetailsService userDetailsService; // Interface utilisée pour récupérer les informations des utilisateurs
    //    private final PasswordEncoder passwordEncoder; // Interface utilisée pour encoder les passwords
    private final JwtAuthenticationFilter jwtAuthenticationFilter; // Votre filtre JWT
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ConfigSpringSecurity(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAuthenticationFilter jwtAuthenticationFilter,
            JwtTokenProvider jwtTokenProvider) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtTokenProvider = jwtTokenProvider;
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
        return http.
                csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                )

                .authorizeHttpRequests((auth) -> {
                    auth
                            // Autorise l'accès à tout le monde pour les pages d'accueil et d'inscription + la version stylisée du site
                            //TODO : autoriser route register seulement a ladmin
                            .requestMatchers("/", "/**/{path:[^\\.]+}", "/register", "/login").permitAll()
                            .requestMatchers("/css/**").permitAll()
                            .requestMatchers("/users/myprofil").authenticated()
                            .requestMatchers("/picture/**").permitAll();
                    //TODO ici on utilise %20 pour représenter l'espace car c'est la manière standard d'encoder les espaces selon les spécifications des URL
                    //TODO dans mon controller, mettre "/gestion d'utilisateurs"
                })
                //                }).formLogin(login -> login
                //                        .loginPage("/login")
                //                        //                        .defaultSuccessUrl("/", true)// Configure la page de connexion
                //                        .permitAll()) // Permet à tout le monde d'accéder à la page de connexion
                //                .logout(logout -> logout// Configure la déconnexion
                //                        //TODO : ajouter redirection sur la page d'accueil lors d'une déconnexion
                //                        .permitAll()) // Permet à tout le monde de se déconnecter
                .addFilterBefore((Filter) jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Ajout du filtre JWT
                .build();
    }

    //    @Bean
    //    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //        http
    //                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
    //                .and()
    //                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), BasicAuthenticationFilter.class)
    //                .csrf().disable()
    //                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //                .and()
    //                .authorizeHttpRequests((requests) -> requests
    //                        .requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
    //                        .anyRequest().authenticated())
    //        ;
    //        return http.build();
    //    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}