package com.gft.calendar;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;

public class DateIterator implements Iterator<LocalDate>{

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

    public DateIterator(LocalDate currentDate ){
        this.localDate = currentDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "DateIterator{" +
                "localDate=" + localDate +
                '}';
    }
}
