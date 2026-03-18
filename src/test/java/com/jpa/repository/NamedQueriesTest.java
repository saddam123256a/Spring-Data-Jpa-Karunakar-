package com.jpa.repository;

import com.jpa.entity.Product;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
private ProductRepositroy productRepositroy;

    @Test
    void nameJPQLQuery(){
    Product byPrice = productRepositroy.findByPrice(new BigDecimal(200));
    System.out.println(byPrice.getName());
    System.out.println(byPrice.getDescription());
}
@Test
void namedJPQLQueries(){
    List<Product> products = productRepositroy.findAllByOrderByNameDesc();
    products.forEach((p)->{
        System.out.println(p.getName());
        System.out.println(p.getDescription());
    });

    Product byPrice = productRepositroy.findByPrice(new BigDecimal(200));
    System.out.println(byPrice.getPrice());
    System.out.println(byPrice.getDescription());
}
@Test
void namedNativeSQLQuery(){
    Product byDescription = productRepositroy.findByDescription("I am product 1");
    System.out.println(byDescription.getName());
    System.out.println(byDescription.getDescription());
}
}
