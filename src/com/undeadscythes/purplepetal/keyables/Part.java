package com.undeadscythes.purplepetal.keyables;

/**
 * A constituent part of an object, a key-value pair along with a cardinality.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class Part extends Pair {
    private final int quantity;
    
    /**
     * Make a new part with some number of pairs.
     * @param pair
     * @param quantity
     */
    public Part(Pair pair, int quantity) {
        this(pair.getKey(), pair.toString(), quantity);
    }
    
    /**
     * Make a new part with some number of key-values.
     * @param key
     * @param value
     * @param quantity_
     */
    public Part(int key, String value, int quantity_) {
        super(key, value);
        quantity = quantity_;
    }
    
    /**
     * Get a single pair of this part.
     * @return
     */
    public Pair getPair() {
        return new Pair(getKey(), toString());
    }
    
    /**
     * Get a string as "value x amount".
     * @return
     */
    public String getPartString() {
        return String.format("%s x %d", getValue(), getQuantity());
    }
    
    /**
     * Get how many pair items this part consists of.
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
}
