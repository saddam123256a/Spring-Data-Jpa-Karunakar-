package com.jpa.repository;

import com.jpa.entity.Address;
import com.jpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalTest {
@Autowired
    private OrderRepository orderRepository;
@Autowired
private AddressRepository addressRepository;
@Test
void saveOrderMethod(){
Order order=new Order();
    order.setOrderTrackingNumber("100ABC");
    order.setTotalQuantity(6);
    order.setStatus("IN PROGRESS");
    order.setTotalPrice(new BigDecimal(750));

  Address address=new Address();
    address.setCity("Mumbai");
address.setStreet("Park Street");
address.setState("Hyd");
address.setCountry("Australia");
address.setZipCode("456446");

order.setAddress(address);
orderRepository.save(order);
}

@Test
    void updateOrderMethod(){
    Order order=orderRepository.findById(1L).get();
    order.setStatus("CANCELLED");
    order.getAddress().setZipCode("2jkdljdjd");

    orderRepository.save(order);

}
@Test
    void deleteOrderMethod(){
    orderRepository.deleteById(1L);
}

}
