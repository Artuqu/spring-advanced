package pl.strefakursow.springadvanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.repository.ItemPagingAndSortingRepository;
import pl.strefakursow.springadvanced.repository.ItemRepository;
import pl.strefakursow.springadvanced.service.AdvancedService;

import java.util.List;
import java.util.Optional;

@Service
public class JpaAdvancedImplementation implements AdvancedService {


    ItemRepository ir;
    ItemPagingAndSortingRepository itemPagingAndSortingRepository;

    @Autowired
    JpaAdvancedImplementation(ItemRepository ir, ItemPagingAndSortingRepository itemPagingAndSortingRepository) {
        this.ir = ir;
        this.itemPagingAndSortingRepository = itemPagingAndSortingRepository;
    }

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

    @Override
    public List<Item> findByQuantity(Integer quantity) {
        return ir.findByQuantity(quantity);
    }

    @Override
    public List<Item> findByQuantityBetween(int minQuantity, int maxQuantity) {
        return ir.findByQuantityBetween(minQuantity, maxQuantity);
    }

    @Override
    public List<Item> findByQuantityGreaterThanEqualOrderByQuantityDesc(int minQuantity) {
        return ir.findByQuantityGreaterThanEqualOrderByQuantityDesc(minQuantity);
    }

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return itemPagingAndSortingRepository.findAll(pageable);
    }
}
