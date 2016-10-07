package com.gft.calendar;

import java.time.LocalDate;

/**
 * Created by jbki on 9/29/2016.
 */
public class CalendarIterable implements Iterable<LocalDate>{

    private LocalDate localDate = LocalDate.now();

    public CalendarIterable(LocalDate localDate) {
        this.localDate = localDate;
    }

    public CalendarIterator iterator() {
        return new CalendarIterator(localDate);
    }
}
