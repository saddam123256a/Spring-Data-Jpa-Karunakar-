package com.jpa.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
//@NamedQuery(
//        name="Product.findByPrice",
//        query = "SELECT p from Product p where p.price=:price"
//
//)
//@NamedQueries(
//        {
//                @NamedQuery(
//                        name="Product.findAllOrderByNameDesc",
//                        query = "SELECT p from Product p ORDER By p.name DESC"
//                ),
//                @NamedQuery(
//                        name="Product.findByPrice",
//                        query="SELECT p from Product p where p.price =:price"
//                )
//        }
//)

@NamedNativeQuery(
        name="Product.findByDescription",
        query="select * from products p where p.description=?1",
        resultClass=Product.class
)



@Entity
@Table(
        name="products",
        schema = "recentjpa",
        uniqueConstraints = {
                @UniqueConstraint(
                        name="swu",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name="stock_keeping",nullable = false)
    private String swu;
@Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSwu() {
        return swu;
    }

    public void setSwu(String swu) {
        this.swu = swu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", swu='" + swu + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", active=" + active +
                ", imageUrl='" + imageUrl + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
