package purplepetal;

import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * {@link JPanel} with handy methods for accessing databases and controlling
 * containers. Primarily for use as tabs in a larger project.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class HandyPanel extends JPanel {
    private static final Logger LOGGER = Logger.getLogger(HandyPanel.class.getName());

    /**
     * Given key-value {@link Pair} based {@link JComboBox}, select a certain
     * index with the given key.
     * @param comboBox
     * @param key
     */
    protected void selectKey(JComboBox<Pair> comboBox, int key) {
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
    protected Pair getSelection(JComboBox<Pair> comboBox) {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }
}
