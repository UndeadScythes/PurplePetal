package com.undeadscythes.purplepetal.utilities;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import com.undeadscythes.purplepetal.keyables.Keyable;
import com.undeadscythes.purplepetal.keyables.Keyable;

/**
 * SWING related methods for easy doings of things.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("ClassWithoutLogger")
public class Swingers {
    /**
     * Given key-value {@link Keyable} based {@link JComboBox}, select a certain
     * index with the given key.
     * @param comboBox
     * @param key
     */
    public static void setSelectedItem(JComboBox<? extends Keyable> comboBox, int key) {
        comboBox.setSelectedIndex(0);
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).getKey() == key) {
                comboBox.setSelectedIndex(i);
            }
        }
    }
    
    /**
     * Return the {@link Keyable} selected in a combo box.
     * @param <T>
     * @param comboBox
     * @return
     */
    public static <T extends Keyable> T getSelectedItem(JComboBox<T> comboBox) {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }
    
    /**
     * Set the selected key.
     * @param <T>
     * @param list
     * @param key
     */
    public static <T extends Keyable> void setSelectedItem(JList<T> list, int key) {
        DefaultListModel<T> listModel = (DefaultListModel<T>) list.getModel();
        clearSelection(list);
        if (key > -1) {
            list.setSelectedIndex(getIndex(listModel, key));
        }
    }
    
    /**
     * Return the {@link Keyable} selected in a combo box.
     * @param <T>
     * @param list
     * @return
     */
    public static <T extends Keyable> T getSelectedItem(JList<T> list) {
        return list.getSelectedValue();
    }
    
    /**
     * Get the selected key.
     * @param <T>
     * @param list
     * @return
     */
    public static <T extends Keyable> int getSelectedKey(JList<T> list) {
        int key = -1;
        T item = getSelectedItem(list);
        if (item != null) {
            key = item.getKey();
        }
        return key;
    }
    
    /**
     * Get the selected key.
     * @param <T>
     * @param list
     * @return
     */
    public static <T extends Keyable> int getSelectedKey(JComboBox<T> list) {
        int key = -1;
        T item = getSelectedItem(list);
        if (item != null) {
            key = item.getKey();
        }
        return key;
    }

    /**
     * Set the text of the fields to "".
     * @param fields
     */
    public static void clearText(JTextField... fields) {
       setText("", fields);
    }
    
    /**
     * Set the text of the fields to "".
     * @param labels
     */
    public static void clearText(JLabel... labels) {
       setText("", labels);
    }
    
    /**
     * Clear the list selections.
     * @param lists
     */
    @SuppressWarnings("rawtypes")
    public static void clearSelection(JList... lists) {
        for (JList list : lists) {
            list.clearSelection();
        }
    }
    
    /**
     * Clear the combo selections.
     * @param combos
     */
    @SuppressWarnings("rawtypes")
    public static void clearSelection(JComboBox... combos) {
        for (JComboBox combo : combos) {
            if (combo.getItemCount() > 0) {
                combo.setSelectedIndex(0);
            }
        }
    }
    
    /**
     * Set the text of the fields to text.
     * @param text
     * @param fields
     */
    public static void setText(String text, JTextField... fields) {
        for (JTextField field : fields) {
            field.setText(text);
        }
    }
    
    /**
     * Set the text of the labels to text.
     * @param text
     * @param labels
     */
    public static void setText(String text, JLabel... labels) {
        for (JLabel label : labels) {
            label.setText(text);
        }
    }
    
    /**
     * Remove the item from the list with this key.
     * @param list
     * @param key
     */
    public static void removeItem(DefaultListModel<? extends Keyable> list, int key) {
        int index = getIndex(list, key);
        if (index > -1) {
            list.remove(index);
        }
    }
    
    /**
     * Remove the item from the list with this key.
     * @param combo
     * @param key
     */
    public static void removeItem(DefaultComboBoxModel<? extends Keyable> combo, int key) {
        int index = getIndex(combo, key);
        if (index > -1) {
            combo.removeElementAt(index);
        }
    }
    
    /**
     * Returns the index of the item with a given key in the list.
     * @param list
     * @param key
     * @return
     */
    public static int getIndex(DefaultListModel<? extends Keyable> list, int key) {
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Returns the index of the item with a given key in the list.
     * @param combo
     * @param key
     * @return
     */
    public static int getIndex(DefaultComboBoxModel<? extends Keyable> combo, int key) {
        for (int i = 0; i < combo.getSize(); i++) {
            if (combo.getElementAt(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Replace (or add) the item with this key with the value given.
     * @param <T>
     * @param list
     * @param key
     * @param value
     */
    public static <T extends Keyable> void replaceItem(DefaultListModel<T> list, int key, T value) {
        int index = getIndex(list, key);
        if (index > -1) {
            list.remove(index);
            list.add(index, value);
        } else {
            list.addElement(value);
        }
    }

    private Swingers() {}
}
