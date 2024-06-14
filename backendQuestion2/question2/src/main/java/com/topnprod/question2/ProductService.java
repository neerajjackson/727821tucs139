package com.topnprod.question2;

import com.topnprod.question2.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Value("${ecommerce.api.url}")
    private String ecommerceApiUrl;

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getTopProducts(String category, BigDecimal minPrice, BigDecimal maxPrice, int limit) {
        String url = String.format("%s/categories/%s/products", ecommerceApiUrl, category);
        Product[] products = restTemplate.getForObject(url, Product[].class);

        if (products == null) {
            return List.of();
        }

        return Arrays.stream(products)
                .filter(product -> product.getPrice().compareTo(minPrice) >= 0 && product.getPrice().compareTo(maxPrice) <= 0)
                .sorted((p1, p2) -> Integer.compare(p2.getRating(), p1.getRating()))
                .limit(limit)
                .collect(Collectors.toList());
    }
}