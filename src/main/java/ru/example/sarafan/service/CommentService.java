package ru.example.sarafan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.sarafan.domain.Comment;
import ru.example.sarafan.domain.User;
import ru.example.sarafan.domain.Views;
import ru.example.sarafan.dto.EventType;
import ru.example.sarafan.dto.ObjectType;
import ru.example.sarafan.repo.CommentRepo;
import ru.example.sarafan.util.WsSender;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
