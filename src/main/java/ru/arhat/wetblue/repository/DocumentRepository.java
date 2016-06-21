package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Country;
import ru.arhat.wetblue.model.Document;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
