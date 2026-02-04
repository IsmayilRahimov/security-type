package securitybasic.securitytype.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import securitybasic.securitytype.model.Users;
import securitybasic.securitytype.service.UserService;


@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl extends UserService {

    @Override
    public ResponseEntity<String> login(String username, String password) {
        return null;
    }

    @Override
    public ResponseEntity<Users> register(Users users) {
        return null;
    }
}
