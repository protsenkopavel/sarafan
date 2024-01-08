package ru.example.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.sarafan.domain.User;
import ru.example.sarafan.domain.UserSubscription;
import ru.example.sarafan.domain.UserSubscriptionId;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);
}
