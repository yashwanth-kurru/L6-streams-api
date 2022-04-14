package expo.streams.api.repository;

import expo.streams.api.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
//    public Product findOrdersBy()
}
