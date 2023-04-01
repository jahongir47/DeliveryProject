package uz.jahongir.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jahongir.library.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findFirstByUsername(String username);
}
