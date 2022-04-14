package expo.streams.api.repository;

import expo.streams.api.entities.Order;
import expo.streams.api.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    public List<Order> findAllByProducts(Product product);
}
