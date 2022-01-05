package pl.strefakursow.springadvanced.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.strefakursow.springadvanced.entity.Item;


public interface ItemPagingAndSortingRepository extends PagingAndSortingRepository <Item, Long>{

}
