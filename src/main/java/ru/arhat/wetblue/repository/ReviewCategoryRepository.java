package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Review;
import ru.arhat.wetblue.model.ReviewCategory;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ReviewCategoryRepository extends JpaRepository<ReviewCategory, Long> {
}
