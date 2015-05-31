package com.undeadscythes.purplepetal.keyables;

/**
 * A timed, completable order.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class Order extends Part {
    private final int tot;
    private final String ordered;
    private String delivered;
    
    /**
     * Create a new order.
     * @param quantity
     * @param ordered_
     * @param mult
     * @param key
     */
    public Order(int key, int quantity, int mult, String ordered_) {
        super(key, "", quantity);
        ordered = ordered_;
        tot = mult * quantity;
    }
    
    /**
     * Complete the order.
     * @param delivered
     */
    public void complete(String delivered) {
        this.delivered = delivered;
    }
    
    @Override
    public String toString() {
        String value;
        if (isComplete()) {
            value = String.format("%s - x%d (%d) Delivered", delivered, getQuantity(), tot);
        } else {
            value = String.format("%s - x%d (%d) Ordered", ordered, getQuantity(), tot);
        }
        return value;
    }
    
    /**
     * Check if the order has been completed.
     * @return
     */
    public boolean isComplete() {
        return delivered != null;
    }
}
