package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.Category;
import ru.arhat.wetblue.model.Item;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
