package pl.strefakursow.springadvanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.repository.ItemRepository;
import pl.strefakursow.springadvanced.service.AdvancedService;

import java.util.List;
import java.util.Optional;

@Service
public class JpaAdvancedImplementation implements AdvancedService {

    @Autowired
    ItemRepository ir;


    @Override
    public void saveItem(Item item) {
        ir.save(item);
    }

    @Override
    public Optional<Item> findItem(Long id) {
        return ir.findById(id);
    }


    @Override
    public void deleteItem(Long id) {
        ir.deleteById(id);
    }

    @Override
    public List<Item> getItemsWithQuantityOverTwenty() {
        return ir.getItemsWithQuantityOverTwenty();
    }

    @Override
    public List<Item> getItemsWithQuantityOver(int selectQuantity) {
        return ir.getItemsWithQuantityOver(selectQuantity);
    }

    @Override
    public List<Item> getItemsWithNameLike(String name) {
        return ir.getItemsWithNameLike(name);
    }
}
