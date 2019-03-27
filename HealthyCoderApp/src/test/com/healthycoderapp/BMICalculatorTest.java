package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

class BMICalculatorTest {

    @Test
    void shouldReturnTrueWhenDietRecommended() {
        //given : initial conditions
        double weight = 89.0;
        double height = 1.72;

        //when
        boolean isRecommended = BMICalculator.isDietRecommended(weight, height);

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