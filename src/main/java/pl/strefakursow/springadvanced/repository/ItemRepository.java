package pl.strefakursow.springadvanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.strefakursow.springadvanced.entity.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.quantity>20")
    List<Item> getItemsWithQuantityOverTwenty();

    @Query("select i from Item i where i.quantity>:choose")
    List<Item> getItemsWithQuantityOver(@Param("choose") int selectQuantity);

    @Query("select i from Item i where i.name like :name")
    List<Item> getItemsWithNameLike(@Param("name") String name);

    List<Item> findByQuantity (Integer quantity);

    List<Item> findByQuantityBetween(int minQuantity, int maxQuantity);

    List<Item> findByQuantityGreaterThanEqualOrderByQuantityDesc (int minQuantity);
}
