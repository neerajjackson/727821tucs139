package com.topnprod.question2;


import com.topnprod.question2.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.math.*;

@RestController
public class ProductController {

    private final ProductService productService;

    @Value("${default.top.products.limit}")
    private int defaultTopProductsLimit;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/top-products")
    public List<Product> getTopProducts(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "minPrice", required = false) BigDecimal minPrice,
            @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice,
            @RequestParam(value = "limit", required = false) Integer limit) {

        if (limit == null) {
            limit = defaultTopProductsLimit;
        }
        if (minPrice == null) {
            minPrice = BigDecimal.ZERO;
        }
        if (maxPrice == null) {
            maxPrice = BigDecimal.valueOf(Double.MAX_VALUE);
        }

        return productService.getTopProducts(category, minPrice, maxPrice, limit);
    }
}