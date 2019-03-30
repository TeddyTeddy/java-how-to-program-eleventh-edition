import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DaysTest {

    SimpleEnumExample example;

    @BeforeEach
    void setup() {
        example = new SimpleEnumExample();
    }

    @AfterEach
    void tearDown() {
        example = null;
    }

    @Test
    void testGetStringRepresentationViaSwitch() {
        // given
        SimpleEnumExample.Days[] week = SimpleEnumExample.Days.values();

        for(SimpleEnumExample.Days day : week) {
            // when
            String dayString = example.getStringRepresentationViaSwitch(day);

            // then
            String expected = "It's " + day.toString();
            assertEquals(expected, dayString);
        }
    }

    @Test
    void testGetStringRepresentationViaIf() {
        // given
        SimpleEnumExample.Days[] week = SimpleEnumExample.Days.values();

        for(SimpleEnumExample.Days day : week) {
            // when
            String dayString = example.getStringRepresentationViaIf(day);

            // then
            String expected = "It's " + day.toString();
            assertEquals(expected, dayString);
        }
    }

    @Test
    void simpleEnumExampleOutSideClassTest() {
        // given

        // when
        SimpleEnumExample.Days[] week = SimpleEnumExample.Days.values();

        // then
        assertAll(
                () -> assertEquals(SimpleEnumExample.Days.SUNDAY, week[0]),
                () -> assertEquals(SimpleEnumExample.Days.MONDAY, week[1]),
                () -> assertEquals(SimpleEnumExample.Days.TUESDAY, week[2]),
                () -> assertEquals(SimpleEnumExample.Days.WEDNESDAY, week[3]),
                () -> assertEquals(SimpleEnumExample.Days.THURSDAY, week[4]),
                () -> assertEquals(SimpleEnumExample.Days.FRIDAY, week[5]),
                () -> assertEquals(SimpleEnumExample.Days.SATURDAY, week[6])
        );
    }

    @Test
    void testGetEnumValues() {
        // given

        // when
        ArrayList<String> week = example.getEnumValues();

        // then
        assertAll(
                () -> assertEquals(SimpleEnumExample.Days.SUNDAY.toString(), week.get(0)),
                () -> assertEquals(SimpleEnumExample.Days.MONDAY.toString(), week.get(1)),
                () -> assertEquals(SimpleEnumExample.Days.TUESDAY.toString(), week.get(2)),
                () -> assertEquals(SimpleEnumExample.Days.WEDNESDAY.toString(), week.get(3)),
                () -> assertEquals(SimpleEnumExample.Days.THURSDAY.toString(),  week.get(4)),
                () -> assertEquals(SimpleEnumExample.Days.FRIDAY.toString(),  week.get(5)),
                () -> assertEquals(SimpleEnumExample.Days.SATURDAY.toString(),  week.get(6))
        );

    }

    @Test
    void testGetWeekdaysAbbreviations() {
        // given

        // when
        ArrayList<String> weekdayAbbreviations = example.getWeekdaysAbbreviations();

        // then
        assertAll(
                () -> assertEquals("SUN", weekdayAbbreviations.get(0)),
                () -> assertEquals("MON", weekdayAbbreviations.get(1)),
                () -> assertEquals("TUE", weekdayAbbreviations.get(2)),
                () -> assertEquals("WED", weekdayAbbreviations.get(3)),
                () -> assertEquals("THUR", weekdayAbbreviations.get(4)),
                () -> assertEquals("FRI", weekdayAbbreviations.get(5)),
                () -> assertEquals("SAT", weekdayAbbreviations.get(6))
        );
    }

}