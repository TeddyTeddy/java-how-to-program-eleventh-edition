package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class BMICalculatorTest {

    private String environment = "prod";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all unit tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all unit tests");
    }

    @Nested
    class isDietRecommendedTests {
        @ParameterizedTest(name = "weight={0}, height={1}")
        //@ValueSource(doubles = {89.0, 95.0, 110.0})
        @CsvSource(value= {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"} )
            //@CsvFileSource(resources= "diet-recommended-input-data.csv", numLinesToSkip = 1)
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
    }

    @Nested
    class FindCoderWithWorstBMITests {
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
        void shouldReturnCoderWithWorstBMIIn1MsWhenCoderListHas10000Elements() {

            assumeTrue(BMICalculatorTest.this.environment.equals("prod"));

            // given
            List<Coder> coders = new ArrayList<>(10000);
            for(int i = 0; i < 10000; ++i) {
                coders.add(new Coder(1.0 + i, 10.0 + i));
            }

            // when
            Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);
            // then
            assertTimeout(Duration.ofMillis(50), executable);
        }

        @Test
        //@Disabled
        @DisabledOnOs(OS.WINDOWS)
        void shouldReturnNullWorstBMICoderWhenCoderListEmpty() {
            // given
            List<Coder> coders = new ArrayList<>();

            //when
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

            //then
            assertNull(coderWorstBMI);
        }
    }

    @Nested
    class GetBMIScoresTests {
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
}