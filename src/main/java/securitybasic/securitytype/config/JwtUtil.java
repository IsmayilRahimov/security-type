package securitybasic.securitytype.config;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import securitybasic.securitytype.constants.UserRole;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtUtil {


    private final String SECRET_KEY = "adkasdkasdqqqq1312lasfajkgsmczfakjnqorkjdadwqrtqtzatrewradfasdad12123adasdcacdqwcqwdqecwqce12e1uyujghg";

    private final Long EXPIRATION_TIME = 864_000_000L;


    public String generateToken(String username, UserRole role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
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
