package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.User;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByLogin(String login);
}
