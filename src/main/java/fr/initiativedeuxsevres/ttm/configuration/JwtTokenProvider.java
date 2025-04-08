package fr.initiativedeuxsevres.ttm.configuration;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

// Classe qui gère les opérations liées au JWT (génération de token, validation de token, Extraction d'infos)
@Component
public class JwtTokenProvider {

    //Spring va chercher la valeur de jwt-secret dans le application.yml et initialiser la String jwtSecret à partir de ça.
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    // Spring récupère la valeur de jwt-expiration-milliseconds dans application.yml pour initialiser la String jwtExpirationDate
    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    // Méthode qui crée un JWT pour un utilisateur authentifié. Elle définit le payload et les informations à stocker dans le JWT.
    //TODO ajout du rôle dans le payload du token
    public String generateToken(Authentication authentication) {
        // récupère le username
        String username = authentication.getName();
        Date currentDate = new Date();
        // date d'expiration du token
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        // construction du token
        return Jwts.builder()
                .subject(username) // définit le sujet du token
                .issuedAt(new Date())// date d'émission du token
                .expiration(expireDate) // date d'expiration du token
                .signWith(key()) // signe le token avec la secret key
                .compact(); // finalise la construction du token et le convertit en une String
    }

    // méthode pour générer la secret key pour signer le token
    private SecretKey key() {
        //décode la secret key et génère une clé HMAC
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    // Méthode qui récup le username à partir d'un token
    public String getUsername(String token) {
        return Jwts.parser() // crée un parser
                .verifyWith(key())
                .build() //construit le parser
                .parseSignedClaims(token) //parse les claims
                .getPayload() // recup le payload du token
                .getSubject(); // recup le username
    }

    // validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parse(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}