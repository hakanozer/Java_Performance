package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.entities.projections.IProCat;
import com.works.models.Currency;
import com.works.services.ProductService;
import com.works.services.XmlService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {

    private final ProductService productService;
    private final XmlService xmlService;

    @PostMapping("save")
    public Product save(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("saveAll")
    public List<Product> saveAll(@RequestBody List<Product> products) {
        return productService.saveAll(products);
    }

    @GetMapping("findAll")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("findAllJoin")
    public Page<IProCat> findAllJoin( @RequestParam(defaultValue = "0") int pageNo ) {
        return productService.findAllJoin(pageNo);
    }

    @GetMapping("xml")
    public List<Currency> xml() {
        return xmlService.xml();
    }

}
