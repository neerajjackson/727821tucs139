package com.avgcalc.avgcalc;

import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
// import org.junit.jupiter.api.Test;
import com.avgcalc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AvgcalcApplicationTests 
{
@Autowired
private AverageCalculatorService averageCalculatorService;

@Test
void testCalculateAverage() {
	Numbers numbers = new Numbers();
	numbers.setNumbers(Arrays.asList(1, 2, 3, 4, 5));
	double average = averageCalculatorService.calculateAverage(numbers);
	assertEquals(3.0, average);
}
}
