package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.arhat.wetblue.model.Production;
import ru.arhat.wetblue.model.Review;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ReviewCategory_Review WHERE review_id = :id",nativeQuery = true)
    void removRelationshipByReviewId(@Param("id")Long id);
}

