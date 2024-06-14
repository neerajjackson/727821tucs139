package com.avgcalc.avgcalc;

// import com.*;
import com.avgcalc.*;
import org.springframework.stereotype.Service;



// File: src/main/java/com/example/averagecalculator/service/NumberFetchService.java

// package com.example.averagecalculator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NumberFetchService {

    private final RestTemplate restTemplate;

    public NumberFetchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Integer> fetchPrimes() {
        String url = "http://204.48.26.144/test/primes";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Integer> fetchFibonacci() {
        String url = "http://204.48.26.144/test/fibo";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Integer> fetchEven() {
        String url = "http://204.48.26.144/test/even";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Integer> fetchRandom() {
        String url = "http://204.48.26.144/test/rand";
        return restTemplate.getForObject(url, List.class);
    }
}