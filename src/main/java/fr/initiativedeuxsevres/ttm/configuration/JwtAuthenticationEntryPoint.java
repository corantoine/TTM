package fr.initiativedeuxsevres.ttm.configuration;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Classe permettant de gérer les erreurs d'authentification JWT

// Annotation indiquant que la classe est un composant Spring, similaire à @Bean pour les méthodes
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // Méthode appelée à chaque fois qu'une exception d'auth se produit.
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        // renvoie une erreur 401 si l'auth échoue
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }

}
