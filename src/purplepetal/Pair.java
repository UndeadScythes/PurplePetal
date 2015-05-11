package purplepetal;

import java.util.logging.Logger;

/**
 * Key-value pair.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class Pair implements Keyable {
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
    
    @Override
    public int getKey() {
        return key;
    }
    
    /**
     * Get the key as a string.
     * @return
     */
    public String getKeyString() {
        return Integer.toString(getKey());
    }
}
