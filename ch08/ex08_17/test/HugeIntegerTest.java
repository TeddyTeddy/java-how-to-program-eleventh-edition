import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.function.Executable;

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
    }

    @Nested
    class TestIsLessThanMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isLessThan-returns-true.csv", numLinesToSkip = 1)
        void testIsGreaterThanReturnsTrue(String aString, String bString) {
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
        void testIsGreaterThanReturnsFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isLessThan = HugeInteger.isLessThan(a,b);

            // then
            assertFalse(isLessThan);
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
    }

    @Nested
    class TestIsGreaterThanOrEqualToMethod {
        @ParameterizedTest(name="a={0}, b={1}")
        @CsvFileSource(resources = "resources/isGreaterThanOrEqualTo-returns-true.csv", numLinesToSkip = 1)
        void testIsNotEqualToReturnsTrue(String aString, String bString) {
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
        void testIsNotEqualToReturnsFalse(String aString, String bString) {
            // given
            HugeInteger a = new HugeInteger(aString);
            HugeInteger b = new HugeInteger(bString);

            // when
            boolean isGreaterThanOrEqual = HugeInteger.isGreaterThanOrEqualTo(a,b);

            // then
            assertFalse(isGreaterThanOrEqual);
        }
    }
}