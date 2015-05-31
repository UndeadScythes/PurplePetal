package com.undeadscythes.purplepetal.panels.date;

import com.undeadscythes.purplepetal.panels.date.DateListener;
import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Does nothing.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class NullListener implements DateListener {
    @Override
    public void dateSelected(LocalDate date) {
    }

    @Override
    public void getMarkers(YearMonth ym) {
    }
}
