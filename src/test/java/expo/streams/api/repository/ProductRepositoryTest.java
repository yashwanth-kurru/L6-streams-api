package expo.streams.api.repository;

import expo.streams.api.entities.Order;
import expo.streams.api.entities.Product;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Label("Obtain a list of products belongs to category “Books” with price > 100")
    void test1(){
        List<Product> products = (List<Product>) productRepository.findAll();
        List<Product> bookProducts = products
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("books") && p.getPrice()> 100)
                .collect(Collectors.toList());
        bookProducts.forEach(product -> {
            System.out.println(product.getId()+" ==> "+product.getName()+" ==> "+product.getPrice());
        });
    }

    @Test
    @Label("Obtain a list of order with products belong to category “Baby”")
    void test2(){
        List<Order> orders = (List<Order>) orderRepository.findAll();
        List<Order> babyProducts_Orders = orders
                .stream()
                .filter(order -> order.getProducts().stream().map(Product::getCategory).collect(Collectors.toList()).contains("Baby"))
                .collect(Collectors.toList());

        babyProducts_Orders.parallelStream().forEach(o ->{
            System.out.println(o.getId());
        });
    }

}