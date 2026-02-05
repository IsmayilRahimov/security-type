package securitybasic.securitytype.config;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import securitybasic.securitytype.constants.UserRole;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtUtil {


    private final String SECRET_KEY = "adkasdkasdqqqq1312lasfajkgsmczfakjnqorkjdadwqrtqtzatuyujghg";

    public String generateToken(String username, UserRole role) {
        return Jwts.builder()
                .setSubject(username)
                .claim(username, role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
