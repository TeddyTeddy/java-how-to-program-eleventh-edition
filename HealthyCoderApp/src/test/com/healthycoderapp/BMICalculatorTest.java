package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class BMICalculatorTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all unit tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all unit tests");
    }

    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvSource(value= {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"} )
    void shouldReturnTrueWhenDietRecommended(Double coderWeight, Double coderHeight) {
        //given : initial conditions

        //when
        boolean isRecommended = BMICalculator.isDietRecommended(coderWeight, coderHeight);

        //then
        assertTrue(isRecommended);
    }

    @Test
    void shouldReturnFalseWhenDietNotRecommended() {
        //given : initial conditions
        double weight = 50.0;
        double height = 1.92;

        //when
        boolean isRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(isRecommended);
    }

    @Test
    void shouldThrowArithmeticExceptionWhenHeightZero() {
        //given : initial conditions
        double weight = 50.0;
        double height = 0.0;

        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void shouldReturnCoderWithWorstBMIWhenCoderListNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0)); // worst BMI
        coders.add(new Coder(1.82, 64.7));

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertAll(
                () -> assertEquals(1.82, coderWorstBMI.getHeight()),
                () -> assertEquals(98.0, coderWorstBMI.getWeight())
        );

    }

    @Test
    void shouldReturnNullWorstBMICoderWhenCoderListEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertNull(coderWorstBMI);
    }

    @Test
    void shouldReturnCorrectBMIScoreArrayWhenCoderListNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0)); // worst BMI
        coders.add(new Coder(1.82, 64.7));
        double[] expected = {18.52, 29.59, 19.53};

        // when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        // then
        assertArrayEquals(expected, bmiScores);
    }
}