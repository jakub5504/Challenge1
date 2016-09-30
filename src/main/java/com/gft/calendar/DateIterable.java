package com.gft.calendar;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;

/**
 * Created by jbki on 9/29/2016.
 */
public class DateIterable implements Iterable<LocalDate>{

    private LocalDate localDate = LocalDate.now();

    public DateIterator iterator() {
        return new DateIterator(localDate);
    }
}
