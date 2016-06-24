package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arhat.wetblue.model.Item;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ParamRepository extends JpaRepository<ru.arhat.wetblue.model.Param, Long> {
    @Query(value = "DELETE FROM item_param WHERE params_id = :id",nativeQuery = true)
    void removRelationshipByParamId(@Param("id")Long id);

}
