package securitybasic.securitytype.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import securitybasic.securitytype.model.Users;
import securitybasic.securitytype.service.imp.UserServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final UserServiceImpl userService;


    @GetMapping("/secured")
    public String secured() {
        return "This is the secured endpoint";
    }

    @GetMapping("/info")
    public String info() {
        return "This is the info endpoint";
    }


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
