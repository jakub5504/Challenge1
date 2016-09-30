import com.gft.calendar.DateIterable;
import com.gft.calendar.DateIterator;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class LocalDateTest {


    @Test
    public void callingTwiceNextMethodShoudReturnFriday() {

        DateIterable dateObject = new DateIterable();
        DateIterator dateIterator = dateObject.iterator();
        LocalDate result = dateIterator.next();
        result = dateIterator.next();
        assertEquals("Program did not return FRIDAY value", DayOfWeek.FRIDAY, result.getDayOfWeek());
    }

    @Test
    public void callingOnceNextMethodShoudReturnThursday() {

        DateIterable dateObject = new DateIterable();
        DateIterator dateIterator = dateObject.iterator();
        LocalDate result = dateIterator.next();
        assertEquals("Program did not return THURSDAY value",DayOfWeek.THURSDAY, result.getDayOfWeek());
    }

    @Test
    public void twoIteratorsShouldWorkSimultaneously(){

        DateIterable firstDateObject = new DateIterable();
        DateIterator firstDateIterator = firstDateObject.iterator();
        LocalDate firstResult = firstDateIterator.next();


        DateIterable secondDateObject = new DateIterable();
        DateIterator secondDateIterator = secondDateObject.iterator();
        LocalDate secondResult = secondDateIterator.next();
        secondResult = secondDateIterator.next();
        assertEquals("Program did not return FRIDAY value", DayOfWeek.FRIDAY, secondResult.getDayOfWeek());
        assertEquals("Program did not return THURSDAY value", DayOfWeek.THURSDAY, firstResult.getDayOfWeek());
    }

    @Test
    public void workingWithSecondIteratorShouldntHaveImpactOnFirst(){

        DateIterable firstDateObject = new DateIterable();
        DateIterator firstDateIterator = firstDateObject.iterator();
        DateIterable secondDateObject = new DateIterable();
        DateIterator secondDateIterator = secondDateObject.iterator();
        LocalDate secondResult = secondDateIterator.next();
        secondResult = secondDateIterator.next();

        assertEquals("Program did not return FRIDAY value", DayOfWeek.FRIDAY, secondResult.getDayOfWeek());
        assertEquals("Program did not return todays date value", LocalDate.now(), firstDateIterator.getLocalDate());



    }
}
