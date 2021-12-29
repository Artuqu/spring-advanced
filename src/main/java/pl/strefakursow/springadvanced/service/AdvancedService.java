package pl.strefakursow.springadvanced.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.strefakursow.springadvanced.entity.Item;

import java.util.List;
import java.util.Optional;

public interface AdvancedService {

    void saveItem(Item item);
    Optional<Item> findItem(Long id);
    void deleteItem(Long id);
    List<Item> getItemsWithQuantityOverTwenty();
    List<Item> getItemsWithQuantityOver(int selectQuantity);
    List<Item> getItemsWithNameLike(String name);
    List<Item> findByQuantity (Integer quantity);
    List<Item> findByQuantityBetween(int minQuantity, int maxQuantity);
    List<Item> findByQuantityGreaterThanEqualOrderByQuantityDesc (int minQuantity);
    Page<Item> findAll(Pageable pageable);
}
