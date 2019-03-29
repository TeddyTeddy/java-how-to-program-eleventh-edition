import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class HugeIntegerTest {
    @Nested
    class HugeIntegerConstructorTests {
        @ParameterizedTest(name = "number={0}")
        @CsvFileSource(resources = "resources/invalid-constructor-arguments.csv", numLinesToSkip = 0)
        void passingInvalidStringToHugeIntegerConstructor(String invalidArgument) {
            // given

            //when
            Executable executable = () -> {
                HugeInteger hugeInteger = new HugeInteger(invalidArgument);
            };

            //then
            assertThrows(IllegalArgumentException.class, executable);

        }

        @ParameterizedTest(name = "number={0}, hugeIntegerRepresentation={1}")
        @CsvFileSource(resources = "resources/valid-constructor-arguments.csv", numLinesToSkip = 1)
        void passingValidStringToHugeIntegerConstructor(String validNumber, String hugeIntegerRepresentation) {
            // given

            // when
            HugeInteger hugeInteger = new HugeInteger(validNumber);

            // then
            assertEquals(hugeIntegerRepresentation, hugeInteger.toString()); // calls String.equals() method for object comparison
        }
    }

    @Nested
    class HugeIntegerAddMethodTests {
        @ParameterizedTest(name="a={0}, b={1}, aPlusB={2}")
        @CsvFileSource(resources = "resources/valid-addition-arguments.csv", numLinesToSkip = 1)
        void testAdd(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                HugeInteger result = HugeInteger.add(a, b);

                // then
                assertEquals(expectedResult, result.toString());

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}, aPlusB={2}")
        @CsvFileSource(resources = "resources/valid-addition-arguments.csv", numLinesToSkip = 1)
        void testAddPerformance(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                Executable executable = () -> {
                    HugeInteger result = HugeInteger.add(a, b);
                };

                // then
                assertTimeout(Duration.ofMillis(10), executable); // all addition operations must perform under 10 ms

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/overflowing-addition-arguments.csv", numLinesToSkip = 1)
        void testAddException(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable executable = () -> {
                HugeInteger result = HugeInteger.add(a, b);
            };

            // then
            assertThrows(Exception.class, executable);

        }
    }

    @Nested
    class TestIsEqualToMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isEqualTo-returns-true.csv", numLinesToSkip = 1)
        void testIsEqualToReturnsTrue(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isEqual = HugeInteger.isEqualTo(a,b);

            // then
            assertTrue(isEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isEqualTo-returns-false.csv", numLinesToSkip = 1)
        void testIsEqualToReturnsFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isEqual = HugeInteger.isEqualTo(a,b);

            // then
            assertFalse(isEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isEqualTo-performance.csv", numLinesToSkip = 1)
        void testIsEqualToPerformance(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable e = () -> { boolean isEqual = HugeInteger.isEqualTo(a,b); };

            // then
            assertTimeout(Duration.ofMillis(2), e); // all isEqualTo calls must perform under 2 msecs
        }
    }

    @Nested
    class TestIsGreaterThanMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isGreaterThan-returns-true.csv", numLinesToSkip = 1)
        void testIsGreaterThanReturnsTrue(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isGreaterThan = HugeInteger.isGreaterThan(a,b);

            // then
            assertTrue(isGreaterThan);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isGreaterThan-returns-false.csv", numLinesToSkip = 1)
        void testIsGreaterThanReturnsFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isGreaterThan = HugeInteger.isGreaterThan(a,b);

            // then
            assertFalse(isGreaterThan);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isGreaterThan-performance.csv", numLinesToSkip = 1)
        void testIsGreaterThanPerformance(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable e = () -> { boolean isGreaterThan = HugeInteger.isGreaterThan(a,b); };

            // then
            assertTimeout(Duration.ofMillis(2), e); // all isGreaterThanCalls must perform under 2 msecs
        }
    }

    @Nested
    class TestIsLessThanMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isLessThan-returns-true.csv", numLinesToSkip = 1)
        void testIsLessThanReturnsTrue(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isLessThan = HugeInteger.isLessThan(a,b);

            // then
            assertTrue(isLessThan);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isLessThan-returns-false.csv", numLinesToSkip = 1)
        void testIsLessThanReturnsFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isLessThan = HugeInteger.isLessThan(a,b);

            // then
            assertFalse(isLessThan);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isLessThan-performance.csv", numLinesToSkip = 1)
        void testIsLessThanThanPerformance(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable e = () -> {
                boolean isLessThan = HugeInteger.isLessThan(a, b);
            };

            // then
            assertTimeout(Duration.ofMillis(2), e); // all isLessThan calls must perform in 2 msecs
        }
    }

    @Nested
    class TestSubtractMethod {
        @ParameterizedTest(name="a={0}, b={1}, aMinusB={2}")
        @CsvFileSource(resources = "resources/valid-subtraction-arguments.csv", numLinesToSkip = 1)
        void testSubtract(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                HugeInteger result = HugeInteger.subtract(a, b);

                // then
                assertEquals(expectedResult, result.toString());

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/overflowing-subtraction-arguments.csv", numLinesToSkip = 1)
        void testSubtractException(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable executable = () -> {
                HugeInteger result = HugeInteger.subtract(a, b);
            };

            // then
            assertThrows(Exception.class, executable);

        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/valid-subtraction-arguments.csv", numLinesToSkip = 1)
        void testSubtractPerformance(String aString, String bString, String expectedResult) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable executable = () -> {
                HugeInteger result = HugeInteger.subtract(a, b);
            };

            // then
            assertTimeout(Duration.ofMillis(3), executable); // all subtract calls must perform under 3 secs

        }
    }

    @Nested
    class TestIsNotEqualToMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isNotEqualTo-returns-true.csv", numLinesToSkip = 1)
        void testIsNotEqualToReturnsTrue(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isNotEqual = HugeInteger.isNotEqualTo(a,b);

            // then
            assertTrue(isNotEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isNotEqualTo-returns-false.csv", numLinesToSkip = 1)
        void testIsNotEqualToReturnsFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isNotEqual = HugeInteger.isNotEqualTo(a,b);

            // then
            assertFalse(isNotEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isNotEqualTo-performance.csv", numLinesToSkip = 1)
        void testIsNotEqualToPerformance(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable e = () -> { boolean isNotEqual = HugeInteger.isNotEqualTo(a,b); };

            // then
            assertTimeout(Duration.ofMillis(2), e); // all isNotEqualTo calls must perform under 2 msecs
        }

    }

    @Nested
    class TestIsGreaterThanOrEqualToMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isGreaterThanOrEqualTo-returns-true.csv", numLinesToSkip = 1)
        void testIsGreaterThanOrEqualToReturnsTrue(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isGreaterThanOrEqual = HugeInteger.isGreaterThanOrEqualTo(a,b);

            // then
            assertTrue(isGreaterThanOrEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isGreaterThanOrEqualTo-returns-false.csv", numLinesToSkip = 1)
        void testIsGreaterThanOrEqualToFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isGreaterThanOrEqual = HugeInteger.isGreaterThanOrEqualTo(a,b);

            // then
            assertFalse(isGreaterThanOrEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isGreaterThanOrEqualTo-performance.csv", numLinesToSkip = 1)
        void testIsGreaterThanOrEqualToPerformance(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable e = () -> {
                boolean isGreaterThanOrEqual = HugeInteger.isGreaterThanOrEqualTo(a, b);
            };

            // then
            assertTimeout(Duration.ofMillis(2), e); // all isGreaterThanOrEqualTo calls must perform under 2 msecs
        }
    }

    @Nested
    class TestIsLessThanOrEqualToMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isLessThanOrEqualTo-returns-true.csv", numLinesToSkip = 1)
        void testIsLessThanOrEqualToReturnsTrue(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isLessThanOrEqual = HugeInteger.isLessThanOrEqualTo(a,b);

            // then
            assertTrue(isLessThanOrEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isLessThanOrEqualTo-returns-false.csv", numLinesToSkip = 1)
        void testIsLessThanOrEqualToReturnsFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isLessThanOrEqual = HugeInteger.isLessThanOrEqualTo(a,b);

            // then
            assertFalse(isLessThanOrEqual);
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isLessThanOrEqualTo-performance.csv", numLinesToSkip = 1)
        void testIsLessThanOrEqualToPerformance(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable e = () -> {
                boolean isLessThanOrEqual = HugeInteger.isLessThanOrEqualTo(a,b); };

            // then
            assertTimeout(Duration.ofMillis(2), e); // all isLessThanOrEqualTo calls must complete under 2 msecs
        }
    }

    @Nested
    class TestMultiplyMethod {
        @ParameterizedTest(name="a={0}, b={1}, aTimesB={2}")
        @CsvFileSource(resources = "resources/valid-multiplication-arguments.csv", numLinesToSkip = 1)
        void testMultiply(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                HugeInteger result = HugeInteger.multiply(a, b);

                // then
                assertEquals(expectedResult, result.toString());

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}, aTimesB={2}")
        @CsvFileSource(resources = "resources/valid-multiplication-arguments.csv", numLinesToSkip = 1)
        void testMultiplyPerformance(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                Executable e = () -> {
                    HugeInteger result = HugeInteger.multiply(a, b);
                };

                // then
                assertTimeout(Duration.ofMillis(30), e); // all multiply calls must end in 30 msecs

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/overflowing-multiplication-arguments.csv", numLinesToSkip = 1)
        void testMultiplyException(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable executable = () -> {
                HugeInteger result = HugeInteger.multiply(a, b);
            };

            // then
            assertThrows(Exception.class, executable);

        }
    }

    @Nested
    class TestDivideMethod {
        @ParameterizedTest(name="a={0}, b={1}, aDividedByB={2}")
        @CsvFileSource(resources = "resources/valid-division-arguments.csv", numLinesToSkip = 1)
        void testDivide(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                HugeInteger result = HugeInteger.divide(a, b);

                // then
                assertEquals(expectedResult, result.toString());

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}, aDividedByB={2}")
        @CsvFileSource(resources = "resources/valid-division-arguments.csv", numLinesToSkip = 1)
        void testDividePerformance(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                Executable e = () -> {
                    HugeInteger result = HugeInteger.divide(a, b);
                };

                // then
                assertTimeout(Duration.ofMillis(30), e); // all divide calls must execute under 30 secs

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }


        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/overflowing-division-arguments.csv", numLinesToSkip = 1)
        void testDivideException(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable executable = () -> {
                HugeInteger result = HugeInteger.divide(a, b);
            };

            // then
            assertThrows(Exception.class, executable);

        }
    }

    @Nested
    class TestRemainderMethod {
        @ParameterizedTest(name="a={0}, b={1}, aRemainderB={2}")
        @CsvFileSource(resources = "resources/valid-remainder-arguments.csv", numLinesToSkip = 1)
        void testRemainder(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                HugeInteger result = HugeInteger.remainder(a, b);

                // then
                assertEquals(expectedResult, result.toString());

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}, aRemainderB={2}")
        @CsvFileSource(resources = "resources/valid-remainder-arguments.csv", numLinesToSkip = 1)
        void testRemainderPerformance(String aString, String bString, String expectedResult) {
            try {
                // given
                HugeInteger a = new HugeInteger(aString);
                HugeInteger b = new HugeInteger(bString);

                // when
                Executable e = () -> {
                    HugeInteger result = HugeInteger.remainder(a, b);
                };

                // then
                assertTimeout(Duration.ofMillis(50), e); // all remainder calls must perform under 50 msecs

            } catch(Exception e) {
                System.out.println(e.getMessage()); // should never run, coz a & b are legit
            }
        }

        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/overflowing-remainder-arguments.csv", numLinesToSkip = 1)
        void testRemainderException(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            Executable executable = () -> {
                HugeInteger result = HugeInteger.remainder(a, b);
            };

            // then
            assertThrows(Exception.class, executable);

        }
    }
}