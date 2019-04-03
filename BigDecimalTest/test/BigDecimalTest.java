import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalTest {
    @Test
    void whenBigDecimalCreated_thenValueMatches() {
        //given

        // when
        BigDecimal bdFromString = new BigDecimal("-0.009");
        BigDecimal bdFromCharArray = new BigDecimal(new char[] {'-','3', '.', '1', '6', '1', '5'});
        BigDecimal bdFromInt = new BigDecimal(42);
        BigDecimal bdFromLong = new BigDecimal(1234567890L);

        // then
        System.out.println(bdFromString.precision());
        System.out.println(bdFromString.scale());
        System.out.println(bdFromString.signum());

        assertEquals("-0.009", bdFromString.toString());
        assertEquals("-3.1615", bdFromCharArray.toString());
        assertEquals("42", bdFromInt.toString());
        assertEquals("1234567890", bdFromLong.toString());

        assertEquals(5, bdFromCharArray.precision());
        assertEquals(4, bdFromCharArray.scale());
        assertEquals(-1, bdFromCharArray.signum());
    }
}