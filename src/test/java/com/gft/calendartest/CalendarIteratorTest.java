package com.gft.calendartest;

import com.gft.calendar.CalendarIterable;
import com.gft.calendar.CalendarIterator;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalendarIteratorTest {


    @Test
    public void callingNextMethodShoudReturnDesiredValues() {

        CalendarIterable dateObject = new CalendarIterable(LocalDate.of(2016,10,3));
        CalendarIterator dateIterator = dateObject.iterator();
        LocalDate result = dateIterator.next();
        assertThat("Program did not return FRIDAY od TUESDAY value", result.getDayOfWeek(), anyOf(is(DayOfWeek.TUESDAY),is(DayOfWeek.FRIDAY)));
    }


    @Test
    public void twoIteratorsShouldWorkSimultaneously(){

        CalendarIterable firstDateObject = new CalendarIterable(LocalDate.of(2016,10,3));
        CalendarIterator firstDateIterator = firstDateObject.iterator();

        firstDateObject.iterator().next();
        LocalDate firstResult = firstDateIterator.next();
        assertEquals("Program did not return THURSDAY value", DayOfWeek.TUESDAY, firstResult.getDayOfWeek());
    }
}
