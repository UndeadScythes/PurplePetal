package com.undeadscythes.purplepetal.keyables.typedpart;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.keyables.Part;

/**
 * A part with a type.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class TypedPart extends Part {
    /**
     * The type of this part.
     */
    public final PartType type;
    
    /**
     * Create a new typed part.
     * @param pair
     * @param amount
     * @param type
     */
    public TypedPart(Pair pair, int amount, PartType type) {
        this(pair.getKey(), pair.getValue(), amount, type);
    }
    
    /**
     * Create a new typed part.
     * @param key
     * @param value
     * @param amount
     * @param type
     */
    public TypedPart(int key, String value, int amount, PartType type) {
        super(key, value, amount);
        this.type = type;
    }
}
