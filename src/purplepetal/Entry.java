package purplepetal;

import java.util.logging.Logger;

/**
 * A diary entry.
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class Entry {
    private static final Logger LOGGER = Logger.getLogger(Entry.class.getName());
    
    private final Part part;
    private final EntryType type;
    
    /**
     * Create a new entry with a particular type.
     * @param part
     * @param type
     */
    public Entry(Part part, EntryType type) {
        this.part = part;
        this.type = type;
    }
    
    /**
     * Get the type of this entry.
     * @return
     */
    public EntryType getType() {
        return type;
    }
    
    /**
     * Get the key of this entry.
     * @return
     */
    public int getKey() {
        return part.getKey();
    }
    
    @Override
    public String toString() {
        return part.toString();
    }
}
