package com.jpa.repository;

import com.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {
    @Autowired

    private ProductRepositroy productRepositroy;

    @Test
    void saveMethod(){
        //create product

        Product product = new Product();
        product.setName("product");
        product.setDescription("I am product 1");
        product.setSwu("100ABD");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");
        
        //save
        Product saveObject = productRepositroy.save(product);

//display product info

        System.out.println(saveObject.getId());
        System.out.println(saveObject.toString());
    }
    @Test
    void updateUsingSaveMethod(){
        //find or retrieve an entity

        Long id=1L;

        Product product = productRepositroy.findById(id).get();
        //update entity information
        product.setName("Karunakar");
        product.setDescription("I am a Java Developer");

        //save updated entity

        Product save = productRepositroy.save(product);
        System.out.println(save);
    }
    @Test

    void findByIdMethod(){
        Long id=1L;
        Product product=productRepositroy.findById(id).get();
        System.out.println(product);
    }
    @Test
    void saveAllMethod(){

        Product product1 = new Product();
        product1.setName("product 11");
        product1.setDescription("I am product 11");
        product1.setSwu("100APLBDT");
        product1.setPrice(new BigDecimal(12));
        product1.setActive(true);
        product1.setImageUrl("product11.png");

        Product product2 = new Product();
        product2.setName("product12");
        product2.setDescription("I am product 12");
        product2.setSwu("100AYBSG");
        product2.setPrice(new BigDecimal(900));
        product2.setActive(true);
        product2.setImageUrl("product12.png");

        productRepositroy.saveAll(List.of(product1,product2));
    }
@Test
    void findAllMethod(){
        List<Product> products = productRepositroy.findAll();
    products.forEach((p)->{
        System.out.println(p.getName());
    });
    }
@Test
    void deleteById(){
        Long id=2L;
        productRepositroy.deleteById(id);
    }
    @Test
    void deleteAll() {
        productRepositroy.deleteAll();

//
//        Product product = productRepositroy.findById(4L).get();
//        Product product1 = productRepositroy.findById(5L).get();
//        productRepositroy.deleteAll(List.of(product1, product));
    }
    @Test
void countMethod(){
    long count = productRepositroy.count();
    System.out.println(count);
}
@Test
void existByIdMethod(){
        Long id=8L;
    boolean b = productRepositroy.existsById(id);
    System.out.println(b);
}


}
