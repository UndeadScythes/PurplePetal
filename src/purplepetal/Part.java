package purplepetal;

import java.util.logging.Logger;

/**
 * A constituent part of an object, a key-value pair along with a cardinality.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class Part implements Keyable {
    private static final Logger LOGGER = Logger.getLogger(Part.class.getName());
    private final Pair pair;
    private final int amount;
    
    /**
     * Make a new part with some number of pairs.
     * @param pair
     * @param amount
     */
    public Part(Pair pair, int amount) {
        this.pair = pair;
        this.amount = amount;
    }
    
    /**
     * Get a single pair of this part.
     * @return
     */
    public Pair getPair() {
        return pair;
    }
    
    @Override
    public int getKey() {
        return pair.getKey();
    }
    
    /**
     * Get the value of the pair of this part.
     * @return
     */
    public String getValue() {
        return pair.toString();
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d)", getValue(), getAmount());
    }
    
    /**
     * Get how many pair items this part consists of.
     * @return
     */
    public int getAmount() {
        return amount;
    }
}
