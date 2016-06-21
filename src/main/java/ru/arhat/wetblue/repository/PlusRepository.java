package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Param;
import ru.arhat.wetblue.model.Plus;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface PlusRepository extends JpaRepository<Plus, Long> {
}
