package com.works.services;

import com.works.entities.Product;
import com.works.entities.projections.IProCat;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    final CacheManager cacheManager;

    public Product saveProduct(Product product) {
        cacheManager.getCache("product").clear();
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Cacheable("product")
    public Page<IProCat> findAllJoin(int pageNo) {
        //Sort sort = Sort.by("price").ascending();
        Pageable pageable = PageRequest.of(pageNo, 10);
        return productRepository.findAllJoin(pageable);
    }

}
