package pl.strefakursow.springadvanced.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.strefakursow.springadvanced.entity.Item;

@Repository
public interface ItemPagingAndSortingRepository extends PagingAndSortingRepository <Item, Long>{

}
