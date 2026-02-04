package securitybasic.securitytype.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import securitybasic.securitytype.model.Users;
import securitybasic.securitytype.service.imp.UserServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final UserServiceImpl userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Users> signIn(@RequestBody Users user) {
        return userService.register(user);
    }
}
