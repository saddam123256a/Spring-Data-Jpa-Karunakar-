package com.jpa.repository;

import com.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepositroy extends JpaRepository<Product,Long> {
/*
Return the found product entry by using its name as search
creteria.If no product entry is found ,this method return null
 */
    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product>findByPriceGreaterThan(BigDecimal price);

    List<Product>findByPriceLessThan(BigDecimal price);

    List<Product>findByNameContaining(String name);

    //Define JPQL query using @Query annotation with index or position parameters
    @Query("SELECT p from Product p where p.name=?1 or p.description=?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name,String desccription);

    //Define JPQL query using @Query annotation with Named parameters
    @Query("SELECT p from Product p where p.name =:name or p.description=:description")
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,
                                                  @Param("description") String description);
//Define Native SQL query using @Query annotation with index or position parameters
    @Query(value = "select * from products p where p.name =?1 or p.description =?2 ",nativeQuery = true)
    Product findByNameOrDescriptionSQLIndexParam(String name,String description);

//Define Native SQL query using @Query annotation with index or position parameters
@Query (value="select * from products p where p.name =:name or p.description=:description",nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name,
                                                 @Param("description") String description);


Product findByPrice(@Param("price") BigDecimal price);

List<Product>findAllByOrderByNameDesc();
@Query(nativeQuery = true)
Product findByDescription(String description);
}
