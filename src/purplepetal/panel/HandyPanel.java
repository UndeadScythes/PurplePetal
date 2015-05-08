package purplepetal.panel;

import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import purplepetal.Keyable;
import purplepetal.Pair;

/**
 * Adds non-SQL related methods for easy doings of things.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class HandyPanel extends JPanel {
    private static final Logger LOGGER = Logger.getLogger(HandyPanel.class.getName());

    /**
     * Given key-value {@link Pair} based {@link JComboBox}, select a certain
     * index with the given key.
     * @param comboBox
     * @param key
     */
    protected void comboSelectKey(JComboBox<Pair> comboBox, int key) {
        comboBox.setSelectedIndex(0);
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).getKey() == key) {
                comboBox.setSelectedIndex(i);
            }
        }
    }
    
    /**
     * Return the {@link Pair} selected in a combo box.
     * @param comboBox
     * @return
     */
    protected Pair comboGetSelection(JComboBox<Pair> comboBox) {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }

    /**
     * Set the text of the fields to "".
     * @param fields
     */
    protected void clearFields(JTextField... fields) {
        setFields("", fields);
    }
    
    /**
     * Clear the list selections.
     * @param lists
     */
    protected void clearFields(JList... lists) {
        for (JList list : lists) {
            list.clearSelection();
        }
    }
    
    /**
     * Clear the combo selections.
     * @param combos
     */
    protected void clearFields(JComboBox... combos) {
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
    protected void setFields(String text, JTextField... fields) {
        for (JTextField field : fields) {
            field.setText(text);
        }
    }
    
    /**
     * Remove the item from the list with this key.
     * @param list
     * @param key
     */
    protected void listRemoveKey(DefaultListModel<? extends Keyable> list, int key) {
        int index = listGetIndex(list, key);
        if (index > -1) {
            list.remove(index);
        }
    }
    
    /**
     * Returns the index of the item with a given key in the list.
     * @param list
     * @param key
     * @return
     */
    protected int listGetIndex(DefaultListModel<? extends Keyable> list, int key) {
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getKey() == key) {
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
    protected <T extends Keyable> void listReplaceKey(DefaultListModel<T> list, int key, T value) {
        int index = listGetIndex(list, key);
        if (index > -1) {
            list.remove(index);
            list.add(index, value);
        } else {
            list.addElement(value);
        }
    }
    
    /**
     * Clear all fields and refresh the tables.
     */
    protected void clearAndRefresh() {
        clear();
        refresh();
    }
    
    /**
     * Refresh the main tables.
     */
    protected abstract void refresh();

    /**
     * Clear all the fields.
     */
    protected abstract void clear();
}
