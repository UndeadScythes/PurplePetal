package purplepetal;

import java.util.logging.Logger;

/**
 * Key-value pair.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class Pair {
    private static final Logger LOGGER = Logger.getLogger(Pair.class.getName());
    private final int key;
    private final String value;
    
    /**
     * Create a new key-value pair.
     * @param key
     * @param value
     */
    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    /**
     * Get the key of the pair.
     * @return
     */
    public int getKey() {
        return key;
    }
}
