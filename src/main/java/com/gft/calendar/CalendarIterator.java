package com.gft.calendar;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;

public class CalendarIterator implements Iterator<LocalDate>{

    private LocalDate localDate;

    public boolean hasNext() {

        return true;
    }

    public LocalDate next() {
        DayOfWeek tuesday = DayOfWeek.TUESDAY;
        DayOfWeek friday = DayOfWeek.FRIDAY;
        localDate = localDate.plusDays(1);
        while(!localDate.getDayOfWeek().equals(friday) && !localDate.getDayOfWeek().equals(tuesday))
        {
            localDate = localDate.plusDays(1);
        }
        System.out.println(localDate.getDayOfWeek());
        return localDate;
    }

    CalendarIterator(LocalDate currentDate){
        this.localDate = currentDate;
    }


}
