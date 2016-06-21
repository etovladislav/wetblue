package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Plus;
import ru.arhat.wetblue.model.Production;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface ProductionRepository extends JpaRepository<Production, Long> {
}
