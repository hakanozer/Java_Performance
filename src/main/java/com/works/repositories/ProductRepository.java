package com.works.repositories;

import com.works.entities.Product;
import com.works.entities.projections.IProCat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from PUBLIC.PRODUCT inner join PUBLIC.PRODUCT_CATEGORIES PC on PRODUCT.PID = PC.PRODUCT_PID inner join PUBLIC.CATEGORY C on C.CID = PC.CATEGORIES_CID ", nativeQuery = true)
    Page<IProCat> findAllJoin( Pageable pageable);

}