import com.gft.calendar.DateIterable;
import com.gft.calendar.DateIterator;
import com.gft.calendar.directory.DirectoryIterable;
import com.gft.calendar.directory.DirectoryIterator;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DateIterableTest {


    @Test
    public void callingNextMethodShoudReturnDesiredValues() {

        DateIterable dateObject = new DateIterable(LocalDate.of(2016,10,3));
        DateIterator dateIterator = dateObject.iterator();
        LocalDate result = dateIterator.next();
        assertThat("Program did not return FRIDAY od TUESDAY value", result.getDayOfWeek(), anyOf(is(DayOfWeek.TUESDAY),is(DayOfWeek.FRIDAY)));
    }


    @Test
    public void twoIteratorsShouldWorkSimultaneously(){

        DateIterable firstDateObject = new DateIterable(LocalDate.of(2016,10,3));
        DateIterator firstDateIterator = firstDateObject.iterator();

        firstDateObject.iterator().next();
        LocalDate firstResult = firstDateIterator.next();
        assertEquals("Program did not return THURSDAY value", DayOfWeek.TUESDAY, firstResult.getDayOfWeek());
    }

    @Test
    public void testTest(){
        DirectoryIterable fileIterable = new DirectoryIterable();
        DirectoryIterator fileIterator = fileIterable.iterator();
        System.out.println(fileIterator.hasNext());
    }
}
