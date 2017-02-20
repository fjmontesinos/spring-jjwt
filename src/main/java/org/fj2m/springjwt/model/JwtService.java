package org.fj2m.springjwt.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.fj2m.springjwt.model.domain.MinimalProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static java.time.ZoneOffset.UTC;

/**
 * Created by javier-montesinos on 19/02/17.
 */
@Component
public class JwtService {
    private static final String ISSUER = "www.montesinos.org.es";
    private SecretKeyProvider secretKeyProvider;
    private final ProfileService profileService;


    @SuppressWarnings("unused")
    public JwtService() {
        this(null, null);
    }

    @Autowired
    public JwtService(SecretKeyProvider secretKeyProvider, ProfileService profileService) {
        this.secretKeyProvider = secretKeyProvider;
        this.profileService = profileService;
    }

    public String tokenFor(MinimalProfile minimalProfile) throws IOException, URISyntaxException {
        byte[] secretKey = secretKeyProvider.getKey();
        Date expiration = Date.from(LocalDateTime.now().plusHours(2).toInstant(UTC));
        return Jwts.builder()
                .setSubject(minimalProfile.getUsername())
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Optional<MinimalProfile> verify(String token) throws IOException, URISyntaxException {
        byte[] secretKey = secretKeyProvider.getKey();
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return profileService.minimal(claims.getBody().getSubject().toString());
    }
}
