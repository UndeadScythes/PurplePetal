package com.undeadscythes.purplepetal.keyables;

/**
 * Key-value pair.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class Pair implements Keyable {
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
    
    /**
     * Return the value.
     * @return
     */
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return getValue();
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
