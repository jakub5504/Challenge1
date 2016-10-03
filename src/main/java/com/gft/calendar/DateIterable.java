package com.gft.calendar;

import java.time.LocalDate;

/**
 * Created by jbki on 9/29/2016.
 */
public class DateIterable implements Iterable<LocalDate>{

    private LocalDate localDate = LocalDate.now();

    public DateIterable(LocalDate localDate) {
        this.localDate = localDate;
    }

    public DateIterator iterator() {
        return new DateIterator(localDate);
    }
}
