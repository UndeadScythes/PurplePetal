package com.undeadscythes.purplepetal.models;

import javax.swing.DefaultComboBoxModel;
import com.undeadscythes.purplepetal.keyables.Keyable;
import com.undeadscythes.purplepetal.keyables.Keyable;

/**
 * A combo box model to list pairs or parts.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 * @param <T>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class PurpleComboModel<T extends Keyable> extends DefaultComboBoxModel<T> {
    /**
     * Get an element by key.
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getKey(int key) {
        T result = null;
        for (int i = 0; i < getSize(); i++) {
            T element = getElementAt(i);
            if (element.getKey() == key) {
                result = element;
                break;
            }
        }
        return result;
    }
}
