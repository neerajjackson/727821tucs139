package com.avgcalc.avgcalc;



// package com.example.averagecalculator.controller;

import com.avgcalc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AverageCalculatorService {

    private final NumberFetchService numberFetchService;

    public AverageCalculatorService(NumberFetchService numberFetchService) {
        this.numberFetchService = numberFetchService;
    }

    public double calculateAverage(List<Integer> numberList) {
        if (numberList == null || numberList.isEmpty()) 
        {
            throw new IllegalArgumentException("The list of numbers cannot be null or empty");
        }
        double sum = 0;
        for (int number : numberList) 
        {
            sum += number;
        }
        return sum / numberList.size();
    }

    public double calculatePrimesAverage() {
        List<Integer> primes = numberFetchService.fetchPrimes();
        return calculateAverage(primes);
    }

    public double calculateFibonacciAverage() {
        List<Integer> fibonacci = numberFetchService.fetchFibonacci();
        return calculateAverage(fibonacci);
    }

    public double calculateEvenAverage() {
        List<Integer> even = numberFetchService.fetchEven();
        return calculateAverage(even);
    }

    public double calculateRandomAverage() {
        List<Integer> random = numberFetchService.fetchRandom();
        return calculateAverage(random);
    }
}