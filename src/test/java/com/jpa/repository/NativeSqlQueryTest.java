package com.jpa.repository;

import com.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSqlQueryTest {
    @Autowired
private  ProductRepositroy productRepositroy;
@Test
void findByNameOrDescriptionSQLIndexParamMethod(){
    Product product = productRepositroy.findByNameOrDescriptionSQLIndexParam("product1", "I am product 1");
    System.out.println(product.getId());
    System.out.println(product.getName());
    System.out.println(product.getDescription());
}
@Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
    Product product= productRepositroy.findByNameOrDescriptionSQLNamedParam("product1", "I am product 1");
    System.out.println(product.getId());
    System.out.println(product.getName());
    System.out.println(product.getDescription());
}

}
