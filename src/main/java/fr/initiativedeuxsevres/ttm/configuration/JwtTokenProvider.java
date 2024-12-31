package fr.initiativedeuxsevres.ttm.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

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
    public String generateToken(Authentication authentication){

        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder() // initialise un constructeur de JWT
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key())
                .compact(); // finalise la construction du token et le convertit en une chaîne de caractères

        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    // Méthode qui extrait le nom d'utilisateur d'un JWT
    public String getUsername(String token){

        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // validate JWT token
    public boolean validateToken(String token){
            Jwts.parser()
                    .verifyWith((SecretKey) key())
                    .build()
                    .parse(token);
            return true;

    }
}