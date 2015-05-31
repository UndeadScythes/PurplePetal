package com.undeadscythes.purplepetal.panels.date;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * A class that can receive a date selection input.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
public interface DateListener {
    /**
     * Fired when a date selection methods is invoked.
     * @param date
     */
    void dateSelected(LocalDate date);
    
    /**
     * Generate the calendar markers for the given month.
     * @param ym
     */
    void getMarkers(YearMonth ym);
}
