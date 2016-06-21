package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Item;
import ru.arhat.wetblue.model.Param;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ParamRepository extends JpaRepository<Param, Long> {
}
