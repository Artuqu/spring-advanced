package pl.strefakursow.springadvanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.springadvanced.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
