package purplepetal;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Easier to read log info.
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class OneLineFormatter extends SimpleFormatter {
    private static final Logger LOGGER = Logger.getLogger(OneLineFormatter.class.getName());
    
    @Override
    public String format(LogRecord record) {
        if (record.getLevel() == Level.INFO) {
            return record.getMessage() + "\r\n";
        } else {
            return super.format(record);
        }
    }
}
