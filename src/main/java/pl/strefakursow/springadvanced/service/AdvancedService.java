package pl.strefakursow.springadvanced.service;

import pl.strefakursow.springadvanced.entity.Item;

import java.util.List;
import java.util.Optional;

public interface AdvancedService {

    void saveItem(Item item);
    Optional<Item> findItem(Long id);
    void deleteItem(Long id);
    List<Item> getItemsWithQuantityOverTwenty();
}
