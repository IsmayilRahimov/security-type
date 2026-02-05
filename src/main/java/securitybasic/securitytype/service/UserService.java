package securitybasic.securitytype.service;


import org.springframework.http.ResponseEntity;
import securitybasic.securitytype.model.Users;

public interface UserService {

    Users register(Users users);

    String login(String username, String password);
}
