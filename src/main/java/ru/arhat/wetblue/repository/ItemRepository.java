package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arhat.wetblue.model.Document;
import ru.arhat.wetblue.model.Item;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "DELETE FROM category_item WHERE items_id = :id",nativeQuery = true)
    void removRelationshipByItemId(@Param("id")Long id);
}
