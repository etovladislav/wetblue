package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.arhat.wetblue.model.Document;
import ru.arhat.wetblue.model.Item;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Category_Item WHERE items_id = :id",nativeQuery = true)
    public void removRelationshipByItemId(@Param("id")Long id);
}
