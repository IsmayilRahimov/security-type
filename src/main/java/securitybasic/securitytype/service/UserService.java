package securitybasic.securitytype.service;


import org.springframework.http.ResponseEntity;
import securitybasic.securitytype.model.Users;

public interface UserService {

    ResponseEntity<String> login(String username, String password);

    ResponseEntity<Users> register(Users users);
}
