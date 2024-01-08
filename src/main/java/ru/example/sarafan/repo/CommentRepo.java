package ru.example.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.sarafan.domain.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}