package ru.arhat.wetblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arhat.wetblue.model.ReviewCategory;
import ru.arhat.wetblue.model.Slider;

/**
 * Created by etovladislav on 21.06.16.
 */
public interface SliderRepository extends JpaRepository<Slider, Long> {
}
