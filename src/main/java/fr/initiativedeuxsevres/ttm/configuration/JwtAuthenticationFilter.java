package fr.initiativedeuxsevres.ttm.configuration;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Execute Before Executing Spring Security Filters
// Validate the JWT Token and Provides user details to Spring Security for Authentication

// Rôle principal de la classe : filtrer les requêtes HTTP et vérifier la présence et la validité d'un JWT
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    // UserDetailsService interface de SSecurity utilisée pour charger les détails de l'user à partir d'une source de données.
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // Recup du token
        String token = getTokenFromRequest(request); // Extrait le token JWT de l'en-tête Authorization de la requête HTTP

        // Validation du Token
        if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
            String username = jwtTokenProvider.getUsername(token); // Token present && valide ? extraction du username a partir du token
            UserDetails userDetails = userDetailsService.loadUserByUsername(username); // charge les détails de l'user

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken); // Maj du contexte de sécurité ?
        }

        filterChain.doFilter(request, response); // Poursuite de la chaine de filtres pour continuer le traitement de la requête
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7,
                    bearerToken.length()); //Cette méthode extrait le token JWT de l'en-tête Authorization de la requête HTTP. Si l'en-tête commence par "Bearer ", elle retourne le token sans le préfixe "Bearer ".
        }

        return null;
    }
}