package com.wds.filmverwaltungsapp.ots.filmverwaltungsappotsrestjavaspringcom.logic;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class TokenGenerator {
    @Value("${ollmaier.app.jwtSecret}")
    private String jwtSecret;

    @Value("${ollmaier.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(String name) {

        //UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((name))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
        //return "Test";
    }
}
