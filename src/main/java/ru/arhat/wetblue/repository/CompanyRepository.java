package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Category;
import ru.arhat.wetblue.model.Company;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
