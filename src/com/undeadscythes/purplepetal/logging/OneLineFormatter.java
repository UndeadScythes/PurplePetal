package com.undeadscythes.purplepetal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * Easier to read log info.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class OneLineFormatter extends SimpleFormatter {
    @Override
    public String format(LogRecord record) {
        if (record.getLevel() == Level.INFO) {
            return record.getMessage() + "\r\n";
        } else {
            return super.format(record);
        }
    }
}
