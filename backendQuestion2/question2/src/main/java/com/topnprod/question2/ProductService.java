package com.topnprod.question2;

// package com.example.topproducts.service;

import com.topnprod.question2.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public List<Product> getTopProducts(int limit) {
        String url = ecommerceApiUrl + "/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);

        if (products == null) {
            return List.of();
        }

        return Arrays.stream(products)
                .sorted((p1, p2) -> Integer.compare(p2.getRating(), p1.getRating()))
                .limit(limit)
                .collect(Collectors.toList());
    }
}