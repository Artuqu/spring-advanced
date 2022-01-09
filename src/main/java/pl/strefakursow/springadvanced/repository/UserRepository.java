package pl.strefakursow.springadvanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.springadvanced.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
