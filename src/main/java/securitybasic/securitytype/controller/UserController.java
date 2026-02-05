package securitybasic.securitytype.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("/sign-up")
    public ResponseEntity<Users> signUp(@RequestBody Users user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody Users user) {
        String result = userService.login(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(result);
    }
}
