package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Production;
import ru.arhat.wetblue.model.Review;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
