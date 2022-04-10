package expo.streams.api.controller;

import expo.streams.api.entities.Customer;
import expo.streams.api.entities.Order;
import expo.streams.api.entities.Product;
import expo.streams.api.repository.CustomerRepository;
import expo.streams.api.repository.OrderRepository;
import expo.streams.api.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    final OrderRepository orderRepository;
    final CustomerRepository customerRepository;
    final ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
       Order order1 =  orderRepository.save(order);
       return new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @GetMapping ("/order")
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>((List<Order>) orderRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer customer1 =  customerRepository.save(customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addOrder(@RequestBody Product product){
        Product product1 =  productRepository.save(product);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

}
