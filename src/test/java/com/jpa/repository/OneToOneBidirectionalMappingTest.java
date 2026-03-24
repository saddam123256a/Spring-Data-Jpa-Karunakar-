package com.jpa.repository;

import com.jpa.entity.Address;
import com.jpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setTotalQuantity(6);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(750));

        Address address = new Address();
        address.setCity("Mumbai");
        address.setStreet("Park Street");
        address.setState("Hyd");
        address.setCountry("Australia");
        address.setZipCode("456446");
        order.setAddress(address);
        address.setOrder(order);
        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod() {
        Address address = addressRepository.findById(2L).get();
        address.setZipCode("OOOOOOOO");
        address.getOrder().setStatus("FINALIZED");
        addressRepository.save(address);
    }

    @Test
    void fetchAddressMethod() {
Address address=addressRepository.findById(2L).get();

    }
    @Test
    void deleteAddressMethod(){
        addressRepository.deleteById(2L);
    }
}
