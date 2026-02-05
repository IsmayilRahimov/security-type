package securitybasic.securitytype.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import securitybasic.securitytype.config.JwtUtil;
import securitybasic.securitytype.model.Users;
import securitybasic.securitytype.repository.UserRepository;
import securitybasic.securitytype.service.UserService;


@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    @Override
    public Users register(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser = userRepository.save(users);
        log.info("Users registered successfully");

        return savedUser;
    }

    @Override
    public String login(String username, String password) {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        boolean matches = passwordEncoder.matches(password, user.getPassword());

        if (!matches) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}
