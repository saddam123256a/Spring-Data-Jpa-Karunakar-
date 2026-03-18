package com.jpa.repository;

import com.jpa.entity.Product;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodTest {
@Autowired
    private  ProductRepositroy productRepositroy;
@Test
void findByName(){
    Product product=productRepositroy.findByName("product");
    System.out.println(product.getId());
    System.out.println(product.getName());
}
@Test
void findByIdMethod(){
    Product product=productRepositroy.findById(2L).get();
    System.out.println(product.getId());
    System.out.println(product.getName());
    System.out.println(product.getDescription());
}
@Test
void findByNameOrDescriptionMethod() {
    List<Product> products = productRepositroy.findByNameOrDescription("product1", "I am product 1");
    products.forEach((product) -> {
        System.out.println(product.getId());
        System.out.println(product.getDescription());
    });
}
@Test
void findByNameAndDescriptionMethod(){
        List<Product> products1= productRepositroy.findByNameAndDescription("product1", "I am product 1");
        products1.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getDescription());
        }));

    }
    @Test
    void findDistinctByNameMethod(){
        Product distinctByName = productRepositroy.findDistinctByName("product1");
        System.out.println(distinctByName.getId());
        System.out.println(distinctByName.getName());
        System.out.println(distinctByName.getDescription());


}

@Test
    void findByPriceGreaterThanMethod(){
    List<Product> byPriceGreaterThan = productRepositroy.findByPriceGreaterThan(new BigDecimal(200));
    byPriceGreaterThan.forEach((product -> {
        System.out.println(product.getId());
        System.out.println(product.getName());
    }));
}
@Test
void findByPriceLessThanMethod(){
    List<Product> byPriceLessThan = productRepositroy.findByPriceLessThan(new BigDecimal(200));
    byPriceLessThan.forEach((p)->{
        System.out.println(p.getId());
        System.out.println(p.getDescription());
    });
}

@Test
    void findNameConatiningMethod(){
    List<Product> product1 = productRepositroy.findByNameContaining("product1");
    product1.forEach(product -> {
        System.out.println(product.getId());;
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    });
}



}
