package com.jpa.repository;

import com.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {
    @Autowired
    private ProductRepositroy productRepositroy;
    @Test
void findByNameOrDescriptionJPQLIndexParamMethod(){
        Product product = productRepositroy.findByNameOrDescriptionJPQLIndexParam("product1", "I am product 1");
        System.out.println(product.getName());
    System.out.println(product.getDescription());
}
@Test
void findByNameOrDescriptionJPQLNameParamMethod(){
    Product product = productRepositroy.findByNameOrDescriptionJPQLNamedParam("product1", "I am product 1");
    System.out.println(product.getId());
    System.out.println(product.getName());
}
}
