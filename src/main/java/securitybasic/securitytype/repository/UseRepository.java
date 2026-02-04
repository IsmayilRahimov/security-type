package securitybasic.securitytype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitybasic.securitytype.model.Users;

import java.util.Optional;
@Repository
public interface UseRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    Optional<Users> findByEmail(String email);

    Optional<Users> findById(Long id);
}
