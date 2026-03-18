package com.jpa.repository;

import com.jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PagenationAndSortingTest {
    @Autowired
    private ProductRepositroy productRepositroy;

    @Test
    void pagination() {
        int pageNo = 0;
        int pageSize = 6;


        //create pageable object

        PageRequest pageable = PageRequest.of(pageNo, pageSize);
//findAll method and pass pageable instance
        Page<Product> page = productRepositroy.findAll(pageable);
        List<Product> products = page.getContent();
        products.forEach((p) -> {
            System.out.println(p);
        });
        //total page

        int totalPages = page.getTotalPages();
        //total elements
        long totalElements = page.getTotalElements();
        //number of elements
        int numberOfElements = page.getNumberOfElements();
        //size
        int size = page.getSize();
        //first
        boolean islast = page.isLast();
        //first
        boolean first = page.isFirst();

        System.out.println("total page -> " + totalPages);
        System.out.println("totalElements -> " + totalElements);
        System.out.println("No ofd ElementsPerPage -> " + numberOfElements);
        System.out.println("size  -> " + size);
        System.out.println("isLast -> " + islast);
        System.out.println("isFirst -> " + first);
    }

    @Test
    void sorting() {
        String sorBy = "price";
        // String sortDir="DESC";
        List<Product> all = productRepositroy.findAll(Sort.by(sorBy));
        all.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void sorting1() {
        String sortBy = "price";
        String sortDir = "asc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        List<Product> all = productRepositroy.findAll(sort);
        all.forEach((p) -> {
            System.out.println(p);});
    }

    @Test
    void paginationAndSortingTogether(){

        String sortBy = "price";
        String sortDir = "desc";
        int pageNo = 2;
        int pageSize = 5;

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = productRepositroy.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach((p) ->{
            System.out.println(p);
        });

        // total pages
        int totalPage = page.getTotalPages();
        // total elements
        long totalElements = page.getTotalElements();
        // number of elements
        int numberOfElements = page.getNumberOfElements();
        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();
        // first
        boolean isFirst = page.isFirst();
        System.out.println("total page -> " + totalPage);
        System.out.println("totalElements -> " + totalElements);
        System.out.println("numberOfElementsPerPage -> " + numberOfElements);
        System.out.println(" size ->" + size);
        System.out.println(" isLast -> " + isLast);
        System.out.println("isFirst -> " + isFirst);
    }
}
