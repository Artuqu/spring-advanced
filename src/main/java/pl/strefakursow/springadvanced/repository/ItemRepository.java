package pl.strefakursow.springadvanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.strefakursow.springadvanced.entity.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("select i from Item i where i.quantity>20")
    List<Item> getItemsWithQuantityOverTwenty();
}
