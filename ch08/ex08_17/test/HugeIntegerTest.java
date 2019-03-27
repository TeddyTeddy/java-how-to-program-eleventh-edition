import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class HugeIntegerTest {
    @Nested
    class HugeIntegerConstructorTests {
        @ParameterizedTest
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
    }
}