package ru.example.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.sarafan.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
