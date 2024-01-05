package ru.example.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.sarafan.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
